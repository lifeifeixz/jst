package org.flysli.gadget.plugins.transfer;

import org.flysli.gadget.plugins.transfer.annotation.Format;
import org.flysli.gadget.plugins.transfer.annotation.Import;
import org.flysli.gadget.plugins.transfer.execute.DefaultFormatProcer;
import org.flysli.gadget.plugins.transfer.procer.ConstraintProcer;

import java.lang.reflect.Field;
import java.util.List;

public class Processer {
    public static Object process(Object source) {
        Class<?> oClass = source.getClass();
        Field[] declaredFields = oClass.getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            Object o = ReflexUtilSandBox.getValue(f, source);
            o = DispatchConverter.entry(f.getAnnotations(), o);
            ReflexUtilSandBox.setValue(f, source, o);
        }
        return source;
    }


    public static List<Object> process(List<Object> sources) {
        sources.parallelStream().forEach(e -> process(e));
        return sources;
    }
}
