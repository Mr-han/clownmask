package cn.clownmask.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.clownmask.modules.sys.entity.SysDictEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
	
}
