import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimilarRatingsTest {


        String filename="ratings_short.csv";
        SimilarRatings sr=new SimilarRatings(filename);



    @Test
    void getAverageByID() {

        double avgRating=sr.getAverageByID("1798709", 2);
        assertEquals(8.25,avgRating);

    }

    @Test
    void getAverageRatings() {
        int numberOfRaters=2;
        ArrayList<Rating> ratingsList = sr.getAverageRatings(numberOfRaters);
        System.out.println(ratingsList);
        assertEquals(2,ratingsList.size());
    }

    @Test
    void getAverageRatingsByFilter() {
        int numberOfRaters=2;
        Filter f  =new FilterGenre("Sci-Fi");
        ArrayList<Rating> ratingsList = sr.getAverageRatingsByFilter(numberOfRaters,f);
        System.out.println(ratingsList);
        assertEquals(1,ratingsList.size());
    }

    @Test
    void getRaterSize() {
        assertEquals(5,sr.getRaterSize());
    }

    @Test
    void getDotProduct() {
        RaterDatabase.initialize(filename);
        ArrayList<Rater>  myRaters= RaterDatabase.getRaters();
        Rater firstRater= myRaters.get(0);
        Rater secondRater= myRaters.get(3);
        double dotProductResult=sr.dotProduct(firstRater,secondRater);
        assertEquals(15,dotProductResult);

    }

    @Test
    void getSimilarities() {
        ArrayList<Rating> list= sr.getSimilarities("1");
        System.out.println(list);
        assertEquals(3,list.size());
    }

    @Test
    void getSimilarRatingsByFilter() {
        Filter f  =new FilterGenre("Sci-Fi");
        ArrayList<Rating> list= sr.getSimilarRatingsByFilter ("1", 1, 1,f);
        System.out.println(list);
        assertEquals(1,list.size());
    }

    @Test
    void getSimilarRatings() {
        ArrayList<Rating> list= sr.getSimilarRatings ("1", 1, 1);
        System.out.println(list);
        assertEquals(3,list.size());
    }
}