package com.parkinglot.queryservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.parkinglot.dto.Cars;


public class RegNumberQueryService
    implements CarQueryService
{

    @Override
    public List<String> queryBy( String color, Map<String, Cars> mapOfCars )
    {
        List<String> regNos = new ArrayList<String>();
        mapOfCars.forEach( ( k, v ) -> {
            if( color.equals( v.getColor() ) )
            {
                regNos.add( v.getRegNo() );
            }
        } );

        return regNos;
    }

}
