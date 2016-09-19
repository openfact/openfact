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

public class SPI11 {

    public static void main(String[] args) throws IOException {
        String sourceDir = "/home/admin/git/openfact-temp/server-spi/src/main/java/org/openfact/models/ubl/common";
        String destinationDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/org/openfact/models/jpa/ubl/common";

        String representationDir = "/home/admin/git/openfact-temp/core/src/main/java/org/openfact/representations/idm/ubl/common";
        
        copyFolder(sourceDir, destinationDir);
        removeUnusedFiles(representationDir, destinationDir);
        replaceAllModelWord(destinationDir);
        appendImplementations(destinationDir);
        
        appendGettersSettersImplementations(destinationDir);
    }

    private static void removeUnusedFiles(String representationDir, String destinationDir) throws IOException {
        List<Path> paths1 = SPI.getPaths(representationDir);
        List<Path> paths2 = SPI.getPaths(destinationDir);
        
        List<String> validClasses = new ArrayList<>();
        for (Path path: paths1) {
            String className = FilenameUtils.removeExtension(path.getFileName().toFile().getName());
            validClasses.add(className.replace("Representation", ""));
        }
        
        for (Path path : paths2) {
            String className = FilenameUtils.removeExtension(path.getFileName().toFile().getName());            
            String classNameWithoutPattern = className.replace("Adapter", "");
            if(!validClasses.contains(classNameWithoutPattern)) {
                Files.delete(path);
            }
        }
    }

    private static void appendGettersSettersImplementations(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());
            
            //class name
            String className = FilenameUtils.removeExtension(path.getFileName().toFile().getName());
    
            String classNameWithoutPattern = className.replace("Adapter", "");
            String classNameLowerCase = className.substring(0, 1).toLowerCase() + className.substring(1);
            String classNameWithoutPatternLowerCase = classNameWithoutPattern.substring(0, 1).toLowerCase() + classNameWithoutPattern.substring(1);
              
            // new content            
            StringBuilder newContent = new StringBuilder();
            for (String line : lines) {                
                if (line.contains("get") && line.contains("();")) {
                    List<String> splits = Arrays.asList(line.split(" "));
                    splits = splits.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());

                    StringBuilder getter = new StringBuilder();
                    getter.append(splits.get(0)).append(" ").append(splits.get(1).replace(";", ""));
                    getter.append("{return this." + classNameWithoutPatternLowerCase+"."+splits.get(1)+"}");
                    
                    newContent.append(getter);
                } else if(line.contains("set") && line.contains("void")) {
                    List<String> splits = Arrays.asList(line.split(" "));
                    splits = splits.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());

                    //
                    String tempLine = line.substring(line.indexOf("(") +1 , line.indexOf(")"));
                    List<String> map = Arrays.asList(tempLine.split(" "));
                    
                    StringBuilder setter = new StringBuilder();
                    
                    try {
                        setter.append(splits.get(0)).append(" ").append(splits.get(1)).append(" ").append(splits.get(2).replace(";", ""));
                        setter.append("{this." + classNameWithoutPatternLowerCase+"."+splits.get(1).substring(0, splits.get(1).indexOf("(")+1)+map.get(1)+");}");                        
                    } catch (IndexOutOfBoundsException e) {             
                        System.out.println("");
                    }
                    
                    newContent.append(setter);
                } else {
                    newContent.append(line);
                }
                newContent.append("\n");
            }

            Files.write(path, newContent.toString().getBytes(charset));

        }
    }

    private static void appendImplementations(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());
            
            // new content
            String className = SPI.getClassName(path);
            if(className == null) {
                continue;
            }
            String classNameWithoutPattern = className.replace("Adapter", "");
            String classNameLowerCase = className.substring(0, 1).toLowerCase() + className.substring(1);
            String classNameWithoutPatternLowerCase = classNameWithoutPattern.substring(0, 1).toLowerCase() + classNameWithoutPattern.substring(1);
                        
            StringBuilder newContent = new StringBuilder();
            boolean isConstructorAdded = false;
            for (String line : lines) {                
                if (line.contains("class")) {                    
                    newContent.append("public class " + className + " implements " + classNameWithoutPattern + "Model," + " JpaModel<"+classNameWithoutPattern+"Entity"+"> {");
                } else if(line.contains("get") && isConstructorAdded == false) {
                    isConstructorAdded = true;
                    
                    newContent.append("protected static final Logger logger = Logger.getLogger(" +className+".class);").append("\n");
                    newContent.append("protected "+classNameWithoutPattern+"Entity "+ classNameWithoutPatternLowerCase +";").append("\n");
                    newContent.append("protected EntityManager em;").append("\n");
                    newContent.append("protected OpenfactSession session;").append("\n");
                    
                    newContent.append("public " +classNameWithoutPattern + "Adapter(OpenfactSession session, EntityManager em, " + classNameWithoutPattern + "Entity " + classNameWithoutPatternLowerCase +"){").append("\n");
                    newContent.append("this.session = session;").append("\n");
                    newContent.append("this.em = em;").append("\n");
                    newContent.append("this."+ classNameWithoutPatternLowerCase +" = "+classNameWithoutPatternLowerCase+";").append("\n");
                    newContent.append("}").append("\n");                    
                    
                    newContent.append(line);
                } else {
                    newContent.append(line);
                }
                newContent.append("\n");
            }

            Files.write(path, newContent.toString().getBytes(charset));

        }
    }

    private static void replaceAllModelWord(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);

        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);
            content = content.replace("Model", "Adapter");
            content = content.replace("org.openfact.models.ubl.common", "org.openfact.models.jpa.ubl.common");
            content = content.replace("interface", "class");
            Files.write(path, content.getBytes(charset));
        }
    }

    public static void copyFolder(String sourceDir, String destinationDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);

        for (Path path : paths) {

            Path destinationPath = Paths.get(destinationDir);
            if (!Files.exists(destinationPath)) {
                Files.createDirectory(destinationPath);
            }

            String fileName = path.getFileName().toFile().getName();
            Path pathPattern = destinationPath.resolve(fileName.replaceAll("Model", "Adapter"));
            Files.copy(path, pathPattern, StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
