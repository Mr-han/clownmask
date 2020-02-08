package cn.clownmask.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.clownmask.common.utils.PageUtils;
import cn.clownmask.modules.sys.entity.SysDictEntity;

import java.util.Map;

/**
 * 数据字典
 *
 * @author Mark hanchaoqun@hotmail.com
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

