package iris.platform.platformshop.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.diboot.core.binding.annotation.BindEntityList;
import iris.platform.platformshop.entity.EbStoreCategory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
public class EbStoreCategoryVo {

    /**
     * 商品分类表ID
     */
    private Integer id;

    private Integer pid;

    /**
     * 分类名称
     */
    private String cateName;


    /**
     * 图标
     */
    private String pic;

    private Set<EbStoreCategoryVo> childrens;






}
