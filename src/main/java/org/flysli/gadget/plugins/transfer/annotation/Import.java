package org.flysli.gadget.plugins.transfer.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.TYPE,ElementType.PACKAGE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Import {

    Class<?>[] procers();
}
