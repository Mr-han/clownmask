package cn.clownmask.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.clownmask.common.annotation.DataFilter;
import cn.clownmask.common.utils.PageUtils;
import cn.clownmask.common.utils.Query;
import cn.clownmask.modules.sys.dao.SysDictDao;
import cn.clownmask.modules.sys.entity.SysDictEntity;
import cn.clownmask.modules.sys.service.SysDictService;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {

    @Override
    @DataFilter(subDept = true, user = false, tableAlias = "t1")
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");

        IPage<SysDictEntity> page = this.page(
            new Query<SysDictEntity>().getPage(params),
            new QueryWrapper<SysDictEntity>()
                .like(StringUtils.isNotBlank(name),"name", name)
        );

        return new PageUtils(page);
    }

}
