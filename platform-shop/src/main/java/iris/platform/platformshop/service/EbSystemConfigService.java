package iris.platform.platformshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import iris.platform.platformshop.entity.EbSystemConfig;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 配置表 服务类
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-13
 */
public interface EbSystemConfigService extends IService<EbSystemConfig> {

    String selectValueBymenuName(@Param("menuName") String menuName);
}
