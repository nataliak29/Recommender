public class FilterMinutes implements Filter {
    private int myMinMinutes;
    private int myMaxMinutes;

    public FilterMinutes(int minMinutes,int maxMinutes) {
        myMinMinutes = minMinutes;
        myMaxMinutes = maxMinutes;
    }

    @Override
    public boolean satisfies(String id) {
        if (MovieDatabase.getMinutes(id) >= myMinMinutes && MovieDatabase.getMinutes(id) <= myMaxMinutes)  {
            return true;
        }
        else {
            return false;
        }
    }
}
