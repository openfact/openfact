package org.openfact.ubl.pe;

import java.text.ParseException;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.util.MaskToString;
import org.openfact.ubl.UblIDProvider;

public class UblIDPEProvider implements UblIDProvider {

	protected OpenfactSession session;

	public UblIDPEProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
		System.out.println("closing...");

	}

	@Override
	public String getDocument(OrganizationModel organization) {
		String value = "F001-00000001";
		String mask = "A###-########";
		try {
			return MaskToString.formatString(value, mask, true);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
