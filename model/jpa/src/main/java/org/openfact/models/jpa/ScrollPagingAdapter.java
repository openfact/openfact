package org.openfact.models.jpa;

import org.openfact.models.ScrollModel;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

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
            return (T) converter.apply((List) results);
        }

        private void refreshResults() {
            int start = (page - 1) * pageSize;
            List<R> results = (List<R>) query.setFirstResult(start).setMaxResults(pageSize + 1).getResultList();
            page++;
            if (results.size() > pageSize) {
                hasMore = true;
                results.remove(results.size());
            }
            this.results = results;
        }

    }

}
