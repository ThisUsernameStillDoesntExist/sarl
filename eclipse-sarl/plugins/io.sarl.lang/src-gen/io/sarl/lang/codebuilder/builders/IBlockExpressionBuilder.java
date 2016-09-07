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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl XBlockExpression.
 */
@SuppressWarnings("all")
public interface IBlockExpressionBuilder {

	/** Replies the context for type resolution.
	 * @return the context or <code>null</code> if the Ecore object is the context.
	 */
	IJvmTypeProvider getTypeResolutionContext();

	/** Create the XBlockExpression.
	 */
	void eInit(IJvmTypeProvider context);

	/** Replies the string for "auto-generated" comments.
	 * @return the comment text.
	 */
	@Pure
	String getAutoGeneratedActionString();

	/** Replies the string for "auto-generated" comments.
	 * @param resource the resource for which the comment must be determined.
	 * @return the comment text.
	 */
	@Pure
	String getAutoGeneratedActionString(Resource resource);

	/** An empty block expression.
	 * @return the block expression.
	 */
	@Pure
	XBlockExpression getXBlockExpression();

	/** Replies the resource to which the XBlockExpression is attached.
	 */
	@Pure
	Resource eResource();

	/** Change the documentation of the element.
	 *
	 * <p>getXBlockExpression()
	 *
	 * @param doc the documentation.
	 */
	void setInnerDocumentation(String doc);

	/** Add an expression inside the block.
	 * @return the expression builder.
	 */
	IExpressionBuilder addExpression();

	/** Fill the block with the standard "auto-generated" content.
	 * <p>Any previously added content is removed.
	 * @param type - the expected type of the block (the last instruction), or
	    <code>null</code> for no type.
	 */
	void setDefaultAutoGeneratedContent(String type);

	/** Dispose the resource.
	 */
	void dispose();

}

