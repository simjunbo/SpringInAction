package chapter2.soundsystem;

import com.sjb.chapter2.soundsystem.CDPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by simjunbo on 2018-05-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-test/chapter2/cdplayer-property.xml"})
public class CDPlayerPropertyTest {
    @Autowired
    private CDPlayer cp;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cp);
    }
}
