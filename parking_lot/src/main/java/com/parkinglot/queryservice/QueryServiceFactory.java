package com.parkinglot.queryservice;

public class QueryServiceFactory
{
    public static final String SLOT = "slot";
    public static final String REGISTER_NUMBER = "registerNumber";
    private CarQueryService regNumberQueryService;
    private CarQueryService slotQueryService;


    public CarQueryService getQuerySevice( String type )
    {

        if( type.equals( REGISTER_NUMBER ) )
        {

            return getRegisterNumberQueryService();
        }
        else if( type.equals( SLOT ) )
        {
            return getSlotQueryService();
        }
        throw new IllegalArgumentException( "QueryService of this type not registered" );
    }


    private CarQueryService getRegisterNumberQueryService()
    {
        if( null == regNumberQueryService )
        {
            regNumberQueryService = new RegNumberQueryService();
        }

        return regNumberQueryService;
    }


    private CarQueryService getSlotQueryService()
    {
        if( null == slotQueryService )
        {

            slotQueryService = new SlotQueryService();
            ;
        }

        return slotQueryService;
    }
}
