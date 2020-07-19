package iris.platform.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @gitee https://gitee.com/fuyang_lipengjun/platform
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
@RequestMapping("/sys")
@Slf4j
public class SysPageController2 {

    /**
     * 视图路径
     *

     * @return 页面视图路径
     */
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        log.info("主页模块");
        return "sys/"+page;
    }

}
