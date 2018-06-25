package com.sjb.chapter9.web;

import com.sjb.chapter9.data.Spittle;
import com.sjb.chapter9.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by simjunbo on 2018-06-15.
 */

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

/*
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute("spittleList",
                spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
*/

    /**
     * 핸들러 메소드가 이처럼 객체나 컬렉션을 리턴해 주는 값들은 모델로 들어가게 되고 모델 키는 그 타임에 따라 추측된다.
     * 논리적 뷰의 이름은 요청 패스를 통해 추론된다. 이 메소드가 /spittles의 GET 요청을 처리하는 것이므로 뷰 이름은
     * (앞의/를 떼어 내고) spittles가 된다.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    /**
     * 쿼리 파라미터 방식 (RequestParam 이용)
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    /**
     * 패스 방식 (PathVariable 이용)
     */
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
