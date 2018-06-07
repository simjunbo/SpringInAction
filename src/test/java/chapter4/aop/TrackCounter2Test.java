package chapter4.aop;

import com.sjb.chapter4.aop.parameter.xml.CompactDisc;
import com.sjb.chapter4.aop.parameter.xml.TrackCounter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by simjunbo on 2018-06-07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-test/chapter4/trackCounter.xml"})
public class TrackCounter2Test {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter counter;

    @Test
    public void testTrackCounter() {
        cd.playTrack(1); // 일부트랙실행
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);

        Assert.assertEquals(1, counter.getPlayCount(1));
        Assert.assertEquals(1, counter.getPlayCount(2));
        Assert.assertEquals(4, counter.getPlayCount(3));
        Assert.assertEquals(0, counter.getPlayCount(4));
        Assert.assertEquals(0, counter.getPlayCount(5));
        Assert.assertEquals(0, counter.getPlayCount(6));
        Assert.assertEquals(2, counter.getPlayCount(7));
    }
}
