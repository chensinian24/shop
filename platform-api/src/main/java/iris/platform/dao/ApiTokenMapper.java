package iris.platform.dao;

import iris.platform.entity.TokenEntity;
import org.apache.ibatis.annotations.Param;
import iris.platform.common.dao.BaseDao;

/**
 * 用户Token
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 * @date 2017-03-23 15:22:07
 */
public interface ApiTokenMapper extends BaseDao<TokenEntity> {

    TokenEntity queryByUserId(@Param("userId") Long userId);

    TokenEntity queryByToken(@Param("token") String token);

}