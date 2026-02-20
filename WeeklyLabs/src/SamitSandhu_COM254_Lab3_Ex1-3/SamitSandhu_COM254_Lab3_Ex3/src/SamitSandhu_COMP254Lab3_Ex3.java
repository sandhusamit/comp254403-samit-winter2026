import java.io.File;

public class SamitSandhu_COMP254Lab3_Ex3 {

    public static void main(String[] args) {

        String path = "C:\\Development\\IdeaProjects\\comp254403-samit-winter2026\\WeeklyLabs\\src\\SamitSandhu_COM254_Lab3_Ex1-3";
        String filename = "example2.txt";

        boolean fileFound = find(path, filename);

        if (!fileFound) {
            System.out.println("Couldn't Find: " + filename);
        }
    }

    public static boolean find(String path, String filename) {
        File file = new File(path);

        if (!file.exists()) {
            return false;
        }

        // If it's a file, check name
        if (file.isFile()) {
            if (file.getName().equals(filename)) {
                System.out.println("Found: " + file.getAbsolutePath());
                return true;
            }
            return false;
        }

        // If it's a directory, recurse into children
        File[] list = file.listFiles();
        if (list != null) {
            for (File f : list) {
                if (find(f.getAbsolutePath(), filename)) {
                    return true; // stop early as soon as found
                }
            }
        }

        return false;
    }
}