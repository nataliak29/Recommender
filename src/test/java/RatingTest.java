import static org.junit.jupiter.api.Assertions.*;

class RatingTest {
    private final Rating RatingToTest= new Rating("100", 5.6);
    private final Rating SecondRating= new Rating("200", 8.3);

    @org.junit.jupiter.api.Test
    void getItem() {
        String item= RatingToTest.getItem();
        assertEquals("100",item);
    }

    @org.junit.jupiter.api.Test
     void getValue() {
        double val= RatingToTest.getValue();
        assertEquals(5.6,val);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String printedRating= RatingToTest.toString();
        assertEquals(printedRating,"[100, 5.6]");
    }

    @org.junit.jupiter.api.Test
    void compareTo() {
        int result= RatingToTest.compareTo(SecondRating);
        assertEquals(-1,result);
    }
}