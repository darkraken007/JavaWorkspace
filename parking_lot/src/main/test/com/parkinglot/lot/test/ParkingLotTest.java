package com.parkinglot.lot.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.parkinglot.lot.ParkingLot;


public class ParkingLotTest
{

    ParkingLot plot;

    String status =
        "Slot No.                        Registration No                 Colour                          \n" +
            "3                               KA 17 EJ 7713                   yellow                          \n" +
            "2                               KA 17 EJ 7712                   red                             \n" +
            "13                              KA 17 EJ 7723                   red                             \n" +
            "5                               KA 17 EJ 7715                   yellow                          \n" +
            "4                               KA 17 EJ 7714                   pink                            \n" +
            "10                              KA 17 EJ 7720                   pink                            \n" +
            "1                               KA 17 EJ 7711                   green                           \n" +
            "12                              KA 17 EJ 7722                   white                           \n" +
            "11                              KA 17 EJ 7721                   yellow                          \n" +
            "7                               KA 17 EJ 7717                   red                             \n" +
            "6                               KA 17 EJ 7716                   white                           \n" +
            "9                               KA 17 EJ 7719                   yellow                          \n" +
            "8                               KA 17 EJ 7718                   red                             \n";


    @Before
    public void setUp()
    {
        plot = new ParkingLot( 14 );
        System.out.println( plot.allocateAParkingSpot( "KA 17 EJ 7711", "green" ) );
        plot.allocateAParkingSpot( "KA 17 EJ 7712", "red" );
        plot.allocateAParkingSpot( "KA 17 EJ 7713", "yellow" );
        plot.allocateAParkingSpot( "KA 17 EJ 7714", "pink" );
        plot.allocateAParkingSpot( "KA 17 EJ 7715", "yellow" );
        plot.allocateAParkingSpot( "KA 17 EJ 7716", "white" );
        System.out.println( plot.allocateAParkingSpot( "KA 17 EJ 7717", "red" ) );
        plot.allocateAParkingSpot( "KA 17 EJ 7718", "red" );
        plot.allocateAParkingSpot( "KA 17 EJ 7719", "yellow" );
        plot.allocateAParkingSpot( "KA 17 EJ 7720", "pink" );
        plot.allocateAParkingSpot( "KA 17 EJ 7721", "yellow" );
        plot.allocateAParkingSpot( "KA 17 EJ 7722", "white" );
        plot.allocateAParkingSpot( "KA 17 EJ 7723", "red" );
    }


    @Test
    public void allocateParkingSpotTest()
    {

        Assert.assertTrue(
            "Allocated slot number: 14"
                .equals( plot.allocateAParkingSpot( "KA 17 EJ 1121", "blue green" ) ) );
    }


    @Test( expected = IllegalArgumentException.class )
    public void testParkingLotCreationWhenSlotis0()
    {

        new ParkingLot( 0 );
    }


    @Test( expected = IllegalArgumentException.class )
    public void testParkingLotCreationWhenSlotisLessThan0()
    {

        new ParkingLot( -1 );
    }


    @Test
    public void allocateOnFullSlotTest()
    {
        plot.allocateAParkingSpot( "KA 17 EJ 1121", "blue green" );
        plot.allocateAParkingSpot( "KA 17 EJ 1134", "blue green" );
        Assert.assertTrue(
            "Sorry, parking lot is full"
                .equals( plot.allocateAParkingSpot( "KA 17 EJ 1134", "blue green" ) ) );
    }


    @Test
    public void allocateForAlreadyAllocatedRegNumTest()
    {
        plot.allocateAParkingSpot( "KA 17 EJ 1121", "blue green" );
        plot.allocateAParkingSpot( "KA 17 EJ 1134", "blue green" );
        Assert.assertTrue(
            "Slot already alloted for given Registration Number"
                .equals( plot.allocateAParkingSpot( "KA 17 EJ 1121", "blue green" ) ) );
    }


    @Test
    public void deAllocateThenAllocateWhenFullTest()
    {
        plot.allocateAParkingSpot( "KA 17 EJ 1121", "blue green" );
        plot.deAllocateParkingSpot( 4 );
        Assert.assertTrue(
            "Allocated slot number: 4"
                .equals( plot.allocateAParkingSpot( "KA 17 EJ 1166", "blue green" ) ) );
    }


