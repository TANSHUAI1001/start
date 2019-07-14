package com.tan.start.utils;

import com.tan.start.dto.RoleResourceDTO;
import com.tan.start.dto.SysResourceDTO;
import com.tan.start.entity.SysResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateTreeFromList {

    public static List<Menu> generateTree(List<RoleResourceDTO> list){
        List<Menu> trees = new ArrayList<Menu>();
        Map<String,Menu> map = new HashMap<>();
        for (SysResource item:list) {
            map.put(item.getId().toString(),new Menu(item));
        }
        for (SysResource item:list) { // list按level排序，没有配置parent直接升级item位置
            if("1".equals(item.getLevel())){
                trees.add(map.get(item.getId().toString()));
            }else {
                Menu tmp = map.get(item.getParent());
                if(tmp != null && tmp.getSub() != null){
                    tmp.getSub().add(map.get(item.getId().toString()));
                }else{
                    trees.add(map.get(item.getId().toString()));
                }

            }
        }
        return trees;
    }
}
