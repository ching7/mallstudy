package com.cyn.mallstudy.service;

import com.cyn.mallstudy.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.service
 * @Date 2020/3/10 19:41
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 会员浏览记录管理Service
 **/
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> list(Long memberId);
}
