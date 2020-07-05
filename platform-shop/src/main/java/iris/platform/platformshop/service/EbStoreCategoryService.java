package iris.platform.platformshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import iris.platform.platformshop.entity.EbStoreCategory;
import iris.platform.platformshop.vo.EbStoreCategoryVo;

import java.util.List;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-11
 */
public interface EbStoreCategoryService extends IService<EbStoreCategory> {

    List<EbStoreCategory> getSecondaryIndex(Integer limit);

    List<EbStoreCategoryVo> getCategoryWithChildrenModel();

}
