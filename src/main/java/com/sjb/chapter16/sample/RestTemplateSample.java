package com.sjb.chapter16.sample;

import com.sjb.chapter16.data.Spitter;
import com.sjb.chapter16.data.Spittle;
import com.sjb.chapter16.exception.SpittleNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by simjunbo on 2018-07-31.
 */
public class RestTemplateSample {

    /**
     * GET
     */
    // Object (가변) 방식
    public Profile fetchFacebookProfile(String id) {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://graph.facebook.com/{soitter}", Profile.class, id);
    }

    // Map 방식
    public Profile fetchFacebookProfile2(String id) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", id);
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://graph.facebook.com/{spitter}", Profile.class, urlVariables);
    }

    public Spittle fetchSpittle(long id) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Spittle> response = rest.getForEntity(
                "http://localhost:8080/spitter-api/apittles/{id}", Spittle.class, id);
        if (response.getStatusCode() == HttpStatus.NOT_MODIFIED) {
            throw new RuntimeException();
        }
        return response.getBody();
    }

    /**
     * UPDATE
     */
    // 가변
    public void updateSpittle(Spittle spittle) throws SpittleNotFoundException {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/spitter-api/spittles/" + spittle.getId();
        rest.put(URI.create(url), spittle);
    }

    // 가변
    public void updateSpittle2(Spittle spittle) throws SpittleNotFoundException {
        RestTemplate rest = new RestTemplate();
        rest.put("http://localhost:8080/spitter-api/spittles/{id}", spittle, spittle.getId());
    }

    // Map
    public void updateSpittle3(Spittle spittle) throws SpittleNotFoundException {
        RestTemplate rest = new RestTemplate();
        Map<String, Long> params = new HashMap<>();
        params.put("id", spittle.getId());
        rest.put("http://localhost:8080/spitter-api/spittles/{id}", spittle, params);
    }

    /**
     * DELETE
     */
    public void deleteSpittle(long id) {
        RestTemplate rest = new RestTemplate();
        rest.delete(
                URI.create("http://localhost:8080/spitter-api/spittles/" + id)
        );
    }

    public void deleteSpittle2(long id) {
        RestTemplate rest = new RestTemplate();
        rest.delete("http://localhost:8080/spitter-api/spittles/{id}", id);
    }

    /**
     * INSERT
     */
    public Spitter postSpitterForObject(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        return rest.postForObject("http://localhost:8080/spitter-api/spitters", spitter, Spitter.class);
    }

    public Spitter postSpitterForObject2(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Spitter> response = rest.postForEntity("http://localhost:8080/spitter-api/spitters", spitter, Spitter.class);
        Spitter result = response.getBody();
        URI url = response.getHeaders().getLocation();
        return result;
    }

    public String postSpitter(Spitter spitter) {
        RestTemplate rest = new RestTemplate();
        return rest.postForLocation(
                "http://localhost:8080/spitter-api/spitters", spitter).toString();
    }

    /**
     * 직접 설정
     */
    public Spitter exchange(String spitterId) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Spitter> response = rest.exchange(
                "http://localhost:8080/spitter-api/spitters/{spitter}", HttpMethod.GET, null, Spitter.class, spitterId);
        Spitter spitter = response.getBody();
        return spitter;
    }

    public Spitter exchange2(String spitterId) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        RestTemplate rest = new RestTemplate();
        ResponseEntity<Spitter> response = rest.exchange(
                "http://localhost:8080/spitter-api/spitters/{spitter}", HttpMethod.GET, requestEntity, Spitter.class, spitterId);
        Spitter spitter = response.getBody();
        return spitter;
    }
}
