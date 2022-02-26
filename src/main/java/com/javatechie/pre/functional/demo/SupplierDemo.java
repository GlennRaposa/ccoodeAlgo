package com.javatechie.pre.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String>{


	//THIS IS THE FUNCTIONAL INTERFACE ABSTRACT METHOD
	@Override
	public String get() {
		return "Hi Supplier";
	}


	public static void main(String[] args) {

		Supplier<String> supplier = () -> {
			return "Hi Supplier Exploded_Lambda";
		};

		Supplier<String> supplierSlim = () -> "Hi Supplier Slim_Lambda";

		//System.out.println(supplier.get());
		//System.out.println(supplierSlim.get());

		List<String> list1 = Arrays.asList();
		System.out.println(list1.stream().findAny().orElseGet(() -> "---- Hi we did find any thing in the list ---"));

		//Our custom Supplier
		System.out.println(list1.stream().findAny().orElseGet(supplierSlim));
	}
}
