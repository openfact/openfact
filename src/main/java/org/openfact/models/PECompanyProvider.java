package org.openfact.models;

import java.util.Optional;

public interface PECompanyProvider {

    Optional<PECompanyModel> getCompany(String id);

}
