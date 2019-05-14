package org.flysli.gadget.plugins.transfer;

import java.lang.reflect.Field;

public class ReflexUtilSandBox {
    public static Object getInstance(Class c) {

        try {
            return c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getValue(Field f, Object source) {
        Object o = null;
        try {
            o = f.get(source);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }

    public static void setValue(Field f, Object source, Object val) {
        try {
            f.set(source, val);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
