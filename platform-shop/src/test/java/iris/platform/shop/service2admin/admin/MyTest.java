package iris.platform.shop.service2admin.admin;

import iris.platform.shop.PlatformShopApplicationTests;
import iris.platform.shop.dao.AdDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class MyTest extends PlatformShopApplicationTests {

    @Autowired
    AdDao adDao;

    @Test
    public void test(){
        int i = adDao.queryTotal();
        log.info("===================={}",i);
    }
}
