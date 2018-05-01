/**
 * Copyright (c) 2016 Bosch Software Innovations GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 * 
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * Contributors:
 * Bosch Software Innovations GmbH - Please refer to git log
 */
package org.eclipse.vorto.codegen.prosystfi.templates;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.vorto.codegen.api.ITemplate;
import org.eclipse.vorto.codegen.api.InvocationContext;
import org.eclipse.vorto.codegen.prosystfi.tasks.FunctionalItemImplGeneratorTask;
import org.eclipse.vorto.core.api.model.datatype.Entity;
import org.eclipse.vorto.core.api.model.datatype.EnumLiteral;
import org.eclipse.vorto.core.api.model.datatype.ObjectPropertyType;
import org.eclipse.vorto.core.api.model.datatype.PrimitivePropertyType;
import org.eclipse.vorto.core.api.model.datatype.PrimitiveType;
import org.eclipse.vorto.core.api.model.datatype.Property;
import org.eclipse.vorto.core.api.model.datatype.PropertyType;
import org.eclipse.vorto.core.api.model.datatype.Type;
import org.eclipse.vorto.core.api.model.functionblock.Configuration;
import org.eclipse.vorto.core.api.model.functionblock.Fault;
import org.eclipse.vorto.core.api.model.functionblock.FunctionBlock;
import org.eclipse.vorto.core.api.model.functionblock.FunctionblockModel;
import org.eclipse.vorto.core.api.model.functionblock.Operation;
import org.eclipse.vorto.core.api.model.functionblock.ReturnObjectType;
import org.eclipse.vorto.core.api.model.functionblock.ReturnPrimitiveType;
import org.eclipse.vorto.core.api.model.functionblock.ReturnType;
import org.eclipse.vorto.core.api.model.functionblock.Status;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class FunctionalItemImplTemplate implements ITemplate<FunctionblockModel> {
  private String fiPackage;
  
  private String[] imports;
  
  public FunctionalItemImplTemplate(final String fiPackage, final String... imports) {
    this.fiPackage = fiPackage;
    this.imports = imports;
  }
  
  @Override
  public String getContent(final FunctionblockModel fbm, final InvocationContext ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append("*****************************************************************************************");
    _builder.newLine();
    _builder.append("* The present code has been generated by the Eclipse Vorto ProSyst Code Generator.");
    _builder.newLine();
    _builder.append("*");
    _builder.newLine();
    _builder.append("* The basis for the generation was the Functionblock which is uniquely identified by:");
    _builder.newLine();
    _builder.append("* Name:\t\t\t");
    String _name = fbm.getName();
    _builder.append(_name, "");
    _builder.newLineIfNotEmpty();
    _builder.append("* Namespace:\t");
    String _namespace = fbm.getNamespace();
    _builder.append(_namespace, "");
    _builder.newLineIfNotEmpty();
    _builder.append("* Version:\t\t");
    String _version = fbm.getVersion();
    _builder.append(_version, "");
    _builder.newLineIfNotEmpty();
    _builder.append("*****************************************************************************************");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("package ");
    _builder.append(this.fiPackage, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.Collections;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    {
      for(final String imprt : this.imports) {
        _builder.append("import ");
        _builder.append(imprt, "");
        _builder.append(".*;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("import com.prosyst.mbs.services.fim.FunctionalItem;");
    _builder.newLine();
    _builder.append("import com.prosyst.mbs.services.fim.FunctionalItemFactory;");
    _builder.newLine();
    _builder.append("import com.prosyst.mbs.services.fim.spi.AbstractFunctionalItem;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* This is a implementation class for the functional item ");
    String _name_1 = fbm.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _name_2 = fbm.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
    _builder.append(_firstUpper_1, "");
    _builder.append(FunctionalItemImplGeneratorTask.SUFFIX, "");
    _builder.append(" extends AbstractFunctionalItem implements ");
    String _name_3 = fbm.getName();
    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_2, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* The default UID for this functional item.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final String UID = \"");
    String _namespace_1 = fbm.getNamespace();
    _builder.append(_namespace_1, "\t");
    _builder.append(":");
    String _name_4 = fbm.getName();
    _builder.append(_name_4, "\t");
    _builder.append(":");
    String _version_1 = fbm.getVersion();
    _builder.append(_version_1, "\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* This map contains the available attributes.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Map<String, ?> attributes;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    FunctionBlock fb = fbm.getFunctionblock();
    _builder.newLineIfNotEmpty();
    {
      Status _status = fb.getStatus();
      boolean _notEquals = (!Objects.equal(_status, null));
      if (_notEquals) {
        {
          Status _status_1 = fb.getStatus();
          EList<Property> _properties = _status_1.getProperties();
          for(final Property property : _properties) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("* ");
            String _description = property.getDescription();
            _builder.append(_description, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("*/");
            _builder.newLine();
            {
              PropertyType _type = property.getType();
              if ((_type instanceof PrimitivePropertyType)) {
                _builder.append("\t");
                _builder.append("private ");
                PropertyType _type_1 = property.getType();
                PrimitiveType _type_2 = ((PrimitivePropertyType) _type_1).getType();
                String _name_5 = _type_2.getName();
                _builder.append(_name_5, "\t");
                _builder.append(" ");
                String _name_6 = property.getName();
                _builder.append(_name_6, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                PropertyType _type_3 = property.getType();
                if ((_type_3 instanceof ObjectPropertyType)) {
                  _builder.append("\t");
                  PropertyType _type_4 = property.getType();
                  ObjectPropertyType objectProperty = ((ObjectPropertyType) _type_4);
                  _builder.newLineIfNotEmpty();
                  {
                    Type _type_5 = objectProperty.getType();
                    if ((_type_5 instanceof Entity)) {
                      _builder.append("\t");
                      _builder.append("private ");
                      Type _type_6 = objectProperty.getType();
                      String _name_7 = ((Entity) _type_6).getName();
                      _builder.append(_name_7, "\t");
                      _builder.append(" ");
                      String _name_8 = property.getName();
                      _builder.append(_name_8, "\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    } else {
                      Type _type_7 = objectProperty.getType();
                      if ((_type_7 instanceof org.eclipse.vorto.core.api.model.datatype.Enum)) {
                        _builder.append("\t");
                        _builder.append("private ");
                        Type _type_8 = objectProperty.getType();
                        String _name_9 = ((org.eclipse.vorto.core.api.model.datatype.Enum) _type_8).getName();
                        _builder.append(_name_9, "\t");
                        _builder.append(" ");
                        String _name_10 = property.getName();
                        _builder.append(_name_10, "\t");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.newLine();
          }
        }
      }
    }
    {
      Configuration _configuration = fb.getConfiguration();
      boolean _notEquals_1 = (!Objects.equal(_configuration, null));
      if (_notEquals_1) {
        {
          Configuration _configuration_1 = fb.getConfiguration();
          EList<Property> _properties_1 = _configuration_1.getProperties();
          for(final Property property_1 : _properties_1) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("* ");
            String _description_1 = property_1.getDescription();
            _builder.append(_description_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("*/");
            _builder.newLine();
            {
              PropertyType _type_9 = property_1.getType();
              if ((_type_9 instanceof PrimitivePropertyType)) {
                _builder.append("\t");
                _builder.append("private ");
                PropertyType _type_10 = property_1.getType();
                PrimitiveType _type_11 = ((PrimitivePropertyType) _type_10).getType();
                String _name_11 = _type_11.getName();
                _builder.append(_name_11, "\t");
                _builder.append(" ");
                String _name_12 = property_1.getName();
                _builder.append(_name_12, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                PropertyType _type_12 = property_1.getType();
                if ((_type_12 instanceof ObjectPropertyType)) {
                  _builder.append("\t");
                  PropertyType _type_13 = property_1.getType();
                  ObjectPropertyType objectProperty_1 = ((ObjectPropertyType) _type_13);
                  _builder.newLineIfNotEmpty();
                  {
                    Type _type_14 = objectProperty_1.getType();
                    if ((_type_14 instanceof Entity)) {
                      _builder.append("\t");
                      _builder.append("private ");
                      Type _type_15 = objectProperty_1.getType();
                      String _name_13 = ((Entity) _type_15).getName();
                      _builder.append(_name_13, "\t");
                      _builder.append(" ");
                      String _name_14 = property_1.getName();
                      _builder.append(_name_14, "\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    } else {
                      Type _type_16 = objectProperty_1.getType();
                      if ((_type_16 instanceof org.eclipse.vorto.core.api.model.datatype.Enum)) {
                        _builder.append("\t");
                        _builder.append("private ");
                        Type _type_17 = objectProperty_1.getType();
                        String _name_15 = ((org.eclipse.vorto.core.api.model.datatype.Enum) _type_17).getName();
                        _builder.append(_name_15, "\t");
                        _builder.append(" ");
                        String _name_16 = property_1.getName();
                        _builder.append(_name_16, "\t");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.newLine();
          }
        }
      }
    }
    {
      Fault _fault = fb.getFault();
      boolean _notEquals_2 = (!Objects.equal(_fault, null));
      if (_notEquals_2) {
        {
          Fault _fault_1 = fb.getFault();
          EList<Property> _properties_2 = _fault_1.getProperties();
          for(final Property property_2 : _properties_2) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("* ");
            String _description_2 = property_2.getDescription();
            _builder.append(_description_2, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("*/");
            _builder.newLine();
            {
              PropertyType _type_18 = property_2.getType();
              if ((_type_18 instanceof PrimitivePropertyType)) {
                _builder.append("\t");
                _builder.append("private ");
                PropertyType _type_19 = property_2.getType();
                PrimitiveType _type_20 = ((PrimitivePropertyType) _type_19).getType();
                String _name_17 = _type_20.getName();
                _builder.append(_name_17, "\t");
                _builder.append(" ");
                String _name_18 = property_2.getName();
                _builder.append(_name_18, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                PropertyType _type_21 = property_2.getType();
                if ((_type_21 instanceof ObjectPropertyType)) {
                  _builder.append("\t");
                  PropertyType _type_22 = property_2.getType();
                  ObjectPropertyType objectProperty_2 = ((ObjectPropertyType) _type_22);
                  _builder.newLineIfNotEmpty();
                  {
                    Type _type_23 = objectProperty_2.getType();
                    if ((_type_23 instanceof Entity)) {
                      _builder.append("\t");
                      _builder.append("private ");
                      Type _type_24 = objectProperty_2.getType();
                      String _name_19 = ((Entity) _type_24).getName();
                      _builder.append(_name_19, "\t");
                      _builder.append(" ");
                      String _name_20 = property_2.getName();
                      _builder.append(_name_20, "\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                    } else {
                      Type _type_25 = objectProperty_2.getType();
                      if ((_type_25 instanceof org.eclipse.vorto.core.api.model.datatype.Enum)) {
                        _builder.append("\t");
                        _builder.append("private ");
                        Type _type_26 = objectProperty_2.getType();
                        String _name_21 = ((org.eclipse.vorto.core.api.model.datatype.Enum) _type_26).getName();
                        _builder.append(_name_21, "\t");
                        _builder.append(" ");
                        String _name_22 = property_2.getName();
                        _builder.append(_name_22, "\t");
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  }
                }
              }
            }
            _builder.append("\t");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Creates a ");
    String _name_23 = fbm.getName();
    String _firstUpper_3 = StringExtensions.toFirstUpper(_name_23);
    _builder.append(_firstUpper_3, "\t");
    _builder.append(" functional item instance.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_24 = fbm.getName();
    String _firstUpper_4 = StringExtensions.toFirstUpper(_name_24);
    _builder.append(_firstUpper_4, "\t");
    _builder.append(FunctionalItemImplGeneratorTask.SUFFIX, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t");
    _builder.append("this(UID);");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Creates a ");
    String _name_25 = fbm.getName();
    String _firstUpper_5 = StringExtensions.toFirstUpper(_name_25);
    _builder.append(_firstUpper_5, "\t");
    _builder.append(" functional item instance with a provided unique id.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _name_26 = fbm.getName();
    String _firstUpper_6 = StringExtensions.toFirstUpper(_name_26);
    _builder.append(_firstUpper_6, "\t");
    _builder.append(FunctionalItemImplGeneratorTask.SUFFIX, "\t");
    _builder.append("(String uid) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t");
    _builder.append("super(uid);");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("this.attributes = Collections.emptyMap();");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.newLine();
    {
      EList<Operation> _operations = fb.getOperations();
      for(final Operation operation : _operations) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("* ");
        String _description_3 = operation.getDescription();
        _builder.append(_description_3, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("*/");
        _builder.newLine();
        {
          ReturnType _returnType = operation.getReturnType();
          boolean _equals = Objects.equal(_returnType, null);
          if (_equals) {
            _builder.append("\t");
            _builder.append("public void ");
            String _name_27 = operation.getName();
            _builder.append(_name_27, "\t");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("//Add your application code here.");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            {
              ReturnType _returnType_1 = operation.getReturnType();
              if ((_returnType_1 instanceof ReturnObjectType)) {
                _builder.append("\t");
                ReturnType _returnType_2 = operation.getReturnType();
                Type type = ((ReturnObjectType) _returnType_2).getReturnType();
                _builder.newLineIfNotEmpty();
                {
                  if ((type instanceof Entity)) {
                    _builder.append("\t");
                    _builder.append("public ");
                    String _name_28 = ((Entity) type).getName();
                    _builder.append(_name_28, "\t");
                    _builder.append(" ");
                    String _name_29 = operation.getName();
                    _builder.append(_name_29, "\t");
                    _builder.append("() {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("//Add your application code here.");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("return new ");
                    String _name_30 = ((Entity) type).getName();
                    _builder.append(_name_30, "\t\t");
                    _builder.append("();");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  } else {
                    if ((type instanceof org.eclipse.vorto.core.api.model.datatype.Enum)) {
                      _builder.append("\t");
                      _builder.append("public ");
                      String _name_31 = ((org.eclipse.vorto.core.api.model.datatype.Enum) type).getName();
                      _builder.append(_name_31, "\t");
                      _builder.append(" ");
                      String _name_32 = operation.getName();
                      _builder.append(_name_32, "\t");
                      _builder.append("() {");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("//Add your application code here.");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("\t");
                      _builder.append("return ");
                      String _name_33 = ((org.eclipse.vorto.core.api.model.datatype.Enum) type).getName();
                      _builder.append(_name_33, "\t\t");
                      _builder.append(".");
                      EList<EnumLiteral> _enums = ((org.eclipse.vorto.core.api.model.datatype.Enum) type).getEnums();
                      EnumLiteral _get = _enums.get(0);
                      String _name_34 = ((EnumLiteral) _get).getName();
                      String _upperCase = _name_34.toUpperCase();
                      _builder.append(_upperCase, "\t\t");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              } else {
                ReturnType _returnType_3 = operation.getReturnType();
                if ((_returnType_3 instanceof ReturnPrimitiveType)) {
                  _builder.append("\t");
                  ReturnType _returnType_4 = operation.getReturnType();
                  PrimitiveType type_1 = ((ReturnPrimitiveType) _returnType_4).getReturnType();
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("public ");
                  String _name_35 = type_1.getName();
                  _builder.append(_name_35, "\t");
                  _builder.append(" ");
                  String _name_36 = operation.getName();
                  _builder.append(_name_36, "\t");
                  _builder.append("() {");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("//Add your application code here.");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("\t");
                  String _name_37 = type_1.getName();
                  _builder.append(_name_37, "\t\t");
                  _builder.append(" value;");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("return value;");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
