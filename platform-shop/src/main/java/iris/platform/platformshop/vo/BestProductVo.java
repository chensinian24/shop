package iris.platform.platformshop.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BestProductVo {

    /**
     * 商品id
     */
    private Integer id;


    /**
     * 商品图片
     */
    private String image;



    /**
     * 商品名称
     */
    private String storeName;

    /**
     * 商品简介
     */
    private String storeInfo;



    /**
     * 分类id
     */
    private String cateId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 市场价
     */
    private BigDecimal otPrice;

    /**
     * 市场价
     */
    private BigDecimal sales;


    /**
     * 单位名
     */
    private String unitName;

}
