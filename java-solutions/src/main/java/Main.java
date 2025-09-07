import BinarySearch.BinarySearch;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listToSearch = BinarySearch.generateList(10, 100);
        try {
            BinarySearch.binarySearch(listToSearch, BinarySearch.pickTarget(listToSearch));
            BinarySearch.binarySearch(listToSearch, 145);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}