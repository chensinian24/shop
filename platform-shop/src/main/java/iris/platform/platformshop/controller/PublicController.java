package iris.platform.platformshop.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import iris.platform.platformshop.controller.response.BaseResponse;
import iris.platform.platformshop.entity.EbStoreCategory;
import iris.platform.platformshop.service.EbStoreCategoryService;
import iris.platform.platformshop.service.EbStoreProductService;
import iris.platform.platformshop.service.EbSystemConfigService;
import iris.platform.platformshop.vo.BenifitProductVo;
import iris.platform.platformshop.vo.BestProductVo;
import iris.platform.platformshop.service.admin.ISystemService;
import iris.platform.platformshop.vo.EbStoreCategoryVo;
import iris.platform.platformshop.vo.HotProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/public")
@RestController
public class PublicController {

    @Autowired
    ISystemService systemService;

    @Autowired
    EbSystemConfigService ebSystemConfigService;

    @Autowired
    EbStoreCategoryService ebStoreCategoryService;

    @Autowired
    EbStoreProductService ebStoreProductService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public BaseResponse index() {
        JSONObject responseJson = new JSONObject();
        //首页banner图
        JSONArray banner = systemService.getAllEbSystenGroupDataByConfigName("routine_home_banner");
        responseJson.put("banner", banner);
        JSONArray menus = systemService.getMenus("routine_home_menus");
        responseJson.put("menus", menus);
        JSONArray roll = systemService.getAllEbSystenGroupDataByConfigName("routine_home_roll_news");
        responseJson.put("roll", roll);
        JSONObject info = new JSONObject();

        JSONArray activity = systemService.getAllEbSystenGroupDataByConfigName("routine_home_activity");
        String site_name = ebSystemConfigService.selectValueBymenuName("site_name");
        JSONArray routine_index_page = systemService.getAllEbSystenGroupDataByConfigName("routine_index_page");
        //快速选择简介
        Object fastInfo = routine_index_page.getJSONObject(0).get("fast_info");
        info.put("fastInfo", fastInfo);
        Object bastInfo = routine_index_page.getJSONObject(0).get("bast_info");
        info.put("bastInfo", bastInfo);
        Object firstInfo = routine_index_page.getJSONObject(0).get("first_info");
        info.put("firstInfo", firstInfo);
        Object salesInfo = routine_index_page.getJSONObject(0).get("sales_info");
        info.put("salesInfo", salesInfo);
        //促销单品简介
        String logUrl = ebSystemConfigService.selectValueBymenuName("routine_index_logo");
        logUrl = logUrl.replace("\\", "/");
        Object fastNumber = routine_index_page.getJSONObject(0).getInteger("fast_number");
        Object baseNumber = routine_index_page.getJSONObject(0).getInteger("bast_number");
        Object firstNumber = routine_index_page.getJSONObject(0).getInteger("first_number");
        //快速选择分类个数
        List<EbStoreCategory> fastList = ebStoreCategoryService.getSecondaryIndex((Integer) fastNumber);
        // 精品推荐个数
        List<BestProductVo> bastList = ebStoreProductService.getBestProduct((Integer) baseNumber);

        List<BestProductVo> firstList = ebStoreProductService.getBestProduct((Integer) firstNumber);
        //首页精品推荐图片
        JSONArray bastBanner = systemService.getAllEbSystenGroupDataByConfigName("routine_home_bast_banner");
        //首页促销单品
        List<BenifitProductVo> benefit = ebStoreProductService.getBenifitProduct(3);
        info.put("fastList", fastList);
        info.put("bastList", bastList);
        info.put("firstList", firstList);
        info.put("bastBanner", bastBanner);
        responseJson.put("info", info);
        responseJson.put("benefit", benefit);
        responseJson.put("activity", activity);

        //首发新品
        JSONArray lovely = systemService.getAllEbSystenGroupDataByConfigName("routine_home_new_banner");
        responseJson.put("lovely", lovely);
        //热门榜单 猜你喜欢
        List<HotProductVo> likeInfo = ebStoreProductService.getHotProduct(3);

        responseJson.put("likeInfo", likeInfo);
        responseJson.put("logUrl", logUrl);
        responseJson.put("site_name", site_name);

        String newGoodsBananr = ebSystemConfigService.selectValueBymenuName("new_goods_bananr");
        responseJson.put("new_goods_banner", newGoodsBananr);

        return BaseResponse.successResponse.of(responseJson);

    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public BaseResponse category() {
        List<EbStoreCategoryVo> categoryWithChildrenModel = ebStoreCategoryService.getCategoryWithChildrenModel();
        return BaseResponse.successResponse.of(categoryWithChildrenModel);
    }

}
