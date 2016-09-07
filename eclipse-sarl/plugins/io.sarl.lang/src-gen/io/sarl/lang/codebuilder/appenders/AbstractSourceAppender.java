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
package io.sarl.lang.codebuilder.appenders;

import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Named;
import io.sarl.lang.codebuilder.CodeBuilderFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.formatting.impl.AbstractTokenStream;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.scoping.batch.DelegatingScopes;
import org.eclipse.xtext.xbase.scoping.batch.TypeScopes;

/** Abstract implementation of an appender for the Sarl language.
 */
@SuppressWarnings("all")
public abstract class AbstractSourceAppender {

	public static final String OVERRIDEN_TYPE_SCOPE_PROVIDER_NAME = "io.sarl.lang.codebuilder.appenders.SourceAppender.providerType";

	@Inject
	private Injector originalInjector;

	@Inject
	@Named(OVERRIDEN_TYPE_SCOPE_PROVIDER_NAME)
	private AbstractTypeScopeProvider scopeProvider;

	@Inject
	private TypeScopes typeScopes;

	private boolean isFormatting;

	/** Set if this building is formatting the generated code.
	 *
	 * @param formatting <code>true</code> if the appender is formatting the generated code.
	 */
	public void setFormatting(boolean formatting) {
		this.isFormatting = formatting;
	}

	/** Replies if this building is formatting the generated code.
	 *
	 * @return <code>true</code> if the appender is formatting the generated code.
	 */
	public boolean isFormatting() {
		return this.isFormatting;
	}

	/** Replies the context for type resolution.
	 * @return the context, or <code>null</code> if the Ecore object is the context.
	 */
	protected abstract IJvmTypeProvider getTypeResolutionContext();

	/** Build the source code and put it into the given appender.
	 * @param appender the object that permits to create the source code.
	 */
	public abstract void build(ISourceAppender appender) throws IOException;

	/** Build the source code and put it into the given appender.
	 * @param the object to serialize
	 * @param appender the object that permits to create the source code.
	 * @param context the context for type resolution.
	 */
	protected void build(EObject object, ISourceAppender appender) throws IOException {
		final IJvmTypeProvider provider = getTypeResolutionContext();
		if (provider != null) {
			final Map<Key<?>, Binding<?>> bindings = this.originalInjector.getBindings();
			Injector localInjector = CodeBuilderFactory.createOverridingInjector(this.originalInjector, (binder) -> binder.bind(AbstractTypeScopeProvider.class).toInstance(AbstractSourceAppender.this.scopeProvider));
			final IScopeProvider oldDelegate = this.typeScopes.getDelegate();
			localInjector.injectMembers(this.typeScopes);
			try {
				final AppenderSerializer serializer = localInjector.getProvider(AppenderSerializer.class).get();
				serializer.serialize(object, appender, isFormatting());
			} finally {
				try {
					final Field f = DelegatingScopes.class.getDeclaredField("delegate");
					if (!f.isAccessible()) {
						f.setAccessible(true);
					}
					f.set(this.typeScopes, oldDelegate);
				} catch (Exception exception) {
					throw new Error(exception);
				}
			}
		} else {
			final AppenderSerializer serializer = this.originalInjector.getProvider(AppenderSerializer.class).get();
			serializer.serialize(object, appender, isFormatting());
		}
	}

	@Singleton
	public static class AppenderSerializer extends Serializer {

		public void serialize(EObject object, ISourceAppender appender, boolean isFormatting) throws IOException {
			final AppenderBasedTokenStream stream = new AppenderBasedTokenStream(appender);
			final SaveOptions options;
			if (isFormatting) {
				options = SaveOptions.newBuilder().format().getOptions();
			} else {
				options = SaveOptions.defaultOptions();
			}
			serialize(object, stream, options);
			stream.flush();
		}

	}

	private static class AppenderBasedTokenStream extends AbstractTokenStream {

		private final ISourceAppender appender;

		public AppenderBasedTokenStream(ISourceAppender appender) {
			this.appender = appender;
		}

		public String toString() {
			return this.appender.toString();
		}

		public void writeHidden(EObject grammarElement, String value) throws IOException {
			if (!Strings.isEmpty(value)) {
				this.appender.append(value);
			}
		}

		public void writeSemantic(EObject grammarElement, String value) throws IOException {
			if (!Strings.isEmpty(value)) {
				this.appender.append(value);
			}
		}

	}

}

