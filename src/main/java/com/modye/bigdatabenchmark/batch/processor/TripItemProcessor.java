package com.modye.bigdatabenchmark.batch.processor;

import com.modye.bigdatabenchmark.model.Trip;
import com.modye.bigdatabenchmark.repository.model.ModelTrip;
import com.modye.bigdatabenchmark.utils.mapper.TripMapper;
import org.springframework.batch.item.ItemProcessor;

import java.util.UUID;

/**
 * Created by modye on 29/10/2015.
 */
public class TripItemProcessor implements ItemProcessor<Trip, ModelTrip> {

    @Override
    public ModelTrip process(final Trip trip) throws Exception {
        final ModelTrip modelTrip = TripMapper.mapToModel(trip);
        modelTrip.setId(UUID.randomUUID());
        return modelTrip;
    }
}
