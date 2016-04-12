package com.cht.ly.gen.interceptor;

import com.cht.ly.gen.config.Configuration;

/**
 * Created by Edward on 2016/3/24.
 */
public interface Interceptor {
    public void before(Configuration configuration);
    public void after(Configuration configuration);
}
