package converter;

import annotations.Convert;
import service.StringConverter;

public class WholeBold implements StringConverter {
    @Convert("bold")
    @Override
    public String convert(String stringToBeConverted) {
        if (stringToBeConverted.isEmpty())
            throw new IllegalArgumentException();

        return makeBold(stringToBeConverted);
    }

    private static String makeBold(String words) {
        StringBuilder stringBuilder = new StringBuilder(words);
        stringBuilder.insert(0, "**");
        stringBuilder.append("**");
        return stringBuilder.toString();
    }
}
