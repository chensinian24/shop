package iris.platform.platformshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 产品分类辅助表
 * </p>
 *
 * @author sinian.csn
 * @since 2020-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EbStoreProductCate extends Model<EbStoreProductCate> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 分类id
     */
    private Integer cateId;

    /**
     * 添加时间
     */
    private Integer addTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
