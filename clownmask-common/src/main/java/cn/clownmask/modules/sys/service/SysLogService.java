package cn.clownmask.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;

import cn.clownmask.common.utils.PageUtils;
import cn.clownmask.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 *
 * @author Mark hanchaoqun@hotmail.com
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
