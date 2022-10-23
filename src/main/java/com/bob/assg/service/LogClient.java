package com.bob.assg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.bob.assg.web.LogDto;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Service
public class LogClient {
	@Autowired
	private WebClient webClient;
	
	public Disposable sendLog(LogDto logDto) {
		return webClient.post()
				.uri("/log")
				.body(Mono.just(logDto), LogDto.class)
				.retrieve()
				.bodyToMono(Void.class)
				.subscribe();
		
	}
}
