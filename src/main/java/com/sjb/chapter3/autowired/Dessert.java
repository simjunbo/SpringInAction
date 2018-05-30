package com.sjb.chapter3.autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by simjunbo on 2018-05-30.
 */
public interface Dessert {

}

@Component
class Cake implements Dessert {
}

@Component
class Cookies implements Dessert {
}

@Component
@Cold
@Cremy
class IceCream implements Dessert {
}

@Component
@Cold
@Fruity
class Popsicle implements Dessert {
}