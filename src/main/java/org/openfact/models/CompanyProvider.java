package org.openfact.models;

import java.util.List;

public interface CompanyProvider {

    CompanyModel addCompany(String name, UserModel owner);

}
