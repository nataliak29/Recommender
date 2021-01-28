import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class LoadData {

    public  ArrayList<Movie> loadMovies(String filename) {
        FileResource fr = new FileResource(filename);
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            try {
                String anID = record.get(0);
                String aTitle = record.get(1);
                String aYear = record.get(2);
                String theGenres = record.get(4);
                String aDirector = record.get(5);
                String aCountry = record.get(3);
                String aPoster = record.get(7);
                int theMinutes = Integer.parseInt(record.get(6));

                Movie thisMovie = new Movie(anID, aTitle, aYear, theGenres, aDirector, aCountry, aPoster, theMinutes);
                listOfMovies.add(thisMovie);
            }
            catch (Exception ArrayIndexOutOfBoundsException) {
                String anID = record.get(0);
                String aTitle = record.get(1);
                Movie thisMovie = new Movie(anID, aTitle, "0","n/a","n/a","n/a","n/a",0);
                listOfMovies.add(thisMovie);

            }
        }
        return listOfMovies;
    }

    public  ArrayList<Rater> loadRaters(String filename) {
        FileResource fr = new FileResource(filename);
        ArrayList<Rater> listOfRaters = new ArrayList<Rater>();
        ArrayList<String> listOfRaterIDs = new ArrayList<String>();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            String raterID = record.get(0);
            String item = record.get(1);
            Double val = Double.valueOf(record.get(2));
            Rater thisRater= new Rater(raterID);

            if (listOfRaterIDs.contains(raterID)) {
                for (Rater r: listOfRaters) {
                    if (r.getID().equals(raterID)) {
                        int raterIndex= listOfRaters.indexOf(r);
                        Rater rater= listOfRaters.get(raterIndex);
                        rater.addRating(item, val);
                        listOfRaters.set( raterIndex, rater);
                    }
                }
            }
            else {
                thisRater.addRating(item, val);
                listOfRaters.add(thisRater);
                listOfRaterIDs.add(raterID);
            }
        }
        return listOfRaters;
    }

}
