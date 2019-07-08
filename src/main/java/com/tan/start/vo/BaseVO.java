package com.tan.start.vo;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class BaseVO {

    public static Object convert(Object dest,Object orig){
        try {
            BeanUtils.copyProperties(dest,orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return dest;
    }
    public static <T> List<T> convertList(List orig,Class destClz){
        List<T> dest = new ArrayList<>();
        for (Object item:orig) {
            T tmp = null;
            try {
                tmp = (T) destClz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            convert(tmp,item);
            dest.add(tmp);
        }
        return dest;
    }
}
