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
package io.sarl.lang.documentation;

import io.sarl.lang.services.SARLGrammarAccess;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.inject.Inject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.IComment;
import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.lib.Pure;

/** Formatter a documentation string.
 */
public class DocumentationFormatter implements IDocumentationFormatter {

	private static final String SPACE_CHAR = " ";
	private static final String NL_CHAR = "\n";
	private static final String EMPTY_STR = "";
	private String mlLinePrefix;
	private String mlStart;
	private String mlEnd;
	private String slPrefix;

	protected static boolean isNewLine(char character) {
		if (character == '\n' || character == '\r' || character == '\f') {
			return true;
		}
	return ((((1 << Character.LINE_SEPARATOR)
			| (1 << Character.PARAGRAPH_SEPARATOR)) >> Character.getType((int) character)) & 1) != 0;
	}

	@Pure
	public String getMultilineCommentStartSymbols() {
		return this.mlStart;
	}

	public void setMultilineCommentStartSymbols(String symbols) {
		this.mlStart = symbols;
	}

	@Pure
	public String getMultilineCommentEndSymbols() {
		return this.mlEnd;
	}

	public void setMultilineCommentEndSymbols(String symbols) {
		this.mlEnd = symbols;
	}

	@Pure
	public String getMultilineCommentLinePrefix() {
		return this.mlLinePrefix;
	}

	public void setMultilineCommentLinePrefix(String prefix) {
		this.mlLinePrefix = prefix;
	}

	@Pure
	public String getSinglelineCommentPrefix() {
		return this.slPrefix;
	}

	@Pure
	protected Set<Character> getSinglelineCommentSpecialChars() {
		final Set<Character> set = new TreeSet<>();
		set.add('*');
		set.add('+');
		set.add('-');
		set.add('=');
		return set;
	}

	public void setSinglelineCommentPrefix(String prefix) {
		this.slPrefix = prefix;
	}

	@Inject
	public void setGrammarAccess(SARLGrammarAccess access) {
		if (this.mlStart == null || this.mlEnd == null) {
			AbstractRule mlRule = access.getML_COMMENTRule();
			for (AbstractElement element : ((Group) mlRule.getAlternatives()).getElements()) {
				if (element instanceof Keyword && this.mlStart == null) {
					this.mlStart = ((Keyword) element).getValue();
				} else if (element instanceof UntilToken && this.mlEnd == null) {
					this.mlEnd = ((Keyword) ((UntilToken) element).getTerminal()).getValue();
				}
			}
		}
		if (this.mlLinePrefix == null) {
			this.mlLinePrefix = this.mlStart.substring(this.mlStart.length() - 1);
		}
		if (this.slPrefix == null) {
			AbstractRule slRule = access.getSL_COMMENTRule();
			for (AbstractElement element : ((Group) slRule.getAlternatives()).getElements()) {
				if (element instanceof Keyword) {
					this.slPrefix = ((Keyword) element).getValue().trim();
					break;
				}
			}
		}
	}

	@Pure
	public String formatMultilineComment(String doc) {
		return formatMultilineComment(doc, (String) null);
	}

	@Pure
	public String formatMultilineComment(String doc, String indentation) {
		IAppendable appendable = new StringBuilderBasedAppendable();
		formatMultilineComment(doc, indentation, appendable);
		return appendable.getContent();
	}

	@Pure
	public void formatMultilineComment(String doc, IAppendable appendable) {
		formatMultilineComment(doc, null, appendable);
	}

	@Pure
	public void formatMultilineComment(String doc, String indentation, IAppendable appendable) {
		if (!Strings.isEmpty(doc)) {
			final SortedMap<Integer, Replacement> replacements = new TreeMap();
			formatMultlineComment(indentation, Strings.newLine(), new AppendableAccessor(appendable, doc, replacements, 0, doc.length()));
		}
	}

	@Pure
	public void formatMultilineComment(ITextReplacerContext context, IComment comment) {
		formatMultlineComment(context.getIndentationString(), context.getNewLinesString(1), new RegionAccessor(context, comment));
	}

	@Pure
	public String formatSinglelineComment(String doc) {
		return formatSinglelineComment(doc, (String) null);
	}

