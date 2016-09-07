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

import io.sarl.lang.sarl.SarlAction;
import io.sarl.lang.sarl.SarlFactory;
import java.util.Objects;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.lib.Pure;

/** Builder of a Sarl SarlAction.
 */
@SuppressWarnings("all")
public class SarlActionBuilderImpl extends AbstractBuilder implements ISarlActionBuilder {

	@Inject
	private Provider<IFormalParameterBuilder> parameterProvider;
	@Inject
	private Provider<IBlockExpressionBuilder> blockExpressionProvider;
	@Inject
	private Provider<IExpressionBuilder> expressionProvider;
	private EObject container;

	private SarlAction sarlAction;

	/** Initialize the Ecore element.
	 * @param container - the container of the SarlAction.
	 * @param name - the name of the SarlAction.
	 */
	public void eInit(XtendTypeDeclaration container, String name, String modifier, IJvmTypeProvider context) {
		setTypeResolutionContext(context);
		if (this.sarlAction == null) {
			this.container = container;
			this.sarlAction = SarlFactory.eINSTANCE.createSarlAction();
			this.sarlAction.setAnnotationInfo(XtendFactory.eINSTANCE.createXtendMember());
			this.sarlAction.setName(name);
			if (Strings.equal(modifier, "def")
				|| Strings.equal(modifier, "override")) {
				this.sarlAction.getModifiers().add(modifier);
			} else {
				throw new IllegalStateException("Invalid modifier");
			}
			container.getMembers().add(this.sarlAction);
		}
	}

	/** Replies the generated element.
	 */
	@Pure
	public SarlAction getSarlAction() {
		return this.sarlAction;
	}

	/** Replies the resource.
	 */
	@Pure
	public Resource eResource() {
		return getSarlAction().eResource();
	}

	/** Change the documentation of the element.
	 *
	 * <p>The documentation will be displayed just before the element.
	 *
	 * @param doc the documentation.
	 */
	public void setDocumentation(String doc) {
		if (Strings.isEmpty(doc)) {
			getSarlAction().eAdapters().removeIf(new Predicate<Adapter>() {
				public boolean test(Adapter adapter) {
					return adapter.isAdapterForType(DocumentationAdapter.class);
				}
			});
		} else {
			DocumentationAdapter adapter = (DocumentationAdapter) EcoreUtil.getExistingAdapter(
					getSarlAction(), DocumentationAdapter.class);
			if (adapter == null) {
				adapter = new DocumentationAdapter();
				getSarlAction().eAdapters().add(adapter);
			}
			adapter.setDocumentation(doc);
		}
	}

	/** Add a formal parameter.
	 * @param name the name of the formal parameter.
	 */
	public IFormalParameterBuilder addParameter(String name) {
		IFormalParameterBuilder builder = this.parameterProvider.get();
		builder.eInit(this.sarlAction, name, getTypeResolutionContext());
		return builder;
	}

	/** Add a throwable exception.
	 * @param type the fully qualified name of the exception.
	 */
	public void addException(String type) {
		this.sarlAction.getExceptions().add(newTypeRef(this.container, type));
	}

	/** Add a fired exception.
	 * @param type the fully qualified name of the event.
	 */
	public void addFiredEvent(String type) {
		this.sarlAction.getFiredEvents().add(newTypeRef(this.container, type));
	}

	/** Change the return type.
	 @param type the return type of the member.
	 */
	public void setReturnType(String type) {
		if (!Strings.isEmpty(type)
				&& !Objects.equals("void", type)
				&& !Objects.equals(Void.class.getName(), type)) {
			this.sarlAction.setReturnType(newTypeRef(container, type));
		} else {
			this.sarlAction.setReturnType(null);
		}
	}

	/** Create the block of code.
	 * @return the block builder.
	 */
	public IBlockExpressionBuilder getExpression() {
		IBlockExpressionBuilder block = this.blockExpressionProvider.get();
		block.eInit(getTypeResolutionContext());
		XBlockExpression expr = block.getXBlockExpression();
		this.sarlAction.setExpression(expr);
		return block;
	}

	/** Add an annotation.
	 * @param type the qualified name of the annotation
	 */
	public void addAnnotation(String type) {
		if (!Strings.isEmpty(type)) {
			XAnnotation annotation = XAnnotationsFactory.eINSTANCE.createXAnnotation();
			annotation.setAnnotationType(newTypeRef(getSarlAction(), type).getType());
			getSarlAction().getAnnotations().add(annotation);
		}
	}

	/** Add a modifier.
	 * @param modifier - the modifier to add.
	 */
	public void addModifier(String modifier) {
		if (!Strings.isEmpty(modifier)) {
			getSarlAction().getModifiers().add(modifier);
		}
	}

	@Override
	@Pure
	public String toString() {
		return EmfFormatter.objToStr(getSarlAction());
	}

	@Inject
	private Provider<ITypeParameterBuilder> iTypeParameterBuilderProvider;

	/** Add a type parameter.
	 * @param name - the simple name of the type parameter.
	 * @return the builder of type parameter.
	 */
	public ITypeParameterBuilder addTypeParameter(String name) {
		ITypeParameterBuilder builder = this.iTypeParameterBuilderProvider.get();
		final SarlAction object = getSarlAction();
		builder.eInit(object, name, getTypeResolutionContext());
		object.getTypeParameters().add(builder.getJvmTypeParameter());
		return builder;
	}

}

