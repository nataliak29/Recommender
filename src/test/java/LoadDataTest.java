import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class LoadDataTest {

    @Test
    void loadMovies() {
        LoadData ld=new LoadData();
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        String filename="ratedmovies_short.csv";
        listOfMovies = ld.loadMovies(filename);
        int moviesCount= listOfMovies.size();
        assertEquals(6,moviesCount);
    }

    @Test
    void loadMoviesComedy() {
        LoadData ld=new LoadData();
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        String filename="ratedmovies_short.csv";
        listOfMovies = ld.loadMovies(filename);
        int comedyCount=0;
        for (Movie m : listOfMovies) {
            String genres = m.getGenres();
            if (genres.indexOf("Comedy")!=-1) {
                comedyCount+=1;
            }
        }
        assertEquals(1,comedyCount);
    }

    @Test
    void loadRaters() {
        LoadData ld=new LoadData();
        ArrayList<Rater> listOfRaters= new ArrayList<Rater>();
        String filename="ratings_short.csv";
        listOfRaters = ld.loadRaters(filename);
        int ratersCount= listOfRaters.size();
        assertEquals(5,ratersCount);
    }
    @Test
    void loadRatersMaxRatings() {
        LoadData ld=new LoadData();
        ArrayList<Rater> listOfRaters= new ArrayList<Rater>();
        String filename="ratings_short.csv";
        listOfRaters = ld.loadRaters(filename);
        int maxNumMoviesRated=0;
        for (Rater r : listOfRaters) {
            int numItemsRated = r.numRatings();
            if (numItemsRated > maxNumMoviesRated) {
                maxNumMoviesRated = numItemsRated;
            }
        }
        assertEquals(3,maxNumMoviesRated);
    }
}