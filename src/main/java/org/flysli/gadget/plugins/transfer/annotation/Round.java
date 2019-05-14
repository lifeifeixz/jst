package org.flysli.gadget.plugins.transfer.annotation;

import org.flysli.gadget.plugins.transfer.procer.ConstraintProcer;
import org.flysli.gadget.plugins.transfer.procer.ProcerRound;

import java.lang.annotation.*;


@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(procers = ProcerRound.class)
public @interface Round {
    int digit() default 2;

    Class<? extends ConstraintProcer>[] worker() default ProcerRound.class;

    String ifnull() default "";
}
