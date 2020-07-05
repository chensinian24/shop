package iris.platform.platformshop.controller.product;

import iris.platform.platformshop.controller.reqVo.StoreProductQuery;
import iris.platform.platformshop.controller.response.BaseResponse;
import iris.platform.platformshop.service.EbStoreProductService;
import iris.platform.platformshop.vo.StoreProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    EbStoreProductService ebStoreProductService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public BaseResponse list(@RequestBody StoreProductQuery data) {
        List<StoreProductVo> productsList = ebStoreProductService.getProductsList(data.getCateId(), data.getParentCateId(), data.getKeyWord(), data.getIsNew(), data.getSalesOrder(), data.getPriceOrder(), data.getPageNum(), data.getPageSize());
        return BaseResponse.successResponse.of(productsList);
    }

    @RequestMapping(value = "/hot", method = RequestMethod.POST)
    public BaseResponse hot(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<StoreProductVo> productsList = ebStoreProductService.getHotProducts(pageNum, pageSize);
        return BaseResponse.successResponse.of(productsList);
    }

}
