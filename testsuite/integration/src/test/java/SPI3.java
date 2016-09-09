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

public class SPI3 {

    public static void main(String[] args) throws IOException {
        String sourceDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/org/openfact/ublbase";
        String destinationDir = "/home/admin/git/openfact-temp/model/jpa/src/main/java/org/openfact/models/jpa/entities/ubl";

        copyFolder(sourceDir, destinationDir, "");
        
        putPackage(destinationDir, "org.openfact.models.jpa.entities.ubl;");
        removeFunctions(destinationDir);
        
        changeClassName(destinationDir);
        replaceTypes(destinationDir);
        trimAttributes(destinationDir);        
                        
        
        setLists(destinationDir);
        changeListsNames(destinationDir);
        //lowerCase(destinationDir);
        initSetLists(destinationDir);
                                      
    }

    public static void copyFolder(String sourceDir, String destinationDir, String pattern) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        
        for (Path path : paths) {
            String className = SPI.getClassName(path);

            Path destinationPath = Paths.get(destinationDir);
            if (!Files.exists(destinationPath)) {
                Files.createDirectory(destinationPath);
            }

            String newClassName = className.trim().replaceAll(" ", "");            
            Path pathPattern = destinationPath.resolve(newClassName + pattern + ".java");
            Files.copy(path, pathPattern, StandardCopyOption.REPLACE_EXISTING);
        }                      
    }
    
    public static void putPackage(String sourceDir, String packageName) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);
                           
            content = "import org.openfact.models.jpa.entities.ublType.*;" + "\n" + content;
            content = "import java.util.ArrayList; " + "\n" + content;
            content = "import java.util.List; " + "\n" + content;            
            content = "package " + packageName + "\n" + content;
            
            Files.write(path, content.getBytes(charset));
        } 
    }
    
    public static void changeClassName(String sourceDir) throws IOException {
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
                    newContent.append("public class " + SPI.getClassName(path).trim().replaceAll(" ", "") + "{").append("\n");
                } else {
                    newContent.append(line).append("\n");
                }                
            }
            Files.write(path, newContent.toString().getBytes(charset));
           
        } 
    }
    
    public static void  replaceTypes(String sourceDir) throws IOException{
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);
                    
            content = content.replaceAll("AllowanceChargeReasonCode. Type ", "AllowanceChargeReasonCodeType ");
            content = content.replaceAll("Binary Object. Type ", "BinaryObjectType ");
            content = content.replaceAll("Amount. Type ", "BigDecimal ");
            content = content.replaceAll("Binary Object. Type ", "BinaryObjectType ");
            content = content.replaceAll("Channel_ ", "ChannelCodeType ");
            content = content.replaceAll("Chip_ ", "ChipCodeType ");
            content = content.replaceAll("Code. Type ", "CodeType ");
            content = content.replaceAll("Currency_ Code. Type ", "CurrencyCodeType ");
            content = content.replaceAll("Currency_ ", "CurrencyCodeType ");
            content = content.replaceAll("Date. Type ", "LocalDate ");
            content = content.replaceAll("DocumentStatus_ ", "DocumentStatusCodeType ");
            content = content.replaceAll("Identifier. Type ", "IdentifierType ");
            content = content.replaceAll("Indicator. Type ", "boolean ");
            content = content.replaceAll("Latitude Direction_ Code. Type ", "LatitudeDirectionCodeType ");            
            content = content.replaceAll("Line Status_ Code. Type ", "LineStatusCodeType ");
            content = content.replaceAll("Measure. Type ", "MeasureType ");
            content = content.replaceAll("Name. Type ", "NameType ");
            content = content.replaceAll("Numeric. Type ", "BigDecimal ");
            content = content.replaceAll("PackagingTypeCode. Type ", "PackagingTypeCodeType ");
            content = content.replaceAll("Percent. Type ", "BigDecimal ");
            content = content.replaceAll("Quantity. Type ", "QuantityType ");
            content = content.replaceAll("Rate. Type ", "RateType ");
            content = content.replaceAll("ReceiptAdviceTypeCode. Type ", "ReceiptAdviceTypeCodeType ");
            content = content.replaceAll("Text. Type ", "TextType ");
            content = content.replaceAll("TextTypeUnqDat. Type ", "TextTypeUnqDat ");
            content = content.replaceAll("Time. Type ", "LocalTime ");
            content = content.replaceAll("WeekDayCode. Type ", "WeekDayCodeType ");                       
            
            Files.write(path, content.getBytes(charset));
        } 
    }
    
    public static void  trimAttributes(String sourceDir) throws IOException{
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

                    if(line.contains("Substitute Carrier Party")) {
                        System.out.println("");
                    }
                    
                    String attribute = "";
                    for (int i = 2; i < splits.size(); i++) {
                        if(i == splits.size() - 1) {
                            attribute = attribute + splits.get(i);
                            continue;
                        }
                        attribute = attribute + splits.get(i) + " ";
                    }
                    attributes.add(attribute);
                }
            }
            
            // replacte
            String content = new String(Files.readAllBytes(path), charset);
            for (String attribute : attributes) {
                String attributeWithoutComma = attribute.replaceAll(";", "");
                content = content.replaceAll(attributeWithoutComma, attributeWithoutComma.trim().replaceAll(" ", ""));
            }
            
                        
            Files.write(path, content.getBytes(charset));
        } 
    }
        
    public static void setLists(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());
            
            List<String> attributes = new ArrayList<>();            
            for (String line : lines) {
                if (line.contains("m_")) {
                    List<String> splits = Arrays.asList(line.split(" "));
                    splits = splits.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());
                    
                    attributes.add(splits.get(1));
                }
            }
            
            // replacte
            String content = new String(Files.readAllBytes(path), charset);
            for (String attribute : attributes) {
                String attributeType = "List<" + attribute + ">";
                
                content = content.replaceAll("private " + attribute + " ", "private " +attributeType + " ");                
            }
            
                        
            Files.write(path, content.getBytes(charset));
        } 
    }
    
    public static void initSetLists(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());
            
            List<String> attributes = new ArrayList<>();            
            for (String line : lines) {
                if (line.contains("List<")) {
                    List<String> splits = Arrays.asList(line.split(" "));
                    splits = splits.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());
                    
                    attributes.add(splits.get(2).replaceAll(";", ""));
                }
            }
            
            // replacte
            String content = new String(Files.readAllBytes(path), charset);
            for (String attribute : attributes) {
                String attributeDeclaration = attribute + " = new ArrayList<>()";
                
                content = content.replaceAll(attribute+";", attributeDeclaration+";");                
            }
            
                        
            Files.write(path, content.getBytes(charset));
        } 
    }
    
    public static void changeListsNames(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());
            
            List<String> attributes = new ArrayList<>();            
            for (String line : lines) {
                if (line.contains("m_") && line.contains("private")) {
                    List<String> splits = Arrays.asList(line.split(" "));
                    splits = splits.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());
                    
                    attributes.add(splits.get(2).replaceAll(";", ""));
                }
            }
            
            // replacte
            String content = new String(Files.readAllBytes(path), charset);
            for (String attribute : attributes) {
                String newAttributeName = attribute.replaceAll("m_", "");
                newAttributeName = English.plural(newAttributeName, 2);
                content = content.replaceAll(attribute, newAttributeName);
            }
            
                        
            Files.write(path, content.getBytes(charset));
        } 
    }
    
    public static void removeFunctions(String sourceDir) throws IOException {
        List<Path> paths = SPI.getPaths(sourceDir);
        for (Path path : paths) {
            Charset charset = StandardCharsets.UTF_8;

            BufferedReader br = Files.newBufferedReader(path);
            List<String> lines = br.lines().collect(Collectors.toList());

            StringBuilder newContent = new StringBuilder();
            int brace = 0;
            for (String line : lines) {
                if (line.contains("{")) {
                    brace++;
                }
                
                if(brace < 2) {
                    newContent.append(line).append("\n");
                }
                
                if (line.contains("}//")) {
                    newContent.append("}").append("\n");
                }
            }

            Files.write(path, newContent.toString().getBytes(charset));
        }
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
