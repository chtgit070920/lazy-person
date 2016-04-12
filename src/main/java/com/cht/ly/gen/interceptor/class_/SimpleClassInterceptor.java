package com.cht.ly.gen.interceptor.class_;

import com.cht.ly.gen.config.Configuration;
import com.cht.ly.gen.interceptor.AbstractInterceptor;

/**
 * Created by Edward on 2016/3/24.
 */
public class SimpleClassInterceptor extends AbstractInterceptor {
    public void before(Configuration configuration) {
        package_(configuration);
        import_(configuration);
        comment_(configuration);
        class_(configuration);
    }

    public void after(Configuration configuration) {
        StringBuffer code= configuration.getCode();
        code.append("}");
    }

    protected void package_(Configuration configuration){
        StringBuffer code= configuration.getCode();
        code.append("package ");
        code.append(configuration.getPackageName()+"\r\n");
    }
    protected void import_(Configuration configuration) {

    }
    protected void comment_(Configuration configuration) {
        StringBuffer code= configuration.getCode();
        code.append("\r\n");
        code.append("/**\r\n");
        code.append(" * Created by "+configuration.getAuthor()+" on 2016/3/24\r\n");
        code.append(" */\r\n");
    }

    protected void class_(Configuration configuration){
        StringBuffer code= configuration.getCode();
        code.append("public class "+ configuration.getClassName()+" {\r\n");
    }

}
