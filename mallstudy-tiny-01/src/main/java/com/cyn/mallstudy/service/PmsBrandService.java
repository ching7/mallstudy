package com.cyn.mallstudy.service;
import com.cyn.mallstudy.mbg.model.PmsBrand;

import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy
 * @Package: com.cyn.mallstudy.service.impl
 * @Date 2020/2/21 22:37
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
