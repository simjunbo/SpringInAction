package com.sjb.chapter16.web;

import com.sjb.chapter16.data.Spittle;
import com.sjb.chapter16.data.SpittleRepository;
import com.sjb.chapter16.exception.SpittleNotFoundException;
import com.sjb.chapter16.model.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by simjunbo on 2018-06-15.
 */

//@Controller
@RestController
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
    @Autowired
    private SpittleRepository spittleRepository;

    // ResponseBody 사용 (RestController 사용 시, 제외할 수 있음)
    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    // ResponseStatus 사용
    @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Spittle saveSpittle(@RequestBody Spittle spittle) {
        return spittleRepository.save(spittle);
    }

    // ResponseEntity 사용하여 응답 내 헤더 설정
    @RequestMapping(value = "/test2", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Spittle> saveSpittl2(@RequestBody Spittle spittle, UriComponentsBuilder ucb) {
        Spittle result = spittleRepository.save(spittle);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri =
                ucb.path("/spittles/")
                .path(String.valueOf(spittle.getId()))
                .build()
                .toUri();
        headers.setLocation(locationUri);

        ResponseEntity<Spittle> responseEntity =
                new ResponseEntity<Spittle>(
                        result, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Spittle spittleById(@PathVariable long id) {
        Spittle spittle = spittleRepository.findOne(id);
        if (spittle == null) {
            throw new SpittleNotFoundException(id);
        }
        return spittle;
    }

    @ExceptionHandler(SpittleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error spittleNotFound(SpittleNotFoundException e) {
        long spittledId = e.getSpittleId();
        return new Error(4, "Spittle [" + spittledId + "] not found");
    }
}
