/**
 * Copyright (c) 2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional information regarding copyright
 * ownership.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License 2.0 which is available at https://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.vorto.middleware.internal.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.eclipse.vorto.middleware.deserializer.IDeserializer;
import org.eclipse.vorto.middleware.deserializer.MimeType;
import org.eclipse.vorto.middleware.internal.service.deserializer.DeserializerFactory;
import org.eclipse.vorto.middleware.internal.service.impl.DefaultMappingService;
import org.eclipse.vorto.middleware.monitoring.IPayloadMonitor;
import org.eclipse.vorto.middleware.monitoring.MonitorMessage;
import org.eclipse.vorto.middleware.monitoring.MonitorMessage.Severity;
import org.eclipse.vorto.middleware.plugins.ExecutionContext;
import org.eclipse.vorto.middleware.plugins.IPlugin.ExecutionProblem;
import org.eclipse.vorto.model.ModelId;
import org.eclipse.vorto.model.runtime.InfomodelValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * AMQP Queue listener for any telemetry data coming in for the given tenant
 *
 */
public class EclipseHonoPayloadListener implements MessageListener {

  @Value(value = "${hono.tenantId}")
  private String tenantId;

  @Autowired
  private DefaultMappingService mappingService;

  @Autowired
  private IPluginService pluginService;
  
  @Autowired
  private IPayloadMonitor logger;

  private static final String HEADER_DEVICE_ID = "device_id";
  private static final String HEADER_VORTO_ID = "vorto";
  private static final String HEADER_CONTENT_TYPE = "JMS_AMQP_CONTENT_TYPE";

  @Override
  public void onMessage(Message message) {
    try {
      final String deviceId = message.getStringProperty(HEADER_DEVICE_ID);
      final MimeType contentType = MimeType.create(message.getStringProperty(HEADER_CONTENT_TYPE));

      final IDeserializer deserializer = DeserializerFactory.getDeserializer(contentType);
      final Object rawPayload = deserializer.deserialize(message, logger);
      
      InfomodelValue normalizedData = null;
      
      if (contentType != MimeType.ECLIPSE_DITTO) {
        final String modelId = message.getStringProperty(HEADER_VORTO_ID);
        if (modelId == null) {
          logger.monitor(MonitorMessage.inboundMessage(message.getJMSMessageID(), deviceId, "No vorto model id found in message. Please add a field 'vorto' as a custom field during device registration.", Severity.ERROR));
          return;
        }
        normalizedData = mappingService.map(ModelId.fromPrettyFormat(modelId), rawPayload);
      }
       
      final InfomodelValue normalizedPayload = normalizedData;
      
      pluginService.startedPlugins().stream().forEach(handler -> {
        try {
          handler.execute(normalizedPayload, new ExecutionContext(deviceId,message.getJMSMessageID(), contentType,rawPayload,logger));
        } catch (ExecutionProblem t) {
          try {
			logger.monitor(MonitorMessage.inboundMessage(message.getJMSMessageID(), deviceId, t.getMessage(), Severity.ERROR));
		} catch (JMSException e) {
			//FIXME
		}
        } catch(JMSException ex) {
        	//FIXME
        }
      });

    } catch (JMSException e) {
      try {
		logger.monitor(MonitorMessage.inboundMessage(message.getJMSMessageID(), "unknown", "Problem with consuming AMQP message:"+e.getMessage(), Severity.ERROR));
	} catch (JMSException e1) {
		//FIXME
	}
    }
  }
}
