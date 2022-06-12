import java.io.File;
import java.util.*;

public class NestedFolders {
    public static void main(String[] args) {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File file = new File(path);
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(file);
        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}