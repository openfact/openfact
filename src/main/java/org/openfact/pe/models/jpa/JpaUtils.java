package org.openfact.pe.models.jpa;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JpaUtils {

    private JpaUtils() {
        // Just util class
    }

    public static <T> Optional<T> getFirstResult(List<T> list) {
        if (list.size() == 1) {
            return Optional.of(list.get(0));
        } else if (list.isEmpty()) {
            return Optional.empty();
        } else {
            throw new IllegalStateException("Mas de un resultado encontrado");
        }
    }

    public static <T, V> Optional<V> getFirstResult(List<T> list, Function<T, V> fn) {
        if (list.size() == 1) {
            return Optional.of(fn.apply(list.get(0)));
        } else if (list.isEmpty()) {
            return Optional.empty();
        } else {
            throw new IllegalStateException("Mas de un resultado encontrado");
        }
    }
}
