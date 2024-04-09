
package com.barberia.citaShow.response;

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
public class TypeOfServiceResponse {
    private Long id;
    private String name;
    private String description;
    private String gender;
    private List<ServiceResponse> service;
    private List<ProvidersResponse> providers;
}
