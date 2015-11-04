package com.modye.bigdatabenchmark.repository.couchbase;

import com.modye.bigdatabenchmark.model.Trip;
import com.modye.bigdatabenchmark.repository.model.ModelTrip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by modye on 30/10/2015.
 */
public interface CouchbaseRepository extends CrudRepository<ModelTrip, String> {

    /**
     * Additional custom finder method.
     */
    List<Trip> findByLastname();

}
