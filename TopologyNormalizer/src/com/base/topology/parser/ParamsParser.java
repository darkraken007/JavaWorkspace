package com.base.topology.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.nokia.cm.converter.parameter.dto.Pdmeta;

public class ParamsParser {

	public Pdmeta loadParamsFile(File dir, String fileName){
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance( Pdmeta.class );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File paramsFilePath = new File( dir + File.separator + fileName + ".xml" );
            Pdmeta object = (Pdmeta)(unmarshaller
                .unmarshal( new File( paramsFilePath.getAbsolutePath() ) ));
            return object;
        }
        catch( JAXBException e )
        {
            throw new RuntimeException( e );
        }
	}
}
