package org.example.food.truck.service;

import com.github.pagehelper.PageInfo;
import org.example.food.truck.vo.FoodFacilityPermitConditionVO;
import org.example.food.truck.vo.FoodFacilityPermitVO;

/**
 * FoodTruckService
 *
 * @author chensheng
 **/
public interface FoodTruckService {
    /**
     * Querying food truck information by specified conditions.
     *
     * @param condition conditions
     * @return food truck information
     */
    PageInfo<FoodFacilityPermitVO> queryFoodTrucks(FoodFacilityPermitConditionVO condition);

    /**
     * Retrieve detailed information for a food truck by location id.
     *
     * @param locationId location id
     * @return food truck infomation
     */
    FoodFacilityPermitVO detail(Integer locationId);
}
