package chapter3.autowired;

import com.sjb.chapter3.autowired.AutowiredExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by simjunbo on 2018-05-30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-test/chapter3/autowired.xml"})
public class AutowiredExampleTest {

    @Autowired
    private AutowiredExample ae;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(ae);
    }
}
