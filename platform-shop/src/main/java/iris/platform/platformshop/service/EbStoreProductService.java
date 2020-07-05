package iris.platform.platformshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import iris.platform.platformshop.entity.EbStoreProduct;
import iris.platform.platformshop.vo.BenifitProductVo;
import iris.platform.platformshop.vo.BestProductVo;
import iris.platform.platformshop.vo.HotProductVo;
import iris.platform.platformshop.vo.NewProductVo;
import iris.platform.platformshop.vo.StoreProductVo;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-11
 */
public interface EbStoreProductService extends IService<EbStoreProduct> {

    List<BestProductVo> getBestProduct(Integer limit);

    List<NewProductVo> getNewProduct(Integer limit);

    List<BenifitProductVo> getBenifitProduct(Integer limit);

    List<HotProductVo> getHotProduct(Integer limit);

    /**
     * @param cateId
     * @param parentCateId
     * @param keyWord
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<StoreProductVo> getProductsList(Integer cateId, Integer parentCateId, String keyWord, Integer isNew, String salesOrder, String priceOrder, Integer pageNum, Integer pageSize);

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<StoreProductVo> getHotProducts(Integer pageNum, Integer pageSize);

    StoreProductVo getProductDetail(Integer productId);



}
