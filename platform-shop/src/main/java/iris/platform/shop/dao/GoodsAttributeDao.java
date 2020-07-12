package iris.platform.shop.dao;

import iris.platform.shop.entity.GoodsAttributeEntity;
import iris.platform.common.dao.BaseDao;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-13 10:41:08
 */
public interface GoodsAttributeDao extends BaseDao<GoodsAttributeEntity> {

    int updateByGoodsIdAttributeId(GoodsAttributeEntity goodsAttributeEntity);
}
