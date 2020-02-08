package cn.clownmask.modules.sys.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.clownmask.common.exception.UploadFileNotFoundException;
import cn.clownmask.common.utils.ConfigConstant;
import cn.clownmask.common.utils.CoreConst;
import cn.clownmask.common.utils.MD5;
import cn.clownmask.common.vo.ResponseVo;
import cn.clownmask.common.vo.UploadResponse;
import cn.clownmask.modules.oss.cloud.CloudStorageConfig;
import cn.clownmask.modules.oss.cloud.QiNiuYunUtil;
import cn.clownmask.modules.sys.service.SysConfigService;
import lombok.extern.slf4j.Slf4j;

/**
 * 后台文件上传接口、云存储配置
 *
 */
@Slf4j
@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	private SysConfigService sysConfigService;

    @ResponseBody
    @PostMapping("/upload")
    public UploadResponse upload(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) {
            throw new UploadFileNotFoundException(UploadResponse.Error.FILENOTFOUND);
        }
        try {
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
            /*String dir = fmt.format(new Date());*/
            CloudStorageConfig cloudStorageConfig = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);
            String dir = cloudStorageConfig.getQiniuPrefix();
            String md5 = MD5.getMessageDigest(file.getBytes());
            String filePath = String.format("%1$s/%2$s%3$s", dir, md5, suffix);
            ResponseVo responseVo = QiNiuYunUtil.writeFile(cloudStorageConfig, filePath, file.getBytes());
            /*String fileName = String.format("%1$s%2$s", md5, suffix);*/
            String qiniuDomain = cloudStorageConfig.getQiniuDomain();
            String url = String.format("%1$s/%2$s", qiniuDomain, filePath);
            if (responseVo.getStatus().equals(CoreConst.SUCCESS_CODE)) {
              /*  File sysFile = new File();
                sysFile.setName(originalFilename);
                sysFile.setSize(file.getSize()+"");
                sysFile.setType(suffix);
                sysFile.setUrl(url);
                sysFile.setRelUrl(filePath);
                sysFile.setCreateTime(new Date());
                fileService.insertFile(sysFile);*/
                return new UploadResponse(url, originalFilename, suffix, url, CoreConst.SUCCESS_CODE);
            } else {
                return new UploadResponse(originalFilename, CoreConst.FAIL_CODE, responseVo.getMsg());
            }
        } catch (Exception e) {
            log.error(String.format("UploadController.upload%s", e));
            throw e;
        }
    }

    @ResponseBody
    @PostMapping("/upload2QiniuForMd")
    public Object upload2QiniuForMd(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new UploadFileNotFoundException(UploadResponse.Error.FILENOTFOUND);
        }
        try {
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            CloudStorageConfig cloudStorageConfig = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);
            String dir = cloudStorageConfig.getQiniuPrefix();
            String md5 = MD5.getMessageDigest(file.getBytes());
            String filePath = String.format("%1$s/%2$s%3$s", dir, md5, suffix);
            ResponseVo responseVo = QiNiuYunUtil.writeFile(cloudStorageConfig, filePath, file.getBytes());
            String qiniuDomain = cloudStorageConfig.getQiniuDomain();
            String url = String.format("%1$s/%2$s", qiniuDomain, filePath);
            if (responseVo.getStatus().equals(CoreConst.SUCCESS_CODE)) {
                Map<String, Object> resultMap = new HashMap<>(3);
                resultMap.put("success", 1);
                resultMap.put("message", "上传成功");
                resultMap.put("filename", url);
                return resultMap;
            } else {
                return new UploadResponse(originalFilename, CoreConst.FAIL_CODE, responseVo.getMsg());
            }
        } catch (Exception e) {
            log.error(String.format("UploadController.upload%s", e));
            throw e;
        }
    }

}
