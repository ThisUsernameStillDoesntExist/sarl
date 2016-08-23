/*
 * $Id$
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2016 the original authors or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sarl.lang.mwe2.codebuilder.extractor;

import com.google.common.base.Objects;
import com.google.inject.ImplementedBy;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Functions.Function4;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

import io.sarl.lang.mwe2.codebuilder.config.CodeBuilderConfig;

/** Extract elements from the grammar.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 */
@ImplementedBy(NoBacktrackGrammarCodeElementExtractor.class)
public interface CodeElementExtractor {

	/** Initialize the extractor.
	 *
	 * @param grammar the grammar to use.
	 */
	void initialize(Grammar grammar);

	/** Replies the interface for the code builder that is creating the element of the given name.
	 *
	 * @param elementName the name of the element.
	 * @return the interface.
	 */
	@Pure
	TypeReference getElementBuilderInterface(String elementName);

	/** Replies the implementation for the code builder that is creating the element of the given name.
	 *
	 * @param elementName the name of the element.
	 * @return the interface.
	 */
	@Pure
	TypeReference getElementBuilderImpl(String elementName);

	/** Replies the custom implementation for the code builder that is creating the element of the given name.
	 *
	 * @param elementName the name of the element.
	 * @return the interface.
	 */
	@Pure
	TypeReference getElementBuilderImplCustom(String elementName);

	/** Replies the base package for the code builder.
	 *
	 * @return the base package for the code builder.
	 */
	@Pure
	String getBasePackage();

	/** Replies the base package for the builders.
	 *
	 * @return the base package for the builders.
	 */
	@Pure
	String getAppenderPackage();

	/** Replies the base package for the documentation tools.
	 *
	 * @return the base package for the documentation tools.
	 */
	@Pure
	String getDocumentationPackage();

	/** Replies the adapter for inner-block documentation.
	 *
	 * @return the adapter.
	 */
	@Pure
	TypeReference getInnerBlockDocumentationAdapter();

	/** Replies the base package for the serialization tools.
	 *
	 * @return the base package for the serialization tools.
	 */
	@Pure
	String getSerializerPackage();

	/** Replies the base package for the builders.
	 *
	 * @return the base package for the builders.
	 */
	@Pure
	String getBuilderPackage();

	/** Replies the type associated to the top elements.
	 *
	 * @return the type of the top elements.
	 */
	@Pure
	TypeReference getLanguageTopElementType();

	/** Replies the implementation for the code appender that is creating the element of the given name.
	 *
	 * @param elementName the name of the element.
	 * @return the interface.
	 */
	@Pure
	TypeReference getElementAppenderImpl(String elementName);

	/** Replies the custom implementation for the code appender that is creating the element of the given name.
	 *
	 * @param elementName the name of the element.
	 * @return the interface.
	 */
	@Pure
	TypeReference getElementAppenderImplCustom(String elementName);

	/** Replies the implementation for the code adapter.
	 *
	 * @return the implementation.
	 */
	@Pure
	TypeReference getAbstractAppenderImpl();

	/** Replies the base package for the ecore elements of the grammar.
	 *
	 * @return the base package for the ecore elements.
	 */
	@Pure
	String getLanguageBasePackage();

	/** Replies the type for the scripts from the grammar.
	 *
	 * @return the language script.
	 */
	@Pure
	TypeReference getLanguageScriptInterface();

	/** Replies the the top elements of the grammar.
	 *
	 * @param grammar the grammar.
	 * @param config the configuration.
	 * @return the top elements.
	 */
	@Pure
	Iterable<ElementDescription> getTopElements(Grammar grammar, CodeBuilderConfig config);

	/** Extract type members from the given rule.
	 *
	 * <p>The callback functions are invoked for each member discovered in the grammar.
	 *
	 * <p>When a callback is replying a value, the visiting is stopping and the value is replied.
	 *
	 * @param <T> type of the value to extract.
	 * @param element the element that is containing the members.
	 * @param grammarContainer the member's container in the grammar. It is should be called by the grammar element
	 *     of the given element.
	 * @param constructorCallback the function to call on each discovered constructor.
	 *     The parameters of the callback function are: the grammar container given to the visiting function;
	 *     and the grammar container of the member.
	 * @param namedMemberCallback the function to call on each discovered named member.
	 *     The parameters of the callback function are: the grammar container given to the visiting function;
	 *     the grammar container of the member, and the name of the member.
	 * @return the first value replied by the callback, or <code>null</code>.
	 */
	<T> T visitMemberElements(
			ElementDescription element,
			EObject grammarContainer,
			Function4<CodeElementExtractor, EObject, EObject, EClassifier, T> constructorCallback,
			Function4<CodeElementExtractor, EObject, EObject, EClassifier, T> namedMemberCallback);

