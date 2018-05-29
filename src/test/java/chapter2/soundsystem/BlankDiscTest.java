package chapter2.soundsystem;

import com.sjb.chapter2.soundsystem.BlankDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by simjunbo on 2018-05-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-test/blank.xml"})
public class BlankDiscTest {
    @Autowired
    private BlankDisc bd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(bd);
    }
}
