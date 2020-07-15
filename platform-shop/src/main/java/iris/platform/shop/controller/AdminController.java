package iris.platform.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author: xinguiyuan
 * @date: 2018-10-17 22:57:36 
 */
@Controller
@RequestMapping("/shop")
@Slf4j
public class AdminController {

    @RequestMapping("/{path}")
    public String index(ModelMap modelMap, @PathVariable String path) {
        log.info("here is the first page");
        return "/shop/"+path;
    }
}

