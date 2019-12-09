package com.parkinglot.queryservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.parkinglot.dto.Cars;


public class SlotQueryService
    implements CarQueryService
{
    public SlotQueryService()
    {
        // TODO Auto-generated constructor stub
    }


    @Override
    public List<String> queryBy( String color, Map<String, Cars> mapOfCars )
    {
        List<String> slots = new ArrayList<String>();
        mapOfCars.forEach( ( k, v ) -> {
            if( color.equals( v.getColor() ) )
            {
                slots.add( v.getSlot() );
            }
        } );

        return slots;
    }

}
