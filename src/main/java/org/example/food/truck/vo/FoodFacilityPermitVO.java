package org.example.food.truck.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * FoodFacilityPermitVO
 *
 * @author chensheng
 **/
@Data
public class FoodFacilityPermitVO {
    @ApiModelProperty(value = "primary key")
    private Integer locationId;

    @ApiModelProperty("applicant")
    private String applicant;

    @ApiModelProperty("facility type")
    private String facilityType;

    @ApiModelProperty("cnn")
    private Integer cnn;

    @ApiModelProperty("location description")
    private String locationDescription;

    @ApiModelProperty("address")
    private String address;

    @ApiModelProperty("block lot")
    private String blockLot;
    @ApiModelProperty("block")
    private String block;

    @ApiModelProperty("lot")
    private String lot;

    @ApiModelProperty("permit")
    private String permit;

    @ApiModelProperty("status")
    private String status;

    @ApiModelProperty("food items")
    private String foodItems;

    @ApiModelProperty("x")
    private String x;

    @ApiModelProperty("y")
    private String y;

    @ApiModelProperty("latitude")
    private String latitude;

    @ApiModelProperty("longitude")
    private String longitude;

    @ApiModelProperty("schedule")
    private String schedule;

    @ApiModelProperty("daysHours")
    private String daysHours;

    @ApiModelProperty("noiSent")
    private String noiSent;

    @ApiModelProperty("approved")
    private LocalDate approved;

    @ApiModelProperty("received")
    private String received;

    @ApiModelProperty("prior permit")
    private Boolean priorPermit;

    @ApiModelProperty("expiration date")
    private LocalDate expirationDate;

    @ApiModelProperty("location")
    private String location;

    @ApiModelProperty("firePrevention districts")
    private Integer firePreventionDistricts;

    @ApiModelProperty("police districts")
    private Integer policeDistricts;

    @ApiModelProperty("supervisor districts")
    private Integer supervisorDistricts;

    @ApiModelProperty("zipCodes")
    private Integer zipCodes;

    @ApiModelProperty("neighborhoods")
    private Integer neighborhoods;
}
