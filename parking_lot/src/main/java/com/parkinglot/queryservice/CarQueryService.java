package com.parkinglot.queryservice;

import java.util.List;
import java.util.Map;

import com.parkinglot.dto.Cars;


public interface CarQueryService
{
    public List<String> queryBy( String color, Map<String, Cars> mapOfCars );
}
