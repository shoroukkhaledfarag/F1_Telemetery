package com.shoroukkhaled.F1_Telemetery.shared.interfaces;

import java.util.List;

public interface ICrudService <CreateDto, UpdateDto, SimpleDto, FullDto> {
    SimpleDto create(CreateDto createDto);
    SimpleDto update(UpdateDto updateDto);
    void deleteById(Long id);
    FullDto getById(Long id);
    List<FullDto> getAll();
}
