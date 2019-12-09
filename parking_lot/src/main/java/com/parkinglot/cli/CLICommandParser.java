package com.parkinglot.cli;

import java.util.Arrays;
import java.util.List;

import com.parkinglot.lot.ParkingLot;


public class CLICommandParser
{
    ParkingLot plot;


    public void parse( String commandAndArguments )
    {

        List<String> commandAndArgumentList = Arrays.asList( commandAndArguments.split( " " ) );
        String command = commandAndArgumentList.get( 0 );

        switch( command )
        {
            case "create_parking_lot":
                processCreateParkingLotCommand( commandAndArgumentList );

                break;

            case "park":
                processParkCommand( commandAndArgumentList );

                break;
            case "leave":
                processLeaveCommand( commandAndArgumentList );

                break;

            case "registration_numbers_for_cars_with_colour":
                processRegNumsWithColorCommand( commandAndArgumentList );

                break;

            case "slot_numbers_for_cars_with_colour":
                processSlotWithColorCommand( commandAndArgumentList );

                break;

            case "slot_number_for_registration_number":
                processGetSlotNumberForRegNumCommand( commandAndArgumentList );

                break;

            case "status":
                processStatus( commandAndArgumentList );
                break;
            case "help":
                processHelp();
                break;

            default:
                break;
        }
    }


    private void processHelp()
    {
        String title = String.format( "%-64s%-32s", "Commands", "Description" ) + "\n";
        String create_parking_lot = String.format(
            "%-64s%-32s", "create_parking_lot",
            "Create a parking lot.One Positive integer Argument" ) + "\n";
        String park = String.format(
            "%-64s%-32s", "park",
            "Parks a Car in Lot. " +
                "Two Arguments. First defines the Registration Number which is A String and other defines color of the car" ) +
            "\n";
        String leave = String.format(
            "%-64s%-32s", "leave", "Leave the car from slot.One Positive integer Argument" ) + "\n";
        String registration_numbers_for_cars_with_colour = String.format(
            "%-64s%-32s", "registration_numbers_for_cars_with_colour",
            "Fetches all Registration numbers for given color" + "One String Argument" ) + "\n";
        String slot_numbers_for_cars_with_colour = String.format(
            "%-64s%-32s", "slot_numbers_for_cars_with_colour",
            "Fetches all slot numbers for given color" + "One String Argument" ) + "\n";
        String slot_number_for_registration_number = String.format(
            "%-64s%-32s", "slot_number_for_registration_number",
            "Fetches slot number for given Registration Number" + "One String Argument" ) + "\n";
        String status =
            String.format( "%-64s%-32s", "status", "Shows Current status of the lot" ) + "\n";
        System.out.println(
            title + create_parking_lot + park + leave + registration_numbers_for_cars_with_colour +
                slot_number_for_registration_number + slot_numbers_for_cars_with_colour + status );
    }


    private void processStatus( List<String> commandAndArgumentList )
    {
        if( checkIfParkingLotIsDefined() && checkArgumentSize( commandAndArgumentList.size(), 1 ) )
        {
            System.out.println( plot.printStatus() );
        }

    }


    private void processGetSlotNumberForRegNumCommand( List<String> commandAndArgumentList )
    {
        if( checkIfParkingLotIsDefined() && checkArgumentSize( commandAndArgumentList.size(), 2 ) )
        {

            System.out.println( plot.getAllocatedSlotNumber( commandAndArgumentList.get( 1 ) ) );
        }
    }


    private void processSlotWithColorCommand( List<String> commandAndArgumentList )
    {
        if( checkIfParkingLotIsDefined() && checkArgumentSize( commandAndArgumentList.size(), 2 ) )
        {

            System.out
                .println( plot.printAllSlotWithGivenColor( commandAndArgumentList.get( 1 ) ) );
        }
    }


    private void processRegNumsWithColorCommand( List<String> commandAndArgumentList )
    {
        if( checkIfParkingLotIsDefined() && checkArgumentSize( commandAndArgumentList.size(), 2 ) )
        {
            System.out
                .println( plot.printAllRegNumWithGivenColor( commandAndArgumentList.get( 1 ) ) );
        }

    }


    private void processLeaveCommand( List<String> commandAndArgumentList )
    {
        int size = commandAndArgumentList.size();
        if( checkArgumentSize( size, 2 ) && checkIfParkingLotIsDefined() )
        {

            int slot;
            try
            {
                slot = Integer.parseInt( commandAndArgumentList.get( 1 ) );
                System.out.println( plot.deAllocateParkingSpot( slot ) );
            }
            catch( NumberFormatException e )
            {
                System.out.println( "Illegal argument passed. Slot should be a number" );
                return;
            }
        }
    }


    private boolean checkArgumentSize( int size, int expectedSize )
    {
        if( size != expectedSize )
        {

            System.out
                .println( "Illegal number of arguments. Please see option -help for more details" );
            return false;
        }
        return true;
    }


    private void processParkCommand( List<String> commandAndArgumentList )
    {
        if( checkArgumentSize( commandAndArgumentList.size(), 3 ) && checkIfParkingLotIsDefined() )
        {
            System.out.println(
                plot.allocateAParkingSpot(
                    commandAndArgumentList.get( 1 ), commandAndArgumentList.get( 2 ) ) );
        }
    }


    private boolean checkIfParkingLotIsDefined()
    {
        if( null == plot )
        {
            System.out
                .println( "ParkingLot not defined. Please see option -help for more details." );
            return false;
        }
        return true;
    }


    private void processCreateParkingLotCommand( List<String> commandAndArgumentList )
    {
        if( !checkArgumentSize( commandAndArgumentList.size(), 2 ) )
        {
            return;
        }

        String slotSize = commandAndArgumentList.get( 1 );
        try
        {

            int size = Integer.parseInt( slotSize );
            if( size < 1 )
            {

                System.out
                    .println( "Slot size should be a integer greater than 0. Please try again" );
                return;
            }
            plot = new ParkingLot( size );

        }
        catch( NumberFormatException e )
        {
            System.out.println(
                "Slot size should be a integer. Please see option -help for more details" );
            return;
        }

        System.out.println( "Created a parking lot with " + slotSize + " slots" );

    }

}
