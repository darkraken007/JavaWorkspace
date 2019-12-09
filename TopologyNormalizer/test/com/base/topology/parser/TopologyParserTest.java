package com.base.topology.parser;

import java.io.File;

import com.base.topology.model.MOClassList;


public class TopologyParserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologyParser topologyParser = new TopologyParser();
		final File dir = new File("D:\\SourceCodes\\SBC\\Tools\\TopologyNormalizer\\Topology\\");
		
		MOClassList moClassList = topologyParser.loadModelHierarchy(dir, "topologyVMGW");
	}

}
