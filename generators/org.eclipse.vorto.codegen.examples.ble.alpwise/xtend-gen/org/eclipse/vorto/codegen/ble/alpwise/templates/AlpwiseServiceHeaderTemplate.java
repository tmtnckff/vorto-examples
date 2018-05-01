/**
 * Copyright (c) 2017 Oliver Meili
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Eclipse Distribution License v1.0 which accompany this distribution.
 * 
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  The Eclipse Distribution License is available at
 *  http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 *  Contributors:
 *  Oliver Meili <omi@ieee.org>
 */
package org.eclipse.vorto.codegen.ble.alpwise.templates;

import java.io.File;
import org.eclipse.emf.common.util.EList;
import org.eclipse.vorto.codegen.api.InvocationContext;
import org.eclipse.vorto.codegen.ble.model.blegatt.Characteristic;
import org.eclipse.vorto.codegen.ble.model.blegatt.Service;
import org.eclipse.vorto.codegen.ble.templates.BleGattTemplate;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AlpwiseServiceHeaderTemplate extends BleGattTemplate<Service> {
  @Override
  public String getFileName(final Service service) {
    String _name = service.getName();
    return (_name + "Service.h");
  }
  
  @Override
  public String getPath(final Service service) {
    return ((BleGattTemplate.rootPath + File.separator) + "services");
  }
  
  @Override
  public String getContent(final Service service, final InvocationContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* ");
    String _name = service.getName();
    _builder.append(_name, "");
    _builder.append("Service generated by Vorto */");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#ifndef __");
    String _name_1 = service.getName();
    String _upperCase = _name_1.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("_SERVICE_H__");
    _builder.newLineIfNotEmpty();
    _builder.append("#define __");
    String _name_2 = service.getName();
    String _upperCase_1 = _name_2.toUpperCase();
    _builder.append(_upperCase_1, "");
    _builder.append("_SERVICE_H__");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#include <stdint.h>");
    _builder.newLine();
    _builder.append("#include <AttBase.h>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#include \"BleUtils.h\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#define ENABLE_");
    String _name_3 = service.getName();
    String _upperCase_2 = _name_3.toUpperCase();
    _builder.append(_upperCase_2, "");
    _builder.append("_SERVICE_NOTIFICATIONS 1");
    _builder.newLineIfNotEmpty();
    _builder.append("#define NUM_");
    String _name_4 = service.getName();
    String _upperCase_3 = _name_4.toUpperCase();
    _builder.append(_upperCase_3, "");
    _builder.append("_SERVICES         1");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("// Configuration per service instance");
    _builder.newLine();
    _builder.append("typedef struct _");
    String _name_5 = service.getName();
    _builder.append(_name_5, "");
    _builder.append("Service_t {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("uint8_t uuid[16];");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("AttServiceAttribute ServiceHandle; /** Attribute handle for the service */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// Configuration and status per characteristic");
    _builder.newLine();
    {
      EList<Characteristic> _characteristics = service.getCharacteristics();
      for(final Characteristic ch : _characteristics) {
        _builder.append("\t");
        _builder.append("characteristicProperty_t   ");
        String _name_6 = ch.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_6);
        _builder.append(_firstUpper, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("uint8_t                    ");
        String _name_7 = ch.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_7);
        _builder.append(_firstUpper_1, "\t");
        _builder.append("Value[");
        int _length = ch.getLength();
        _builder.append(_length, "\t");
        _builder.append("];");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("} ");
    String _name_8 = service.getName();
    _builder.append(_name_8, "");
    _builder.append("Service_t;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    String _name_9 = service.getName();
    _builder.append(_name_9, "");
    _builder.append("Service_t ");
    String _name_10 = service.getName();
    _builder.append(_name_10, "");
    _builder.append("Service_Instances[NUM_");
    String _name_11 = service.getName();
    String _upperCase_4 = _name_11.toUpperCase();
    _builder.append(_upperCase_4, "");
    _builder.append("_SERVICES];");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("void ");
    String _name_12 = service.getName();
    _builder.append(_name_12, "");
    _builder.append("Service_Init(void);");
    _builder.newLineIfNotEmpty();
    _builder.append("void ");
    String _name_13 = service.getName();
    _builder.append(_name_13, "");
    _builder.append("Service_WriteAndNotifyValue(characteristicProperty_t *ch, uint8_t *value, uint8_t length, uint8_t notify);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("#endif /* __");
    String _name_14 = service.getName();
    String _upperCase_5 = _name_14.toUpperCase();
    _builder.append(_upperCase_5, "");
    _builder.append("_SERVICE_H__ */");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
