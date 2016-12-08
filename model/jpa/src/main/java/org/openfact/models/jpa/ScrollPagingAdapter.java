/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa;

import org.openfact.models.ScrollModel;

import javax.persistence.TypedQuery;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ScrollPagingAdapter<T, R> implements ScrollModel<T> {

    protected int size;
    protected TypedQuery<R> query;
    protected Function<List<R>, T> converter;

    protected Class<R> type;

    public ScrollPagingAdapter(Class<R> type, TypedQuery<R> query, Function<List<R>, T> converter) {
        this(type, query, converter, 10);
    }

    public ScrollPagingAdapter(Class<R> type, TypedQuery<R> query, Function<List<R>, T> converter, int size) {
        this.type = type;
        this.query = query;
        this.converter = converter;
        this.size = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new PageIterator<T, R>();
    }

    class PageIterator<T, R> implements Iterator<T> {

        private int page;
        private int pageSize;
        private List<R> results;

        private boolean hasMore;

        public PageIterator() {
            this.page = 1;
            this.pageSize = size;
        }

        @Override
        public boolean hasNext() {
            if (results == null) {
                refreshResults();
                return !results.isEmpty();
            }
            return hasMore;
        }

        @Override
        public T next() {
            if (results.isEmpty()) {
                throw new NoSuchElementException();
            }
            return (T) converter.apply((List)results);
        }

        private void refreshResults() {
            int start = (page - 1) * pageSize;
            List<R> results = (List<R>) query.setFirstResult(start).setMaxResults(pageSize + 1).getResultList();
            page++;
            if(results.size() > pageSize) hasMore = true;
            results.remove(results.size());
            this.results = results;
        }

    }

}
