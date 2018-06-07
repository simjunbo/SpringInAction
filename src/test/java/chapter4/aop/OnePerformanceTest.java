package chapter4.aop;

import com.sjb.chapter4.aop.introduction.ConcertConfig;
import com.sjb.chapter4.aop.introduction.Encoreable;
import com.sjb.chapter4.aop.introduction.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by simjunbo on 2018-06-07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class OnePerformanceTest {
    @Autowired
    private Performance performance;

    @Test
    public void perform() throws Exception {
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performEncore();
    }
}
