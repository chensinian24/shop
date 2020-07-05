package iris.platform.platformshop.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import iris.platform.platformshop.entity.EbStoreProduct;
import iris.platform.platformshop.vo.BenifitProductVo;
import iris.platform.platformshop.vo.BestProductVo;
import iris.platform.platformshop.vo.HotProductVo;
import iris.platform.platformshop.vo.NewProductVo;
import iris.platform.platformshop.vo.StoreProductVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-11
 */
public interface EbStoreProductMapper extends BaseMapper<EbStoreProduct> {

    @Select("select id,image,store_name as storeName,cate_id as cateId,price,ot_price as otPrice,IFNULL(sales,0) + IFNULL(ficti,0) as sales,unit_name as unitName from eb_store_product ${ew.customSqlSegment}")
    List<BestProductVo> getBestProduct(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select("select id,image,store_name as storeName,cate_id as cateId,price,IFNULL(sales,0) + IFNULL(ficti,0) as sales,unit_name as unitName from eb_store_product ${ew.customSqlSegment}")
    List<NewProductVo> getNewProduct(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select("select id,image,store_name as storeName,cate_id as cateId,price,ot_price as otPrice,stock,unit_name as unitName from eb_store_product ${ew.customSqlSegment}")
    List<BenifitProductVo> getBenifitProduct(@Param(Constants.WRAPPER) Wrapper wrapper);
    @Select("select id,image,store_name as storeName,cate_id as cateId,price,unit_name as unitName from eb_store_product ${ew.customSqlSegment}")
    List<HotProductVo> getHotProducts(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select("SELECT id,store_name,cate_id,image,IFNULL(sales,0) + IFNULL(ficti,0) as sales,price,stock FROM eb_store_product ${ew.customSqlSegment}")
    List<StoreProductVo> getProductsList(Page<?> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    @Select("SELECT ${ew.sqlSelect} FROM eb_store_product ${ew.customSqlSegment}")
    List<StoreProductVo> customSqlSelect(Page<?> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
