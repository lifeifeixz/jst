package org.flysli.gadget.plugins.transfer;

import org.flysli.gadget.plugins.transfer.annotation.Import;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationUtil {
    public static boolean has(Field f, Class<Annotation> annotation) {
        Annotation[] annotations = f.getAnnotations();
        for (Annotation a : annotations) {
            Import anImport = a.getClass().getAnnotation(Import.class);
            if (anImport != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean similar(Annotation var1, Annotation var2) {
        return var1.annotationType() == var2.annotationType();
    }
}
