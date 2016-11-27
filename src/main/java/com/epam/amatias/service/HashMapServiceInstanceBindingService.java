package com.epam.amatias.service;

import org.springframework.cloud.servicebroker.model.CreateServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Alexey on 26.11.2016.
 */
@Service
public class HashMapServiceInstanceBindingService implements ServiceInstanceBindingService {

	@Override
	public CreateServiceInstanceBindingResponse createServiceInstanceBinding(CreateServiceInstanceBindingRequest request) {
		Map<String, Object> credentials =
				Collections.singletonMap("url", "http://hashmap-service-broker.local.pcfdev.io");
		return new CreateServiceInstanceAppBindingResponse().withCredentials(credentials);
	}

	@Override
	public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest request) {

	}
}
