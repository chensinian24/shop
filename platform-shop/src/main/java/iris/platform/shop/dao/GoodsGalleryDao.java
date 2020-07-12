package iris.platform.shop.dao;

import iris.platform.shop.entity.GoodsGalleryEntity;

import java.util.Map;
import iris.platform.common.dao.BaseDao;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-23 14:41:43
 */
public interface GoodsGalleryDao extends BaseDao<GoodsGalleryEntity> {
    int deleteByGoodsId(Map<String, Integer> map);
}
