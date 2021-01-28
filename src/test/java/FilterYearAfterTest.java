import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterYearAfterTest {

    @Test
    void satisfies() {
        FilterYearAfter fg =new FilterYearAfter(2000);
        assertEquals(false,fg.satisfies("0006414"));
        assertEquals(true,fg.satisfies("1798709"));
    }
}