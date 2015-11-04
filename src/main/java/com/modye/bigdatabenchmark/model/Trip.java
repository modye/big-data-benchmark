package com.modye.bigdatabenchmark.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by modye on 29/10/2015.
 */
@JsonPropertyOrder(value={"medallion", "hack_license", "vendor_id", "rate_code", "store_and_fwd_flag", "pickup_datetime", "dropoff_datetime", "passenger_count", "trip_time_in_secs", "trip_distance", "pickup_longitude", "pickup_latitude", "dropoff_longitude", "dropoff_latitude"})
public class Trip {

    @JsonProperty("medaillon")
    private String medallion;

    @JsonProperty("hack_license")
    private String hackLicense;

    @JsonProperty("vendor_id")
    private String vendorId;

    @JsonProperty("rate_code")
    private String rateCode;

    @JsonProperty("store_and_fwd_flag")
    private String storeAndFwdFlag;

    @JsonProperty("pickup_datetime")
    private String pickupDatetime;

    @JsonProperty("dropoff_datetime")
    private String dropoffDatetime;

    @JsonProperty("passenger_count")
    private String passengerCount;

    @JsonProperty("trip_time_in_secs")
    private String tripTimeInSecs;

    @JsonProperty("trip_distance")
    private String tripDistance;

    @JsonProperty("pickup_longitude")
    private String pickupLongitude;

    @JsonProperty("pickup_latitude")
    private String pickupLatitude;

    @JsonProperty("dropoff_longitude")
    private String dropoffLongitude;

    @JsonProperty("dropoff_latitude")
    private String dropoffLatitude;

    public Trip() {
    }

    public String getMedallion() {
        return medallion;
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

    public String getPickupDatetime() {
        return pickupDatetime;
    }

    public void setPickupDatetime(String pickupDatetime) {
        this.pickupDatetime = pickupDatetime;
    }

    public String getDropoffDatetime() {
        return dropoffDatetime;
    }

    public void setDropoffDatetime(String dropoffDatetime) {
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

    public String getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(String tripDistance) {
        this.tripDistance = tripDistance;
    }

    public String getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(String pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public String getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(String pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public String getDropoffLongitude() {
        return dropoffLongitude;
    }

    public void setDropoffLongitude(String dropoffLongitude) {
        this.dropoffLongitude = dropoffLongitude;
    }

    public String getDropoffLatitude() {
        return dropoffLatitude;
    }

    public void setDropoffLatitude(String dropoffLatitude) {
        this.dropoffLatitude = dropoffLatitude;
    }
}