	@Pure
		public String formatSinglelineComment(String doc, String indentation) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
		formatSinglelineComment(doc, indentation, appendable);
		return appendable.getContent();
	}

	@Pure
	public void formatSinglelineComment(String doc, IAppendable appendable) {
		formatSinglelineComment(doc, null, appendable);
	}

	@Pure
	public void formatSinglelineComment(String doc, String indentation, IAppendable appendable) {
		if (!Strings.isEmpty(doc)) {
			final SortedMap<Integer, Replacement> replacements = new TreeMap<>();
			int offset = doc.indexOf(getSinglelineCommentPrefix());
			if (offset < 0) {
				offset = 0;
			}
			int endOffset = doc.indexOf(NL_CHAR, offset);
			if (endOffset < 0) {
				endOffset = doc.length();
			}
			formatSinglelineComment(
				indentation,
				new AppendableAccessor(appendable, doc, replacements, offset, endOffset));
		}
	}

	public void formatSinglelineComment(ITextReplacerContext context, IComment comment) {
		formatSinglelineComment(context.getIndentationString(), new RegionAccessor(context, comment));
	}

	private <T> void formatSinglelineComment(String indentationString, FormattedTextAccessor<T> backend) {
		final String indent = Strings.emptyIfNull(indentationString);
		final String comment = backend.getCommentText();
		// Compute the starting offset of the text inside the comment
		int offset = comment.indexOf(getSinglelineCommentPrefix());
		if (offset < 0) {
			backend.replace(0, 0, getSinglelineCommentPrefix());
			offset = 0;
		} else {
			offset += getSinglelineCommentPrefix().length();
		}
		final int endOffset = comment.length();
		T currentLine = backend.getFirstLine(backend.getCommentOffset());
		boolean firstLine = true;
		while (currentLine != null) {
			String lineText = backend.getLineText(currentLine);
			int lineOffset = backend.getLineOffset(currentLine);
			int lineLength = backend.getLineLength(currentLine);
			// Clamp the line text to the comment area.
			if (firstLine) {
				if (lineOffset < offset) {
					final int len = offset - lineOffset;
					lineText = lineText.substring(len);
					lineOffset += len;
					lineLength -= len;
				}
			} else if (lineOffset >= endOffset) {
				// After the end of comment
				backend.applyReplacements();
				return;
			} else {
				final String prefix;
				if (!startsWith(lineText, 0, getSinglelineCommentPrefix())) {
					prefix = indent + getSinglelineCommentPrefix();
				} else {
					prefix = indent;
				}
				backend.replace(lineOffset, 0, prefix);
			}
			// Skip the comment characters that corresponds to the Javadoc format: //[*-+=].
			int realCommentStart = 0;
			final Set<Character> specialChars = getSinglelineCommentSpecialChars();
			while (realCommentStart < lineLength && specialChars.contains(lineText.charAt(realCommentStart))) {
				++realCommentStart;
			}
			// Search for the first non whitespace
			int firstNonWhiteSpacePos = realCommentStart;
			while (firstNonWhiteSpacePos < lineLength && Character.isWhitespace(lineText.charAt(firstNonWhiteSpacePos))) {
				++firstNonWhiteSpacePos;
			}
			// Add whitespace at the beginning.
			if (firstNonWhiteSpacePos == lineLength) {
				// Empty comment
				if (realCommentStart < firstNonWhiteSpacePos) {
					backend.replace(realCommentStart + lineOffset, lineLength - realCommentStart, EMPTY_STR);
				}
			} else {
				final int expectedNbWhiteSpaces = getWhiteSpacesOnFirstLine();
				final int nbWhiteSpaces = firstNonWhiteSpacePos - realCommentStart;
				if (nbWhiteSpaces != expectedNbWhiteSpaces) {
					backend.replace(realCommentStart + lineOffset, nbWhiteSpaces, makeWhiteSpaces(expectedNbWhiteSpaces));
				}
				// Format the comment text
				formatLineText(
					lineText.substring(firstNonWhiteSpacePos, lineLength), true,
					new SubAccessor<>(backend, lineOffset + firstNonWhiteSpacePos));
				// Remove trailing whitespaces
				int endOfText = lineLength;
				while ((endOfText - 1) > firstNonWhiteSpacePos && Character.isWhitespace(lineText.charAt(endOfText - 1))) {
					--endOfText;
				}
				if (endOfText < lineLength) {
					backend.replace(endOfText + lineOffset, lineLength - endOfText, EMPTY_STR);
				}
			}
			firstLine = false;
			currentLine = backend.getNextLine(currentLine);
		}
		backend.applyReplacements();
	}

	private static String safeSubstring(String text, int start, int length) {
		if (text == null) {
			return EMPTY_STR;
		}
		final int index = Math.max(0, start);
		final int len = Math.max(0, Math.min(length, text.length()));
		return text.substring(index, index + len);
	}

	private static boolean startsWith(String text, int start, String pattern) {
		return safeSubstring(text, start, pattern.length()).equals(pattern);
	}

	private static String makeWhiteSpaces(int nb) {
		final StringBuilder b = new StringBuilder();
		for (int i = 0; i < nb; ++i) {
			b.append(SPACE_CHAR);
		}
		return b.toString();
	}

	protected int getWhiteSpacesOnFirstLine() {
		return 1;
	}

	protected int getWhiteSpacesOnOtherLines() {
		return 1;
	}

	protected <T> void formatLineText(String lineText, boolean isMultlineComment, FormattedTextAccessor<T> backend) {
	}

	private <T> boolean formatMultlineCommentFirstLine(String lineText, String indentationString, String newLineString, int endCommentOffset, FormattedTextAccessor<T> backend) {
		// Skip the comment characters that corresponds to the Javadoc format: /**.
		int realCommentStart = 0;
		while (realCommentStart < lineText.length() && startsWith(lineText, realCommentStart, getMultilineCommentLinePrefix())) {
			realCommentStart += getMultilineCommentLinePrefix().length();
		}
		// Search for the first non whitespace
		int firstNonWhiteSpacePos = realCommentStart;
		boolean hasNonSpaceChar = false;
		while (firstNonWhiteSpacePos < lineText.length() && Character.isWhitespace(lineText.charAt(firstNonWhiteSpacePos))) {
			if (!Character.isSpaceChar(lineText.charAt(firstNonWhiteSpacePos))) {
				hasNonSpaceChar = true;
			}
			++firstNonWhiteSpacePos;
		}
		// Add whitespace at the beginning.
		final int expectedNbWhiteSpaces = getWhiteSpacesOnFirstLine();
		final int nbWhiteSpaces = firstNonWhiteSpacePos - realCommentStart;
		if (hasNonSpaceChar || nbWhiteSpaces != expectedNbWhiteSpaces) {
			backend.replace(realCommentStart, nbWhiteSpaces, makeWhiteSpaces(expectedNbWhiteSpaces));
		}
		// Treat the end of comment
		if (endCommentOffset <= lineText.length()) {
			// Comment end at the first line. Insert a newline character
			// Search for the end of comment text.
			int endPos = endCommentOffset;
			final int end = endPos;
			while ((endPos - 1) > firstNonWhiteSpacePos && Character.isWhitespace(lineText.charAt(endPos - 1))) {
				--endPos;
			}
			// Format the comment text
			formatLineText(lineText.substring(firstNonWhiteSpacePos, endPos), true, new SubAccessor<>(backend, firstNonWhiteSpacePos));
			// Do the replacement
			backend.replace(endPos, end - endPos, newLineString + indentationString + SPACE_CHAR);
			// We don't need to treat more line
			return true;
		}
		// Format the comment text
		formatLineText(lineText.substring(firstNonWhiteSpacePos, lineText.length()), true, new SubAccessor<>(backend, firstNonWhiteSpacePos));
		return false;
	}

	private <T> boolean formatMultlineCommentOtherLines(String lineText, String indentationString, String newLineString, int endCommentOffset, FormattedTextAccessor<T> backend) {
		// Search for the comment prefix (usually " * "
		int realCommentStart = 0;
		while (realCommentStart < lineText.length() && Character.isWhitespace(lineText.charAt(realCommentStart))) {
			++realCommentStart;
		}
		boolean foundStar = false;
		if (realCommentStart < lineText.length() && startsWith(lineText, realCommentStart, getMultilineCommentLinePrefix())) {
			realCommentStart += getMultilineCommentLinePrefix().length();
			foundStar = true;
			while (realCommentStart < lineText.length() && Character.isWhitespace(lineText.charAt(realCommentStart))) {
				++realCommentStart;
			}
		}
		// Compute the standard prefix.
		StringBuilder prefix = new StringBuilder(indentationString);
		prefix.append(SPACE_CHAR);
		prefix.append(getMultilineCommentLinePrefix());
		prefix.append(makeWhiteSpaces(getWhiteSpacesOnOtherLines()));
		// Force replacement by the line's prefix
		int minBoundForEnd = 0;
		if (endCommentOffset > lineText.length() || foundStar || realCommentStart < endCommentOffset) {
			backend.replace(0, realCommentStart, prefix.toString());
			if (foundStar) {
				minBoundForEnd = prefix.length();
			}
		}
		// Format the comment text
		if (endCommentOffset <= lineText.length()) {
			// End of comment on the current line.
			int endPosition = endCommentOffset;
			final int end = endPosition;
			while ((endPosition - 1) >= minBoundForEnd && Character.isWhitespace(lineText.charAt(endPosition - 1))) {
				--endPosition;
			}
			if (endPosition > 0) {
				// Comment end with a text before. Insert a newline character
				backend.replace(endPosition, end - endPosition, newLineString + indentationString + SPACE_CHAR);
			} else {
				// Replace spaces before end of comment if they exist
				backend.replace(endPosition, end - endPosition, indentationString + SPACE_CHAR);
			}
			// We don't need to treat more line
			return true;
		}
		return false;
	}

	private <T> void formatMultlineComment(String indentationString, String newLineString, FormattedTextAccessor<T> backend) {
		final String indent = Strings.emptyIfNull(indentationString);
		final String comment = backend.getCommentText();
		// Compute the starting offset of the text inside the comment
		int offset = comment.indexOf(getMultilineCommentStartSymbols());
		if (offset < 0) {
			backend.replace(0, 0, getMultilineCommentStartSymbols());
			offset = 0;
			} else {
				offset += getMultilineCommentStartSymbols().length();
			}
			// Compute the ending offset of the text inside the comment
			int endOffset = comment.indexOf(getMultilineCommentEndSymbols(), offset);
			if (endOffset < 0) {
				endOffset = comment.length();
				backend.replace(endOffset, 0, getMultilineCommentEndSymbols());
			}
			// Go through the lines
			T currentLine = backend.getFirstLine(backend.getCommentOffset());
			boolean firstLine = true;
			while (currentLine != null) {
				String lineText = backend.getLineText(currentLine);
				int lineOffset = backend.getLineOffset(currentLine);
				int lineLength = backend.getLineLength(currentLine);
				// Clamp the line text to the comment area.
				if (lineOffset < offset) {
					final int len = offset - lineOffset;
					lineText = lineText.substring(len);
					lineOffset += len;
					lineLength -= len;
				}
				if ((lineOffset + lineLength) > endOffset) {
					final int len = lineOffset + lineLength - endOffset;
					lineText = lineText.substring(0, lineText.length() - len);
					lineLength -= len;
				}
				if (firstLine) {
					if (formatMultlineCommentFirstLine(lineText, indent, newLineString, endOffset - lineOffset, new SubAccessor(backend, lineOffset))) {
						backend.applyReplacements();
						return;
					}
				} else {
				if (formatMultlineCommentOtherLines(lineText, indent, newLineString, endOffset - lineOffset, new SubAccessor(backend, lineOffset))) {
					backend.applyReplacements();
					return;
				}
			}
			firstLine = false;
			currentLine = backend.getNextLine(currentLine);
		}
		backend.applyReplacements();
	}

	public interface FormattedTextAccessor<T> {
		T getFirstLine(int offset);
		T getNextLine(T currentLine);
		int getLineOffset(T currentLine);
		int getLineLength(T currentLine);
		String getLineText(T line);
		String getCommentText();
		int getCommentOffset();
		int getCommentEndOffset();
		Replacement replace(int offset, int length, String newText);
		void applyReplacements();
	}

	public class SubAccessor<T> implements FormattedTextAccessor<T> {
		private final FormattedTextAccessor<T> parent;
		private final int offsetInParent;
		public SubAccessor(FormattedTextAccessor<T> parent, int offsetInParent) {
			assert parent != null;
			this.parent = parent;
			this.offsetInParent = offsetInParent;
		}
		public T getFirstLine(int offset) {
			return this.parent.getFirstLine(offset);
		}
		public T getNextLine(T currentLine) {
			return this.parent.getNextLine(currentLine);
		}
		public int getLineOffset(T currentLine) {
			return this.parent.getLineOffset(currentLine);
		}
		public int getLineLength(T currentLine) {
			return this.parent.getLineLength(currentLine);
		}
		public String getLineText(T line) {
			return this.parent.getLineText(line);
		}
		public String getCommentText() {
			return this.parent.getCommentText();
		}
		public int getCommentOffset() {
			return this.parent.getCommentOffset();
		}
		public int getCommentEndOffset() {
			return this.parent.getCommentEndOffset();
		}
		public Replacement replace(int offset, int length, String newText) {
			return this.parent.replace(this.offsetInParent + offset, length, newText);
		}
		public final void applyReplacements() {
			throw new UnsupportedOperationException();
		}
	}

	public static class Line {
		private final int offset;
		private final int length;
		public static Line newInstance(String text, int offset) {
			if (offset < 0 || offset >= text.length()) {
				return null;
			}
			int soffset = offset;
			while (soffset >= 0 && !isNewLine(text.charAt(soffset))) {
				--soffset;
			}
			++soffset;
			int eoffset = soffset;
			while (eoffset < text.length() && !isNewLine(text.charAt(eoffset))) {
				++eoffset;
			}
			final int length = Math.max(0, eoffset - soffset);
			return new Line(soffset, length);
		}
		private Line(int offset, int length) {
			this.offset = offset;
			this.length = length;
		}
		public int getOffset() {
			return this.offset;
		}
		public int getLength() {
			return this.length;
		}
		public String toString() {
			return "offset: " + getOffset() + "; length: " + getLength();
		}
	}

	public static abstract class AbstractReplacementAccessor<T> implements FormattedTextAccessor<T> {
		private final String documentation;
		private SortedMap<Integer, Replacement> replacements;
		private boolean applied;
		public AbstractReplacementAccessor(String documentation, SortedMap<Integer, Replacement> replacements) {
			this.documentation = documentation;
			this.replacements = replacements;
		}
		protected final void checkNotApplied() {
			if (this.applied) {
				throw new IllegalStateException("Changes are already applied");
			}
			this.applied = true;
		}
		public String getCommentText() {
			return this.documentation;
		}
		protected SortedMap<Integer, Replacement> getReplacements() {
			if (this.replacements == null) {
				this.replacements = new TreeMap<>();
			}
			return this.replacements;
		}
		public Replacement replace(int offset, int length, String newText) {
			Replacement rep = getReplacements().remove(offset);
			if (rep == null) {
				rep = new Replacement(offset, length, newText);
			} else {
				rep = new Replacement(offset, rep.getLength() + length, rep.getText() + newText);
			}
			getReplacements().put(offset, rep);
			return rep;
		}
		protected static void applyReplacements(IAppendable appendable, String text, Map<Integer, Replacement> replacements) {
			int offset = 0;
			for (final Replacement replacement : replacements.values()) {
				if (replacement.getOffset() < offset) {
					appendable.append("<<<Conflicting replacements>>>");
				} else {
					final int len = replacement.getOffset() - offset;
					assert offset >= 0;
					assert replacement.getOffset() <= text.length();
					String notReplacedString = text.substring(offset, replacement.getOffset());
					appendable.append(notReplacedString);
					offset += notReplacedString.length();
					appendable.append(replacement.getText());
					offset += replacement.getLength();
				}
			}
			if (offset < text.length()) {
				String notReplacedString = text.substring(offset);
				appendable.append(notReplacedString);
			}
		}
	}

	public static abstract class AbstractDebuggingAccessor<T> extends AbstractReplacementAccessor<T> {
		private String buffer;
		public AbstractDebuggingAccessor(String text, SortedMap<Integer, Replacement> replacements) {
			super(text, replacements);
		}
		private String computeBuffer() {
			IAppendable appendable = new FakeTreeAppendable();
			applyReplacements(appendable, getCommentText(), getReplacements());
			return appendable.getContent();
		}
		public String toString() {
			if (this.buffer == null) {
				this.buffer = computeBuffer();
			}
			return this.buffer;
		}

		public Replacement replace(int offset, int length, String newText) {
			final Replacement rep = super.replace(offset, length, newText);
			this.buffer = computeBuffer();
			return rep;
		}

	}

	public static class RegionAccessor extends AbstractReplacementAccessor<ILineRegion> {
		private final ITextReplacerContext context;
		private final ITextRegionAccess access;
		private final IComment comment;
		public RegionAccessor(ITextReplacerContext context, IComment comment) {
			super(comment.getText(), null);
			this.context = context;
			this.comment = comment;
			this.access = comment.getTextRegionAccess();
		}

		public String getCommentText() {
			return this.comment.getText();
		}

		public String getLineText(ILineRegion line) {
			ITextSegment segment = this.access.regionForOffset(line.getOffset(), line.getLength());
			return segment.getText();
		}

		public int getCommentOffset() {
			return this.comment.getOffset();
		}

		public int getCommentEndOffset() {
			return this.comment.getEndOffset();
		}

		public ILineRegion getFirstLine(int offset) {
			return this.access.regionForLineAtOffset(offset);
		}

		public ILineRegion getNextLine(ILineRegion currentLine) {
			return currentLine.getNextLine();
		}

		public int getLineOffset(ILineRegion currentLine) {
			return currentLine.getOffset() - getCommentOffset();
		}

		public int getLineLength(ILineRegion currentLine) {
			return currentLine.getLength();
		}

		public void applyReplacements() {
			checkNotApplied();
			for (Replacement replacement : getReplacements().values()) {
				ITextSegment target = this.access.regionForOffset(replacement.getOffset() + getCommentOffset(), replacement.getLength());
				this.context.addReplacement(target.replaceWith(replacement.getText()));
			}
		}

	}

	private static class AppendableAccessor extends AbstractReplacementAccessor<Line> {
		private final IAppendable target;
		private final int commentOffset;
		private final int commentEndOffset;
		public AppendableAccessor(IAppendable target, String documentation, SortedMap<Integer, Replacement> replacements, int commentOffset, int commentEndOffset) {
			super(documentation, replacements);
			this.target = target;
			this.commentOffset = commentOffset;
			this.commentEndOffset = commentEndOffset;
		}

		public Line getFirstLine(int offset) {
			return Line.newInstance(getCommentText(), offset);
		}

		public Line getNextLine(Line currentLine) {
			int index = getCommentText().indexOf(NL_CHAR, currentLine.getOffset());
			if (index < 0) {
				return null;
			}
			return Line.newInstance(getCommentText(), index + 1);
		}

		public int getLineOffset(Line currentLine) {
			return currentLine.getOffset();
		}

		public int getLineLength(Line currentLine) {
			return currentLine.getLength();
		}

		public String getLineText(Line line) {
			final int offset = line.getOffset();
			return getCommentText().substring(offset, offset + line.getLength());
		}

		public int getCommentOffset() {
			return this.commentOffset;
		}

		public int getCommentEndOffset() {
			return this.commentEndOffset;
		}

		public void applyReplacements() {
			checkNotApplied();
			applyReplacements(this.target, getCommentText(), getReplacements());
		}

	}

	public static class Replacement {
		private final int offset;
		private final int length;
		private final String text;
		public Replacement(int offset, int length, String text) {
			this.offset = offset;
			this.length = length;
			this.text = text;
		}
		public int getOffset() {
			return this.offset;
		}
		public int getLength() {
			return this.length;
		}
		public String getText() {
			return this.text;
		}
		public String toString() {
			return "offset: " + getOffset() + "; length: " + getLength() + "; new text: " + getText();
		}

	}

}

