import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterMinutesTest {

    @Test
    void satisfies() {
        FilterMinutes fg =new FilterMinutes(120,171);
        assertEquals(false,fg.satisfies("0006414"));
        assertEquals(true,fg.satisfies("0113277"));

    }
}