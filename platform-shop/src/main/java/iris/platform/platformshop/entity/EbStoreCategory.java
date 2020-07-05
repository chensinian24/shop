package iris.platform.platformshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.core.binding.annotation.BindField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.xml.ws.BindingType;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 商品分类表
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EbStoreCategory extends Model<EbStoreCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品分类表ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标
     */
    private String pic;

    /**
     * 是否推荐
     */
    private Boolean isShow;

    /**
     * 添加时间
     */
    private Integer addTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
