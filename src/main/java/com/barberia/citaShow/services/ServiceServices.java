package com.barberia.citaShow.services;

import com.barberia.citaShow.request.CreateServiceRequest;
import com.barberia.citaShow.response.ServiceResponse;

public interface ServiceServices {

    ServiceResponse save(CreateServiceRequest request);
}
