/**
 * Copyright (c) 2015-2016 Bosch Software Innovations GmbH and others.
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
package org.eclipse.vorto.codegen.webui.templates.dao;

import org.eclipse.vorto.codegen.api.IFileTemplate;
import org.eclipse.vorto.codegen.api.InvocationContext;
import org.eclipse.vorto.codegen.webui.templates.TemplateUtils;
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CrudRepositoryTemplate implements IFileTemplate<InformationModel> {
  @Override
  public String getFileName(final InformationModel context) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = context.getName();
    _builder.append(_name, "");
    _builder.append("Repository.java");
    return _builder.toString();
  }
  
  @Override
  public String getPath(final InformationModel context) {
    StringConcatenation _builder = new StringConcatenation();
    String _baseApplicationPath = TemplateUtils.getBaseApplicationPath(context);
    _builder.append(_baseApplicationPath, "");
    _builder.append("/dao");
    return _builder.toString();
  }
  
  @Override
  public String getContent(final InformationModel element, final InvocationContext context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package com.example.iot.");
    String _name = element.getName();
    String _lowerCase = _name.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".dao;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("import org.springframework.data.repository.CrudRepository;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.example.iot.");
    String _name_1 = element.getName();
    String _lowerCase_1 = _name_1.toLowerCase();
    _builder.append(_lowerCase_1, "");
    _builder.append(".model.");
    String _name_2 = element.getName();
    _builder.append(_name_2, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _name_3 = element.getName();
    _builder.append(_name_3, "");
    _builder.append("Repository extends CrudRepository<");
    String _name_4 = element.getName();
    _builder.append(_name_4, "");
    _builder.append(", Long>  {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
