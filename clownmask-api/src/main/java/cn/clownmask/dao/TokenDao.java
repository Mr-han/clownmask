package cn.clownmask.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.clownmask.entity.TokenEntity;

/**
 * 用户Token
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface TokenDao extends BaseMapper<TokenEntity> {
	
}
