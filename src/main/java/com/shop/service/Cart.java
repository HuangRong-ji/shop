package com.shop.service;

import com.shop.bean.CartItem;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> itemMap = new LinkedHashMap<Integer, CartItem>();


    public void addItem(CartItem cartItem) {
        CartItem item = itemMap.get(cartItem.getId());
        if (item == null) {
            itemMap.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    public void deleteItem(Integer id) {
        itemMap.remove(id);
    }

    public void clear() {
        itemMap.clear();
    }

    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = itemMap.get(id);
        if (cartItem != null) {
            //更新商品的数量
            cartItem.setCount(count);
            //更新商品的金额
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        //遍历获取总数量
        for (Map.Entry<Integer, CartItem> entry : itemMap.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer, CartItem> entry : itemMap.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, CartItem> itemMap) {
        this.itemMap = itemMap;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount="+getTotalCount()+
                ",totalPrice="+getTotalPrice()+
                ",itemMap=" + itemMap +
                '}';
    }
}
