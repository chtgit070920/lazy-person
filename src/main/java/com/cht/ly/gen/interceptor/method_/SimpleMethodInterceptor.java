package com.cht.ly.gen.interceptor.method_;

import com.cht.ly.gen.config.Configuration;
import com.cht.ly.gen.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by Edward on 2016/3/24.
 */
public class SimpleMethodInterceptor extends AbstractInterceptor {

    public void before(Configuration configuration) {
        configuration.parseMethodNames();
        for(Map<String,String> method:configuration.getStore()){
            if(method.containsKey(Configuration.flag_name)){
                _methodComment(configuration,method);
                _methodAnnotation(configuration,method);
                _methodSignature(configuration,method);
                _methodBody(configuration,method);
            }
        }
    }

    public void after(Configuration configuration) {

    }

    protected void _methodComment(Configuration configuration,Map<String,String> method){
        StringBuffer code= configuration.getCode();

        code.append("\r\n");
        code.append("  /**\r\n");
        code.append("   * @Description(method):");
        code.append(
                method.containsKey(Configuration.flag_comment)?
                        (method.get(Configuration.flag_comment)):
                        (method.get(Configuration.flag_name)));
        code.append("\r\n");
        code.append("   */\r\n");
    }

    protected void _methodAnnotation(Configuration configuration,Map<String,String> method){
        StringBuffer code= configuration.getCode();
        if(method.containsKey(Configuration.flag_annotation)){
            for(String annotation:method.get(Configuration.flag_annotation).split(",")){
                code.append("  ");
                code.append(annotation+"\r\n");
            }
        }
    }

    protected void _methodSignature(Configuration configuration,Map<String,String> method){
        StringBuffer code= configuration.getCode();
        code.append(  "  ");

        code.append( method.containsKey(Configuration.flag_visit)?
                        (method.get(Configuration.flag_visit)+" "):"private ");

        code.append(method.containsKey(Configuration.flag_static)?("static "):"");

        code.append(method.containsKey(Configuration.flag_final)?
                ("final "):"");

        code.append(method.containsKey(Configuration.flag_type)?
                  (method.get(Configuration.flag_type)+" "):"void ");

        code.append(method.get(Configuration.flag_name));

        code.append("(");
        code.append(method.containsKey(Configuration.flag_param)?
                        (method.get(Configuration.flag_param)):"");
        code.append( ")");
    }

    protected void _methodBody(Configuration configuration,Map<String,String> method){
        StringBuffer code= configuration.getCode();
        code.append("{\r\n");
        code.append("  }\r\n");
    }
}
