package org.openfact.services.util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class MaskToString {

	public static String formatString(String value, String mask, boolean literalCharacter) throws ParseException {
		MaskFormatter mf = new MaskFormatter(mask);
		mf.setValueContainsLiteralCharacters(literalCharacter);
		return mf.valueToString(value);
	}
}
