package com.barberia.citaShow.dto;

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
public class TypeOfServiceDto {
    private Long id;
    private String name;
    private String description;
    private String gender;
    private List<ServiceDto> service;
    private List<ProvidersDto> providers;
}
