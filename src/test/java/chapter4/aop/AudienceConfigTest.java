package chapter4.aop;

import com.sjb.chapter4.aop.javaconfig.ConcertConfig;
import com.sjb.chapter4.aop.javaconfig.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by simjunbo on 2018-06-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)               // 자동으로 생성되는 스프링 애플리케이션 컨텍스트를 갖는다.
@ContextConfiguration(classes = ConcertConfig.class) // 설정을 로드한다. 설정 클래스는 @ComponentScan을 가지므로 CompactDisc도 포함한다.
public class AudienceConfigTest {
    @Autowired
    private Performance performance;

    @Test
    public void play() {
        performance.perform();
    }
}
