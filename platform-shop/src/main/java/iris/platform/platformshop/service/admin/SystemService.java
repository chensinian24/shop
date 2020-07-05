package iris.platform.platformshop.service.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import iris.platform.platformshop.entity.SystemGroup;
import iris.platform.platformshop.entity.SystemGroupData;
import iris.platform.platformshop.service.EbStoreCategoryService;
import iris.platform.platformshop.service.SystemGroupDataService;
import iris.platform.platformshop.service.SystemGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SystemService implements ISystemService {



    @Autowired
    SystemGroupDataService systemGroupDataService;

    @Autowired
    SystemGroupService systemGroupService;

    @Autowired
    EbStoreCategoryService ebStoreCategoryService;


    @Override
    public JSONArray getMenus(String configName) {
        QueryWrapper<SystemGroup> queryWrapper = new QueryWrapper<SystemGroup>();
        queryWrapper.eq("config_name",configName);
        SystemGroup systemGroup = systemGroupService.getOne(queryWrapper);
        QueryWrapper<SystemGroupData> systemGroupDataQueryWrapper = new QueryWrapper<>();
        systemGroupDataQueryWrapper.eq("gid",systemGroup.getId()).eq("status",1);
        List<SystemGroupData> systemGroupDataList = systemGroupDataService.list(systemGroupDataQueryWrapper);
        JSONArray ret = new JSONArray();
        for (SystemGroupData systemGroupData : systemGroupDataList) {
            Long id = systemGroupData.getId();
            String value = systemGroupData.getValue();
            JSONObject i = new JSONObject();
            i.put("id",id);
            JSONObject jsonObjectValue = JSONObject.parseObject(value);
            for (Map.Entry entry : jsonObjectValue.entrySet()) {
                JSONObject json = (JSONObject)entry.getValue();
                i.put(String.valueOf(entry.getKey()),json.get("value"));

            }
            ret.add(i);
        }

        return ret;
    }

    @Override
    public JSONArray getAllEbSystenGroupDataByConfigName(String configName) {
        QueryWrapper<SystemGroup> queryWrapper = new QueryWrapper<SystemGroup>();
        queryWrapper.eq("config_name",configName);
        SystemGroup systemGroup = systemGroupService.getOne(queryWrapper);
        QueryWrapper<SystemGroupData> systemGroupDataQueryWrapper = new QueryWrapper<>();
        systemGroupDataQueryWrapper.eq("gid",systemGroup.getId()).eq("status",1);
        List<SystemGroupData> systemGroupDataList = systemGroupDataService.list(systemGroupDataQueryWrapper);
        JSONArray ret = new JSONArray();
        for (SystemGroupData systemGroupData : systemGroupDataList) {
            Long id = systemGroupData.getId();
            String value = systemGroupData.getValue();
            JSONObject i = new JSONObject();
            i.put("id",id);
            JSONObject jsonObjectValue = JSONObject.parseObject(value);
            for (Map.Entry entry : jsonObjectValue.entrySet()) {
                JSONObject json = (JSONObject)entry.getValue();
                i.put(String.valueOf(entry.getKey()),json.get("value"));

            }
            ret.add(i);
        }

        return ret;
    }


    @Override
    public JSONArray getCategory() {


        return null;
    }
}
