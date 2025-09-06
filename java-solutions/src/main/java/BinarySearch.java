import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        generateList(10, 100);
    }

    /*
    Binary search algo:
    1. Check if the array is empty. Return -1 if so.
    2. Set the left and right bounds as the lowest and highest indices of the array.
    3. Always set the middle index as the half of the difference of the right and left bound.
        This rounds down automatically with ints in Java.
    4. Sort the array.
    5. Compare the target against the value at the middle index.
        - If middle value is smaller than target, set left bound to middle index.
        - If middle value is greater than target, set right bound to middle index.
        - If equal, value has been found.
    6. Set new middle, repeat until value is found.
     */
    public static int binarySearch(ArrayList<Integer> input, int target) throws Exception{
        if (input.isEmpty() || !input.contains(target)) {
            throw new Exception("Invalid input, target not found: " + target);
        }
        int leftBound = 0;
        int leftVal;
        int rightBound = input.size()-1;
        int rightVal;
        int middle = ((rightBound-leftBound) / 2);
        int midVal;
        input.sort(null);
        System.out.println("Sorted list:\n" + input);
        while (rightBound-leftBound != 0) {
            leftVal = input.get(leftBound);
            midVal = input.get(middle);
            rightVal = input.get(rightBound);
            System.out.printf("L: %d | M: %d | R: %d\n", leftVal, midVal, rightVal);
            if (midVal == target) {
                System.out.println("midVal is target");
                break;
            }
            else if (midVal < target) {
                System.out.println("midVal is smaller");
                leftBound = middle;
            }
            else {
                System.out.println("midVal is greater");
                rightBound = middle;
            }
            middle = (leftBound + (rightBound-leftBound) / 2);
        }
        System.out.println("Result index: " + middle);
        return middle;
    }

    public static ArrayList<Integer> generateList(int size, int maxVal) {
        Random random = new Random();
        ArrayList<Integer> generatedList = new ArrayList<>(List.of(0));
        if (size >= 1) {
            int toAdd;
            generatedList.clear();
            for (int i = 0 ; i < size ; i++) {
                do {
                    toAdd = random.nextInt(-maxVal, maxVal + 1);
                } while (generatedList.contains(toAdd));
                generatedList.add(toAdd);
            }
            System.out.println("Generated list:\n" + generatedList);
        }
        return generatedList;
    }

    public static int pickTarget(ArrayList<Integer> input) {
        Random random = new Random();
        int index = random.nextInt(0, input.size());
        int val = input.get(index);
        System.out.printf("Picked target %d at index %d\n", val, index);
        return val;
    }
}
