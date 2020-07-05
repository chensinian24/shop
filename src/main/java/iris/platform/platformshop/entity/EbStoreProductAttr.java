package iris.platform.platformshop.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品属性表
 * </p>
 *
 * @author sinian.csn
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EbStoreProductAttr extends Model<EbStoreProductAttr> {

    private static final long serialVersionUID=1L;

    /**
     * 商品ID
     */
    private Integer productId;

    /**
     * 属性名
     */
    private String attrName;

    /**
     * 属性值
     */
    private String attrValues;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
