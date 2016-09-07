/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright 2014-2016 the original authors and authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sarl.lang.codebuilder.builders;

import io.sarl.lang.sarl.SarlFormalParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendExecutable;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl formal parameter.
 */
@SuppressWarnings("all")
public interface IFormalParameterBuilder {

	/** Replies the context for type resolution.
	 * @return the context or <code>null</code> if the Ecore object is the context.
	 */
	IJvmTypeProvider getTypeResolutionContext();

	/** Initialize the formal parameter.
	 * @param context - the context of the formal parameter.
	 * @param name - the name of the formal parameter.
	 */
	void eInit(XtendExecutable context, String name, IJvmTypeProvider typeContext);

	/** Replies the created parameter.
	 *
	 * @return the parameter.
	 */
	@Pure
	SarlFormalParameter getSarlFormalParameter();

	/** Replies the JvmIdentifiable that corresponds to the formal parameter.
	 *
	 * @param container the feature call that is supposed to contains the replied identifiable element.
	 */
	void setReferenceInto(XFeatureCall container) ;

	/** Replies the resource to which the formal parameter is attached.
	 */
	@Pure
	Resource eResource();

	/** Change the type.
	 *
	 * @param type the formal parameter type.
	 */
	void setParameterType(String type);

	/** Change the variadic property of the parameter.
	 *
	 * @param isVariadic indicates if the parameter is variadic.
	 */
	void setVarArg(boolean isVariadic);

	/** Replies the default value of the parameter.
	 * @return the default value builder.
	 */
	@Pure
	IExpressionBuilder getDefaultValue();

	/** Dispose the resource.
	 */
	void dispose();

}

