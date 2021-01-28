import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterDirectorsTest {

    @Test
    void satisfies() {
        FilterDirectors fg =new FilterDirectors("Francis Ford Coppola");
        assertEquals(false,fg.satisfies("0006414"));
        assertEquals(true,fg.satisfies("0068646"));
    }
}