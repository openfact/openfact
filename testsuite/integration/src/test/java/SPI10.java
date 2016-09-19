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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.atteo.evo.inflector.English;

public class SPI10 {

    public static void main(String[] args) throws IOException {
        String sourceDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/adapters1";

        implementsInterfaces(sourceDir);
    }

    private static void implementsInterfaces(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);

        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());

            // obtain attributes
            Map<String, String> attributes = new HashMap<>();
            for (String line : lines) {
                if (line.contains("private")) {
                    List<String> splits = Arrays.asList(line.split(" "));
                    splits = splits.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());

                    attributes.put(splits.get(2), splits.get(1));
                }
            }

            // Strig that contains getters and setters
            StringBuilder accessors = new StringBuilder();
            for (String attributeName : attributes.keySet()) {
                accessors.append(getTemplate(attributeName, attributes.get(attributeName))).append(" ");
                accessors.append(setTemplate(attributeName, attributes.get(attributeName))).append(" ");
                accessors.append("\n");
            }

            // new content
            StringBuilder newContent = new StringBuilder();
            for (String line : lines) {
                if (line.contains("}")) {
                    newContent.append(accessors);
                    newContent.append("}");
                } else {
                    newContent.append(line);
                }
            }

            Files.write(path, newContent.toString().getBytes(charset));

        }
    }

    public static String getTemplate(String attributeName, String type) {
        attributeName = attributeName.replaceAll(";", "");
        String template = "public type getAttributeName() {return this.attributeName;}";
        template = template.replaceAll("type", type);
        template = template.replaceAll("attributeName", attributeName);
        template = template.replaceAll("getAttributeName",
                "get" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1));
        return template;
    }

    public static String setTemplate(String attributeName, String type) {
        attributeName = attributeName.replaceAll(";", "");
        String template = "public void setAttributeName(type attributeName) {this.attributeName = attributeName;}";
        template = template.replaceAll("type", type);
        template = template.replaceAll("attributeName", attributeName);
        template = template.replaceAll("setAttributeName",
                "set" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1));
        return template;
    }

}
