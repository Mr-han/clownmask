package cn.clownmask.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.clownmask.modules.sys.entity.SysDeptEntity;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {

    List<SysDeptEntity> queryList(Map<String, Object> params);

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

}
