package iris.platform.dao;

import iris.platform.entity.KeywordsVo;

import java.util.List;
import java.util.Map;
import iris.platform.common.dao.BaseDao;

/**
 * 热闹关键词表
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 * @date 2017-08-11 09:16:46
 */
public interface ApiKeywordsMapper extends BaseDao<KeywordsVo> {
    List<Map> hotKeywordList(Map param);
}
