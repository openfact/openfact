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

public class SPI8 {

    public static void main(String[] args) throws IOException {
        String sourceDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/adapters";
        String destinationDirEntity = "/home/admin/git/openfact-temp/model/jpa/src/main/java/adapters1";

        copyFolder(sourceDir, destinationDirEntity);                              
    }

    public static void copyFolder(String sourceDir, String destinationDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        
        for (Path path : paths) {
          
            Path destinationPath = Paths.get(destinationDir);
            if (!Files.exists(destinationPath)) {
                Files.createDirectory(destinationPath);
            }
           
            String fileName = path.getFileName().toFile().getName();
            Path pathPattern = destinationPath.resolve(fileName.replaceAll("Representation", "Adapter"));
            Files.copy(path, pathPattern, StandardCopyOption.REPLACE_EXISTING);
        }                
    }
    
    public static void changeClassName(String sourceDir, String pattern) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        
        List<String> classNames = new ArrayList<>();
        for (Path path : paths) {
            String className = SPI.getClassName(path);
            classNames.add(className);
        } 
        
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);

            for (String spacedClassName : classNames) {
                String newClassName = spacedClassName.trim().replaceAll(" ", "");    
                content = content.replaceAll(spacedClassName, newClassName);
            }
            Files.write(path, content.getBytes(charset));
            
            //change class name
            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());

            StringBuilder newContent = new StringBuilder();
            for (String line : lines) {
                if (line.contains("public class")) {
                    newContent.append("public class " + SPI.getClassName(path).trim().replaceAll(" ", "") + pattern + "{").append("\n");
                } else {
                    newContent.append(line).append("\n");
                }                
            }
            Files.write(path, newContent.toString().getBytes(charset));
           
        } 
    }
    
    public static void changeClassNameDeclarations(String sourceDir, String pattern) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        
        List<String> classNames = new ArrayList<>();
        for (Path path : paths) {
            classNames.add(SPI.getClassName(path));
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
    }
    
    
}
