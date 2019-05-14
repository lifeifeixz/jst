package org.flysli.gadget.plugins.transfer.annotation;


import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Format{

    Class<?>[] converter();
}
