import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private final Movie MovieToTest= new Movie("100", "MovieTitle", "1900", "Genre1,Genre2",
                                                "Director1,Director2,Director3", "Country1,Country2", "URL", 100);
    private final Movie MovieToTestShort= new Movie("100", "MovieTitle", "1900", "Genre1,Genre2");

    @Test
    void getID() {
        assertEquals("100",MovieToTest.getID());
        assertEquals("100",MovieToTestShort.getID());
    }

    @Test
    void getTitle() {
        assertEquals("MovieTitle",MovieToTest.getTitle());
    }

    @Test
    void getYear() {
        assertEquals(1900,MovieToTest.getYear());
    }

    @Test
    void getGenres() {
        assertEquals("Genre1,Genre2",MovieToTest.getGenres());
    }

    @Test
    void getCountry() {
        assertEquals("Country1,Country2",MovieToTest.getCountry());
    }

    @Test
    void getDirector() {
        assertEquals("Director1,Director2,Director3",MovieToTest.getDirector());
    }

    @Test
    void getPoster() {
        assertEquals("URL",MovieToTest.getPoster());
    }

    @Test
    void getMinutes() {
        assertEquals(100,MovieToTest.getMinutes());
    }

    @Test
    void testToString() {
        String result="Movie [id=100, title=MovieTitle, year=1900, genres= Genre1,Genre2]";
        assertEquals(result,MovieToTest.toString());
    }
}