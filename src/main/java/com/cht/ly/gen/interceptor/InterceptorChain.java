package com.cht.ly.gen.interceptor;

import com.cht.ly.gen.config.Configuration;

import java.util.List;

/**
 * Created by Edward on 2016/3/24.
 */
public   class InterceptorChain {

    private Configuration configuration;
    private List<Interceptor> interceptors;
    private int interceptorIndex = -1;

    public InterceptorChain(Configuration configuration,List<Interceptor> interceptors) {
        this.configuration=configuration;
        this.interceptors=interceptors;
    }

    public void applyBefore(){
        if(null!=interceptors){
            for(int i=0;i<interceptors.size();i++){
                Interceptor interceptor=interceptors.get(i);
                interceptor.before(configuration);
                this.interceptorIndex=i;
            }
        }
    }

    public void applyAfter() {
        if(null!=interceptors){
            for(int i=interceptorIndex;i>=0;i--){
                Interceptor interceptor=interceptors.get(i);
                interceptor.after(configuration);
            }
        }
    }


     public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
    }
}
