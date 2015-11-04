package com.modye.bigdatabenchmark.repository.couchbase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by modye on 30/10/2015.
 */
@Configuration
@EnableCouchbaseRepositories(basePackageClasses = CouchbaseRepository.class)
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.nodes}")
    private List<String> nodes = new ArrayList<String>();

    @Value("${couchbase.bucket}")
    private String bucket;

    @Value("${couchbase.password}")
    private String password;

    @Override
    public List<String> bootstrapHosts() {
        return nodes;
    }

    @Override
    public String getBucketName() {
        return bucket;
    }

    @Override
    public String getBucketPassword() {
        return password;
    }
}
