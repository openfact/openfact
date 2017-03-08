package org.openfact.ubl.report.jasper;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicJRDataSource<T> implements JRDataSource {

    protected CopyOnWriteArrayList<T> dataSource = new CopyOnWriteArrayList<T>();
    protected AtomicInteger current = new AtomicInteger();

    public BasicJRDataSource(T data) {
        this.current.set(0);
        this.dataSource.add(data);
    }

    public BasicJRDataSource(List<T> data) {
        this.current.set(0);
        this.dataSource.addAll(data);
    }

    @Override
    public boolean next() throws JRException {
        return current.getAndIncrement() < this.dataSource.size();
    }

}
