package com.tan.start.vo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BaseVO {

    @Deprecated
    public static Object convert(Object dest,Object orig){
        try {
            BeanUtils.copyProperties(dest,orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("illegal access or invocation target: ",e);
        }
        return dest;
    }

    @Deprecated
    public static <T> List<T> convertList(List orig,Class destClz){
        List<T> dest = new ArrayList<>();
        for (Object item:orig) {
            T tmp = null;
            try {
                tmp = (T) destClz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                log.error("instantiation or illegal access: ",e);
            }
            convert(tmp,item);
            dest.add(tmp);
        }
        return dest;
    }
}
