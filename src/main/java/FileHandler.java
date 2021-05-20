import java.io.File;
import java.nio.file.Path;

public class FileHandler {
    private String p = Path.of("").toAbsolutePath().toString();

    public File[] showFiles() {
        File f = new File(p);
        File files[] = f.listFiles();
        return files;
    }

    public String findFile(String fileName) {
        File files[] = showFiles();
        for (File file : files) {
            if (file.getName().equals(fileName))
                return ("Found: " + file.getName());
        }
        return "File was not found";
    }
}