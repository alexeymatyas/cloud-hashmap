package com.epam.amatias.service;

import org.springframework.cloud.servicebroker.model.*;
import org.springframework.cloud.servicebroker.service.ServiceInstanceService;
import org.springframework.stereotype.Service;

/**
 * Created by Alexey on 26.11.2016.
 */
@Service
public class HashMapServiceInstanceService implements ServiceInstanceService {
	
	@Override
	public CreateServiceInstanceResponse createServiceInstance(CreateServiceInstanceRequest request) {
		return new CreateServiceInstanceResponse();
	}

	@Override
	public GetLastServiceOperationResponse getLastOperation(GetLastServiceOperationRequest request) {
		return new GetLastServiceOperationResponse().withOperationState(OperationState.SUCCEEDED);
	}

	@Override
	public DeleteServiceInstanceResponse deleteServiceInstance(DeleteServiceInstanceRequest request) {
		return new DeleteServiceInstanceResponse();
	}

	@Override
	public UpdateServiceInstanceResponse updateServiceInstance(UpdateServiceInstanceRequest request) {
		return new UpdateServiceInstanceResponse();
	}

}