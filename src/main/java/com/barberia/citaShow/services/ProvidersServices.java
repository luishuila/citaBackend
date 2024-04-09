package com.barberia.citaShow.services;

import com.barberia.citaShow.request.CreateProvidersRequest;
import com.barberia.citaShow.response.ProvidersResponse;

public interface ProvidersServices {

    ProvidersResponse save(CreateProvidersRequest request);
}
