package org.flysli.gadget.plugins.transfer;

import org.flysli.gadget.plugins.transfer.annotation.Format;
import org.flysli.gadget.plugins.transfer.annotation.Import;
import org.flysli.gadget.plugins.transfer.procer.ConstraintProcer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class Processer {
    public static Object process(Object source) {
        Class<?> oClass = source.getClass();
        Field[] declaredFields = oClass.getDeclaredFields();
        Import annotation1 = oClass.getAnnotation(Import.class);
        System.out.println(annotation1);
        for (Field f : declaredFields) {
            f.setAccessible(true);
            Object o = ReflexUtilSandBox.getValue(f, source);
            Annotation[] customAnnotation = f.getAnnotations();
            for (Annotation c : customAnnotation) {
                //format注解
                Format fAnnotation = f.getAnnotation(Format.class);
                if (fAnnotation != null) {
                    Class<?>[] converters = fAnnotation.converter();
                    o = Converter.convert(converters, o);
                }
                //导入注解
                Import importAnnotation = c.annotationType().getAnnotation(Import.class);
                if (importAnnotation != null) {
                    Class<?>[] procers = importAnnotation.procers();
                    for (Class<?> procer : procers) {
                        Object o1 = ReflexUtilSandBox.getInstance(procer);
                        if (o1 != null) {
                            ConstraintProcer constraintProcer = (ConstraintProcer) o1;
                            o = constraintProcer.process(c, o);

                        }
                    }
                }
                ReflexUtilSandBox.setValue(f, source, o);
            }

        }
        return source;
    }


    public static List<Object> process(List<Object> sources) {
        sources.parallelStream().forEach(e -> process(e));
        return sources;
    }
}
