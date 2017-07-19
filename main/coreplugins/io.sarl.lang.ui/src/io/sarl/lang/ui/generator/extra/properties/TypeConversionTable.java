/*
 * $Id$
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

package io.sarl.lang.ui.generator.extra.properties;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.graphics.Image;

import io.sarl.lang.ui.generator.extra.preferences.ExtraLanguagePreferenceAccess;

/** Table for type conversion definition.
 *
 * @author $Author: sgalland$
 * @version $FullVersion$
 * @mavengroupid $GroupId$
 * @mavenartifactid $ArtifactId$
 * @since 0.6
 */
@SuppressWarnings("checkstyle:classdataabstractioncoupling")
public class TypeConversionTable extends AbstractConversionTable {

	private static final String TYPE_CONVERTER_COLUMN_WIDTH_ID = ".typeConverterSection.columnWidth"; //$NON-NLS-1$

	private static final String TYPE_CONVERTER_SORT_COLUMN = ".typeConverterSection.sortColumn"; //$NON-NLS-1$

	/** Constructor.
	 *
	 * @param controller the controller.
	 * @param pluginID the identifier of the plugin.
	 * @param languageImage for the target language (16x16).
	 * @param preferenceStore the preference store to be used.
	 */
	TypeConversionTable(IExtraControlController controller, String pluginID, Image languageImage,
			IPreferenceStore preferenceStore) {
		super(controller, pluginID, languageImage, preferenceStore, false);
	}

	@Override
	protected String getSourceColumnLabel() {
		return Messages.TypeConversionTable_8;
	}

	@Override
	protected String getTargetColumnLabel() {
		return Messages.TypeConversionTable_9;
	}

	@Override
	protected CellEditor createSourceColumnEditor() {
		return createClassCellEditor();
	}

	@Override
	protected CellEditor createTargetColumnEditor() {
		return createTextCellEditor();
	}

	@Override
	protected String getPreferenceKey() {
		return ExtraLanguagePreferenceAccess.getPrefixedKey(getPluginID(),
				ExtraLanguagePreferenceAccess.TYPE_CONVERSION_PROPERTY);
	}

	@Override
	protected String getColumnWidthDialogSettingsKey() {
		return TYPE_CONVERTER_COLUMN_WIDTH_ID;
	}

	@Override
	protected String getColumnSortCriteraDialogSettingsKey() {
		return TYPE_CONVERTER_SORT_COLUMN;
	}

}
