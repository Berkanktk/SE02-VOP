package vop;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MountainSet {
    private Set<Mountain> tree;

    MountainSet(){
        tree = new TreeSet<>();
    }

    public void addMountain(Mountain m) {
        this.tree.add(m);
    }

    @Override
    public String toString() {
        return tree.toString();
    }

    public Set<?> getMountainTree() {
        return tree;
    }

    public Set<Mountain> sortByRange(Comparator<Mountain> comp) {
        Set<Mountain> rangeTree = new TreeSet<>(comp);
        rangeTree.addAll(tree);
        return rangeTree;
    }

    public static void main(String[] args) {
        MountainSet mSet = new MountainSet();

        //læs fra filen
        try (Scanner sc = new Scanner(new File(MountainSet.class.getResource("FranskeBjerge.csv").toURI().getPath()))) {
            String line;
            String[] items;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                items = line.split(";");
                mSet.addMountain(new Mountain(items[0], items[1],
                        items[2], items[3], items[4], items[5]));
            }

            System.out.println(mSet.getMountainTree());
        } catch (FileNotFoundException | URISyntaxException fnfe) {
            fnfe.printStackTrace();
        }
        System.out.println("Sorted by range:");
        System.out.println(mSet.sortByRange(new MountainRangeComparator()));
    }
}
//String path = MountainSet.class.getResource("FranskeBjerge.csv").toURI().getPath();
//File f =new File(path);
//System.out.println("hello world");