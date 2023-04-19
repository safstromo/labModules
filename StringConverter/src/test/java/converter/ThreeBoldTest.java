package converter;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeBoldTest {
    ThreeBold threeBold = new ThreeBold();

    @Test
    void makeFirstThreeCharsBoldReturnsStringWithStarsBeforeAndAfterFirstThree() {
        assertThat(threeBold.convert("test this")).isEqualTo("**tes**t **thi**s");
    }
}

