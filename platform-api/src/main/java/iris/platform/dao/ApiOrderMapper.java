package iris.platform.dao;

import iris.platform.entity.OrderVo;
import org.apache.ibatis.annotations.Param;
import iris.platform.common.dao.BaseDao;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 * @date 2017-08-11 09:16:46
 */
public interface ApiOrderMapper extends BaseDao<OrderVo> {

    /**
     * 根据订单编号查询订单
     *
     * @param order_sn
     * @return
     */
    OrderVo queryObjectByOrderSn(@Param("orderSn") String order_sn);
}
