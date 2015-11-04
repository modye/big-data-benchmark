package com.modye.bigdatabenchmark.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by modye on 04/11/2015.
 */
@Document
public class ModelTrip {

    @Id
    private UUID id;
    @Field("medaillon")
    private String medallion;
    @Field("hack_license")
    private String hackLicense;
    @Field("vendor_id")
    private String vendorId;
    @Field("rate_code")
    private String rateCode;
    @Field("store_and_fwd_flag")
    private String storeAndFwdFlag;
    @Field("pickup_datetime")
    private Instant pickupDatetime;
    @Field("dropoff_datetime")
    private Instant dropoffDatetime;
    @Field("passenger_count")
    private String passengerCount;
    @Field("trip_time_in_secs")
    private String tripTimeInSecs;
    @Field("trip_distance")
    private Double tripDistance;
    @Field("pickup_longitude")
    private Double pickupLongitude;
    @Field("pickup_latitude")
    private Double pickupLatitude;
    @Field("dropoff_longitude")
    private Double dropoffLongitude;
    @Field("dropoff_latitude")
    private Double dropoffLatitude;

    public String getMedallion() {
        return medallion;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setMedallion(String medallion) {
        this.medallion = medallion;
    }

    public String getHackLicense() {
        return hackLicense;
    }

    public void setHackLicense(String hackLicense) {
        this.hackLicense = hackLicense;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getStoreAndFwdFlag() {
        return storeAndFwdFlag;
    }

    public void setStoreAndFwdFlag(String storeAndFwdFlag) {
        this.storeAndFwdFlag = storeAndFwdFlag;
    }

    public Instant getPickupDatetime() {
        return pickupDatetime;
    }

    public void setPickupDatetime(Instant pickupDatetime) {
        this.pickupDatetime = pickupDatetime;
    }

    public Instant getDropoffDatetime() {
        return dropoffDatetime;
    }

    public void setDropoffDatetime(Instant dropoffDatetime) {
        this.dropoffDatetime = dropoffDatetime;
    }

    public String getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(String passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getTripTimeInSecs() {
        return tripTimeInSecs;
    }

    public void setTripTimeInSecs(String tripTimeInSecs) {
        this.tripTimeInSecs = tripTimeInSecs;
    }

    public Double getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(Double tripDistance) {
        this.tripDistance = tripDistance;
    }

    public Double getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(Double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public Double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(Double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public Double getDropoffLongitude() {
        return dropoffLongitude;
    }

    public void setDropoffLongitude(Double dropoffLongitude) {
        this.dropoffLongitude = dropoffLongitude;
    }

    public Double getDropoffLatitude() {
        return dropoffLatitude;
    }

    public void setDropoffLatitude(Double dropoffLatitude) {
        this.dropoffLatitude = dropoffLatitude;
    }
}
