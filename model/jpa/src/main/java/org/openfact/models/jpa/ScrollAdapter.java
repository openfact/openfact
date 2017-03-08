package org.openfact.models.jpa;

import org.openfact.models.ScrollModel;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ScrollAdapter<T, R> implements ScrollModel<T> {

    protected int size;
    protected TypedQuery<R> query;
    protected Function<R, T> converter;

    protected Class<R> type;

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
