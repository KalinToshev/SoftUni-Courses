import java.io.File;
import java.io.FileFilter;

public class ListFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        // Create a file object
        File file = new File(path);
        // Create a FileFilter
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith("txt");
            }
        };
        // Get all the names of the files present
        // in the given directory
        // which are text files
        File[] files = file.listFiles(filter);
        // Display the names of the files
        // and the size
        for (File f : files) {
            long size = f.length();
            System.out.println(f.getName() + ": [" + size + "]");
        }
    }
}
