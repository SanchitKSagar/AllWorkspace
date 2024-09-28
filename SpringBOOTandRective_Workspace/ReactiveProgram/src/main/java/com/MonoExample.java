package com;

import reactor.core.publisher.Mono;

public class MonoExample {

	public static void main(String[] args) {
		
		Mono<String> mono =  Mono.just("Hello");
		
		mono.subscribe(data -> System.out.println(data));
	}

}
