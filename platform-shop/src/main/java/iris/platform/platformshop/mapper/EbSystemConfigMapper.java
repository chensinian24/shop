package iris.platform.platformshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import iris.platform.platformshop.entity.EbSystemConfig;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 配置表 Mapper 接口
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-13
 */
public interface EbSystemConfigMapper extends BaseMapper<EbSystemConfig> {


    @Select("select value from eb_system_config  where  menu_name= #{menuName}")
    String selectValueBymenuName(@Param("menuName") String menuName);
}
