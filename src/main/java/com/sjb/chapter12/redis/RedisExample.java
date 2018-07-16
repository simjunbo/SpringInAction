package com.sjb.chapter12.redis;

import com.sjb.chapter12.redis.config.RedisConfig;
import com.sjb.chapter12.redis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

/**
 * Created by simjunbo on 2018-07-16.
 */
public class RedisExample {

    @Autowired
    private RedisConfig config;

    public void save() {
        RedisConnectionFactory cf = config.redisCF();

        // Save
        RedisConnection conn = cf.getConnection();
        conn.set("Greeting".getBytes(), "Hello World".getBytes());

        // Get
        byte[] greetingBytes = conn.get("greeting".getBytes());
        String greeting = new String(greetingBytes);
    }

    public void opsForValueSample() {
        RedisConnectionFactory cf = config.redisCF();
        RedisTemplate<String, Product> redis =
                new RedisTemplate<>();
        redis.setConnectionFactory(cf);

        // Sample
        // Set
        Product product = new Product();
        product.setSku("123456");
        product.setName("심준보");
        redis.opsForValue().set(product.getSku(), product);

        // Get
        Product result = redis.opsForValue().get(product.getSku());
    }

    public void opsForListSample() {
        RedisConnectionFactory cf = config.redisCF();
        RedisTemplate<String, Product> redis =
                new RedisTemplate<>();
        redis.setConnectionFactory(cf);

        // Sample
        // Set - 엔트리 종단에 추가
        Product product = new Product();
        product.setSku("123456");
        product.setName("심준보");
        redis.opsForList().rightPush("cart", product);

        // Set - 엔트리 시작점에 추가
        redis.opsForList().leftPush("cart", product);

        // Get
        Product first = redis.opsForList().leftPop("cart");
        Product last = redis.opsForList().rightPop("cart");
        // 단순 Get
        List<Product> products = redis.opsForList().range("cart", 2, 12);
    }

    public void opsForSetSample() {
        RedisConnectionFactory cf = config.redisCF();
        RedisTemplate<String, Product> redis =
                new RedisTemplate<>();
        redis.setConnectionFactory(cf);

        // Sample
        // Set
        Product product = new Product();
        product.setSku("123456");
        product.setName("심준보");
        redis.opsForSet().add("cart", product);

        // Get
        Set<Product> diff = redis.opsForSet().difference("cart1", "cart2");
        Set<Product> union = redis.opsForSet().union("cart1", "cart2");
        Set<Product> isect = redis.opsForSet().intersect("cart1", "cart2");

        // Delete
        redis.opsForSet().remove(product.getSku());
    }

    public void keyBinding() {
        RedisConnectionFactory cf = config.redisCF();
        RedisTemplate<String, Product> redis =
                new RedisTemplate<>();
        redis.setConnectionFactory(cf);

        BoundListOperations<String, Product> cart =
                redis.boundListOps("cart");
        Product popped = cart.rightPop();
        cart.rightPush(new Product("1", "홍길동"));
        cart.rightPush(new Product("2", "임꺽정"));
        cart.rightPush(new Product("3", "전우치"));
    }
}
