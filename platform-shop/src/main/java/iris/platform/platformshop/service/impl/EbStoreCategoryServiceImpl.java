package iris.platform.platformshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import iris.platform.platformshop.entity.EbStoreCategory;
import iris.platform.platformshop.mapper.EbStoreCategoryMapper;
import iris.platform.platformshop.service.EbStoreCategoryService;
import iris.platform.platformshop.vo.EbStoreCategoryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author sinian.csn
 * @since 2020-06-11
 */
@Service
public class EbStoreCategoryServiceImpl extends ServiceImpl<EbStoreCategoryMapper, EbStoreCategory> implements EbStoreCategoryService {

    @Resource
    EbStoreCategoryMapper ebStoreCategoryMapper;

    @Override
    public List<EbStoreCategory> getSecondaryIndex(Integer limit) {
        LambdaQueryWrapper<EbStoreCategory> wrapper = Wrappers.<EbStoreCategory>lambdaQuery();
        wrapper.eq(EbStoreCategory::getPid, 0)
                .eq(EbStoreCategory::getIsShow, 0)
                .orderByDesc(EbStoreCategory::getSort)
                .last("limit " + limit);

        List<EbStoreCategory> ebStoreCategories = ebStoreCategoryMapper.selectList(wrapper);

        return ebStoreCategories;
    }

    @Override
    public List<EbStoreCategoryVo> getCategoryWithChildrenModel() {
        return ebStoreCategoryMapper.getCategoryWithChildren();
    }
}
