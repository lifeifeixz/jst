package org.flysli.gadget.plugins.transfer.converter;

import org.flysli.gadget.plugins.transfer.DataFormatConverter;

public class PhoneFormatConverter implements DataFormatConverter {
    @Override
    public Object convert(Object o) {
        return "+86:" + o.toString();
    }
}
