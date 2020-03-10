package com.cyn.mallstudy.nosql.mongodb.repository;

import com.cyn.mallstudy.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.nosql.mongodb.repository
 * @Date 2020/3/10 19:40
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 会员商品浏览历史Repository
 **/
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     *
     * @param memberId
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}