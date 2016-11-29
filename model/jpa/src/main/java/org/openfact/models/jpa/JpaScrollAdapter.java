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
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.openfact.models.ScrollModel;

public class JpaScrollAdapter<T, E> implements ScrollModel<T> {

    protected int firstResult;
    protected int scrollSize = 5;
    protected int fetchSize = 1;

    protected Criteria criteria;

    protected Function<E, T> converter;

    public JpaScrollAdapter(Criteria criteria, Function<E, T> converter) {
        this.criteria = criteria;
        this.converter = converter;
    }

    public JpaScrollAdapter(Criteria criteria, int scrollSize, Function<E, T> converter) {
        this.criteria = criteria;
        this.scrollSize = scrollSize;
        this.converter = converter;
    }

    public JpaScrollAdapter(Criteria criteria, int scrollSize, int fetchSize, Function<E, T> converter) {
        this.criteria = criteria;
        this.scrollSize = scrollSize;
        this.fetchSize = fetchSize;
        this.converter = converter;
    }

    @Override
    public Iterator<T> iterator() {
        return new PageIterator<T, E>(criteria, scrollSize, fetchSize, converter);
    }

    static class PageIterator<T, E> implements Iterator<T> {
        protected int page;
        protected int pageSize;
        protected int fetchSize;

        protected Criteria criteria;

        private int currentResultRow;
        private ScrollableResults results;

        protected Function<E, T> converter;

        public PageIterator(Criteria criteria, int pageSize, int fetchSize, Function<E, T> converter) {
            this.criteria = criteria;
            this.pageSize = pageSize;
            this.fetchSize = fetchSize;
            this.converter = converter;
        }

        @Override
        public boolean hasNext() {
            if (results == null) {
                refreshResults();
            }
            if (results.next()) {
                return true;
            } else {
                refreshResults();
                if (results.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return converter.apply((E)results.get(currentResultRow++));
        }

        private void refreshResults() {
            int start = (page - 1) * pageSize;
            results = criteria.setFirstResult(start).setMaxResults(pageSize + 1).setFetchSize(fetchSize).scroll(ScrollMode.SCROLL_SENSITIVE);
            page++;
            currentResultRow = 0;
        }

    }

}
