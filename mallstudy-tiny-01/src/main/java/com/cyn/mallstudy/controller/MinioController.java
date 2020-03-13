package com.cyn.mallstudy.controller;

import cn.hutool.crypto.digest.MD5;
import com.cyn.mallstudy.common.api.CommonResult;
import com.cyn.mallstudy.dto.MinioUploadDto;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.controller
 * @Date 2020/3/11 19:42
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: MinIO对象存储管理
 **/
@Api(tags = "MinioController", description = "MinIO对象存储管理")
@Controller
@RequestMapping("/minio")
public class MinioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinioController.class);
    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;

    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        try {
            //创建一个MinIO的Java客户端
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            boolean isExist = minioClient.bucketExists(BUCKET_NAME);
            if (isExist) {
                LOGGER.info("存储桶已经存在！");
            } else {
                //创建存储桶并设置只读权限
                minioClient.makeBucket(BUCKET_NAME);
                minioClient.setBucketPolicy(BUCKET_NAME, "*.*", PolicyType.READ_ONLY);
            }
            InputStream in =file.getInputStream();
            String filename = file.getOriginalFilename();
            MD5 md5 = new MD5();
            String md5Str =  md5.digestHex(in);
            String fileExt = filename.substring(filename.lastIndexOf("."));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // 设置存储对象名称
            String objectName = sdf.format(new Date()) + "/" + UUID.randomUUID() +"."+fileExt;
            // 使用putObject上传一个文件到存储桶中
            minioClient.putObject(BUCKET_NAME, objectName, file.getInputStream(), file.getContentType());
            LOGGER.info("文件上传成功!");
            MinioUploadDto minioUploadDto = new MinioUploadDto();
            minioUploadDto.setName(objectName);
            minioUploadDto.setUrl(ENDPOINT + "/" + BUCKET_NAME + "/" + objectName);
            LOGGER.info("文件object-id: "+objectName);
            return CommonResult.success(minioUploadDto);
        } catch (Exception e) {
            LOGGER.info("上传发生错误: {}！", e.getMessage());
        }
        return CommonResult.failed();
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        try {
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            minioClient.removeObject(BUCKET_NAME, objectName);
            return CommonResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }

    @ApiOperation("文件下载")
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult download(@RequestParam("filename") String filename) {
        try {
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            InputStream stream = minioClient.getObject(BUCKET_NAME, filename);

            // 读取输入流直到EOF并打印到控制台。
            byte[] buf = new byte[16384];
            int bytesRead;
            while ((bytesRead = stream.read(buf, 0, buf.length)) >= 0) {
                System.out.println(new String(buf, 0, bytesRead));
            }
            // 关闭流，此处为示例，流关闭最好放在finally块。
            stream.close();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
        return CommonResult.failed();
    }
}
