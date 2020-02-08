package cn.clownmask.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.clownmask.modules.job.entity.ScheduleJobLogEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}
