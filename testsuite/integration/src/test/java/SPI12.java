import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

public class SPI12 {

    public static void main(String[] args) throws IOException {
        String destinationDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/org/openfact/models/jpa/entities/ubl/common";

        List<Path> paths = SPI.getPaths(destinationDir);

        for (Path path : paths) {
            String className = FilenameUtils.removeExtension(path.getFileName().toFile().getName());
            System.out.println("<class>org.openfact.models.jpa.entities.ubl.common."+className+"</class>");
        }
    }

}
