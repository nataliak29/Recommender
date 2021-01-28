import java.util.ArrayList;
import java.util.Collections;

public class SimilarRatings {

    public SimilarRatings () {
        //this("ratings_short.csv");
        this("ratings.csv");
    }

    public SimilarRatings ( String ratingsfile) {
        RaterDatabase.addRatings(ratingsfile);

    }

    public double getAverageByID(String id, int minimalRaters) {
        ArrayList<Rater> myRaters= RaterDatabase.getRaters();
        int countRaters=0;
        double sumRating=0;
        for ( Rater r: myRaters) {
            try {
                if (  r.getRating(id)!=-1) {
                    sumRating+=r.getRating(id);
                    countRaters+=1;
                }
            }
            catch (Exception NullPointerException) {
            }
        }

        double avg=sumRating/countRaters;
        if (countRaters>=minimalRaters) {
            return avg;
        }

        else {
            return 0;
        }

    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> ratingsList = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new FilterTrue());
        for (String m: movies) {
            double val = getAverageByID(m, minimalRaters);
            Rating rating = new Rating (m, val);
            if (val>0) {
                ratingsList.add(rating);
            }
        }
        return ratingsList;
    }

    public ArrayList<Rating>  getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria) {
        ArrayList<Rating> ratingsList = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for (String m: movies) {
            double val = getAverageByID(m, minimalRaters);
            Rating rating = new Rating (m, val);
            if (val>0) {
                ratingsList.add(rating);
            }
        }
        return ratingsList;
    }

    public int getRaterSize() {
        ArrayList<Rater>  myRaters= RaterDatabase.getRaters();
        return myRaters.size();
    }

    double dotProduct(Rater me, Rater r) {
        ArrayList<String> myRatings= me.getItemsRated();
        double dotProduct = 0;

        for (String myMovie:myRatings) {
            double myRate=me.getRating(myMovie)-5;

            if (r.hasRating(myMovie)) {
                double rRate=r.getRating(myMovie)-5;
                dotProduct +=  myRate*rRate;
            }
        }
        return dotProduct;
    }

    public ArrayList<Rating> getSimilarities(String id) {
        ArrayList<Rating> list = new ArrayList<Rating>();
        ArrayList<Rater>  myRaters= RaterDatabase.getRaters();
        Rater me=RaterDatabase.getRater(id);
        for (Rater r:myRaters) {
            double dotPr=dotProduct(me,r);

            if(!r.getID().equals(id) && dotPr>0) {
                Rating item = new Rating (r.getID(), dotPr);
                list.add(item);
                //System.out.println("Dot product between "+me.getID()+" "+r.getID()+" is: "+String.valueOf(dotPr));
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return list;

    }

    public ArrayList<Rating>  getSimilarRatingsByFilter (String id, int numSimilaraters, int minimalRaters,Filter filterCriteria) {
        ArrayList<Rating> similarities = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> similarRatings=new ArrayList<Rating>();

        //loop over movies
        for (String movieID :movies) {
            double weightedRatingSum=0;
            int similarRaters=0;
            //for each movie find raters that rated the movie from similar raters
            for (int k = 0; k < numSimilaraters; k++) {
                Rating raterID = similarities.get(k);
                double similarityRating=raterID.getValue();
                Rater thisRater=RaterDatabase.getRater(raterID.getItem());
                if (thisRater.hasRating(movieID) ) {
                    double movieRating=thisRater.getRating(movieID);
                    // get it's similarity rating and multiply by rating
                    weightedRatingSum+=movieRating*similarityRating;
                    similarRaters+=1;
                }

            }
            if (similarRaters>=minimalRaters) {
                Rating wightedRating =new Rating(movieID,weightedRatingSum/similarRaters);
                similarRatings.add(wightedRating);
            }
        }

        Collections.sort(similarRatings,Collections.reverseOrder());
        return similarRatings;

    }


    public ArrayList<Rating>  getSimilarRatings (String id, int numSimilaraters, int minimalRaters) {
        return getSimilarRatingsByFilter ( id, numSimilaraters, minimalRaters,new FilterTrue());

    }
}
