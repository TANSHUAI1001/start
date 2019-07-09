package com.tan.start.utils;

import com.tan.start.entity.SysResource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        this.value = item.getValue();
        this.name = item.getName();
        this.level = item.getLevel();
        this.classes = item.getClasses();
        this.priority = item.getPriority();
        this.sub = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public List<Menu> getSub() {
        return sub;
    }

    public void setSub(List<Menu> sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", parent='" + parent + '\'' +
                ", classes='" + classes + '\'' +
                ", priority=" + priority +
                ", sub=" + sub +
                '}';
    }
}
