package com.maxmayev.compservice.services;

import com.maxmayev.compservice.Consumer;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JMSConfig{

    @Bean
    public org.springframework.jms.support.converter.MappingJackson2MessageConverter messageConverter() {
        org.springframework.jms.support.converter.MappingJackson2MessageConverter messageConverter =
                new MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("_typeId");

        Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
        typeIdMappings.put("consumer", Consumer.class);
        messageConverter.setTypeIdMappings(typeIdMappings);

        return messageConverter;
    }

}
