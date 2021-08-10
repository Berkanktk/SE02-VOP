package vop;

import java.io.File;
import java.util.Scanner;

//Does only work in the "vop-øvelser" folder

public class FindFilesRecursive {
    private int noDirs;
    private int noFiles;

    private void findFiles(File file) {
        if (file.isDirectory()) {
            noDirs++;
            File[] files = file.listFiles(); // All files and subdirectories
            assert files != null;
            for (File f : files) {
                findFiles(f);
            }
        } else { // Base case
            noFiles++;
            System.out.println(file.getAbsolutePath());
        }
    }

    @Override
    public String toString() {
        return "FindFilesRecursive{" + "noDirs=" + noDirs + ", noFiles=" + noFiles + '}';
    }
    
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
        File startDir = new File(directory);

        FindFilesRecursive ffr = new FindFilesRecursive();
        ffr.findFiles(startDir);
        System.out.println("\n*************\n" + ffr);
    }
}