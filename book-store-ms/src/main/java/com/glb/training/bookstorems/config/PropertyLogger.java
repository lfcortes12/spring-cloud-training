package com.glb.training.bookstorems.config;

import java.util.Arrays;
import java.util.stream.StreamSupport;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PropertyLogger  {


    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        /*final Environment env = event.getApplicationContext().getEnvironment();
        log.info("====== Environment and configuration ======");
        log.info("Active profiles: {}", Arrays.toString(env.getActiveProfiles()));
        final MutablePropertySources sources = ((AbstractEnvironment) env).getPropertySources();
        log.info(sources.toString());
        StreamSupport.stream(sources.spliterator(), false)
                .filter(ps -> ps instanceof EnumerablePropertySource)
                .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                .flatMap(Arrays::stream)
                .distinct()
                .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
                .forEach(prop -> log.info("{}: {}", prop, env.getProperty(prop)));
        log.info("===========================================");*/
    }
}