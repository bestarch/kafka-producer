package com.bestarch.framework.kafkapoc.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.bestarch.framework.kafkapoc.bean.Request;

/**
 * 
 * @author bestarch
 *
 */
@Configuration
@EnableKafka
public class KafkaConfiguration {

	@Bean
    public KafkaTemplate<Integer, Request> kafkaTemplate() {
        return new KafkaTemplate<Integer, Request>(producerFactory());
    }
	
	@Bean
    public ProducerFactory<Integer, Request> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }
	
	@Bean
    public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ProducerConfig.RETRIES_CONFIG, 0);
	    props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
	    props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
	    props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	    return props;
    }
	
}
