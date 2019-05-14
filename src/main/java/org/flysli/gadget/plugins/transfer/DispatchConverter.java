package org.flysli.gadget.plugins.transfer;

import org.flysli.gadget.plugins.transfer.annotation.Round;

import java.lang.annotation.Annotation;

public class DispatchConverter {

    public Object entry(Annotation annotation, Object value) {

        return null;
    }

    public static void main(String[] args) {
        Round.class.getAnnotations();
    }
}
