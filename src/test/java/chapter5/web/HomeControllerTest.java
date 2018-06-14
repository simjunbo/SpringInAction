package chapter5.web;

import com.sjb.chapter5.data.Spittle;
import com.sjb.chapter5.data.SpittleRepository;
import com.sjb.chapter5.web.HomeController;
import com.sjb.chapter5.web.SpittleController;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
/**
 * Created by simjunbo on 2018-06-14.
 */
public class HomeControllerTest {
    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);

        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller) // 모의 프레임워크에서는 컨트롤러에서 전달되는 뷰 이름을 결정하지 않는다.
                .setSingleView(
                        new InternalResourceView("/WEB-INF/view/spittles.jsp"))
                .build();

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();

        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }

        return spittles;
    }

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc =
                standaloneSetup(controller).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }
}
