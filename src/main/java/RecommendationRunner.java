import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class RecommendationRunner {

    public RecommendationRunner () {
        //this("ratings_short.csv");
        this("ratings.csv");
    }

    public RecommendationRunner ( String ratingsfile) {
        RaterDatabase.addRatings(ratingsfile);
    }

    public ArrayList<String> getItemsToRate() {
        ArrayList<String> moviesToDisplay= new ArrayList<String>();
        ArrayList<String> movies = MovieDatabase.filterBy(new FilterTrue());
        int maxNumMovies=5;
        for (int i=0; i<maxNumMovies; i++) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(movies.size());
            String m=movies.get(randomIndex);
            moviesToDisplay.add(m);
        }
        return moviesToDisplay;
    }

    public String getNextMovieToRate(String newRaterID) {
        ArrayList<String> movies = MovieDatabase.filterBy(new FilterTrue());
        Rater thisRater= RaterDatabase.getRater(newRaterID);
        while (true) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(movies.size());
            String m = movies.get(randomIndex);
            if (!thisRater.hasRating(m)) {
                return m;
            }
        }

    }

    public void getUserRatings(String newRaterID) {
        RecommendationRunner rr = new RecommendationRunner();
        ArrayList<String> list = rr.getItemsToRate();
        int inputCounter=0;

        for (String k : list) {
            Movie m = MovieDatabase.getMovie(k);
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object

            boolean correctInput = false;
            System.out.println("Your rating for '"+ m.getTitle() + "'," + String.valueOf(m.getYear())+":");

            while (!correctInput) {
                String ratingString = myObj.nextLine().trim();
                    if (ratingString.isEmpty()) {
                        System.out.println("You skipped movie '"+ m.getTitle() + "'," + String.valueOf(m.getYear()));
                        correctInput = true;
                        inputCounter+=1;

                    }
                    else {
                        try {
                        double rating = Double.valueOf(ratingString);
                        System.out.println("Rating recorded for '" + m.getTitle() + "'," + String.valueOf(m.getYear()));
                        correctInput = true;
                        inputCounter+=1;
                        RaterDatabase.addRaterRating(newRaterID, m.getID(), rating);

                         } catch (Exception NumberFormatException) {
                        System.out.println("Rating should be a number from 0 to 10. Enter rating for movie '" + m.getTitle() + "'," + String.valueOf(m.getYear()));
                        ratingString = myObj.nextLine();
                }
                }
             }
        }
    }

        public void getRecommendations(String newRaterID) {
            SimilarRatings sr = new SimilarRatings();
            ArrayList<Rating> recommendations = new ArrayList<>();

            while (recommendations.size()==0) {
                try {
                    getUserRatings(newRaterID);
                    recommendations = sr.getSimilarRatings(newRaterID, 5, 2);
                }
                catch (Exception IndexOutOfBoundsException) {
                    System.out.println("To get recommendation you need to rate more movies");
                }
            }
            System.out.println("------------------");
            System.out.println("Recommended Movies");
            for (Rating r : recommendations) {
                MovieDatabase.getTitle(r.getItem());
                System.out.println("Movie: " + MovieDatabase.getTitle(r.getItem()) + ", " + String.valueOf(MovieDatabase.getYear(r.getItem())) + ", recommendation weight: " + String.valueOf(r.getValue()));
            }
        }
    }







