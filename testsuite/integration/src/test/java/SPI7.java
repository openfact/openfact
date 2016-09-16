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

import org.atteo.evo.inflector.English;

public class SPI7 {

    public static void main(String[] args) throws IOException {
        String sourceDir = "/home/admin/git/openfact-temp/core/src/main/java/org/openfact/representations/idm/ubl";
        String destinationDirEntity = "/home/admin/git/openfact-temp/core/src/main/java/org/openfact/representations/idm/ubl1";

        //copyFolder(sourceDir, destinationDirEntity);
        lowerCase(sourceDir);
    }

    public static void copyFolder(String sourceDir, String destinationDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);

        for (Path path : paths) {

            Path destinationPath = Paths.get(destinationDir);
            if (!Files.exists(destinationPath)) {
                Files.createDirectory(destinationPath);
            }

            String fileName = path.getFileName().toFile().getName();
            Path pathPattern = destinationPath.resolve(fileName.replaceAll("Model", "Representation"));
            Files.copy(path, pathPattern, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public static void changeClassNameDeclarations(String sourceDir, String pattern1, String pattern2)
            throws IOException {

    }

    public static void lowerCase(String sourceDir) throws IOException {
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
                    String two = attributeName.substring(0, 2);
                    boolean uppercase = !two.toUpperCase().equals(two);
                    if (uppercase) {
                        String newAttributeName = attributeName.substring(0, 1).toLowerCase()
                                + attributeName.substring(1);
                        splits.set(2, newAttributeName);
                    }

                    for (String attribute : splits) {
                        newContent.append(attribute).append(" ");
                    }
                    newContent.append("\n");
                } else {
                    newContent.append(line).append("\n");
                }
            }

            Files.write(path, newContent.toString().getBytes(charset));

        }
    }

}
