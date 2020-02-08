package cn.clownmask.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.clownmask.common.utils.PageUtils;
import cn.clownmask.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Mark hanchaoqun@hotmail.com
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
