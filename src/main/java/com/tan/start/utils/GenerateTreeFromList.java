package com.tan.start.utils;

import com.tan.start.entity.SysResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateTreeFromList {

    public static List<Menu> generateTree(List<SysResource> list){
        List<Menu> trees = new ArrayList<Menu>();
        Map<String,Menu> map = new HashMap<>();
        for (SysResource item:list) {
            map.put(item.getId().toString(),new Menu(item));
        }
        for (SysResource item:list) {
            if("1".equals(item.getLevel())){
                trees.add(map.get(item.getId().toString()));
            }else {
                Menu tmp = map.get(item.getParent());
                tmp.getSub().add(map.get(item.getId().toString()));
            }
        }
        return trees;
    }
}