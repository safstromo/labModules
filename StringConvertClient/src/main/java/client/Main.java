package client;

import service.StringConverter;

import java.util.ServiceLoader;
import java.util.concurrent.ThreadPoolExecutor;

public class Main implements StringConverter {
    static ServiceLoader<StringConverter> serviceLoader = ServiceLoader.load(StringConverter.class);

    public static void main(String[] args) {


    }

    @Override
    public String firstThreeBold(String StringToBeConverted) {
        //TODO

        return "this";
    }
}
