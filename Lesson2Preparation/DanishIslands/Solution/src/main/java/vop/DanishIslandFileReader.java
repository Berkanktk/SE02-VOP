package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DanishIslandFileReader {

    private File inFile;
    private List<DanishIsland> islandList;

    public DanishIslandFileReader(URI fName) {
        inFile = new File(fName);
    }

    private void readFile() {
        islandList = new ArrayList<>();
        String line;
        String[] tokens;
        String name = "";
        double circ;
        double area;
        int addr;
        int adkm;

        try (Scanner scan = new Scanner(inFile)) {
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                tokens = line.split(" "); // Læs filen en linje ad gangen. Split linjen på mellemrums tegnet.

                name = tokens[0]; // Konverter de enkelte værdier til typerne der skal bruges i DanishIsland.

                NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
                circ = format.parse(tokens[1]).doubleValue();
                area = format.parse(tokens[2]).doubleValue();
                addr = format.parse(tokens[3]).intValue();
                adkm = format.parse(tokens[4]).intValue();
                islandList.add(new DanishIsland(name, circ, area, addr, adkm)); // Opret et objekt for hver linje og tilføj det til listen.
            }
        } catch (FileNotFoundException ex) { // Vær omhyggelig med at fange exceptions og få lukket Scanner og fil
            ex.printStackTrace();
        } catch (NumberFormatException | ParseException ex) {
            System.err.println("NumberFormatException in " + name + "\n" + ex.getMessage());
        }
    }

    public List<?> getList() {
        return islandList;
    }

    public static void main(String[] args) throws URISyntaxException {
        System.out.println(DanishIslandFileReader.class.getClassLoader().getResource("Islands_komma.txt"));
        URL file = DanishIslandFileReader.class.getClassLoader().getResource("Islands_komma.txt");
        DanishIslandFileReader fr = new DanishIslandFileReader(file.toURI());
        fr.readFile();

        System.out.println("Result:\n" + fr.getList());
    }
}
