package chatper1.knight;

import com.sjb.chapter1.di.BraveKnight;
import com.sjb.chapter1.di.Quest;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.mock;

/**
 * Created by simjunbo on 2018-05-28.
 */
public class Knight {
    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class); // 모의 Quest 생성
        BraveKnight knight = new BraveKnight(mockQuest); // 모의 Quest 주입
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
