package com.bdqn.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author ldwjava
 * @Date 2019/5/9 15:45
 * @Desc TODO
 **/

public class QueryVo {
    private Items item;

    private ItemCus itemCus;

    private List<Items> itemsList;

    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public ItemCus getItemCus() {
        return itemCus;
    }

    public void setItemCus(ItemCus itemCus) {
        this.itemCus = itemCus;
    }
}
