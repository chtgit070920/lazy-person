package com.cht.ly.gen.interceptor;

import com.cht.ly.gen.config.Configuration;
import com.cht.ly.gen.config.MvcConfiguration;
import com.cht.ly.gen.config.Target;
import com.cht.ly.gen.interceptor.class_.SimpleClassInterceptor;
import com.cht.ly.gen.interceptor.class_.MvcClassInterceptor;
import com.cht.ly.gen.interceptor.field_.SimpleFieldInterceptor;
import com.cht.ly.gen.interceptor.method_.SimpleMethodInterceptor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edward on 2016/3/24.
 */
public class InterceptorChainTest {


    @Test
    public void test(){
        Configuration configuration=new Configuration();
        configuration.setAuthor("Edward");
        configuration.setPackageName("com.cht.lp");
        configuration.setClassName("user");

        List<Interceptor> interceptors=new ArrayList<Interceptor>();
        interceptors.add(new SimpleClassInterceptor());
        interceptors.add(new SimpleFieldInterceptor());
        interceptors.add(new SimpleMethodInterceptor());
        configuration.setFieldNames("v:public,r:int,n:id,z:1;v:protected,r:Object,n:o,z:new:Object();");
        configuration.setMethodNames("v:protected,r:void,n:setId,p:int:i,p:String:str");


        InterceptorChain interceptorChain=new InterceptorChain(configuration,interceptors);
        interceptorChain.applyBefore();
        interceptorChain.applyAfter();

        System.out.println(configuration.getCode());
    }

    @Test
    public void testSpringMvcConfiguration(){
        MvcConfiguration configuration=new MvcConfiguration();
        configuration.setAuthor("Edward");

        configuration.setPackageName("com.cht.lp");
        configuration.setModelName("user");

        configuration.setModelFieldNames("v|private&r|void&n|id");
        configuration.setModelMethodNames("v|private&r|void&n|setId");

        configuration.setActionFieldNames("v|public&r|int&n|id&z|1^v|protected&r|Object&n|o&z|new|Object()&a|@Autowired&a|@RequiresPermissions(\"car:view\")^");
        configuration.setActionMethodNames("v|protected&r|void&n|setId&p|int|i&p|String|str");

        configuration.setServiceFieldNames("v|private&r|void&n|id");
        configuration.setServiceMethodNames("v|private&r|void&n|setId");

        configuration.setDaoFieldNames("v|private&r|void&n|id");
        configuration.setDaoMethodNames("v|private&r|void&n|setId");
        configuration.setTarget(Target.ACTION);

        List<Interceptor> interceptors=new ArrayList<Interceptor>();
        interceptors.add(new MvcClassInterceptor());
        interceptors.add(new SimpleFieldInterceptor());
        interceptors.add(new SimpleMethodInterceptor());

        InterceptorChain interceptorChain=new InterceptorChain(configuration,interceptors);
        interceptorChain.applyBefore();
        interceptorChain.applyAfter();

        System.out.println(configuration.getCode());

    }
}
