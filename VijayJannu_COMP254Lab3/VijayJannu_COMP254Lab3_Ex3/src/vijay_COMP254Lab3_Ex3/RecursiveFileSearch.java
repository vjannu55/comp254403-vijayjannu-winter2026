package vijay_COMP254Lab3_Ex3;

import java.io.File;
import java.util.Scanner;

public class RecursiveFileSearch {

    public static void find(File path, String filename) {

        if (path.isDirectory()) {

            File[] files = path.listFiles();

            if (files != null) {
                for (File file : files) {
                    find(file, filename);  // Recursive call
                }
            }

        } else {

            if (path.getName().equals(filename)) {
                System.out.println("Found: " + path.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Recursive File Finder ===");

        System.out.print("Enter directory path: ");
        String directoryPath = sc.nextLine();

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        File root = new File(directoryPath);

        if (!root.exists()) {
            System.out.println("Invalid path!");
        } else {
            find(root, fileName);
        }

        sc.close();
    }
}