	/** Construct an element description.
	 *
	 * @param name the name of the element.
	 * @param grammarComponent the grammar component of the element.
	 * @param elementType the type of the element.
	 * @return the element description.
	 */
	ElementDescription newElementDescription(String name, EObject grammarComponent, EClassifier elementType);

	/** Replies the description of the formal parameters.
	 *
	 * @return the description of the formal parameter.
	 */
	ElementDescription getFormalParameter();

	/** Replies the type of the formal parameter container.
	 *
	 * @return the type of the formal parameter container.
	 */
	TypeReference getFormalParameterContainerType();

	/** Description of an element.
	 *
	 * @author $Author: sgalland$
	 * @version $FullVersion$
	 * @mavengroupid $GroupId$
	 * @mavenartifactid $ArtifactId$
	 */
	class ElementDescription {

		private final EObject grammarComponent;

		private final String name;

		private final TypeReference builderInterfaceType;

		private final TypeReference builderImplementationType;

		private final TypeReference builderCustomImplementationType;

		private final TypeReference appenderType;

		private final TypeReference elementType;

		private final boolean isAnnotationInfo;

		/** Construct a description.
		 *
		 * @param name the name of the element.
		 * @param grammarComponent the grammar component of the element.
		 * @param elementType the type for the element.
		 * @param builderInterfaceType the type for the interface that corresponds to this element builder.
		 * @param builderImplementationType the type for the class that corresponds to this element builder.
		 * @param builderCustomImplementationType the type for the class that corresponds to this element builder.
		 * @param appenderType the type for the class that corresponds to this element appender.
		 * @param annotationInfo indicates if the annotationInfo field is declared for the element.
		 */
		public ElementDescription(String name, EObject grammarComponent,
				TypeReference elementType, TypeReference builderInterfaceType,
				TypeReference builderImplementationType, TypeReference builderCustomImplementationType,
				TypeReference appenderType, boolean annotationInfo) {
			this.name = Strings.toFirstUpper(name);
			this.grammarComponent = grammarComponent;
			this.elementType = elementType;
			this.builderInterfaceType = builderInterfaceType;
			this.builderImplementationType = builderImplementationType;
			this.builderCustomImplementationType = builderCustomImplementationType;
			this.appenderType = appenderType;
			this.isAnnotationInfo = annotationInfo;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (this == obj) {
				return true;
			}
			if (ElementDescription.class.equals(obj.getClass())) {
				final ElementDescription desc = (ElementDescription) obj;
				return getElementType().equals(desc.getElementType())
					&& getName().equals(desc.getName())
					&& getBuilderInterfaceType().equals(desc.getBuilderInterfaceType())
					&& getBuilderImplementationType().equals(desc.getBuilderImplementationType());
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(getName(), getElementType(), getBuilderInterfaceType(),
					getBuilderImplementationType());
		}

		@Override
		public String toString() {
			return getElementType().toString();
		}

		/** Replies the type of the element.
		 *
		 * @return the type of the element.
		 */
		public TypeReference getElementType() {
			return this.elementType;
		}

		/** Replies the interface type for the element builder.
		 *
		 * @return the interface type.
		 */
		public TypeReference getBuilderInterfaceType() {
			return this.builderInterfaceType;
		}

		/** Replies the type for the element appender.
		 *
		 * @return the interface type.
		 */
		public TypeReference getAppenderType() {
			return this.appenderType;
		}

		/** Replies the implementation type for the element builder.
		 *
		 * @return the implementation type.
		 */
		public TypeReference getBuilderImplementationType() {
			return this.builderImplementationType;
		}

		/** Replies the custom implementation type for the element builder.
		 *
		 * @return the custom implementation type.
		 */
		public TypeReference getBuilderCustomImplementationType() {
			return this.builderCustomImplementationType;
		}

		/** Replies the grammar component that is associated to the element.
		 *
		 * @return the grammar component
		 */
		public EObject getGrammarComponent() {
			return this.grammarComponent;
		}

		/** Replies the name of the element.
		 *
		 * @return the name.
		 */
		public String getName() {
			return this.name;
		}

		/** Replies if the annotationInfo field is declared for the element.
		 *
		 * @return <code>true</code> if the annotationInfo is declared.
		 */
		public boolean isAnnotationInfo() {
			return this.isAnnotationInfo;
		}

	}

}
