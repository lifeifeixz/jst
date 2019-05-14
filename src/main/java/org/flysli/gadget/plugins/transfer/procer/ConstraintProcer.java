package org.flysli.gadget.plugins.transfer.procer;

public interface ConstraintProcer<T, V> {

    /**
     * processing's father or standard
     *
     * @param annotation
     * @param source     The object being processed; the attribute value of the object
     * @return
     */
    V process(T annotation, V source);
}
