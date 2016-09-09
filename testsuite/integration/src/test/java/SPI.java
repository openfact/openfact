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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;

public class SPI {

    public static void main(String[] args) throws IOException {
        String sourceDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/org/openfact/ublbase";
        String destinationDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/org/openfact/models/jpa/entities/ubl1";

        copyFolder(sourceDir, destinationDir, "Entity");

        String[] a = null;
        SPI2.main(a);
    }

    public static void changeClassName(Path path, String pattern) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        String content = new String(Files.readAllBytes(path), charset);

        String className = getClassName(path);
        content = content.replaceAll(className + " ", className + pattern + " ");
        Files.write(path, content.getBytes(charset));
    }

    public static void copyFolder(String sourceDir, String destinationDir, String pattern)
            throws IOException {

        List<Path> paths = getPaths(sourceDir);
        for (Path path : paths) {
            String className = getClassName(path);

            Path destinationPath = Paths.get(destinationDir);
            if (!Files.exists(destinationPath)) {
                Files.createDirectory(destinationPath);
            }

            Path pathPattern = destinationPath.resolve(className + pattern + ".java");
            Files.copy(path, pathPattern, StandardCopyOption.REPLACE_EXISTING);

            changeClassName(pathPattern, pattern);
        }

        // get all new class names AlgoEntity
        paths = getPaths(destinationDir);
        List<String> classNames = new ArrayList<>();
        for (Path path : paths) {
            classNames.add(getClassName(path));
        }

        // replace all
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);

            for (String patternClassName : classNames) {
                String reverseClassName = patternClassName.substring(0, patternClassName.indexOf(pattern));
                content = content.replaceAll(reverseClassName + " ", patternClassName + " ");
                content = content.replaceAll(reverseClassName + ">", patternClassName + ">");
                content = content.replaceAll(pattern + pattern, pattern);
                content = content.replaceAll(pattern + ";", ";");
                content = content.replaceAll(pattern + " =", " =");
            }
            Files.write(path, content.getBytes(charset));
        }

        // remove finalize methods
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());

            StringBuilder newContent = new StringBuilder();
            boolean skip = false;
            for (String line : lines) {
                if (!line.contains("finalize") && skip == false) {
                    newContent.append(line).append("\n");
                } else {
                    skip = true;
                }

                if (skip == true && line.contains("}")) {
                    skip = false;
                }
            }

            Files.write(path, newContent.toString().getBytes(charset));
        }

        // remove contructor
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());

            StringBuilder newContent = new StringBuilder();
            boolean skip = false;

            String patternClassName = getClassName(path);
            String reverseClassName = patternClassName.substring(0, patternClassName.indexOf(pattern));
            for (String line : lines) {

                if (!line.contains(reverseClassName + "()") && skip == false) {
                    newContent.append(line).append("\n");
                } else {
                    skip = true;
                }

                if (skip == true && line.contains("}")) {
                    skip = false;
                }
            }

            Files.write(path, newContent.toString().getBytes(charset));
        }
    }

    public static List<Path> getPaths(String dir) throws IOException {
        Path path = Paths.get(dir);
        final List<Path> result = new ArrayList<>();

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!attrs.isDirectory()) {
                    result.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        return result;
    }

    public static List<String> getLinesFromPath(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static String getClassName(Path path) throws IOException {
        String result = null;
        for (String line : Files.readAllLines(path)) {
            if (line.contains("public class")) {
                int from = line.indexOf("class") + 5;
                int to = line.indexOf("{");
                if (to == -1) {
                    result = line.substring(from).trim();
                } else {
                    result = line.substring(from, to).trim();
                }
            }
        }
        return result;
    }
}
