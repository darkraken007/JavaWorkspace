package com.parkinglot.dto;

public class Cars
{
    String regNo;
    String color;
    String slot;


    public Cars( String regNo, String color, String slot )
    {
        super();
        this.regNo = regNo;
        this.color = color;
        this.slot = slot;
    }


    public String getSlot()
    {
        return slot;
    }


    public String getRegNo()
    {
        return regNo;
    }


    public String getColor()
    {
        return color;
    }

}
