import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterGenreTest {


    @Test
    void satisfiesComedy() {
        FilterGenre fg =new FilterGenre("Comedy");
        assertEquals(true,fg.satisfies("0006414"));
    }

    void satisfiesDrama() {
        FilterGenre fg =new FilterGenre("Drama");
        assertEquals(false,fg.satisfies("0006414"));
    }
}