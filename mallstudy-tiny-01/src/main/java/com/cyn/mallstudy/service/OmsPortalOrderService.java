package com.cyn.mallstudy.service;

import com.cyn.mallstudy.common.api.CommonResult;
import com.cyn.mallstudy.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.service
 * @Date 2020/3/11 17:00
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 前台订单管理Service
 **/
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     *
     * @param orderParam
     * @return
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     *
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);
}