/*******************************************************************************
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
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
 *******************************************************************************/
package org.eclipse.vorto.codegen.latex.tasks.template

import org.eclipse.vorto.codegen.api.ITemplate
import org.eclipse.vorto.codegen.api.InvocationContext
import org.eclipse.vorto.core.api.model.informationmodel.InformationModel
import org.eclipse.vorto.codegen.utils.Utils

class ReviewInformationModelTemplate implements ITemplate<InformationModel>{
	
	LatexFunctionBlockTemplate fbTemplate;
	LatexEntityTemplate entityTemplate;
	LatexEnumTemplate enumTemplate;
	LatexFBPropertyTemplate fbPropertyTemplate;
	
	new(LatexFBPropertyTemplate fbPropertyTemplate, LatexFunctionBlockTemplate fbTemplate,LatexEntityTemplate entityTemplate, LatexEnumTemplate enumTemplate) {
		this.fbTemplate = fbTemplate;
		this.entityTemplate = entityTemplate;
		this.enumTemplate = enumTemplate;
		this.fbPropertyTemplate = fbPropertyTemplate;
	}
	
	override getContent(InformationModel im,InvocationContext invocationContext) {
		'''
			\documentclass[10pt]{article}
			
			\setlength{\textwidth}{16,5cm}
			\setlength{\textheight}{23cm}
			\setlength{\oddsidemargin}{-1cm}
			
			\begin{document}
				\title{\textbf{«im.displayname.replace("_","\\_")»}}
				\author{Generated by Eclipse Vorto}
				\maketitle
				
				
				This document has been created by Eclipse Vorto based on the Information Model 
				«im.displayname.replace("_","\\_")»\footnote{Name: «im.name.replace("_","\\_")», Namespace: «im.namespace», Version: «im.version».} which is
				described in the section below:
				
				\section{Information Model Specification}
				«im.description»\\\\
				«FOR fbProperty : im.properties»
					«fbPropertyTemplate.getContent(fbProperty,invocationContext)»
				«ENDFOR»
				
				\section{Functionblock Specification}
				«FOR fbProperty : im.properties»
					«fbTemplate.getContent(fbProperty.type,invocationContext)»
				«ENDFOR»
				
				\section{Datatype Specification}
				«FOR fbProperty : im.properties»
					«FOR type : Utils.getReferencedEntities(fbProperty.type.functionblock)»
						«entityTemplate.getContent(type,invocationContext)»
					«ENDFOR»
				«ENDFOR»
			\end{document}
		'''
	}
}