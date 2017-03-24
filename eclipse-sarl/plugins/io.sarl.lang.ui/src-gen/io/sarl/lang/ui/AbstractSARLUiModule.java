/*
 * $Id$
 *
 * File is automatically generated by the Xtext language generator.
 * Do not change it.
 *
 * SARL is an general-purpose agent programming language.
 * More details on http://www.sarl.io
 *
 * Copyright (C) 2014-2017 the original authors or authors.
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
package io.sarl.lang.ui;

import com.google.inject.Binder;
import com.google.inject.Provider;
import com.google.inject.name.Names;
import io.sarl.lang.generator.IGeneratorConfigProvider2;
import io.sarl.lang.generator.SarlOutputConfigurationProvider;
import io.sarl.lang.ide.contentassist.antlr.PartialSARLContentAssistParser;
import io.sarl.lang.ide.contentassist.antlr.SARLParser;
import io.sarl.lang.ide.contentassist.antlr.internal.InternalSARLLexer;
import io.sarl.lang.ui.builder.EclipseGeneratorConfigProvider2;
import io.sarl.lang.ui.builder.ProjectRelativeFileSystemAccess;
import io.sarl.lang.ui.contentassist.SARLContentAssistFactory;
import io.sarl.lang.ui.contentassist.SARLImportingTypesProposalProvider;
import io.sarl.lang.ui.contentassist.SARLJavaDocContentAssistProcessor;
import io.sarl.lang.ui.contentassist.SARLProposalProvider;
import io.sarl.lang.ui.contentassist.SARLTemplateContextType;
import io.sarl.lang.ui.contentassist.SARLTemplateProposalProvider;
import io.sarl.lang.ui.editor.SARLSourceViewer;
import io.sarl.lang.ui.highlighting.SARLHighlightingCalculator;
import io.sarl.lang.ui.hover.SARLHoverSerializer;
import io.sarl.lang.ui.hover.SARLHoverSignatureProvider;
import io.sarl.lang.ui.hover.SARLHoverUIStrings;
import io.sarl.lang.ui.hyperlinking.SARLHyperLinkingLabelProvider;
import io.sarl.lang.ui.images.IQualifiedNameImageProvider;
import io.sarl.lang.ui.images.QualifiedPluginImageHelper;
import io.sarl.lang.ui.labeling.SARLDescriptionLabelProvider;
import io.sarl.lang.ui.labeling.SARLDiagnosticLabelDecorator;
import io.sarl.lang.ui.labeling.SARLLabelProvider;
import io.sarl.lang.ui.labeling.SARLUIStrings;
import io.sarl.lang.ui.outline.SARLBehaviorUnitOutlineFilter;
import io.sarl.lang.ui.outline.SARLFieldOutlineFilter;
import io.sarl.lang.ui.outline.SARLOperationOutlineFilter;
import io.sarl.lang.ui.outline.SARLOutlineNodeComparator;
import io.sarl.lang.ui.outline.SARLOutlinePage;
import io.sarl.lang.ui.outline.SARLOutlineTreeProvider;
import io.sarl.lang.ui.preferences.SARLBuilderConfigurationBlock;
import io.sarl.lang.ui.preferences.SARLBuilderPreferenceAccess;
import io.sarl.lang.ui.preferences.SARLPreferenceStoreInitializer;
import io.sarl.lang.ui.preferences.SARLValidatorConfigurationBlock;
import io.sarl.lang.ui.quickfix.SARLQuickfixProvider;
import io.sarl.lang.ui.refactoring.rename.SARLRenameStrategyProvider;
import io.sarl.lang.ui.tasks.SarlTaskTagProvider;
import io.sarl.lang.ui.validation.SARLUIValidator;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport;
import org.eclipse.xtend.core.macro.declaration.IResourceChangeRegistry;
import org.eclipse.xtend.ide.XtendResourceUiServiceProvider;
import org.eclipse.xtend.ide.autoedit.AutoEditStrategyProvider;
import org.eclipse.xtend.ide.builder.UIResourceChangeRegistry;
import org.eclipse.xtend.ide.common.editor.bracketmatching.XtendBracePairProvider;
import org.eclipse.xtend.ide.contentassist.EscapeSequenceAwarePrefixMatcher;
import org.eclipse.xtend.ide.contentassist.antlr.FlexProposalConflictHelper;
import org.eclipse.xtend.ide.contentassist.javadoc.XtendJavaDocContentAssistProcessor;
import org.eclipse.xtend.ide.editor.OccurrenceComputer;
import org.eclipse.xtend.ide.editor.OverrideIndicatorModelListener;
import org.eclipse.xtend.ide.editor.OverrideIndicatorRulerAction;
import org.eclipse.xtend.ide.editor.RichStringAwareToggleCommentAction;
import org.eclipse.xtend.ide.editor.SingleLineCommentHelper;
import org.eclipse.xtend.ide.editor.XtendDoubleClickStrategyProvider;
import org.eclipse.xtend.ide.highlighting.XtendHighlightingConfiguration;
import org.eclipse.xtend.ide.hover.XtendAnnotationHover;
import org.eclipse.xtend.ide.hover.XtendHoverProvider;
import org.eclipse.xtend.ide.hover.XtendHoverSerializer;
import org.eclipse.xtend.ide.hyperlinking.XtendHyperlinkHelper;
import org.eclipse.xtend.ide.macro.EclipseFileSystemSupportImpl;
import org.eclipse.xtend.ide.refactoring.XtendRenameStrategy;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource;
import org.eclipse.xtext.builder.nature.NatureAddingEditorCallback;
import org.eclipse.xtext.builder.preferences.BuilderConfigurationBlock;
import org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess;
import org.eclipse.xtext.common.types.ui.navigation.GlobalDerivedMemberAwareURIEditorOpener;
import org.eclipse.xtext.common.types.ui.navigation.IDerivedMemberAwareEditorOpener;
import org.eclipse.xtext.common.types.ui.query.IJavaSearchParticipation;
import org.eclipse.xtext.common.types.ui.refactoring.JdtRenameSupport;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenameParticipant;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JvmMemberRenameStrategy;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtBasedSimpleTypeScopeProvider;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.LexerProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.tasks.ITaskTagProvider;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.PartialEditingContentAssistContextFactory;
import org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage;
import org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.eclipse.xtext.ui.compare.DefaultViewerCreator;
import org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.formatting2.ContentFormatterFactory;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkLabelProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContextType;
import org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage;
import org.eclipse.xtext.ui.editor.toggleComments.ISingleLineCommentHelper;
import org.eclipse.xtext.ui.editor.toggleComments.ToggleSLCommentAction;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler;
import org.eclipse.xtext.ui.generator.trace.TraceForStorageProvider;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameSupport;
import org.eclipse.xtext.ui.resource.IResourceUIServiceProvider;
import org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.xbase.annotations.ui.DefaultXbaseWithAnnotationsUiModule;
import org.eclipse.xtext.xbase.imports.IUnresolvedTypeResolver;
import org.eclipse.xtext.xbase.ui.editor.XbaseDocumentProvider;
import org.eclipse.xtext.xbase.ui.editor.XbaseEditor;
import org.eclipse.xtext.xbase.ui.editor.XbaseResourceForEditorInputFactory;
import org.eclipse.xtext.xbase.ui.generator.trace.XbaseOpenGeneratedFileHandler;
import org.eclipse.xtext.xbase.ui.hover.HoverUiStrings;
import org.eclipse.xtext.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider;
import org.eclipse.xtext.xbase.ui.imports.InteractiveUnresolvedTypeResolver;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceHandler;
import org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceQueryExecutor;
import org.eclipse.xtext.xbase.ui.jvmmodel.navigation.DerivedMemberAwareEditorOpener;
import org.eclipse.xtext.xbase.ui.jvmmodel.outline.JvmOutlineNodeElementOpener;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContextFactory;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameRefactoringProvider;
import org.eclipse.xtext.xbase.ui.refactoring.XbaseReferenceUpdater;
import org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator;
import org.eclipse.xtext.xbase.validation.UIStrings;

/**
 * Manual modifications go to {@link SARLUiModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractSARLUiModule extends DefaultXbaseWithAnnotationsUiModule {

	public AbstractSARLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ImplicitFragment
	public Provider<? extends IAllContainersState> provideIAllContainersState() {
		return Access.getJavaProjectsState();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ImplicitFragment
	public Class<? extends XtextEditor> bindXtextEditor() {
		return XbaseEditor.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ImplicitFragment
	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return XbaseDocumentProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ImplicitFragment
	public Class<? extends OpenGeneratedFileHandler> bindOpenGeneratedFileHandler() {
		return XbaseOpenGeneratedFileHandler.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureContentAssistLexer(Binder binder) {
		binder.bind(Lexer.class)
			.annotatedWith(Names.named(LexerIdeBindings.CONTENT_ASSIST))
			.to(InternalSARLLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureHighlightingLexer(Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class)
			.annotatedWith(Names.named(LexerIdeBindings.HIGHLIGHTING))
			.to(io.sarl.lang.parser.antlr.internal.InternalSARLLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureHighlightingTokenDefProvider(Binder binder) {
		binder.bind(ITokenDefProvider.class)
			.annotatedWith(Names.named(LexerIdeBindings.HIGHLIGHTING))
			.to(AntlrTokenDefProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return DelegatingContentAssistContextFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public Class<? extends IContentAssistParser> bindIContentAssistParser() {
		return SARLParser.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment2
	public void configureContentAssistLexerProvider(Binder binder) {
		binder.bind(InternalSARLLexer.class).toProvider(LexerProvider.create(InternalSARLLexer.class));
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
		return ContentFormatterFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return BuilderParticipant.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
	public IWorkspaceRoot bindIWorkspaceRootToInstance() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.generator.GeneratorFragment2
	public void configureBuilderPreferenceStoreInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class)
			.annotatedWith(Names.named("builderPreferenceInitializer"))
			.to(BuilderPreferenceAccess.Initializer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptionsBuilderScope(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(CurrentDescriptions.ResourceSetAware.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return NatureAddingEditorCallback.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public void configureIResourceDescriptionsPersisted(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(IBuilderState.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.builder.BuilderIntegrationFragment2
	public Class<? extends DocumentBasedDirtyResource> bindDocumentBasedDirtyResource() {
		return PersistentDataAwareDirtyResource.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.quickfix.QuickfixProviderFragment2
	public Class<? extends IssueResolutionProvider> bindIssueResolutionProvider() {
		return SARLQuickfixProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.labeling.LabelProviderFragment2
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return SARLLabelProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.labeling.LabelProviderFragment2
	public void configureResourceUIServiceLabelProvider(Binder binder) {
		binder.bind(ILabelProvider.class).annotatedWith(ResourceServiceDescriptionLabelProvider.class).to(SARLDescriptionLabelProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2
	public Class<? extends IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return SARLOutlineTreeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2
	public Class<? extends IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return SARLOutlineTreeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.compare.CompareFragment2
	public Class<? extends IViewerCreator> bindIViewerCreator() {
		return DefaultViewerCreator.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.contentAssist.ContentAssistFragment2
	public Class<? extends IContentProposalProvider> bindIContentProposalProvider() {
		return SARLProposalProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.refactoring.RefactorElementNameFragment2
	public Class<? extends IRenameSupport.Factory> bindIRenameSupport$Factory() {
		return JdtRenameSupport.Factory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.refactoring.RefactorElementNameFragment2
	public void configureJvmMemberRenameStrategy$Provider$Delegate(Binder binder) {
		binder.bind(IRenameStrategy.Provider.class).annotatedWith(JvmMemberRenameStrategy.Provider.Delegate.class).to(DefaultRenameStrategyProvider.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.types.TypesGeneratorFragment2
	public Class<? extends PrefixMatcher> bindPrefixMatcher() {
		return FQNPrefixMatcher.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends FindReferencesHandler> bindFindReferencesHandler() {
		return JvmModelFindReferenceHandler.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends ReferenceQueryExecutor> bindReferenceQueryExecutor() {
		return JvmModelReferenceQueryExecutor.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return JvmModelDependentElementsCalculator.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IRenameRefactoringProvider> bindIRenameRefactoringProvider() {
		return CombinedJvmJdtRenameRefactoringProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IReferenceUpdater> bindIReferenceUpdater() {
		return XbaseReferenceUpdater.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IRenameContextFactory> bindIRenameContextFactory() {
		return CombinedJvmJdtRenameContextFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends JdtRenameParticipant.ContextFactory> bindJdtRenameParticipant$ContextFactory() {
		return JvmModelJdtRenameParticipantContext.ContextFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends OutlineNodeElementOpener> bindOutlineNodeElementOpener() {
		return JvmOutlineNodeElementOpener.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends GlobalURIEditorOpener> bindGlobalURIEditorOpener() {
		return GlobalDerivedMemberAwareURIEditorOpener.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IJavaSearchParticipation> bindIJavaSearchParticipation() {
		return IJavaSearchParticipation.No.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public void configureLanguageSpecificURIEditorOpener(Binder binder) {
		if (PlatformUI.isWorkbenchRunning()) {
			binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class).to(DerivedMemberAwareEditorOpener.class);
			binder.bind(IDerivedMemberAwareEditorOpener.class).to(DerivedMemberAwareEditorOpener.class);
		}
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.xbase.XbaseGeneratorFragment2
	public Class<? extends IUnresolvedTypeResolver> bindIUnresolvedTypeResolver() {
		return InteractiveUnresolvedTypeResolver.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2
	public Provider<? extends TemplatesLanguageConfiguration> provideTemplatesLanguageConfiguration() {
		return AccessibleCodetemplatesActivator.getTemplatesLanguageConfigurationProvider();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2
	public Provider<? extends LanguageRegistry> provideLanguageRegistry() {
		return AccessibleCodetemplatesActivator.getLanguageRegistry();
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2
	@SingletonBinding(eager=true)
	public Class<? extends LanguageRegistrar> bindLanguageRegistrar() {
		return LanguageRegistrar.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2
	public Class<? extends XtextTemplatePreferencePage> bindXtextTemplatePreferencePage() {
		return AdvancedTemplatesPreferencePage.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2
	public Class<? extends IPartialEditingContentAssistParser> bindIPartialEditingContentAssistParser() {
		return PartialSARLContentAssistParser.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.ui.templates.CodetemplatesGeneratorFragment2
	public Class<? extends IPartialEditingContentAssistContextFactory> bindIPartialEditingContentAssistContextFactory() {
		return PartialEditingContentAssistContextFactory.class;
	}
	
	// contributed by io.sarl.lang.mwe2.codebuilder.CodeBuilderFragment2
	public void configureconfigureAbstractTypeScopeProviderForSourceAppender(Binder binder) {
		binder.bind(AbstractTypeScopeProvider.class).annotatedWith(Names.named("io.sarl.lang.codebuilder.appenders.SourceAppender.providerType")).to(JdtBasedSimpleTypeScopeProvider.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IRenameStrategy.Provider> bindIRenameStrategy$Provider() {
		return SARLRenameStrategyProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return SARLOutlinePage.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends UIStrings> bindUIStrings() {
		return SARLUIStrings.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IImageHelper.IImageDescriptorHelper> bindIImageDescriptorHelper() {
		return QualifiedPluginImageHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends XtendJavaDocContentAssistProcessor> bindXtendJavaDocContentAssistProcessor() {
		return SARLJavaDocContentAssistProcessor.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return XbaseResourceForEditorInputFactory.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends XbaseDeclarativeHoverSignatureProvider> bindXbaseDeclarativeHoverSignatureProvider() {
		return SARLHoverSignatureProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public void configureSARLFieldOutlineFilter(Binder binder) {
		binder.bind(IOutlineContribution.class).annotatedWith(Names.named("SARLFieldOutlineFilter")).to(SARLFieldOutlineFilter.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
		return SarlOutputConfigurationProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends ISemanticHighlightingCalculator> bindIdeSemanticHighlightingCalculator() {
		return SARLHighlightingCalculator.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	@SingletonBinding
	public Class<? extends IQualifiedNameImageProvider> bindIQualifiedNameImageProvider() {
		return SARLLabelProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public void configureDiagnosticDecorator(Binder binder) {
		binder.bind(ILabelDecorator.class).annotatedWith(Names.named("DiagnosticDecorator")).to(SARLDiagnosticLabelDecorator.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IImageHelper> bindIImageHelper() {
		return QualifiedPluginImageHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IGeneratorConfigProvider2> bindIGeneratorConfigProvider2() {
		return EclipseGeneratorConfigProvider2.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends AbstractValidatorConfigurationBlock> bindAbstractValidatorConfigurationBlock() {
		return SARLValidatorConfigurationBlock.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends HoverUiStrings> bindHoverUiStrings() {
		return SARLHoverUIStrings.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public void configureHyperlinkLabelProvider(Binder binder) {
		binder.bind(ILabelProvider.class).annotatedWith(HyperlinkLabelProvider.class).to(SARLHyperLinkingLabelProvider.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public void configureSmartCaretPreferenceInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("smartCaretPreferenceInitializer")).to(SARLPreferenceStoreInitializer.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends ITypesProposalProvider> bindITypesProposalProvider() {
		return SARLImportingTypesProposalProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public void configureSARLOperationOutlineFilter(Binder binder) {
		binder.bind(IOutlineContribution.class).annotatedWith(Names.named("SARLOperationOutlineFilter")).to(SARLOperationOutlineFilter.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public void configureSARLBehaviorUnitOutlineFilter(Binder binder) {
		binder.bind(IOutlineContribution.class).annotatedWith(Names.named("SARLBehaviorUnitOutlineFilter")).to(SARLBehaviorUnitOutlineFilter.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	@SingletonBinding(eager=true)
	public Class<? extends XbaseUIValidator> bindXbaseUIValidator() {
		return SARLUIValidator.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends ITaskTagProvider> bindITaskTagProvider() {
		return SarlTaskTagProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return SARLTemplateProposalProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public void configureIPreferenceStoreInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("RefactoringPreferences")).to(SARLPreferenceStoreInitializer.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends BuilderConfigurationBlock> bindBuilderConfigurationBlock() {
		return SARLBuilderConfigurationBlock.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends XtendHoverSerializer> bindXtendHoverSerializer() {
		return SARLHoverSerializer.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends OutlineFilterAndSorter.IComparator> bindOutlineFilterAndSorter$IComparator() {
		return SARLOutlineNodeComparator.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return SARLContentAssistFactory.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public void configureSarlBuilderPreferences(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("SarlBuilderPreferences")).to(SARLBuilderPreferenceAccess.Initializer.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings provided by SARL API]
	public Class<? extends XtextTemplateContextType> bindXtextTemplateContextType() {
		return SARLTemplateContextType.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends MutableFileSystemSupport> bindMutableFileSystemSupport() {
		return EclipseFileSystemSupportImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends AbstractFileSystemSupport> bindAbstractFileSystemSupport() {
		return EclipseFileSystemSupportImpl.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return XtendDoubleClickStrategyProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return AutoEditStrategyProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	@SingletonBinding
	public Class<? extends IBracePairProvider> bindIBracePairProvider() {
		return XtendBracePairProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IProposalConflictHelper> bindIProposalConflictHelper() {
		return FlexProposalConflictHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return XtendHighlightingConfiguration.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return XtendHoverProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public void configureOverrideIndicatorRulerAction(Binder binder) {
		binder.bind(IActionContributor.class).annotatedWith(Names.named("OverrideIndicatorRulerAction")).to(OverrideIndicatorRulerAction.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IAnnotationHover> bindIAnnotationHover() {
		return XtendAnnotationHover.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return XtendHyperlinkHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IOccurrenceComputer> bindIOccurrenceComputer() {
		return OccurrenceComputer.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IResourceChangeRegistry> bindIResourceChangeRegistry() {
		return UIResourceChangeRegistry.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ISingleLineCommentHelper> bindISingleLineCommentHelper() {
		return SingleLineCommentHelper.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ITraceForStorageProvider> bindITraceForStorageProvider() {
		return TraceForStorageProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public void configureOverrideIndicatorModelListener(Binder binder) {
		binder.bind(IXtextEditorCallback.class).annotatedWith(Names.named("OverrideIndicatorModelListener")).to(OverrideIndicatorModelListener.class);
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IResourceUIServiceProvider> bindIResourceUIServiceProvider() {
		return XtendResourceUiServiceProvider.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends ToggleSLCommentAction.Factory> bindToggleSLCommentAction$Factory() {
		return RichStringAwareToggleCommentAction.Factory.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends XtextSourceViewer.Factory> bindXtextSourceViewer$Factory() {
		return SARLSourceViewer.Factory.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends PrefixMatcher.CamelCase> bindPrefixMatcher$CamelCase() {
		return EscapeSequenceAwarePrefixMatcher.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
		return ProjectRelativeFileSystemAccess.class;
	}
	
	// contributed by io.sarl.lang.mwe2.binding.InjectionFragment2 [Bindings required by extended Xtend API]
	public Class<? extends IRenameStrategy> bindIRenameStrategy() {
		return XtendRenameStrategy.class;
	}
	
}
