package converter;

import service.StringConverter;

public class WholeBold implements StringConverter {
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
