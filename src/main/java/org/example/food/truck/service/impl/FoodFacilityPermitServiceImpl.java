package org.example.food.truck.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.example.food.truck.entity.FoodFacilityPermitDO;
import org.example.food.truck.mapper.FoodFacilityPermitMapper;
import org.example.food.truck.service.FoodFacilityPermitService;
import org.example.food.truck.vo.FoodFacilityPermitConditionVO;
import org.example.food.truck.vo.FoodFacilityPermitVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * FoodFacilityPermitServiceImpl
 *
 * @author chensheng
 **/
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FoodFacilityPermitServiceImpl implements FoodFacilityPermitService {
    private final FoodFacilityPermitMapper foodFacilityPermitMapper;

    @Override
    public PageInfo<FoodFacilityPermitVO> queryPageList(FoodFacilityPermitConditionVO condition) {
        LambdaQueryWrapper<FoodFacilityPermitDO> queryWrapper = new LambdaQueryWrapper<>();
        // 申请人
        if (!StringUtils.isBlank(condition.getApplicant())) {
            queryWrapper.like(FoodFacilityPermitDO::getApplicant, condition.getApplicant());
        }
        // 快餐车类型
        if (!StringUtils.isBlank(condition.getFacilityType())) {
            queryWrapper.eq(FoodFacilityPermitDO::getFacilityType, condition.getFacilityType());
        }
        // 所在位置
        if (!StringUtils.isBlank(condition.getLocationDescription())) {
            queryWrapper.like(FoodFacilityPermitDO::getLocationDescription, condition.getLocationDescription());
        }
        // 地址
        if (!StringUtils.isBlank(condition.getAddress())) {
            queryWrapper.like(FoodFacilityPermitDO::getAddress, condition.getAddress());
        }
        // 街区号
        if (!StringUtils.isBlank(condition.getBlockLot())) {
            queryWrapper.like(FoodFacilityPermitDO::getBlockLot, condition.getBlockLot());
        }
        // 许可证名称
        if (!StringUtils.isBlank(condition.getPermit())) {
            queryWrapper.like(FoodFacilityPermitDO::getPermit, condition.getPermit());
        }
        // 许可证状态
        if (!StringUtils.isBlank(condition.getStatus())) {
            queryWrapper.eq(FoodFacilityPermitDO::getStatus, condition.getStatus());
        }
        // 销售食物信息
        if (!StringUtils.isBlank(condition.getFoodItems())) {
            queryWrapper.eq(FoodFacilityPermitDO::getFoodItems, condition.getFoodItems());
        }

        // 根据条件，查询快餐车信息
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<FoodFacilityPermitDO> doList = foodFacilityPermitMapper.selectList(queryWrapper);
        PageInfo<FoodFacilityPermitDO> doPageInfo = new PageInfo<>(doList);

        // 构建返回信息
        PageInfo<FoodFacilityPermitVO> voPageInfo = new PageInfo<>();
        List<FoodFacilityPermitVO> voList = new ArrayList<>();
        BeanUtils.copyProperties(doPageInfo, voPageInfo);
        // 复制返回结果信息
        doList.forEach(eachFoodFacilityPermit -> {
            FoodFacilityPermitVO newFoodFacilityPermitVO = new FoodFacilityPermitVO();
            BeanUtils.copyProperties(eachFoodFacilityPermit, newFoodFacilityPermitVO);
            voList.add(newFoodFacilityPermitVO);
        });
        voPageInfo.setList(voList);

        return voPageInfo;
    }
}
