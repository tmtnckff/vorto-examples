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

import org.eclipse.emf.common.util.EList;
import org.eclipse.vorto.codegen.api.InvocationContext;
import org.eclipse.vorto.codegen.api.mapping.IMapped;
import org.eclipse.vorto.codegen.ble.templates.BleGattTemplate;
import org.eclipse.vorto.core.api.model.datatype.Property;
import org.eclipse.vorto.core.api.model.functionblock.FunctionBlock;
import org.eclipse.vorto.core.api.model.functionblock.FunctionblockModel;
import org.eclipse.vorto.core.api.model.functionblock.Status;
import org.eclipse.vorto.core.api.model.informationmodel.FunctionblockProperty;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AlpwiseAppCbkHeaderTemplate extends BleGattTemplate<InformationModel> {
  @Override
  public String getFileName(final InformationModel model) {
    return "BleApp_Cbk.h";
  }
  
  @Override
  public String getPath(final InformationModel model) {
    return BleGattTemplate.rootPath;
  }
  
  @Override
  public String getContent(final InformationModel model, final InvocationContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* BLE Application Callbacks generated by Vorto */");
    _builder.newLine();
    _builder.newLine();
    {
      EList<FunctionblockProperty> _properties = model.getProperties();
      for(final FunctionblockProperty fb : _properties) {
        {
          FunctionblockModel _type = fb.getType();
          IMapped<FunctionblockModel> _mappedElement = context.getMappedElement(_type, "Service");
          boolean _hasAttribute = _mappedElement.hasAttribute("uuid");
          if (_hasAttribute) {
            _builder.append("#include \"");
            FunctionblockModel _type_1 = fb.getType();
            String _name = _type_1.getName();
            _builder.append(_name, "");
            _builder.append("/");
            FunctionblockModel _type_2 = fb.getType();
            String _name_1 = _type_2.getName();
            _builder.append(_name_1, "");
            _builder.append(".h\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      EList<FunctionblockProperty> _properties_1 = model.getProperties();
      for(final FunctionblockProperty fb_1 : _properties_1) {
        {
          FunctionblockModel _type_3 = fb_1.getType();
          FunctionBlock _functionblock = _type_3.getFunctionblock();
          Status _status = _functionblock.getStatus();
          EList<Property> _properties_2 = _status.getProperties();
          for(final Property status : _properties_2) {
            {
              IMapped<Property> _mappedElement_1 = context.getMappedElement(status, "source");
              boolean _hasAttribute_1 = _mappedElement_1.hasAttribute("uuid");
              if (_hasAttribute_1) {
                _builder.append("void ");
                FunctionblockModel _type_4 = fb_1.getType();
                String _name_2 = _type_4.getName();
                _builder.append(_name_2, "");
                _builder.append("_Cbk_");
                String _name_3 = status.getName();
                String _firstUpper = StringExtensions.toFirstUpper(_name_3);
                _builder.append(_firstUpper, "");
                _builder.append("(");
                FunctionblockModel _type_5 = fb_1.getType();
                String _name_4 = _type_5.getName();
                _builder.append(_name_4, "");
                _builder.append("_t *");
                FunctionblockModel _type_6 = fb_1.getType();
                String _name_5 = _type_6.getName();
                String _lowerCase = _name_5.toLowerCase();
                _builder.append(_lowerCase, "");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder.toString();
  }
}
