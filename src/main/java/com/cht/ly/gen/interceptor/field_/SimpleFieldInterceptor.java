package com.cht.ly.gen.interceptor.field_;

import com.cht.ly.gen.config.Configuration;
import com.cht.ly.gen.interceptor.AbstractInterceptor;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.Map;

/**
 * Created by Edward on 2016/3/24.
 */
public class SimpleFieldInterceptor extends AbstractInterceptor {

    public void before(Configuration configuration) {
        configuration.parseFieldNames();
        StringBuffer code= configuration.getCode();
        for(Map<String,String> field:configuration.getStore()){
            if(field.containsKey(Configuration.flag_name)){
                _fieldComment(configuration,field);
                _fieldAnnotation(configuration,field);
                _fieldSignature(configuration,field);
            }
        }
    }

    public void after(Configuration configuration) {

    }

    protected void _fieldComment(Configuration configuration,Map<String,String> field){
        StringBuffer code= configuration.getCode();
        code.append("\r\n");
        code.append("  /**\r\n");
        code.append("   * @Description(field):");
        code.append(
                field.containsKey(Configuration.flag_comment)?
                        (field.get(Configuration.flag_comment)):
                        (field.get(Configuration.flag_name)));
        code.append("\r\n");
        code.append("   */\r\n");
    }

    protected void _fieldAnnotation(Configuration configuration,Map<String,String> field){
        StringBuffer code= configuration.getCode();
        if(field.containsKey(Configuration.flag_annotation)){
            for(String annotation:field.get(Configuration.flag_annotation).split(",")){
                code.append("  ");
                code.append(annotation+"\r\n");
            }
        }
    }

    protected void _fieldSignature(Configuration configuration,Map<String,String> field){
        StringBuffer code= configuration.getCode();
        code.append("  ");
        code.append(field.containsKey(Configuration.flag_visit)?
                                (field.get(Configuration.flag_visit)+" "):"private ");

        code.append(field.containsKey(Configuration.flag_static)?
                                ("static "):"");

        code.append(field.containsKey(Configuration.flag_final)?
                                ("final "):"");

        code.append(field.containsKey(Configuration.flag_type)?
                                (field.get(Configuration.flag_type)+" "):"void ");

        code.append(field.get(Configuration.flag_name));

        code.append(field.containsKey(Configuration.flag_value)?
                                (" = "+field.get(Configuration.flag_value)):"");
        code.append(";\r\n");

        code.append("\r\n");
    }


}
