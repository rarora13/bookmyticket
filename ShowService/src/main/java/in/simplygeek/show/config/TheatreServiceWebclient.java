package in.simplygeek.show.config;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import in.simplygeek.show.constants.CommonConstant;
import in.simplygeek.show.service.TheatreService;

@Configuration
public class TheatreServiceWebclient {
	private final DiscoveryClient discoveryClient;
    private final DynamicHeaderFilter dynamicHeaderFilter;
	
	public TheatreServiceWebclient(DiscoveryClient discoveryClient, DynamicHeaderFilter dynamicHeaderFilter) {
		this.discoveryClient = discoveryClient;
		this.dynamicHeaderFilter = dynamicHeaderFilter;
	}
	
    @Bean
	public TheatreService theatreService() {
    	String url = discoveryClient.getInstances(CommonConstant.THEATRE_SERVICE_NAME).get(0).getUri().toString();
		WebClient client = WebClient.builder().filter(dynamicHeaderFilter).baseUrl(url).build();
		WebClientAdapter adapter = WebClientAdapter.create(client);
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(adapter)
				.build();

		TheatreService service = factory.createClient(TheatreService.class);
		return service;
	}
}
