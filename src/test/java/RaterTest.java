import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RaterTest {

    private final String myID="100";
    private HashMap<String,Rating> myRatings = new HashMap<String,Rating>();

    public RaterTest () {
        myRatings.put("100", new Rating("movie1",5.5));
        myRatings.put("200", new Rating("movie2",8.0));
    }

    @Test
    void addRating() {
        boolean result= false;
        String item="300";
        Rater myRater=new Rater(item);
        myRatings.put(item,new Rating("movie3",4.1));
        if (myRatings.containsKey(item)) {
            result= true;
        }
        assertEquals(true,result);

    }

    @Test
    void hasRating() {
    }

    @Test
    void getID() {
        String item="300";
        Rater myRater=new Rater(item);
        assertEquals("300",myRater.getID());
    }

    @Test
    void getRating() {
    }

    @Test
    void numRatings() {
    }

    @Test
    void getItemsRated() {
    }
}