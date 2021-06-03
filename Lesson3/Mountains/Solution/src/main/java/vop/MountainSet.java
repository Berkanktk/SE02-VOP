package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MountainSet {

    private Set<Mountain> tree; //En datastruktur af typen Set<Mountain>

    public MountainSet() { //En constructor, som initialiserer datastrukturen, så den altid er sorteret vha. compareTo() metoden i klassen Mountain.
        tree = new TreeSet<>();
    }

    public void addMountain(Mountain m) {
        this.tree.add(m);
    }

    @Override
    public String toString() {
        return tree.toString();
    }

    public Set<?> getMountainTree() { //En get()-metode, som returnerer settet.
        return tree;
    }

    public Set<Mountain> sortByRange(Comparator<Mountain> comp) {
        Set<Mountain> rangeTree = new TreeSet<>(comp);
        rangeTree.addAll(tree);
        return rangeTree;
    }

    public static void main(String[] args) {
        MountainSet mSet = new MountainSet(); //erklæres og initialiseres en instans af MountainSet

        //FranskeBjerge.csv læses en linje ad gangen
        try (Scanner sc = new Scanner(new File(MountainSet.class.getResource("FranskeBjerge.csv").toURI().getPath()))) {
            String line;
            String[] items;

            while (sc.hasNextLine()) {
                line = sc.nextLine();
                items = line.split(";");

                //for hver linje oprettes en instans af Mountain, som indsættes vha. add(Mountain m)
                mSet.addMountain(new Mountain(items[0], items[1], items[2], items[3], items[4], items[5]));
            }
            System.out.println(mSet.getMountainTree()); //til slut udskrives settet på System.out

        } catch (FileNotFoundException | URISyntaxException fnfe) {
            fnfe.printStackTrace();
        }
        System.out.println("Sorted by range:");
        System.out.println(mSet.sortByRange(new MountainRangeComparator()));
    }
}