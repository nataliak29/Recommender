import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RecommendationRunner rr=new RecommendationRunner();
        System.out.println("Hello!");
        System.out.println("To get movie recommendations you will need to rate set of movies from 0 to 10.");
        System.out.println("If you do not want to rate a movie hit 'Enter'.");
        rr.getUserRatings("RaterID");
        rr.getRecommendations( "RaterID");



    }

}
