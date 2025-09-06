import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    @DisplayName("Check list size")
    void generateListSize() {
        assertEquals(5, BinarySearch.generateList(5, 10).size());
    }

    @Test
    @DisplayName("Check list range")
    void generateListRange() {
        assertAll(
                () -> {
                    int maxVal = 1000;
                    ArrayList<Integer> generatedList = BinarySearch.generateList(100, maxVal);
                    for (Integer val : generatedList) {
                        assertTrue((val >= -maxVal && val < maxVal+1),
                                "Value " + val + " must be within range between " + -maxVal + " and " + maxVal);
                    }
                }
        );
    }
}