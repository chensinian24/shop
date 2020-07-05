package iris.platform.platformshop.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 商品属性详情表
 * </p>
 *
 * @author sinian.csn
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EbStoreProductAttrResult extends Model<EbStoreProductAttrResult> {

    private static final long serialVersionUID=1L;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 商品属性参数
     */
    private String result;

    /**
     * 上次修改时间
     */
    private Integer changeTime;


    @Override
    protected Serializable pkVal() {
        return this.productId;
    }

}
