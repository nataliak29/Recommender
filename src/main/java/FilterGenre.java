public class FilterGenre implements Filter {

    private String myGenre;

    public FilterGenre(String genre) {
        myGenre = genre;
    }

    @Override
    public boolean satisfies(String id) {
        String movieGenres = MovieDatabase.getGenres(id);
        if (movieGenres.indexOf(myGenre)!=-1) {
            return true;
        }
        else {
            return false;
        }
    }

}