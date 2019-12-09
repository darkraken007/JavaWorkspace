package com.base.topology.util;

import java.io.File;

import javax.xml.bind.JAXBException;

import com.base.topology.model.MOClassList;
import com.base.topology.normaliser.ToploligyNormaliser;
import com.base.topology.parser.TopologyParser;

public class GenerateNormalisedTopology {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub

		TopologyParser tp = new TopologyParser();
		File dir = new File(args[0]);
		MOClassList moClassListOld = tp.loadModelHierarchy(dir, args[1]);
		MOClassList moClassListNew = tp.loadModelHierarchy(dir, args[2]);
		ToploligyNormaliser tn = new ToploligyNormaliser();
		MOClassList normalisedClassListOld = tn.topologyNormaliser(moClassListOld);
		MOClassList normalisedClassListNew = tn.topologyNormaliser(moClassListNew);
		
		tn.writeNormalisedTopology(normalisedClassListNew, dir, "topology_new");
		tn.writeNormalisedTopology(normalisedClassListOld, dir, "topology_old");
		

	}
}