    @Test
    public void DeAllocateTest()
    {
        plot.allocateAParkingSpot( "KA 17 EJ 1121", "blue green" );
        Assert.assertTrue( "Slot number 4 is free".equals( plot.deAllocateParkingSpot( 4 ) ) );
    }


    @Test
    public void DeAllocateOnEmptySlotTest()
    {
        plot.allocateAParkingSpot( "KA 17 EJ 1121", "blue green" );
        plot.deAllocateParkingSpot( 4 );
        Assert.assertTrue( "Not Found".equals( plot.deAllocateParkingSpot( 4 ) ) );
    }


    @Test
    public void DeAllocateOnEmptyLotTest()
    {
        ParkingLot newLot = new ParkingLot( 8 );
        Assert.assertTrue( "Not Found".equals( newLot.deAllocateParkingSpot( 4 ) ) );
    }


    @Test
    public void getAllocatedSlotNumberTest()
    {

        Assert.assertTrue( "8".equals( plot.getAllocatedSlotNumber( "KA 17 EJ 7718" ) ) );
    }


    @Test
    public void getAllocatedSlotNumberWhenPLotIsEmptyTest()
    {
        ParkingLot newLot = new ParkingLot( 8 );
        Assert.assertTrue( "Not Found".equals( newLot.getAllocatedSlotNumber( "KA 17 EJ 7718" ) ) );
    }


    @Test
    public void getAllocatedSlotNumberWhenFullThenRemovedThenAddedTest()
    {
        plot.allocateAParkingSpot( "KA 17 EJ 1121", "blue green" );
        System.out.println( plot.allocateAParkingSpot( "KA 17 EJ 1134", "blue green" ) );
        plot.deAllocateParkingSpot( 5 );
        plot.allocateAParkingSpot( "KA 17 EJ 1136", "blue green" );
        Assert.assertTrue( "5".equals( plot.getAllocatedSlotNumber( "KA 17 EJ 1136" ) ) );
    }


    @Test
    public void printAllRegNoForaGivenColorTest()
    {
        Assert.assertTrue(
            "KA 17 EJ 7713,KA 17 EJ 7715,KA 17 EJ 7721,KA 17 EJ 7719"
                .equals( plot.printAllRegNumWithGivenColor( "yellow" ) ) );
    }


    @Test
    public void printAllRegNoForaGivenColorWhenLotIsEmptyTest()
    {
        ParkingLot newLot = new ParkingLot( 8 );
        Assert.assertTrue( "".equals( newLot.printAllRegNumWithGivenColor( "yellow" ) ) );
    }


    @Test
    public void printAllSlotNoForaGivenColorTest()
    {
        Assert.assertTrue( "3,5,11,9".equals( plot.printAllSlotWithGivenColor( "yellow" ) ) );
    }


    @Test
    public void printAllSlotForaGivenColorWhenLotIsEmptyTest()
    {
        ParkingLot newLot = new ParkingLot( 8 );
        Assert.assertTrue( "".equals( newLot.printAllSlotWithGivenColor( "yellow" ) ) );
    }


    @Test
    public void printStatusTest()
    {

        Assert.assertTrue( status.equals( plot.printStatus() ) );
    }


    @Test
    public void driverTest()
    {

        ParkingLot new_plot = new ParkingLot( 6 );
        System.out.println( new_plot.allocateAParkingSpot( "KA 17 EJ 7711", "green" ) );
        new_plot.allocateAParkingSpot( "KA 17 EJ 7712", "red" );
        new_plot.allocateAParkingSpot( "KA 17 EJ 7713", "yellow" );
        new_plot.allocateAParkingSpot( "KA 17 EJ 7714", "pink" );
        new_plot.allocateAParkingSpot( "KA 17 EJ 7715", "yellow" );
        new_plot.allocateAParkingSpot( "KA 17 EJ 7716", "white" );
        System.out.println( new_plot.deAllocateParkingSpot( 4 ) );
        System.out.println( new_plot.allocateAParkingSpot( "KA 17 EJ 7756", "white" ) );
        System.out.println( new_plot.allocateAParkingSpot( "KA 17 EJ 7788", "white" ) );
    }

}
