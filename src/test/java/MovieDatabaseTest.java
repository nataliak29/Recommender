import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MovieDatabaseTest {

    MovieDatabase md=new MovieDatabase();
    String filename="ratedmovies_short.csv";

    @Test
    void initialize() {
        md.initialize(filename);
        assertEquals(6,md.size());
    }

    @Test
    void containsID() {
        md.initialize(filename);
        assertEquals(true,md.containsID("0006414"));
        assertEquals(false,md.containsID("0006415"));
    }

    @Test
    void getYear() {
        md.initialize(filename);
        assertEquals(1916,md.getYear("0006414"));
    }

    @Test
    void getGenres() {
        md.initialize(filename);
        assertEquals("Short, Comedy, Romance",md.getGenres("0006414"));
    }

    @Test
    void getTitle() {
        md.initialize(filename);
        assertEquals("Behind the Screen",md.getTitle("0006414"));
    }

    @Test
    void getMovie() {
        md.initialize(filename);
        Movie MovieToTest= new Movie("0006414", "Behind the Screen", "1916", "Short, Comedy, Romance");
        assertEquals(MovieToTest.toString(),md.getMovie("0006414").toString());
    }

    @Test
    void getPoster() {
        md.initialize(filename);
        String targetURL="http://ia.media-imdb.com/images/M/MV5BMTkyNDYyNTczNF5BMl5BanBnXkFtZTgwMDU2MzAwMzE@._V1_SX300.jpg";
        assertEquals(targetURL,md.getPoster("0006414"));
    }

    @Test
    void getMinutes() {
        md.initialize(filename);
        assertEquals(30,md.getMinutes("0006414"));
    }

    @Test
    void getCountry() {
        md.initialize(filename);
        assertEquals("USA",md.getCountry("0006414"));
    }

    @Test
    void getDirector() {
        md.initialize(filename);
        assertEquals("Charles Chaplin",md.getDirector("0006414"));
    }

    @Test
    void size() {
        md.initialize(filename);
        assertEquals(6,md.size());
    }

    @Test
    void filterBy() {
        md.initialize(filename);
        FilterMinutes fg =new FilterMinutes(120,171);
        ArrayList<String> moviesFiltered= md.filterBy(fg);

        assertEquals(2,moviesFiltered.size());
    }
}