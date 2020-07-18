package iris.platform.dao;

import iris.platform.entity.FootprintVo;

import java.util.List;
import java.util.Map;
import iris.platform.common.dao.BaseDao;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 * @date 2017-08-11 09:14:26
 */
public interface ApiFootprintMapper extends BaseDao<FootprintVo> {
    int deleteByParam(Map<String, Object> map);

    List<FootprintVo> shareList(Map<String, Object> map);

	List<FootprintVo> queryListFootprint(String userid);
}
