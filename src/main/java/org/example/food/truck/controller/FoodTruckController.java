package org.example.food.truck.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.example.food.truck.service.FoodTruckService;
import org.example.food.truck.vo.FoodFacilityPermitConditionVO;
import org.example.food.truck.vo.FoodFacilityPermitVO;
import org.example.food.truck.vo.ResponseContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FoodTruckController
 *
 * @author chensheng
 **/
@Api(tags = "food truck controller")
@RestController
@RequestMapping("/foodTruck")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FoodTruckController {
    private final FoodTruckService foodTruckService;

    @ApiOperation("queryFoodTrucks")
    @PostMapping("/queryFoodTrucks")
    public ResponseContainer<PageInfo<FoodFacilityPermitVO>> queryFoodTrucks(
            @RequestBody FoodFacilityPermitConditionVO condition) {
        return ResponseContainer.success(foodTruckService.queryFoodTrucks(condition));
    }
}
