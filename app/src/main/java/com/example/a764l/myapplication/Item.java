package com.example.a764l.myapplication;

/**
 * 作者：www on 2016/8/8 13:51
 * 邮箱：2030730029@qq.com
 */
public class Item {
    private int iId;
    private String iName;

    public Item() {
    }

    public Item(int iId, String iName) {
        this.iId = iId;
        this.iName = iName;
    }

    public int getiId() {
        return iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }
}
