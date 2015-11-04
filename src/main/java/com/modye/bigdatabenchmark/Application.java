package com.modye.bigdatabenchmark;

import com.modye.bigdatabenchmark.batch.configuration.ImportBatchConfiguration;
import com.modye.bigdatabenchmark.repository.couchbase.CouchbaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by modye on 29/10/2015.
 */
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {
    public static void main(String... args) {
        System.exit(SpringApplication.exit(SpringApplication.run(
                ImportBatchConfiguration.class, args)));
    }
}
