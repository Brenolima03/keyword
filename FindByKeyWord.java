import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FindByKeyWord {
    public static void main(String[] args) throws IOException {
        String path = "";
        String keyword = "";
        Charset charset = Charset.forName("ISO-8859-1");

        Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String content = Files.readString(file, charset);
                if (content.contains(keyword)) {
                    System.out.println("File found: " + file);
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}