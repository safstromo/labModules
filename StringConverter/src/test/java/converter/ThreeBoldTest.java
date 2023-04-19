package converter;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ThreeBoldTest {
    ThreeBold threeBold = new ThreeBold();

    @Test
    void makeFirstThreeCharsBoldReturnsStringWithStarsBeforeAndAfterFirstThree() {
        assertThat(threeBold.convert("test this")).isEqualTo("**tes**t **thi**s");
    }

    @Test
    void convertSingleWord() {
        assertThat(threeBold.convert("test")).isEqualTo("**tes**t");
    }

    @Test
    void convertShortString() {
        assertThat(threeBold.convert("te")).isEqualTo("**te**");
    }

    @Test
    void convertEmptyStringThrowsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> threeBold.convert(""));
    }
}


