package org.openfact.models.query;

public interface Sortable {

    Sortable orderByAsc(String... asc);

    Sortable orderByDesc(String... desc);

}
