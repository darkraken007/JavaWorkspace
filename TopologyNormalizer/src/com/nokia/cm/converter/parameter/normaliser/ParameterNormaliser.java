package com.nokia.cm.converter.parameter.normaliser;

import java.io.File;
import java.util.Collections;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import com.base.topology.model.MOClassList;
import com.base.topology.model.compare.ManagedObjectComparator;
import com.base.topology.model.compare.ParameterComparator;
import com.nokia.cm.converter.parameter.dto.ManagedObject;
import com.nokia.cm.converter.parameter.dto.Pdmeta;

public class ParameterNormaliser {



	public ParameterNormaliser() throws JAXBException{

	}

	public void processPdmeta(String fileName, File dir,Pdmeta pdmeta) throws JAXBException {
		for(ManagedObject mo:pdmeta.getManagedObject()){
			Collections.sort(mo.getP(),new ParameterComparator());
		}
		Collections.sort(pdmeta.getManagedObject(), new ManagedObjectComparator());
		writeParamsFile(fileName,dir,pdmeta);
	}

	public void writeParamsFile(String fileName, File dir, Pdmeta pdmeta) throws JAXBException {
		JAXBContext jaxbContextTopology = JAXBContext.newInstance(Pdmeta.class);
		Marshaller topologyMarshaller = jaxbContextTopology.createMarshaller();
		topologyMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		topologyMarshaller.marshal(pdmeta, createOutputFile(dir, fileName));
		
	}

	private File createOutputFile(File dir, String dirName) {
        File outputdir = new File( dir, dirName );
        if( !outputdir.exists() )
        {
            outputdir.mkdir();
        }
        File fileName = new File( outputdir, dirName+".xml" );
        return fileName;
	}
}
