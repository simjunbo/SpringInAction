package chapter4.aop;

import com.sjb.chapter4.aop.xml.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by simjunbo on 2018-06-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-test/chapter4/aop.xml"})
public class AudienceXmlTest {
    @Autowired
    private Performance performance;

    @Test
    public void play() {
        performance.perform();
    }
}
