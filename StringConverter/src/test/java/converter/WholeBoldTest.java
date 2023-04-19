package converter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class WholeBoldTest {
    WholeBold wholeBold = new WholeBold();

    @Test
    void wholeBoldAddStarsAtTheStartAndEndOfString() {
        assertThat(wholeBold.convert("test this")).isEqualTo("**test this**");
    }

    @Test
    void convertSingleWord() {
        assertThat(wholeBold.convert("test")).isEqualTo("**test**");
    }

    @Test
    void convertEmptyStringThrowsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> wholeBold.convert(""));
    }

}
