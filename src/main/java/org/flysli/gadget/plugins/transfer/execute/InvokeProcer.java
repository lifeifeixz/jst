package org.flysli.gadget.plugins.transfer.execute;

import java.lang.annotation.Annotation;

public interface InvokeProcer {

    /**
     * 分类处理
     *
     * @param a
     * @param o
     * @return
     */
    Object invoke(Annotation a, Object o);
}
