package com.cht.ly.gen.config;

import java.util.*;

/**
 * Created by Edward on 2016/3/24.
 */
public class Configuration implements java.io.Serializable{

    public static final String segmentation_element="^";
    public static final String segmentation_part="&";
    public static final String segmentation_keyvalue="|";

    public static final String flag_comment="c";//flag of  method comment or filed comment
    public static final String flag_visit="v";//flag of public protectd private ..etc
    public static final String flag_static="s";//flag of  static
    public static final String flag_final="f";//flag of  final
    public static final String flag_abstract="a";//flag of  abstract,only for method
    public static final String flag_type="r";//flag of return type
    public static final String flag_name="n";//flag of  method name or fild name
    public static final String flag_param="p";//flag of  method param
    public static final String flag_value="z";//flag of  value
    public static final String flag_annotation="a";//flag of  anotation
    public static final String flag_nobody="b";//flag of  nobody,only for method

    private String author;
    private String packageName;
    private String className;
    private String fieldNames;
    private String methodNames;
    private String comment;

    private StringBuffer code;
    private List<Map<String,String> >store;


    public void parse(String str) {
        store.clear();//清理存储器
        if(null==str) return;

        //去除所有的空格、制表符、换页符等空白字符的其中任意一个
        String fields=str.replaceAll("\\s*","");
        if("".equals(fields)) return;

        //特殊字符替换
        //str=str.replaceAll("；",";");//替换所有的中文分号为英文分号
        //str=str.replaceAll("，",",");//替换所有的中文逗号为英文逗号
        //str=str.replaceAll("：",":");//替换所有的中文冒号为英文冒号

        //分割出element
        for(String element:str.split("\\"+segmentation_element)){
            Map<String,String> m=new HashMap<String, String>();


            //分割出part
            for(String part :element.split(segmentation_part)){
                if(part.length()<1) continue;//元素出出现多个连续"partSegmentation"会导致part为""
                while(part.indexOf(segmentation_keyvalue)==0){//去除开头的"keyValueSegmentation"
                    part=part.substring(1);
                }
                if(part.length()<1) continue;//元素出出现多个连续"keyValueSegmentation"会导致被替换后part为""
                while(part.lastIndexOf(segmentation_keyvalue)==part.length()-1){//去除结尾的"keyValueSegmentation"
                    part=part.substring(0,part.length()-1);
                }
                if(part.length()<1) continue;//这个肯定不会出现，但为了代码完整美观 故多些此语句

                String prefix,suffix;

                //对part进行再分割，以第一个"keyValueSegmentation"为基准
                int firstIndex=part.indexOf(segmentation_keyvalue);
                if(-1==firstIndex){
                    prefix=part;
                    suffix="";
                }else{
                    prefix=part.substring(0,firstIndex);
                    suffix=part.substring(firstIndex+1);

                    //如果suffix仍有"keyValueSegmentation"，则使用" "替换
                    suffix=suffix.replaceAll("\\"+segmentation_keyvalue," ");//替换为一个空白字符
                }

                //如果已经存在证明有多个类型的part，例如参数part
                String  already=m.get(prefix);
                if(null==already)already="";
                if(!"".equals(already))already+=",";
                suffix=already+suffix;

                m.put(prefix,suffix);
            }
            store.add(m);
        }
    }

    public void parseFieldNames() {
        parse(this.getFieldNames());
    }
    public void parseMethodNames(){
        parse(this.getMethodNames());
    }

    public Configuration(){
        this.code=new StringBuffer();
        store=new LinkedList<Map<String, String>>();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFieldNames() {
        return fieldNames;
    }
    public void setFieldNames(String fieldNames) {
        this.fieldNames = fieldNames;
    }
    public String getMethodNames() {
        return methodNames;
    }
    public void setMethodNames(String methodNames) {
        this.methodNames = methodNames;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public StringBuffer getCode() {
        return code;
    }

    public void setCode(StringBuffer code) {
        this.code = code;
    }

    public List<Map<String, String>> getStore() {
        return store;
    }

    public void setStore(List<Map<String, String>> store) {
        this.store = store;
    }
}
