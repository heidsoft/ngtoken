package cn.ngtoken.logs.config;

import cn.ngtoken.logs.interceptor.LogInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class MvcConfig implements WebMvcConfigurer {
    final static Logger LOGGER = LoggerFactory.getLogger(MvcConfig.class);

    @Autowired
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LOGGER.info("go to addInterceptors ");
        registry.addInterceptor(logInterceptor);
    }
}
