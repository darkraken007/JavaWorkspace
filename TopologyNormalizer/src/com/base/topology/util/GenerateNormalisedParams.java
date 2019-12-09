package com.base.topology.util;

import java.io.File;

import javax.xml.bind.JAXBException;

import com.base.topology.parser.ParamsParser;
import com.nokia.cm.converter.parameter.dto.Pdmeta;
import com.nokia.cm.converter.parameter.normaliser.ParameterNormaliser;

public class GenerateNormalisedParams {

	public static void main(String[] args) throws JAXBException {
		ParamsParser tp = new ParamsParser();
		File dir = new File(args[0]);
		Pdmeta paramsOld = tp.loadParamsFile(dir, args[1]);
		Pdmeta paramsNew = tp.loadParamsFile(dir, args[2]);
		ParameterNormaliser tn = new ParameterNormaliser();
		tn.processPdmeta("params_old", dir, paramsOld);
		tn.processPdmeta("params_new", dir, paramsNew);
		
	}

}
