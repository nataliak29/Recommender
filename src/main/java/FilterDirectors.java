public class FilterDirectors implements Filter  {
    private String myDirectors;

    public FilterDirectors(String directors) {
        myDirectors = directors;
    }

    @Override
    public boolean satisfies(String id) {
        String movieDirectors = MovieDatabase.getDirector(id);
        //String[]  movieDirectorsArray=movieDirectors.split(",");
        String[]  searchedDirectorsArray=myDirectors.split(",");
        for (String d : searchedDirectorsArray) {
            if ( movieDirectors.contains(d) ) {
                return true;
            }

        }
        return false;

    }
}
