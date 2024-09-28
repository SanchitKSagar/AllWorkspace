package com;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducertest {

	public static void main(String[] args)
	{
		String topicName = "testtopic1";
		Properties prop = new Properties();
		prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		Producer<String, String> prodRef = new KafkaProducer<String, String>(prop);
		ProducerRecord<String, String> topicContent = new ProducerRecord<String, String>(topicName, "Hi Tis is from JAVA side");
		
		prodRef.send(topicContent);
		prodRef.close();
		System.out.println("Message sent");
	}
	
}
