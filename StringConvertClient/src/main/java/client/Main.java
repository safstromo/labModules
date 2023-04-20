package client;

import annotations.Convert;
import service.StringConverter;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            switch (scanner.next()) {
                case "1" -> convertToThreeBold(getStringToConvert(scanner));
                case "2" -> convertWholeBold(getStringToConvert(scanner));
                case "3" -> System.exit(0);
            }
        }
    }

    private static void convertWholeBold(String input) {
        for (var c : getConverters("bold")) {
            System.out.println(c.convert(input));
        }

    }

    private static void convertToThreeBold(String input) {
        for (var c : getConverters("threeBold")) {
            System.out.println(c.convert(input));
        }

    }

    private static List<StringConverter> getConverters(String containsString) {
        ServiceLoader<StringConverter> serviceLoader = ServiceLoader.load(StringConverter.class);
        return serviceLoader.stream()
                .filter(c -> c.type().isAnnotationPresent(Convert.class)
                        && c.type().getAnnotation(Convert.class)
                        .value()
                        .equals(containsString))
                .map(ServiceLoader.Provider::get)
                .toList();
    }

    private static void printMenu() {
        System.out.println("""
                --------------------------------------------------------------
                This app converts a string to a Markdown string
                1. First three letters in each word bold (For faster reading)
                2. Make the whole string bold
                3. Exit
                --------------------------------------------------------------
                """);
    }

    private static String getStringToConvert(Scanner scanner) {
        System.out.println("""
                --------------------------------------------------------------
                Enter the string you want converted:
                --------------------------------------------------------------
                """);
        return scanner.next();
    }
}

