package com.cht.ly.gen;

/**
 * Created by Edward on 2016/3/24.
 */
public abstract class AbstractGen {

    private String  root;//dir of gen file


    public  void excute(){
        genJava();
        genJsp();
        genConfig();
    }

    //generate java
    public abstract void genJava();
    //generate jsp
    public abstract void genJsp();
    //generate Config
    public abstract void genConfig();

    //generate java file path
    public abstract String genJavaPath();
    //generate jsp file path
    public abstract String genJspPath();
    //generate jsp file path
    public abstract String genConfigPath();

}
