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

    @ApiModelProperty(value = "申请人")
    private String applicant;

    @ApiModelProperty(value = "快餐车类型。Truck: 卡车; Push Cart: 手推车")
    private String facilityType;

    @ApiModelProperty(value = "所在位置")
    private String locationDescription;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "街区号")
    private String blockLot;

    @ApiModelProperty(value = "许可证名称")
    private String permit;

    @ApiModelProperty(value = "许可证状态。APPROVED: 已批准; REQUESTED: 请求中; SUSPEND: 暂停; EXPIRED: 已过期")
    private String status;

    @ApiModelProperty(value = "销售食物信息")
    private String foodItems;

    @ApiModelProperty(value = "批准日期")
    private LocalDate approved;

    @ApiModelProperty(value = "接收请求日期")
    private LocalDate received;

    @ApiModelProperty(value = "是否优先许可")
    private Boolean priorPermit;

    @ApiModelProperty(value = "许可证过期日期")
    private LocalDate expirationDate;
}
