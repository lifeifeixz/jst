package org.flysli.gadget.plugins.transfer.procer;

import org.flysli.gadget.plugins.transfer.annotation.Round;

import java.text.DecimalFormat;

public class ProcerRound implements ConstraintProcer<Round, Object> {
    @Override
    public Object process(Round annotation, Object source) {
        Double d = null;
        if (source == null) {
            d = Double.valueOf(annotation.ifnull());
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(d));
    }
}
