package in.simplygeek.show.config;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;

import reactor.core.publisher.Mono;

@Component
public class DynamicHeaderFilter implements ExchangeFilterFunction {

	private ThreadLocal<String> clientToken = new ThreadLocal<String>();
//	public static String token = "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJyYWtlc2giLCJpYXQiOjE3MDM3NTU1NjQsImV4cCI6MTcwMzc3MzU2NH0.BKL7KdYiXtzR4BCYeNqWFHqO0Fcp-weG5jVjH5LGV94GQ5UeSLp7D-of3B6_V6ok";

	@Override
	public Mono<ClientResponse> filter(ClientRequest clientRequest, ExchangeFunction nextFilter) {

		// Create a new ClientRequest with the additional headers
		ClientRequest modifiedRequest = ClientRequest
				.from(clientRequest)
				.header("Authorization", "Bearer "+clientToken.get())
				.build();

		return nextFilter.exchange(modifiedRequest);
	}
	
	public void setToken(String token) {
		clientToken.set(token);
	}
}