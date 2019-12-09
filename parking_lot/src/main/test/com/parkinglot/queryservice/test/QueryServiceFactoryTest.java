package com.parkinglot.queryservice.test;

import org.junit.Assert;
import org.junit.Test;

import com.parkinglot.queryservice.QueryServiceFactory;
import com.parkinglot.queryservice.RegNumberQueryService;
import com.parkinglot.queryservice.SlotQueryService;


public class QueryServiceFactoryTest
{

    @Test
    public void regNumQueryServiceInstanceTest()
    {

        Assert.assertTrue(
            new QueryServiceFactory().getQuerySevice(
                QueryServiceFactory.REGISTER_NUMBER ) instanceof RegNumberQueryService );
    }


    @Test
    public void slotQueryServiceInstanceTest()
    {

        Assert.assertTrue(
            new QueryServiceFactory()
                .getQuerySevice( QueryServiceFactory.SLOT ) instanceof SlotQueryService );
    }


    @Test
    public void IllegalQueryServiceInstanceExceptionMessageTest()
    {
        try
        {
            new QueryServiceFactory().getQuerySevice( "acd" );
        }
        catch( IllegalArgumentException e )
        {
            Assert
                .assertTrue( "QueryService of this type not registered".equals( e.getMessage() ) );
        }
    }


    @Test( expected = IllegalArgumentException.class )
    public void IllegalQueryServiceInstanceExceptionTest()
    {

        new QueryServiceFactory().getQuerySevice( "acd" );

    }


    @Test
    public void persistenceOfRegNumQueryServiceInstances()
    {

        QueryServiceFactory qFactory = new QueryServiceFactory();
        Assert.assertEquals(
            qFactory.getQuerySevice( QueryServiceFactory.REGISTER_NUMBER ),
            qFactory.getQuerySevice( QueryServiceFactory.REGISTER_NUMBER ) );
    }


    @Test
    public void persistenceOfSlotQueryServiceInstances()
    {

        QueryServiceFactory qFactory = new QueryServiceFactory();
        Assert.assertEquals(
            qFactory.getQuerySevice( QueryServiceFactory.SLOT ),
            qFactory.getQuerySevice( QueryServiceFactory.SLOT ) );
    }
}
