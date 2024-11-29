package learn.kafka.kafkastreamsyellingapp;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Named;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class KafkaStreamsYellingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamsYellingAppApplication.class, args);
    }

    public static class Functions {
        @Bean
        public Function<KStream<String, String>, KStream<String, String>> yell() {
            return input -> input.mapValues(value -> value.toUpperCase(),
                    Named.as("Convert-to-Yelling"));
        }
    }
}
