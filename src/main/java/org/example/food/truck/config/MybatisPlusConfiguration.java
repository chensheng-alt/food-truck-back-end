package org.example.food.truck.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusLanguageDriverAutoConfiguration;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlusConfiguration
 *
 * @author chensheng
 **/
@Configuration
@AutoConfigureAfter({MybatisPlusLanguageDriverAutoConfiguration.class})
public class MybatisPlusConfiguration {
    @Bean
    @ConditionalOnMissingBean(name = {"com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor"})
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor newInterceptor = new MybatisPlusInterceptor();
        // 添加乐观锁插件
        newInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return newInterceptor;
    }
}
