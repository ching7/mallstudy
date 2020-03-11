package com.cyn.mallstudy.service;

import com.cyn.mallstudy.dto.OssCallbackResult;
import com.cyn.mallstudy.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.service
 * @Date 2020/3/11 17:56
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
