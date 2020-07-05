package iris.platform.platformshop.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品属性值表
 * </p>
 *
 * @author sinian.csn
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EbStoreProductAttrValue extends Model<EbStoreProductAttrValue> {

    private static final long serialVersionUID=1L;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 商品属性索引值 (attr_value|attr_value[|....])
     */
    private String suk;

    /**
     * 属性对应的库存
     */
    private Integer stock;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 属性金额
     */
    private BigDecimal price;

    /**
     * 图片
     */
    private String image;

    /**
     * 唯一值
     */
    private String unique;

    /**
     * 成本价
     */
    private BigDecimal cost;

    /**
     * 产品条码
     */
    private String barCode;


    @Override
    protected Serializable pkVal() {
        return this.suk;
    }

}
