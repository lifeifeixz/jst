package org.flysli.gadget.plugins.transfer;

import org.flysli.gadget.plugins.transfer.annotation.Format;
import org.flysli.gadget.plugins.transfer.annotation.Import;
import org.flysli.gadget.plugins.transfer.annotation.Round;
import org.flysli.gadget.plugins.transfer.execute.DefaultFormatProcer;

import java.lang.annotation.Annotation;

public class DispatchConverter {

    public static Object entry(Annotation[] annotations, Object value) {
        for (Annotation c : annotations) {
            /*format注解*/
            if (c instanceof Format) {
                Class<?>[] converters = ((Format) c).converter();
                value = Converter.convert(converters, value);
            }
            /*Import注解*/
            Import importAnnotation = c.annotationType().getAnnotation(Import.class);
            if (importAnnotation != null) {
                value = new DefaultFormatProcer().invoke(c, value);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Round.class.getAnnotations();
    }
}
