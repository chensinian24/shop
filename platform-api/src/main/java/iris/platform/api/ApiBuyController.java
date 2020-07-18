package iris.platform.api;

import com.alibaba.fastjson.JSONObject;
import iris.platform.annotation.LoginUser;
import iris.platform.common.cache.J2CacheUtils;
import iris.platform.entity.BuyGoodsVo;
import iris.platform.entity.UserVo;
import iris.platform.util.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 */
@Api(tags = "商品购买")
@RestController
@RequestMapping("/api/buy")
public class ApiBuyController extends ApiBaseAction {

    @ApiOperation(value = "商品添加")
    @PostMapping("/add")
    public Object addBuy(@LoginUser UserVo loginUser) {
        JSONObject jsonParam = getJsonRequest();
        Integer goodsId = jsonParam.getInteger("goodsId");
        Integer productId = jsonParam.getInteger("productId");
        Integer number = jsonParam.getInteger("number");
        BuyGoodsVo goodsVo = new BuyGoodsVo();
        goodsVo.setGoodsId(goodsId);
        goodsVo.setProductId(productId);
        goodsVo.setNumber(number);
        J2CacheUtils.put(J2CacheUtils.SHOP_CACHE_NAME, "goods" + loginUser.getUserId() + "", goodsVo);
        return toResponsMsgSuccess("添加成功");
    }
}
