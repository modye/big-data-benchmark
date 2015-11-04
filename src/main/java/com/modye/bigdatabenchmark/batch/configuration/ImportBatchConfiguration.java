package com.modye.bigdatabenchmark.batch.configuration;

import com.modye.bigdatabenchmark.batch.listener.JobCompletionNotificationListener;
import com.modye.bigdatabenchmark.batch.processor.TripItemProcessor;
import com.modye.bigdatabenchmark.batch.writer.TripItemWriter;
import com.modye.bigdatabenchmark.model.Trip;
import com.modye.bigdatabenchmark.repository.couchbase.CouchbaseConfiguration;
import com.modye.bigdatabenchmark.repository.couchbase.CouchbaseRepository;
import com.modye.bigdatabenchmark.repository.model.ModelTrip;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * Created by modye on 29/10/2015.
 * Batch used to read files and insert them in a database
 */
@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
@Import(CouchbaseConfiguration.class)
public class ImportBatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CouchbaseRepository couchbaseRepository;

    /**
     * Import data job
     *
     * @param jobs
     * @param s1
     * @param listener
     * @return
     */
    @Bean
    public Job importDataJob(JobBuilderFactory jobs, Step s1, JobCompletionNotificationListener listener) {
        return jobs.get("importDataJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step firstStep(StepBuilderFactory stepBuilderFactory, ItemReader<Trip> reader,
                          ItemWriter<ModelTrip> writer, ItemProcessor<Trip, ModelTrip> processor) {
        return stepBuilderFactory.get("firstStep")
                .<Trip, ModelTrip>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    /**
     * Reader : read file line by line and parse them to model Object
     *
     * @return
     */
    @Bean
    public ItemReader<Trip> reader() {
        FlatFileItemReader<Trip> reader = new FlatFileItemReader<Trip>();
        reader.setResource(new ClassPathResource("sample.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Trip>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"medallion", "hack_license", "vendor_id", "rate_code", "store_and_fwd_flag", "pickup_datetime", "dropoff_datetime", "passenger_count", "trip_time_in_secs", "trip_distance", "pickup_longitude", "pickup_latitude", "dropoff_longitude", "dropoff_latitude"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Trip>() {{
                setTargetType(Trip.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemProcessor<Trip, ModelTrip> processor() {
        return new TripItemProcessor();
    }

    @Bean
    public ItemWriter<ModelTrip> writer(DataSource dataSource) {
        return new TripItemWriter(couchbaseRepository);
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionNotificationListener();
    }
}
