package iris.platform.common.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import iris.platform.common.dao.SysLogDao;
import iris.platform.common.entity.SysLogEntity;
import iris.platform.common.service.SysLogService;
import iris.platform.common.utils.PageUtilsPlus;
import iris.platform.common.utils.QueryPlus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 李鹏军
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "create_date");
        params.put("asc", false);
        Page<SysLogEntity> page = new QueryPlus<SysLogEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.selectSysLogPage(page, params)));
    }
}
