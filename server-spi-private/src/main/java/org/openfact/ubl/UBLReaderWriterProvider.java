package org.openfact.ubl;

public interface UBLReaderWriterProvider<T> {

    UBLReader<T> reader();

    UBLWriter<T> writer();

}