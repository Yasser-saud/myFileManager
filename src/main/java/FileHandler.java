import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Locale;

public class FileHandler {
    private final String path = Path.of("").toAbsolutePath().toString();

    public File[] showFiles() {
        File f = new File(path);
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

    public void createFile(String fileName) {
        File file = new File(path, fileName.toLowerCase(Locale.ROOT));
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("created");
            } else
                System.out.println("file exists");
        } catch (IOException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
    }

    public String deleteFile(String fileName) {
        File files[] = showFiles();
        try {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    file.delete();
                    return "Removed.";
                }
            }
        } catch (SecurityException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
        return "File was not found";
    }
}