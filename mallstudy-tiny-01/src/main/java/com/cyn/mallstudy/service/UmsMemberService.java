package com.cyn.mallstudy.service;

import com.cyn.mallstudy.common.api.CommonResult;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.service
 * @Date 2020/2/23 20:52
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 会员管理Service
 **/
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
