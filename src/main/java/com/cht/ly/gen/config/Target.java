package com.cht.ly.gen.config;

/**
 * Created by Edward on 2016/3/24.
 */
public enum Target {
    MODEL("module"),
    ACTION("action"),
    SERVICE("service"),
    DAO("dao");

    private String name;
    Target(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(String name){
        for(Target t:Target.values()){
            if(t.getName().equals(name)) return t.getName();
        }
        return null;
    }
}
