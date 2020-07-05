package iris.platform.platformshop.controller.reqVo;

import lombok.Data;

@Data
public class StoreProductQuery {
    private Integer cateId;
    private Integer parentCateId;
    private String keyWord;
    private Integer isNew;
    private String salesOrder;
    private String priceOrder;
    private Integer pageNum;
    private Integer pageSize;
}
