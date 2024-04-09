package com.barberia.citaShow.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@RequiredArgsConstructor
public class CreateTypeOfServiceRequest {

    private Long id;
    private String name;
    private String description;
    private String gender;
    private List<CreateServiceRequest> service;
    private List<CreateProvidersRequest> providers ;
}
