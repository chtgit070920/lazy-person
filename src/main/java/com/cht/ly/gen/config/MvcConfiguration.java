package com.cht.ly.gen.config;

/**
 * Created by Edward on 2016/3/25.
 */
public class MvcConfiguration extends Configuration{

    public static final String subpackage_model="model";
    public static final String subpackage_action="action";
    public static final String subpackage_service="service";
    public static final String subpackage_dao="dao";

    public static final String classnamesuffix_model="";
    public static final String classnamesuffix_action="Action";
    public static final String classnamesuffix_service="Service";
    public static final String classnamesuffix_dao="Dao";

    private String modelName;

    private String modelFieldNames;
    private String modelMethodNames;

    private String actionFieldNames;
    private String actionMethodNames;

    private String serviceFieldNames;
    private String serviceMethodNames;

    private String daoFieldNames;
    private String daoMethodNames;

    private Target target;

    public String getPackageName(){
        if(this.getTarget()==Target.MODEL){
            return super.getPackageName()+"."+subpackage_model;
        }else if(this.getTarget()==Target.ACTION){
            return super.getPackageName()+"."+subpackage_action;
        }else if(this.getTarget()==Target.SERVICE){
            return super.getPackageName()+"."+subpackage_service;
        }else if(this.getTarget()==Target.DAO){
            return super.getPackageName()+"."+subpackage_dao;
        }else{
            return super.getPackageName();
        }
    }

    public String getClassName(){
        String classname=this.getModelName();
        String upperFirst=classname.substring(0,1).toUpperCase();
        String other=classname.length()==1?"":classname.substring(1);
        classname=upperFirst+other;
        if(this.getTarget()==Target.MODEL){
            return classname+classnamesuffix_model;
        }else if(this.getTarget()==Target.ACTION){
            return classname+classnamesuffix_action;
        }else if(this.getTarget()==Target.SERVICE){
            return classname+classnamesuffix_service;
        }else if(this.getTarget()==Target.DAO){
            return classname+classnamesuffix_dao;
        }else{
            return classname;
        }
    }

    public void parseFieldNames() {
        if(this.getTarget()==Target.MODEL){
            parse(this.getModelFieldNames());
        }else if(this.getTarget()==Target.ACTION){
            parse(this.getActionFieldNames());
        }else if(this.getTarget()==Target.SERVICE){
            parse(this.getServiceFieldNames());
        }else if(this.getTarget()==Target.DAO){
            parse(this.getDaoFieldNames());
        }else{
        }
    }
    public void parseMethodNames(){
        if(this.getTarget()==Target.MODEL){
            parse(this.getModelMethodNames());
        }else if(this.getTarget()==Target.ACTION){
            parse(this.getActionMethodNames());
        }else if(this.getTarget()==Target.SERVICE){
            parse(this.getServiceMethodNames());
        }else if(this.getTarget()==Target.DAO){
            parse(this.getDaoMethodNames());
        }else{
        }
    }


    public MvcConfiguration(){
        super();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelMethodNames() {
        return modelMethodNames;
    }

    public void setModelMethodNames(String modelMethodNames) {
        this.modelMethodNames = modelMethodNames;
    }



    public String getActionMethodNames() {
        return actionMethodNames;
    }

    public void setActionMethodNames(String actionMethodNames) {
        this.actionMethodNames = actionMethodNames;
    }

    public String getModelFieldNames() {
        return modelFieldNames;
    }

    public void setModelFieldNames(String modelFieldNames) {
        this.modelFieldNames = modelFieldNames;
    }

    public String getActionFieldNames() {
        return actionFieldNames;
    }

    public void setActionFieldNames(String actionFieldNames) {
        this.actionFieldNames = actionFieldNames;
    }

    public String getServiceFieldNames() {
        return serviceFieldNames;
    }

    public void setServiceFieldNames(String serviceFieldNames) {
        this.serviceFieldNames = serviceFieldNames;
    }

    public String getDaoFieldNames() {
        return daoFieldNames;
    }

    public void setDaoFieldNames(String daoFieldNames) {
        this.daoFieldNames = daoFieldNames;
    }

    public String getServiceMethodNames() {
        return serviceMethodNames;
    }

    public void setServiceMethodNames(String serviceMethodNames) {
        this.serviceMethodNames = serviceMethodNames;
    }

    public String getDaoMethodNames() {
        return daoMethodNames;
    }

    public void setDaoMethodNames(String daoMethodNames) {
        this.daoMethodNames = daoMethodNames;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
