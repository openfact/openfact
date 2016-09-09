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

public class SPI5 {

    public static void main(String[] args) throws IOException {
        //String destinationDirEntity = "/home/admin/git/openfact-temp/model/jpa/src/main/java/org/openfact/models/jpa/entities/ubl";
        //lowerCase(destinationDirEntity);
                
//        lowerCase("/home/admin/git/openfact-temp/model/jpa/src/main/java/adapter");
//        lowerCase("/home/admin/git/openfact-temp/model/jpa/src/main/java/model");
        lowerCase("/home/admin/git/openfact-temp/model/jpa/src/main/java/representation");
    }

    public static void lowerCase(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());
            
            List<String> attributes = new ArrayList<>();            
            for (String line : lines) {
                if (line.contains("private")) {
                    List<String> splits = Arrays.asList(line.split(" "));
                    splits = splits.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());
                                          
   
                    attributes.add(splits.get(2).replaceAll(";", ""));
                }
            }
            
            // replacte
            String content = new String(Files.readAllBytes(path), charset);
            for (String attribute : attributes) {         
                String two = attribute.substring(0, 2);
                boolean uppercase = !two.toUpperCase().equals(two);
                if(uppercase) {
                    String newAttributeName = attribute.substring(0, 1).toLowerCase() + attribute.substring(1);                
                    content = content.replaceAll(attribute, newAttributeName);
                }            
            }
            
                        
            Files.write(path, content.getBytes(charset));
        } 
    }
    
    
}
