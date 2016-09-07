package org.openfact.adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.odysseus.staxon.event.SimpleXMLFilteredEventReader;

public class FilesT {

    public static void main(String[] args) throws IOException {

        String dirString = "/home/admin/git/openfact-temp/model/jpa/src/main/java/oasis";
        Path dir = FileSystems.getDefault().getPath(dirString);

        final List<Path> files = new ArrayList<>();

        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!attrs.isDirectory()) {
                    files.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        for (Path path : files) {

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());

            List<String> newLines = new ArrayList<>();
            boolean skip = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.contains("public") && !line.contains("class")) {
                    skip = true;
                }

                if (skip == false) {
                    newLines.add(line);
                }

                if (line.contains("}")) {
                    skip = false;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (String newLine : newLines) {
                sb.append(newLine);
                sb.append(" ");
            }
            
            Files.write(path, sb.toString().getBytes());
        }
    }

}
