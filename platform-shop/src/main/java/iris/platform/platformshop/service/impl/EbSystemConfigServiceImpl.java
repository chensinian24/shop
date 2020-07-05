package iris.platform.platformshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import iris.platform.platformshop.entity.EbSystemConfig;
import iris.platform.platformshop.mapper.EbSystemConfigMapper;
import iris.platform.platformshop.service.EbSystemConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 配置表 服务实现类
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-13
 */
@Service
public class EbSystemConfigServiceImpl extends ServiceImpl<EbSystemConfigMapper, EbSystemConfig> implements EbSystemConfigService {

@Resource
EbSystemConfigMapper ebSystemConfigMapper;

    @Override
    public String selectValueBymenuName(String menuName) {
        return ebSystemConfigMapper.selectValueBymenuName(menuName);
    }
}
