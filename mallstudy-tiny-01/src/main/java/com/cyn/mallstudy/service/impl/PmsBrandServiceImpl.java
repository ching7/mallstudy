package com.cyn.mallstudy.service.impl;
import com.github.pagehelper.PageHelper;
import com.cyn.mallstudy.mbg.mapper.PmsBrandMapper;
import com.cyn.mallstudy.mbg.model.PmsBrand;
import com.cyn.mallstudy.mbg.model.PmsBrandExample;
import com.cyn.mallstudy.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 文件描述
 *
 * @ProjectName: mallstudy
 * @Package: com.cyn.mallstudy.service.impl
 * @Date 2020/2/21 22:38
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
