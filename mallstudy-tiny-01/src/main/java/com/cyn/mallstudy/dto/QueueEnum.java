package com.cyn.mallstudy.dto;

import lombok.Getter;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.dto
 * @Date 2020/3/11 16:29
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 消息队列枚举配置
 * 用于延迟消息队列及处理取消订单消息队列的常量定义，包括交换机名称、队列名称、路由键名称。
 **/
@Getter
public enum QueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
