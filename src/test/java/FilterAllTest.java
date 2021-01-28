import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FilterAllTest {

    @Test
    void addFilter() {
        ArrayList<Filter> filters = new ArrayList<Filter>();
        FilterDirectors fd =new FilterDirectors("Francis Ford Coppola");
        FilterYearAfter fy =new FilterYearAfter(2000);
        filters.add(fd);
        filters.add(fy);
        assertEquals(2,filters.size());

    }

    @Test
    void satisfiesDirectorYear() {
        FilterAll f=new FilterAll();
        FilterDirectors fd =new FilterDirectors("Francis Ford Coppola");
        FilterYearAfter fy =new FilterYearAfter(1960);
        f.addFilter(fd);
        f.addFilter(fy);
        assertEquals(false,f.satisfies("0006414"));
        assertEquals(true,f.satisfies("0068646"));
    }

    @Test
    void satisfiesMinutesGenre() {
        FilterAll f=new FilterAll();
        FilterMinutes fm =new FilterMinutes(120,173);
        FilterGenre fg =new FilterGenre("Crime");
        f.addFilter(fm);
        f.addFilter(fg);
        assertEquals(true,f.satisfies("0113277"));
        assertEquals(false,f.satisfies("0068646"));
    }

    @Test
    void satisfiesAllTogether() {
        FilterAll f=new FilterAll();
        FilterMinutes fm =new FilterMinutes(0,180);
        FilterGenre fg =new FilterGenre("Drama");
        FilterDirectors fd =new FilterDirectors("Francis Ford Coppola,Spike Jonze");
        FilterYearAfter fy =new FilterYearAfter(2010);
        f.addFilter(fd);
        f.addFilter(fy);
        f.addFilter(fm);
        f.addFilter(fg);
        assertEquals(true,f.satisfies("1798709"));
        assertEquals(false,f.satisfies("0068646"));
    }
}