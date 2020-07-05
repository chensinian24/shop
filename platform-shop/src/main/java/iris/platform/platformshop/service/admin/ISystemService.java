package iris.platform.platformshop.service.admin;

import com.alibaba.fastjson.JSONArray;

public interface ISystemService {

    JSONArray getAllEbSystenGroupDataByConfigName(String configName);

    JSONArray getMenus(String configName);

    /**
     * 获取商品分类结果
     * @return
     */
    JSONArray getCategory();

}
