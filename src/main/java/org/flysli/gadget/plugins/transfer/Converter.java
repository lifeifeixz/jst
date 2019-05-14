package org.flysli.gadget.plugins.transfer;

public class Converter {

    public static Object convert(Class<?>[] converters, Object value) {
        for (Class<?> converter : converters) {
            value = convert(converter, value);
        }
        return value;
    }

    public static Object convert(Class<?> converter, Object value) {
        Object instance = ReflexUtilSandBox.getInstance(converter);
        DataFormatConverter dataFormatConverter = (DataFormatConverter) instance;
        value = dataFormatConverter.convert(value);
        return value;
    }
}
