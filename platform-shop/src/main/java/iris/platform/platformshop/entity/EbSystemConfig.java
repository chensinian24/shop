package iris.platform.platformshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 配置表
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EbSystemConfig extends Model<EbSystemConfig> {

    private static final long serialVersionUID=1L;

    /**
     * 配置id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字段名称
     */
    private String menuName;

    /**
     * 类型(文本框,单选按钮...)
     */
    private String type;

    /**
     * 表单类型
     */
    private String inputType;

    /**
     * 配置分类id
     */
    private Integer configTabId;

    /**
     * 规则 单选框和多选框
     */
    private String parameter;

    /**
     * 上传文件格式1单图2多图3文件
     */
    private Boolean uploadType;

    /**
     * 规则
     */
    private String required;

    /**
     * 多行文本框的宽度
     */
    private Integer width;

    /**
     * 多行文框的高度
     */
    private Integer high;

    /**
     * 默认值
     */
    private String value;

    /**
     * 配置名称
     */
    private String info;

    /**
     * 配置简介
     */
    private String desc;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否隐藏
     */
    private Boolean status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
