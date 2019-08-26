package com.tan.start.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tan.start.entity.SysResource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class Menu implements Serializable {
    private static final long serialVersionUID = -903880838815229102L;
    private String value;
    private String name;
    private String level;
    private String parent;
    private String classes;
    private Integer priority;
    private List<Menu> sub;

    public Menu() {
    }

    public Menu(SysResource item) {
        try {
            BeanUtils.copyProperties(this,item);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e.getMessage(),e);
        }
        this.sub = new ArrayList<>();
    }
}
