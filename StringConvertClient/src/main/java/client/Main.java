package client;

import service.StringConverter;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            switch (scanner.nextLine()) {
                case "1" -> convertToThreeBold();
                case "2" -> convertWholeBold();
                case "3" -> System.exit(0);
            }
        }
    }

    private static void convertWholeBold() {
        for (var c : getConverters("Whole")) {
            System.out.println(c.get().convert("test Whole"));
        }

    }

    private static void convertToThreeBold() {
        for (var c : getConverters("Three")) {
            System.out.println(c.get().convert("test"));
        }

    }

    private static List<ServiceLoader.Provider<StringConverter>> getConverters(String containsString) {
        ServiceLoader<StringConverter> serviceLoader = ServiceLoader.load(StringConverter.class);
        return serviceLoader.stream()
                .filter(stringConverterProvider -> stringConverterProvider.type()
                        .getSimpleName().contains(containsString)).toList();
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
}

