package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//--------------------------------- VIRKER KUN I EN DIRECTORY UDEN SPACES OG SPECIELLE TEGN ---------------------------

public class CamelWriter {

    private File inFile;

    public CamelWriter(String fName) {
        inFile = new File(getClass().getClassLoader().getResource(fName).getFile());
        System.out.println(inFile.getName());
    }

    public void readLines() {
        try (Scanner scan = new Scanner(inFile)) { // Benyt en Scanner til at læse inFile én linje ad gangen
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.length() == 0) {
                    continue;
                }
                convert2camel(line); // Kald convert2camel med hver linje.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void convert2camel(String line) {
        line = line.toLowerCase();
        String[] words = line.split(" "); // Split line til et String[] af de enkelte ord i linjen
        String camelLine = words[0].toLowerCase(); // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        for (int i = 1; i < words.length; i++) { // Sammensæt ordene til ét langt ord og udskriv.
            camelLine += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        printToFile(camelLine);
    }

    private void printToFile(String line) {
        File f = new File("CamelOut2.txt");
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.append(line);
            fw.append("\n");
        } catch (IOException ex) {
            Logger.getLogger(CamelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        String fName = "MaryAnn.txt";
        CamelWriter cw = new CamelWriter(fName);
        cw.readLines();
    }
}