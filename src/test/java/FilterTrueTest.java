import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterTrueTest {

    @Test
    void satisfies() {
        FilterTrue fg =new FilterTrue();
        assertEquals(true,fg.satisfies("0006414"));
        assertEquals(true,fg.satisfies("0068646"));
    }
}