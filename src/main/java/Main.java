import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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