package cn.clownmask.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.clownmask.modules.sys.entity.SysLogEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
