package org.flysli.gadget.plugins.transfer.execute;

import org.flysli.gadget.plugins.transfer.ReflexUtilSandBox;
import org.flysli.gadget.plugins.transfer.annotation.Import;
import org.flysli.gadget.plugins.transfer.procer.ConstraintProcer;

import java.lang.annotation.Annotation;

/**
 * 默认的处理器
 */
public class DefaultFormatProcer implements InvokeProcer {

    @Override
    public Object invoke(Annotation a, Object o) {
        //取出Import注解
        Import annImport = a.annotationType().getAnnotation(Import.class);
        Class<?>[] procers = annImport.procers();
        for (Class<?> procer : procers) {
            Object o1 = ReflexUtilSandBox.getInstance(procer);
            if (o1 != null) {
                ConstraintProcer constraintProcer = (ConstraintProcer) o1;
                return constraintProcer.process(a, o);
            }
        }
        return null;
    }
}
