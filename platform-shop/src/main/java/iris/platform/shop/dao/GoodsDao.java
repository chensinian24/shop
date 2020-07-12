package iris.platform.shop.dao;

import iris.platform.shop.entity.GoodsEntity;
import iris.platform.common.dao.BaseDao;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-21 21:19:49
 */
public interface GoodsDao extends BaseDao<GoodsEntity> {
    Integer queryMaxId();
}
