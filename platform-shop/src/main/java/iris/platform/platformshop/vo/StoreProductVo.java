package iris.platform.platformshop.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StoreProductVo {

    private Integer id;

    /**
     * 商户Id(0为总后台管理员创建,不为0的时候是商户后台创建)
     */
    private Integer merId;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 轮播图
     */
    private String sliderImage;

    /**
     * 商品名称
     */
    private String storeName;

    /**
     * 商品简介
     */
    private String storeInfo;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 产品条码（一维码）
     */
    private String barCode;

    /**
     * 分类id
     */
    private String cateId;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 会员价格
     */
    private BigDecimal vipPrice;

    /**
     * 市场价
     */
    private BigDecimal otPrice;

    /**
     * 邮费
     */
    private BigDecimal postage;

    /**
     * 单位名
     */
    private String unitName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 状态（0：未上架，1：上架）
     */
    private Boolean isShow;

    /**
     * 是否热卖
     */
    private Boolean isHot;

    /**
     * 是否优惠
     */
    private Boolean isBenefit;

    /**
     * 是否精品
     */
    private Boolean isBest;

    /**
     * 是否新品
     */
    private Boolean isNew;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 添加时间
     */
    private Integer addTime;

    /**
     * 是否包邮
     */
    private Boolean isPostage;

    /**
     * 是否删除
     */
    private Boolean isDel;

    /**
     * 商户是否代理 0不可代理1可代理
     */
    private Boolean merUse;

    /**
     * 获得积分
     */
    private BigDecimal giveIntegral;

    /**
     * 成本价
     */
    private BigDecimal cost;

    /**
     * 秒杀状态 0 未开启 1已开启
     */
    private Boolean isSeckill;

    /**
     * 砍价状态 0未开启 1开启
     */
    private Boolean isBargain;

    /**
     * 是否优品推荐
     */
    private Boolean isGood;

    /**
     * 虚拟销量
     */
    private Integer ficti;

    /**
     * 浏览量
     */
    private Integer browse;

    /**
     * 产品二维码地址(用户小程序海报)
     */
    private String codePath;

    /**
     * 淘宝京东1688类型
     */
    private String soureLink;
    /**
     * 虚假销量为  真实销量+ 虚假销量
     * @return
     */
    private Integer fsales ;

}
