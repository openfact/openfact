import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

public class SPI2 {

    public static void main(String[] args) throws IOException {
        String sourceDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/org/openfact/models/jpa/entities/ubl";

        // case sensitive
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());
            StringBuilder newContent = new StringBuilder();

            for (String line : lines) {
                if (line.contains("private")) {
                    List<String> splits = Arrays.asList(line.split(" "));
                    splits = splits.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());

                    String attributeName = splits.get(2);
                    String first = attributeName.substring(0, 1);
                    String second = attributeName.substring(1, 2);
                    if (!isUppercase(first) && !isUppercase(second)) {
                        String newAttributeName = attributeName.substring(0, 1).toLowerCase()
                                + attributeName.substring(1);
                        newContent.append(splits.get(0) + " " + splits.get(1) + " " + newAttributeName + ";")
                                .append("\n");
                    } else {
                        newContent.append(line).append("\n");
                    }
                } else {
                    newContent.append(line).append("\n");
                }
            }

            Files.write(path, newContent.toString().replaceAll(";;", ";").getBytes(charset));
        }

    }

    public static boolean isUppercase(String string) {
        return string.equals(string.toUpperCase());
    }

}
