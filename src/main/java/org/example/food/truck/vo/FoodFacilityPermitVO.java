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
    @ApiModelProperty(value = "主键")
    private Integer locationId;

    @ApiModelProperty("applicant")
    private String applicant;

    @ApiModelProperty("facilityType")
    private String facilityType;

    @ApiModelProperty("cnn")
    private Integer cnn;

    @ApiModelProperty("locationDescription")
    private String locationDescription;

    @ApiModelProperty("address")
    private String address;

    @ApiModelProperty("blockLot")
    private String blockLot;
    @ApiModelProperty("block")
    private String block;

    @ApiModelProperty("lot")
    private String lot;

    @ApiModelProperty("permit")
    private String permit;

    @ApiModelProperty("status")
    private String status;

    @ApiModelProperty("foodItems")
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

    @ApiModelProperty("priorPermit")
    private Boolean priorPermit;

    @ApiModelProperty("expirationDate")
    private LocalDate expirationDate;

    @ApiModelProperty("location")
    private String location;

    @ApiModelProperty("firePreventionDistricts")
    private Integer firePreventionDistricts;

    @ApiModelProperty("policeDistricts")
    private Integer policeDistricts;

    @ApiModelProperty("supervisorDistricts")
    private Integer supervisorDistricts;

    @ApiModelProperty("zipCodes")
    private Integer zipCodes;

    @ApiModelProperty("neighborhoods")
    private Integer neighborhoods;
}
