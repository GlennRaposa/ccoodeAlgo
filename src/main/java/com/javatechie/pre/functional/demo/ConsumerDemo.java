package com.javatechie.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo implements Consumer<Integer>{

	//THIS IS THE FUNCTIONAL INTERFACE ABSTRACT METHOD
	@Override
	public void accept(Integer integer) {
		System.out.println("lambda printing :"+integer);
	}

	/*public static void main(String args[]){
		Consumer<Integer> consumer = (i) -> {
			System.out.println("lambda printing :"+i);
		};
		consumer.accept(12);
	}*/

	public static void main(String[] args) {

		  Consumer<Integer> consumer = t -> System.out.println("custom Printing  : " + t);

		  consumer.accept(10);


		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		//Javas - default implemetation for FOREACH is consumer interface
		list1.stream().forEach(t -> System.out.println("print  : " + t));

		//Using the custom interface
		list1.stream().forEach(consumer);
	}


}
