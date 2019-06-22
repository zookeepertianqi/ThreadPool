package com.example.concurrent.Thread.state;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author baofu.qi
 *
 */
public class App {
    public static void main( String[] args ){
    	List<String> list = new ArrayList<String>();
    	Object lock = new Object();
    	
    	//consume
    	Consumer consumerOne = new Consumer(Consumer.class.getSimpleName(), list, lock);
    	consumerOne.start();
    	//product
    	Producer one = new Producer(Producer.class.getSimpleName() + " one", list, lock);
    	one.start();
    	//product
    	Producer two = new Producer(Producer.class.getSimpleName() + " two", list, lock);
    	two.start();
    }
}
