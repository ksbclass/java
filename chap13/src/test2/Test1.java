package test2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
/*
src/폴더 하위 폴더의 .java 파일 중 InputStream 관련 모든 소스 내용을  
InputStream예제.txt  파일 하나에 저장 하기
InputStream 관련 모든 소스 : XXXInputStreamXXX.java
*/
public class Test1 {
    public static void main(String[] args) throws IOException {
        String src = "src";
        String outputFile = "InputStream예제.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            Files.walk(Paths.get(srcDir))
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .filter(path -> path.getFileName().toString().contains("InputStream"))
                    .forEach(path -> {
                        try {
                            writer.write("==== " + path.toString() + " ====\n");
                            List<String> lines = Files.readAllLines(path);
                            for (String line : lines) {
                                writer.write(line + "\n");
                            }
                            writer.write("\n");
                        } catch (IOException e) {
                            throw new RuntimeException("파일 읽기 오류: " + path, e);
                        }
                    });
        }
        System.out.println("모든 InputStream 관련 소스를 " + outputFile + "에 저장했습니다.");
    }
}
