package chapter2.soundsystem;

import com.sjb.chapter2.soundsystem.CDPlayerConfig;
import com.sjb.chapter2.soundsystem.CompactDisc;
import com.sjb.chapter2.soundsystem.MediaPlyer;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by simjunbo on 2018-05-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)               // 자동으로 생성되는 스프링 애플리케이션 컨텍스트를 갖는다.
@ContextConfiguration(classes = CDPlayerConfig.class) // 설정을 로드한다. 설정 클래스는 @ComponentScan을 가지므로 CompactDisc도 포함한다.
public class CDPlayerTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Autowired
    private MediaPlyer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
/*        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band" +
                        " by The Beatles\n",
                log.getLog());*/
    }
}
