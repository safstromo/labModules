package client;

import service.StringConverter;

import java.util.ServiceLoader;
public class Main implements StringConverter {
    static ServiceLoader<StringConverter> serviceLoader = ServiceLoader.load(StringConverter.class);

    public static void main(String[] args) {


    }

    @Override
    public String convert(String StringToBeConverted) {
        //TODO
        String convertedString = "";
        for (StringConverter s : serviceLoader) {
            convertedString = s.convert(StringToBeConverted);
        }
        return convertedString;
    }
}
