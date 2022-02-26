package com.javatechie.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo implements Predicate<Integer>{

	//THIS IS THE FUNCTIONAL INTERFACE ABSTRACT METHOD
	@Override
	public boolean test(Integer i) {
		if(i %2 == 0){
			return true;
		}
		return false;
	}


	public static void main(String args[]){
		/*Predicate<Integer> p = (i) -> {
			if(i %2 == 0){
				return true;
			}
			return false;
		};*/

		//Exploded form
		Predicate<Integer> predicateExploded = i -> {
             if(i %2 == 0){
				return true;
			}
			return false;
		};

		//slim form
		Predicate<Integer> predicateSlim = i -> i %2 == 0;


		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		list1.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.println("print  Even: " + t));

		list1.stream().filter(predicateExploded).forEach(t -> System.out.println("predicateExploded_print  Even: " + t));


		list1.stream().filter(predicateSlim).forEach(t -> System.out.println("predicateSlim_print  Even: " + t));



		System.out.println(predicateSlim.test(9));
	}


}
