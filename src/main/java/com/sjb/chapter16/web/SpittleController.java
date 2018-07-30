package com.sjb.chapter16.web;

import com.sjb.chapter16.data.Spittle;
import com.sjb.chapter16.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    // ResponseBody 사용
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<Spittle> spittles2(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST, consumes = "application/json")
    public Spittle saveSpittle(@RequestBody Spittle spittle) {
        return spittleRepository.save(spittle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> spittleById(@PathVariable long id) {
        Spittle spittle = spittleRepository.findOne(id);
        if (spittle == null) {
            com.sjb.chapter16.model.Error error = new com.sjb.chapter16.model.Error(4, "not found");
            return new ResponseEntity<com.sjb.chapter16.model.Error> (error, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Spittle>(spittle, HttpStatus.OK);
    }
}
