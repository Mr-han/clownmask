package cn.clownmask.modules.sys.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.clownmask.common.utils.RedisKeys;
import cn.clownmask.common.utils.RedisUtils;
import cn.clownmask.modules.sys.entity.SysConfigEntity;

/**
 * 系统配置Redis
 *
 * @author Mark hanchaoqun@hotmail.com
 */
@Component
public class SysConfigRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfigEntity config) {
        if(config == null){
            return ;
        }
        String key = RedisKeys.getSysConfigKey(config.getParamKey());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysConfigEntity get(String configKey){
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SysConfigEntity.class);
    }
}
