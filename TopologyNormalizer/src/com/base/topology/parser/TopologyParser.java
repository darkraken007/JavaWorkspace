package com.base.topology.parser;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.base.topology.model.MOClassList;


public class TopologyParser {

    public static MOClassList loadModelHierarchy( File dir, String fileName )
    {
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance( MOClassList.class );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File topologyXMLFilePath = new File( dir + File.separator + fileName + ".xml" );
            MOClassList object = (MOClassList)(unmarshaller
                .unmarshal( new File( topologyXMLFilePath.getAbsolutePath() ) ));
            return object;
        }
        catch( JAXBException e )
        {
            throw new RuntimeException( e );
        }
    }
}
