package converter;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class FirstThreeBoldTest {
    FirstThreeBold firstThreeBold = new FirstThreeBold();

    @Test
    void makeFirstThreeCharsBoldReturnsStringWithStarsBeforeAndAfterFirstThree() {
        assertThat(firstThreeBold.convert("test this")).isEqualTo("**tes**t **thi**s");
    }

    @Test
    void convertSingleWord() {
        assertThat(firstThreeBold.convert("test")).isEqualTo("**tes**t");
    }

    @Test
    void convertShortString() {
        assertThat(firstThreeBold.convert("te")).isEqualTo("**te**");
    }

    @Test
    void convertEmptyStringThrowsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> firstThreeBold.convert(""));
    }
}


