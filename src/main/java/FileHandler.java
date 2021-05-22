import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Locale;

public class FileHandler {

    private final String path = Path.of("").toAbsolutePath().toString();

    public File[] showFiles() {
        File f = new File(path);
        File files[] = f.listFiles();
        // the above line by default sort the list in ascending order
        // but i will explicitly sort it my self with the next line
        sort(files);
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
                    return "File have been removed";
                }
            }
        } catch (SecurityException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
        return "File was not found";
    }

    private File[] sort(File[] files) {
        // selection sort
        for (int i = 0; i < files.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < files.length; j++) {
                // change < with > to sort descending instead of ascending
                if (files[j].compareTo(files[index]) < 0) {
                    index = j;
                }
            }
            //swap
            File temp = files[i];
            files[i] = files[index];
            files[index] = temp;
        }

        return files;
    }
}