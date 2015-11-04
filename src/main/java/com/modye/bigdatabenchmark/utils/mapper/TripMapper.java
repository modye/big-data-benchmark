package com.modye.bigdatabenchmark.utils.mapper;

import com.modye.bigdatabenchmark.model.Trip;
import com.modye.bigdatabenchmark.repository.model.ModelTrip;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * Created by Nicolas on 04/11/2015.
 */
public class TripMapper {

    /**
     * Map to model entity {@link ModelTrip} a trip {@link Trip} object
     * @param trip
     * @return
     */
    public static ModelTrip mapToModel(final Trip trip){
        final ModelTrip modelTrip = new ModelTrip();
        modelTrip.setVendorId(trip.getVendorId());
        modelTrip.setMedallion(trip.getMedallion());
        modelTrip.setHackLicense(trip.getHackLicense());
        modelTrip.setDropoffDatetime(toInstant(trip.getDropoffDatetime()));
        modelTrip.setDropoffLatitude(Double.parseDouble(trip.getDropoffLatitude()));
        modelTrip.setDropoffLongitude(Double.parseDouble(trip.getDropoffLongitude()));
        modelTrip.setPassengerCount(trip.getPassengerCount());
        modelTrip.setPickupDatetime(toInstant(trip.getPickupDatetime()));
        modelTrip.setPickupLatitude(Double.parseDouble(trip.getPickupLatitude()));
        modelTrip.setPickupLongitude(Double.parseDouble(trip.getPickupLongitude()));
        modelTrip.setRateCode(trip.getRateCode());
        modelTrip.setTripDistance(Double.parseDouble(trip.getTripDistance()));
        modelTrip.setTripTimeInSecs(trip.getTripTimeInSecs());
        modelTrip.setStoreAndFwdFlag(trip.getStoreAndFwdFlag());
        return modelTrip;
    }

    /**
     * Parse a String into an Instant
     * @param base
     * @return
     */
    public static Instant toInstant(final String base) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(base, formatter).toInstant(ZoneOffset.UTC);
    }
}
