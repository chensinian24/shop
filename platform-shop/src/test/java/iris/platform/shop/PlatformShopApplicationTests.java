package iris.platform.shop;

import iris.platform.shop.dao.AdDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = {"iris.platform.shop.dao","iris.platform.common.dao"})
@Slf4j
public class PlatformShopApplicationTests {

    @Autowired
    AdDao adDao;





}
