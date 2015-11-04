package com.modye.bigdatabenchmark.batch.writer;

import com.modye.bigdatabenchmark.model.Trip;
import com.modye.bigdatabenchmark.repository.couchbase.CouchbaseRepository;
import com.modye.bigdatabenchmark.repository.model.ModelTrip;
import com.modye.bigdatabenchmark.utils.mapper.TripMapper;
import org.springframework.batch.item.ItemWriter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by modye on 29/10/2015.
 */
public class TripItemWriter implements ItemWriter<ModelTrip> {

    private CouchbaseRepository couchbaseRepository;

    public TripItemWriter(final CouchbaseRepository couchbaseRepository) {
        this.couchbaseRepository = couchbaseRepository;
    }

    @Override
    public void write(List<? extends ModelTrip> items) throws Exception {
        couchbaseRepository.save(items);
    }
}
