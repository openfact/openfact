package org.openfact.pe.models.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SUNATUtils {

    private SUNATUtils() {
        // Just utils class
    }

    public static String incrementarSerie(String serie) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(serie);
        String numeroSerie = null;
        while (matcher.find()) {
            numeroSerie = matcher.group();
        }
        if (numeroSerie == null) {
            throw new IllegalStateException("Serie Invalida, no se pudo extraer el Numero de Serie");
        }

        String prefijoSerie = serie.replaceFirst(numeroSerie, "");
        return prefijoSerie + (Integer.parseInt(numeroSerie) + 1);
    }
}
