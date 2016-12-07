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

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;

import javax.persistence.TypedQuery;

import org.openfact.models.ScrollModel;

public class ScrollAdapter<T, R> implements ScrollModel<T> {

    protected int size;
    protected TypedQuery<R> query;
    protected Function<R, T> converter;

    protected  Class<R> type;

    public ScrollAdapter(Class<R> type, TypedQuery<R> query, Function<R, T> converter) {
        this(type, query, converter, 10);
    }

    public ScrollAdapter(Class<R> type, TypedQuery<R> query, Function<R, T> converter, int size) {
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

        private int current;

        public PageIterator() {
            this.page = 1;
            this.pageSize = size;
        }

        @Override
        public boolean hasNext() {
            if (results == null) {
                refreshResults();
            }
            if (current < results.size()) {
                return true;
            } else {
                if (current == pageSize) {
                    refreshResults();
                    return hasNext();
                } else {
                    return false;
                }
            }
        }

        @Override
        public T next() {
            R r = results.get(current++);
            if (r == null) {
                throw new NoSuchElementException();
            }
            return (T) converter.apply(type.cast(r));
        }

        private void refreshResults() {
            int start = (page - 1) * pageSize;
            results = (List<R>) query.setFirstResult(start).setMaxResults(pageSize).getResultList();
            page++;
            current = 0;
        }

    }

}
