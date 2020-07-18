package iris.platform.dao;

import iris.platform.entity.SearchHistoryVo;
import org.apache.ibatis.annotations.Param;
import iris.platform.common.dao.BaseDao;

/**
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 * @date 2017-08-11 09:16:46
 */
public interface ApiSearchHistoryMapper extends BaseDao<SearchHistoryVo> {
    int deleteByUserId(@Param("user_id") Long userId);
}
