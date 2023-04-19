package converter;

import service.StringConverter;

public class ThreeBold implements StringConverter {


    @Override
    public String convert(String stringToBeConverted) {
        if (stringToBeConverted.isEmpty())
            throw new IllegalArgumentException();

        String[] words = stringToBeConverted.split(" ");
        makeFirstThreeBold(words);

        return buildString(words);
    }

    private static String buildString(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0)
                stringBuilder.append(words[i]);
            else
                stringBuilder.append(" ").append(words[i]);
        }
        return stringBuilder.toString();
    }

    private static void makeFirstThreeBold(String[] words) {
        for (int i = 0; i < words.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(words[i]);
            if (words[i].length() < 3) {
                stringBuilder.insert(words[i].length(), "**");
                stringBuilder.insert(0, "**");
            } else {
                stringBuilder.insert(3, "**");
                stringBuilder.insert(0, "**");
            }
            words[i] = stringBuilder.toString();
        }
    }
}
