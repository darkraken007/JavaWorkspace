package com.base.topology.normaliser;

import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.base.topology.model.MOClass;
import com.base.topology.model.MOClassList;
import com.base.topology.model.compare.MOClassNameComparator;

public class ToploligyNormaliser {

	private MOClassList normalisedMOClasslist = new MOClassList();
	
	public MOClassList topologyNormaliser(MOClassList moClassList){
		processMOClass(moClassList.getMOClass());
		
		return moClassList;
	}

	private void processMOClass(MOClass rootMO) {
		if(null != rootMO.getMOClass()){
			for(int i=0; i<rootMO.getMOClass().size();i++){
				processMOClass(rootMO.getMOClass().get(i));
			}
			Collections.sort(rootMO.getMOClass(), new MOClassNameComparator());
		}
	}
	
	
	public void writeNormalisedTopology(MOClassList normalisedClassListNew, File dir, String fileName) throws JAXBException{
		JAXBContext jaxbContextTopology = JAXBContext.newInstance(MOClassList.class);
		Marshaller topologyMarshaller = jaxbContextTopology.createMarshaller();
		topologyMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		topologyMarshaller.marshal(normalisedClassListNew, createOutputFile(dir, fileName));
	}
	
    private File createOutputFile( final File dir, String dirName )
    {
        File outputdir = new File( dir, dirName );
        if( !outputdir.exists() )
        {
            outputdir.mkdir();
        }
        File fileName = new File( outputdir, dirName+".xml" );
        return fileName;
    }
}
