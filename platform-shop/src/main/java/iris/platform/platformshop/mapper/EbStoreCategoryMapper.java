package iris.platform.platformshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import iris.platform.platformshop.entity.EbStoreCategory;
import iris.platform.platformshop.vo.EbStoreCategoryVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-11
 */
public interface EbStoreCategoryMapper extends BaseMapper<EbStoreCategory> {

    @Select("SELECT id,pid,cate_name,pic from eb_store_category where pid=0 and is_show = 1")
    @Results(id="cates",
            value = {
                    @Result(property = "id",column = "id",id = true),
                    @Result(property = "cateName",column = "cate_name"),
                    @Result(property = "pic",column = "pic"),
                    @Result(property = "childrens",column = "id",many = @Many(select = "getChildrensByParentId"))
            }
    )
    List<EbStoreCategoryVo> getCategoryWithChildren();


    @Select("select id,pid,cate_name ,pic from eb_store_category where pid = #{pid} and is_show = 1")
    @ResultMap("cates")
    List<EbStoreCategoryVo> getChildrensByParentId(int pid);



}
