package com.cyn.mallstudy.dao;

import com.cyn.mallstudy.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.dao
 * @Date 2020/3/10 14:03
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 搜索系统中的商品管理自定义Dao
 **/
@Service
public interface EsProductDao {
    @Select({"<script>",
            "select * from mall_study.pms_product ",
            "WHERE 1=1",
            "<when test='id!=null'>",
            "AND id = #{id}",
            "</when>",
            "</script>"})
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
