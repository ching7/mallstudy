package com.cyn.mallstudy.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.dto
 * @Date 2020/3/11 19:44
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: Minio文件上传返回结果
 **/
@Getter
@Setter
public class MinioUploadDto {
    private String url;
    private String name;
}
