import java.util.ArrayList;
public class FilterAll implements Filter  {
    ArrayList<Filter> filters;

    public FilterAll() {
        filters = new ArrayList<Filter>();
    }

    public void addFilter(Filter f) {
        filters.add(f);
    }

    @Override
    public boolean satisfies(String id) {
        for(Filter f : filters) {
            if (! f.satisfies(id)) {
                return false;
            }
        }

        return true;
    }
}
