package iris.platform.platformshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import iris.platform.platformshop.entity.EbStoreCategory;
import iris.platform.platformshop.entity.EbStoreProduct;
import iris.platform.platformshop.mapper.EbStoreCategoryMapper;
import iris.platform.platformshop.mapper.EbStoreProductMapper;
import iris.platform.platformshop.vo.BenifitProductVo;
import iris.platform.platformshop.vo.BestProductVo;
import iris.platform.platformshop.service.EbStoreProductService;
import iris.platform.platformshop.vo.HotProductVo;
import iris.platform.platformshop.vo.NewProductVo;
import iris.platform.platformshop.vo.EbStoreCategoryVo;
import iris.platform.platformshop.vo.StoreProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-11
 */
@Service
public class EbStoreProductServiceImpl extends ServiceImpl<EbStoreProductMapper, EbStoreProduct> implements EbStoreProductService {

    @Resource
    EbStoreProductMapper ebStoreProductMapper;

    @Resource
    EbStoreCategoryMapper ebStoreCategoryMapper;

    @Override
    public List<BestProductVo> getBestProduct(Integer limit) {
        LambdaQueryWrapper<EbStoreProduct> wrapper = Wrappers.<EbStoreProduct>lambdaQuery().eq(EbStoreProduct::getIsBest, 1)
                .eq(EbStoreProduct::getIsDel, 0)
                .eq(EbStoreProduct::getMerId, 0)
                .gt(EbStoreProduct::getStock, 0)
                .eq(EbStoreProduct::getIsShow, 1)
                .last("limit " + limit);
        return ebStoreProductMapper.getBestProduct(wrapper);
    }


    @Override
    public List<NewProductVo> getNewProduct(Integer limit) {
        LambdaQueryWrapper<EbStoreProduct> newProductWrapper = Wrappers.<EbStoreProduct>lambdaQuery()
                .eq(EbStoreProduct::getIsNew, 1)
                .eq(EbStoreProduct::getIsDel, 0)
                .eq(EbStoreProduct::getMerId, 0)
                .gt(EbStoreProduct::getStock, 0)
                .eq(EbStoreProduct::getIsShow, 1)
                .last("limit " + limit);
        return ebStoreProductMapper.getNewProduct(newProductWrapper);
    }

    @Override
    public List<BenifitProductVo> getBenifitProduct(Integer limit) {
        LambdaQueryWrapper<EbStoreProduct> wrapper = Wrappers.<EbStoreProduct>lambdaQuery()
                .eq(EbStoreProduct::getIsBenefit, 1)
                .eq(EbStoreProduct::getIsDel, 0)
                .eq(EbStoreProduct::getMerId, 0)
                .gt(EbStoreProduct::getStock, 0)
                .eq(EbStoreProduct::getIsShow, 1)
                .last("limit " + limit);
        return ebStoreProductMapper.getBenifitProduct(wrapper);
    }


    @Override
    public List<HotProductVo> getHotProduct(Integer limit) {
        LambdaQueryWrapper<EbStoreProduct> wrapper = Wrappers.<EbStoreProduct>lambdaQuery()
                .eq(EbStoreProduct::getIsHot, 1)
                .eq(EbStoreProduct::getIsDel, 0)
                .eq(EbStoreProduct::getMerId, 0)
                .gt(EbStoreProduct::getStock, 0)
                .eq(EbStoreProduct::getIsShow, 1)
                .last("limit " + limit);
        return ebStoreProductMapper.getHotProducts(wrapper);
    }

    @Override
    public List<StoreProductVo> getProductsList(Integer cateId, Integer parentCateId, String keyWord, Integer isNew,String salesOrder,String priceOrder, Integer pageNum, Integer pageSize) {
        //根据cateId 筛选 productId

        LambdaQueryWrapper<EbStoreProduct> wrapper = Wrappers.<EbStoreProduct>lambdaQuery();


        //根据cateId
        if (cateId != null && cateId > 0) {
            wrapper.eq(EbStoreProduct::getCateId, cateId);
        } else if (parentCateId != null && parentCateId > 0) {
            //根据父id 选出 所有cateId
            LambdaQueryWrapper<EbStoreCategory> scWrapper = Wrappers.<EbStoreCategory>lambdaQuery().eq(EbStoreCategory::getPid, parentCateId);

            List<EbStoreCategory> ebStoreCategories = ebStoreCategoryMapper.selectList(scWrapper);

            List<Integer> cateIds = ebStoreCategories.stream().map(EbStoreCategory::getId).collect(Collectors.toList());
            if (cateIds !=null && cateIds.size()>0){
                wrapper.in(EbStoreProduct::getCateId, cateIds);
            }
        }
        if (keyWord != null) {
            //根据关键字
            wrapper.or(qw -> qw.like(EbStoreProduct::getKeyword, keyWord).like(EbStoreProduct::getStoreName, keyWord));
        }

        if (isNew != null && isNew > 0) {
            wrapper.eq(EbStoreProduct::getIsNew, 1);
        }
        //排序设置
        if (salesOrder !=null && salesOrder.length()>0){
            if (salesOrder.equalsIgnoreCase("asc")){
                wrapper.orderByAsc(EbStoreProduct::getSales);
            }else if(salesOrder.equalsIgnoreCase("desc")){
                wrapper.orderByDesc(EbStoreProduct::getSales);
            }
        }
        if (priceOrder !=null && priceOrder.length()>0){
            if (priceOrder.equalsIgnoreCase("asc")){
                wrapper.orderByAsc(EbStoreProduct::getPrice);
            }else if(priceOrder.equalsIgnoreCase("desc")){
                wrapper.orderByDesc(EbStoreProduct::getPrice);
            }
        }
        //分页设置
        Page<EbStoreProduct> page = new Page<>(pageNum, pageSize);

        List<StoreProductVo> productsList = ebStoreProductMapper.getProductsList(page, wrapper);
        return productsList;
    }


    @Override
    public List<StoreProductVo> getHotProducts(Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<EbStoreProduct> wrapper = Wrappers.<EbStoreProduct>lambdaQuery();
        wrapper.select(EbStoreProduct::getId, EbStoreProduct::getImage, EbStoreProduct::getStoreName, EbStoreProduct::getCateId, EbStoreProduct::getPrice, EbStoreProduct::getUnitName, EbStoreProduct::getOtPrice)
                .eq(EbStoreProduct::getIsHot, 1)
                .eq(EbStoreProduct::getIsDel, 0)
                .eq(EbStoreProduct::getMerId, 0)
                .gt(EbStoreProduct::getStock, 0)
                .eq(EbStoreProduct::getIsShow, 1);
        //分页设置
        Page<EbStoreProduct> page = new Page<>(pageNum, pageSize);
        List<StoreProductVo> productsList = ebStoreProductMapper.customSqlSelect(page, wrapper);
        return productsList;
    }
}
