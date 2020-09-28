import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFileExample {

    public static void main(String[] args) throws IOException {
        List<String> file = Files.lines(Paths.get("C:\\Projetos\\CursoUdemySpringBoot2SpringFramework5\\fork\\JavaStreams\\pom.xml"))
                .filter(line -> line.contains("groupId"))
                .map(line -> line.trim()
                        .replaceAll("groupId", "")
                        .replaceAll("<", "")
                        .replaceAll(">", "")
                        .replaceAll("/", "")).collect(Collectors.toList());

        System.out.println("Content of file POM.xml in tag <groupId> " + file);

    }

}
