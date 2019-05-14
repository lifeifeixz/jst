package org.flysli.gadget.plugins.transfer.converter;

import org.flysli.gadget.plugins.transfer.DataFormatConverter;

public class PhoneParseConverter implements DataFormatConverter {
    @Override
    public Object convert(Object o) {
        String s = o.toString();
        String var1 = s.substring(0, 3);
        String var2 = s.substring(3, 6);
        String var3 = s.substring(6, 11);

        return var1 + " " + var2 + " " + var3;
    }
}
