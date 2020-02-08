package cn.clownmask.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.clownmask.common.utils.PageUtils;
import cn.clownmask.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark hanchaoqun@hotmail.com
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
