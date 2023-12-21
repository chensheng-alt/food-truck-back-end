package org.example.food.truck.service;

import com.github.pagehelper.PageInfo;
import org.example.food.truck.vo.FoodFacilityPermitConditionVO;
import org.example.food.truck.vo.FoodFacilityPermitVO;

/**
 * FoodFacilityPermitService
 *
 * @author chensheng
 **/
public interface FoodFacilityPermitService {
    /**
     * 根据查询条件，分页查询快餐车的相关信息
     *
     * @param condition 查询条件
     * @return 快餐车的查询结果
     */
    PageInfo<FoodFacilityPermitVO> queryPageList(FoodFacilityPermitConditionVO condition);


}
