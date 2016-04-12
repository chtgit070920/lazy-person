package com.cht.ly.gen;

/**
 * Created by Edward on 2016/3/24.
 */
public abstract class AbstractLpGen extends  AbstractGen{

    //generate java
    public  void genJava(){
        genModelJava();
        genActionJava();
        genServiceJava();
        genDaoJava();
    }

    //generate jsp
    public  void genJsp(){
        genAddJsp();
        genEditJsp();
        genListJsp();
    }

    @Override
    public String genJavaPath() {
        return null;
    }

    @Override
    public String genJspPath() {
        return this.genJavaPath()+"jsp";
    }

    @Override
    public String genConfigPath() {
        return null;
    }

    public abstract void genModelJava();
    public abstract void genActionJava();
    public abstract void genServiceJava();
    public abstract void genDaoJava();

    public abstract void genAddJsp();
    public abstract void genEditJsp();
    public abstract void genListJsp();

}
