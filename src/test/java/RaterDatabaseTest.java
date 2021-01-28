import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RaterDatabaseTest {
    RaterDatabase rd=new RaterDatabase();
    String filename="ratings_short.csv";

    @Test
    void initialize() {
        rd.initialize(filename);
        assertEquals(5,rd.size());
    }

    @Test
    void addRatings() {
        rd.addRatings(filename);
        assertEquals(5,rd.size());
    }

    @Test
    void addRaterRating() {
        rd.initialize(filename);
        rd.addRaterRating("100", "movie1", 5.0);
        assertEquals(6,rd.size());
    }

    @Test
    void getRater() {
        rd.initialize(filename);
        Rater RaterToTest= new Rater("1");
        assertEquals(RaterToTest.getID(),rd.getRater("1").getID());
    }

    @Test
    void getRaters() {
        rd.initialize(filename);
        ArrayList<Rater> list =rd.getRaters();
        assertEquals(5,list.size());
    }

    @Test
    void size() {
        rd.initialize(filename);
        assertEquals(5,rd.size());
    }
}