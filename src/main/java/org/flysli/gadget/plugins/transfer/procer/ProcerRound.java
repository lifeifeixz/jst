package org.flysli.gadget.plugins.transfer.procer;

import org.flysli.gadget.plugins.transfer.annotation.Round;

public class ProcerRound implements ConstraintProcer<Round, Object> {
    @Override
    public Object process(Round annotation, Object source) {
        if (source == null) {
            return Double.valueOf(annotation.ifnull());
        }
        return source;
    }
}
