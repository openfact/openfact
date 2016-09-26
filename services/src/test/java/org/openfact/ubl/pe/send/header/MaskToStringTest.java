package org.openfact.ubl.pe.send.header;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class MaskToStringTest {
	public static String value = "F001-00000001";
	public static String mask = "A###-########";

	public static void main(String args[]) {
		try {
			System.out.println(formatString(value, mask));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

	public static String formatString(String value, String mask) throws ParseException {
		MaskFormatter mf = new MaskFormatter(mask);
		mf.setValueContainsLiteralCharacters(true);
		return mf.valueToString(value);
	}

}
