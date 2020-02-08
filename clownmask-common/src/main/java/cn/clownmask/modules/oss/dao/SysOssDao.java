package cn.clownmask.modules.oss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.clownmask.modules.oss.entity.SysOssEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}
