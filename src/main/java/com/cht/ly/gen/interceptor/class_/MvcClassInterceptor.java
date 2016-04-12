package com.cht.ly.gen.interceptor.class_;

import com.cht.ly.gen.config.Configuration;
import com.cht.ly.gen.config.MvcConfiguration;
import com.cht.ly.gen.config.Target;

/**
 * Created by Edward on 2016/3/25.
 */
public class MvcClassInterceptor extends SimpleClassInterceptor{

    protected void class_(Configuration configuration){
        StringBuffer code= configuration.getCode();

        MvcConfiguration spingMvcConifguration=(MvcConfiguration)configuration;
        if(Target.ACTION==spingMvcConifguration.getTarget()){
            String className=configuration.getClassName();
            String loweFirst=className.substring(0,1).toLowerCase();
            String other=className.length()==1?"":className.substring(1);
            String requestMapping=loweFirst+other;
            code.append("@Controller\r\n");
            code.append("@RequestMapping(value=\"/"+requestMapping+"\")\r\n");
        }else if(Target.SERVICE==spingMvcConifguration.getTarget()){
            code.append("@Service\r\n");
            code.append("@Transactional(readOnly=true)\r\n");
        }else if(Target.DAO==spingMvcConifguration.getTarget()){
            code.append("@MyBatisRepository\r\n");
        }
        super.class_(configuration);
    }
}
