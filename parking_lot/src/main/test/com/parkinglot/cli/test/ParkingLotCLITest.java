package com.parkinglot.cli.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.parkinglot.cli.ParkingLotCLI;

import org.junit.Assert;
import org.junit.Ignore;


public class ParkingLotCLITest
{

    String input = "create_parking_lot 6\n" + "park KA-01-HH-1234 White\n" +
        "park KA-01-HH-9999 White\n" + "park KA-01-BB-0001 Black\n" + "park KA-01-HH-7777 Red\n" +
        "park KA-01-HH-2701 Blue\n" + "park KA-01-HH-3141 Black\n" + "leave 4\n" + "status\n" +
        "park KA-01-P-333 White\n" + "park DL-12-AA-9999 White\n" +
        "registration_numbers_for_cars_with_colour White\n" +
        "slot_numbers_for_cars_with_colour White\n" +
        "slot_number_for_registration_number KA-01-HH-3141\n" +
        "slot_number_for_registration_number MH-04-AY-1111\n";

    String expected = "Created a parking lot with 6 slots\n" + "Allocated slot number: 1\n" +
        "Allocated slot number: 2\n" + "Allocated slot number: 3\n" + "Allocated slot number: 4\n" +
        "Allocated slot number: 5\n" + "Allocated slot number: 6\n" + "Slot number 4 is free\n" +
        "Slot No.                        Registration No                 Colour                          \n" +
        "6                               KA-01-HH-3141                   Black                           \n" +
        "1                               KA-01-HH-1234                   White                           \n" +
        "3                               KA-01-BB-0001                   Black                           \n" +
        "5                               KA-01-HH-2701                   Blue                            \n" +
        "2                               KA-01-HH-9999                   White                           \n" +
        "Allocated slot number: 4\n" + "Sorry, parking lot is full\n" +
        "KA-01-HH-1234,KA-01-HH-9999,KA-01-P-333\n" + "1,2,4\n" + "6\n" + "Not Found\n";
    PrintStream console;


    private void setOutputToStream( ByteArrayOutputStream baos )
    {

        PrintStream o = new PrintStream( baos );
        console = System.out;
        System.setOut( o );

    }


    private void setOuputToConsole()
    {

        System.out.flush();
        System.setOut( console );
    }


    @Test
    public void singleCommandTest() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        setOutputToStream( baos );
        ParkingLotCLI.processASingleCommand( "create_parking_lot 6" );
        setOuputToConsole();
        String output = baos.toString();
        Assert.assertTrue( "Created a parking lot with 6 slots".trim().equals( output.trim() ) );
        baos.close();
    }


    @Test
    public void singleCommandWhenSlotSize0Test() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        setOutputToStream( baos );
        ParkingLotCLI.processASingleCommand( "create_parking_lot 0" );
        setOuputToConsole();
        String output = baos.toString();
        Assert.assertTrue(
            "Slot size should be a integer greater than 0. Please try again"
                .trim().equals( output.trim() ) );
        baos.close();
    }


    @Test
    public void singleCommandWhenSlotSizeNotAnIntegerStringTest() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        setOutputToStream( baos );
        ParkingLotCLI.processASingleCommand( "create_parking_lot anbd" );
        setOuputToConsole();
        String output = baos.toString();
        Assert.assertTrue(
            "Slot size should be a integer. Please see option -help for more details"
                .trim().equals( output.trim() ) );
        baos.close();
    }


    @Test
    public void singleCommandParkStringTest() throws IOException
    {
        ParkingLotCLI.processASingleCommand( "create_parking_lot 4" );
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        setOutputToStream( baos );
        ParkingLotCLI.processASingleCommand( "park KA-01-HH-1234 White" );
        setOuputToConsole();
        String output = baos.toString();
        Assert.assertTrue( "Allocated slot number: 1".trim().equals( output.trim() ) );
        baos.close();
    }


    @Test
    public void singleCommandLeaveTest() throws IOException
    {
        ParkingLotCLI.processASingleCommand( "create_parking_lot 4" );
        ParkingLotCLI.processASingleCommand( "park KA-01-HH-1234 White" );
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        setOutputToStream( baos );
        ParkingLotCLI.processASingleCommand( "leave 1" );
        setOuputToConsole();
        String output = baos.toString();
        Assert.assertTrue( "Slot number 1 is free".trim().equals( output.trim() ) );
        baos.close();
    }


    @Test
    public void singleCommandLeaveWhenIllegalSlotnumberTest() throws IOException
    {
        ParkingLotCLI.processASingleCommand( "create_parking_lot 4" );
        ParkingLotCLI.processASingleCommand( "park KA-01-HH-1234 White" );
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        setOutputToStream( baos );
        ParkingLotCLI.processASingleCommand( "leave abcd" );
        setOuputToConsole();
        String output = baos.toString();
        Assert.assertTrue(
            "Illegal argument passed. Slot should be a number".trim().equals( output.trim() ) );
        baos.close();
    }


    @Ignore
    public void commandFileTest() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        setOutputToStream( baos );
        ParkingLotCLI.processFileInput(
            System.getProperty( "user.dir" ) + "\\src\\test\\resources\\input.txt" );
        setOuputToConsole();
        String output = baos.toString();
        Assert.assertTrue( expected.trim().equals( output.trim() ) );

    }

}
