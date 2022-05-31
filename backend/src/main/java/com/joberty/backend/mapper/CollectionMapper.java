package com.joberty.backend.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }
}
