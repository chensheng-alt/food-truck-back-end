package org.example.food.truck.vo;

import com.github.pagehelper.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * FoodFacilityPermitConditionVO
 *
 * @author chensheng
 **/
@Data
@ApiModel("FoodFacilityPermitConditionVO")
public class FoodFacilityPermitConditionVO implements IPage {
    private Integer pageNum;
    private Integer pageSize;
    private String orderBy;

    @ApiModelProperty(value = "applicant")
    private String applicant;

    @ApiModelProperty(value = "facility type")
    private String facilityType;

    @ApiModelProperty(value = "location description")
    private String locationDescription;

    @ApiModelProperty(value = "address")
    private String address;

    @ApiModelProperty(value = "街区号")
    private String blockLot;

    @ApiModelProperty(value = "permit")
    private String permit;

    @ApiModelProperty(value = "permit status")
    private String status;

    @ApiModelProperty(value = "food items")
    private String foodItems;

    @ApiModelProperty(value = "approved date")
    private LocalDate approved;

    @ApiModelProperty(value = "received date")
    private LocalDate received;

    @ApiModelProperty(value = "prior permit")
    private Boolean priorPermit;

    @ApiModelProperty(value = "expiration date")
    private LocalDate expirationDate;
}
