package iris.platform.platformshop.service2admin.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import iris.platform.platformshop.PlatformShopApplicationTests;
import iris.platform.platformshop.entity.EbStoreCategory;
import iris.platform.platformshop.entity.EbStoreProduct;
import iris.platform.platformshop.service.EbStoreCategoryService;
import iris.platform.platformshop.service.EbStoreProductService;
import iris.platform.platformshop.service.EbSystemConfigService;
import iris.platform.platformshop.service.admin.ISystemService;
import iris.platform.platformshop.vo.EbStoreCategoryVo;
import iris.platform.platformshop.vo.StoreProductVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j

public class SystemServiceTest extends PlatformShopApplicationTests {

    @Autowired
    ISystemService systemService;

    @Autowired
    EbStoreCategoryService storeCategoryService;

    @Autowired
    EbStoreProductService ebStoreProductService;

    @Autowired
    EbSystemConfigService ebSystemConfigService;


    @Test
    public void getAllEbSystenGroupDataByConfigName() {

        log.info("system service: {}",systemService.getAllEbSystenGroupDataByConfigName("routine_home_banner"));
    }

    @Test
    public void testCateByIndex(){
        QueryWrapper<EbStoreCategory> storeCategoryQueryWrapper = new QueryWrapper<>();
        storeCategoryQueryWrapper.gt("pid",0).eq("is_show",1).orderByDesc("sort").last("limit 4");
        List<EbStoreCategory> list = storeCategoryService.list(storeCategoryQueryWrapper);

        LambdaQueryWrapper<EbStoreProduct> last = Wrappers.<EbStoreProduct>lambdaQuery().eq(EbStoreProduct::getIsBest, 1)
                .eq(EbStoreProduct::getIsDel, 0)
                .eq(EbStoreProduct::getMerId, 0)
                .gt(EbStoreProduct::getStock, 0)
                .eq(EbStoreProduct::getIsShow, 1)
                .last("limit 1");

        log.info("Eb Store Best Product:{}",ebStoreProductService.getBestProduct(1));




        log.info("Eb Store is New Product:{}",ebStoreProductService.getNewProduct(1));

        LambdaQueryWrapper<EbStoreProduct> isbenifit = Wrappers.<EbStoreProduct>lambdaQuery()
                .eq(EbStoreProduct::getIsBenefit, 1)
                .eq(EbStoreProduct::getIsDel, 0)
                .eq(EbStoreProduct::getMerId, 0)
                .gt(EbStoreProduct::getStock, 0)
                .eq(EbStoreProduct::getIsShow, 1)
                .last("limit 1");
        log.info("Eb Store is Benifit Product:{}",ebStoreProductService.getBenifitProduct(1));

        log.info("store category list:{}",list);
    }


    @Test
    public void testSystemConfig(){

        log.info("routine info:{}",ebSystemConfigService.selectValueBymenuName("routine_index_logo"));

    }


    @Test
    public void getCategoryWithChildrenModel(){
        List<EbStoreCategoryVo> categoryWithChildrenModel = storeCategoryService.getCategoryWithChildrenModel();

        log.info("vo:{}",categoryWithChildrenModel);
    }


    @Test
    public void getProductList(){



    }

}