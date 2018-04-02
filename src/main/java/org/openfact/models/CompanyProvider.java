package org.openfact.models;

import java.util.Optional;

public interface CompanyProvider {

    CompanyModel addCompany(String name, UserModel owner);

    Optional<CompanyModel> getCompany(String id);

}
