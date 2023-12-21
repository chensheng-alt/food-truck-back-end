package org.example.food.truck.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * FoodFacilityPermit
 *
 * @author chensheng
 **/
@Data
@TableName("food_facility_permit")
public class FoodFacilityPermitDO {
    @TableId(
            value = "location_id",
            type = IdType.AUTO
    )
    private Integer locationId;

    @TableField("applicant")
    private String applicant;

    @TableField("facility_type")
    private String facilityType;

    @TableField("cnn")
    private Integer cnn;

    @TableField("location_description")
    private String locationDescription;

    @TableField("address")
    private String address;

    @TableField("block_lot")
    private String blockLot;
    @TableField("block")
    private String block;

    @TableField("lot")
    private String lot;

    @TableField("permit")
    private String permit;

    @TableField("status")
    private String status;

    @TableField("food_items")
    private String foodItems;

    @TableField("x")
    private String x;

    @TableField("y")
    private String y;

    @TableField("latitude")
    private String latitude;

    @TableField("longitude")
    private String longitude;

    @TableField("schedule")
    private String schedule;

    @TableField("days_hours")
    private String daysHours;

    @TableField("noi_sent")
    private String noiSent;

    @TableField("approved")
    private LocalDate approved;

    @TableField("received")
    private String received;

    @TableField("prior_permit")
    private Boolean priorPermit;

    @TableField("expiration_date")
    private LocalDate expirationDate;

    @TableField("location")
    private String location;

    @TableField("fire_prevention_districts")
    private Integer firePreventionDistricts;

    @TableField("police_districts")
    private Integer policeDistricts;

    @TableField("supervisor_districts")
    private Integer supervisorDistricts;

    @TableField("zip_codes")
    private Integer zipCodes;

    @TableField("neighborhoods")
    private Integer neighborhoods;
}
