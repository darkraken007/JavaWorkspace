package com.parkinglot.lot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.parkinglot.dto.Cars;
import com.parkinglot.queryservice.QueryServiceFactory;


public class ParkingLot
{
    private static final String NOT_FOUND = "Not Found";
    Map<String, Cars> mapOfCars;
    List<String> slots;
    int slotSize;


    public ParkingLot( int slotSize )
    {
        this.slotSize = slotSize;
        if( slotSize <= 0 )
        {
            throw new IllegalArgumentException();
        }
        slots = new ArrayList<String>();
        mapOfCars = new HashMap<String, Cars>();
    }


    public String allocateAParkingSpot( String regNo, String color )
    {
        int index = 0;
        if( slots.contains( regNo ) )
        {

            return "Slot already alloted for given Registration Number";

        }
        if( slotSize <= slots.size() && !slots.contains( "-1" ) )
        {
            return "Sorry, parking lot is full";
        }
        else if( slotSize == slots.size() && slots.contains( "-1" ) )
        {
            index = slots.indexOf( "-1" );
            String slot = String.valueOf( index + 1 );
            Cars car = new Cars( regNo, color, slot );

            slots.set( index, regNo );
            mapOfCars.put( regNo, car );
            return "Allocated slot number: " + slot;
        }
        else
        {
            index = slots.size();
        }
        String slot = String.valueOf( index + 1 );
        Cars car = new Cars( regNo, color, slot );

        slots.add( index, regNo );
        mapOfCars.put( regNo, car );
        return "Allocated slot number: " + slot;

    }


    public String deAllocateParkingSpot( int slot )
    {
        String returnMsg = NOT_FOUND;
        if( slot > slots.size() )
        {

            return returnMsg;
        }

        int index = slot - 1;
        String regNo = slots.get( index );

        if( null != regNo && !("-1".equals( regNo )) )
        {
            mapOfCars.remove( regNo );
            slots.set( index, "-1" );
            returnMsg = "Slot number " + slot + " is free";
        }

        return returnMsg;
    }


    public String getAllocatedSlotNumber( String regNum )
    {

        if( slots.contains( regNum ) )
        {

            return String.valueOf( slots.indexOf( regNum ) + 1 );
        }

        else
        {

            return NOT_FOUND;
        }
    }


    public String printAllRegNumWithGivenColor( String color )
    {

        List<String> list = new QueryServiceFactory()
            .getQuerySevice( QueryServiceFactory.REGISTER_NUMBER ).queryBy( color, mapOfCars );
        return String.join( ",", list );
    }


    public String printAllSlotWithGivenColor( String color )
    {

        List<String> list = new QueryServiceFactory()
            .getQuerySevice( QueryServiceFactory.SLOT ).queryBy( color, mapOfCars );
        return String.join( ",", list );
    }


    public String printStatus()
    {
        String title =
            String.format( "%-32s%-32s%-32s", "Slot No.", "Registration No", "Colour" ) + "\n";
        StringBuilder str = new StringBuilder( title );
        for( Entry<String, Cars> entry : mapOfCars.entrySet() )
        {

            Cars car = entry.getValue();
            str.append(
                String.format( "%-32s%-32s%-32s", car.getSlot(), car.getRegNo(), car.getColor() ) );
            str.append( "\n" );

        }

        return str.toString();
    }
}
