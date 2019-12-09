package com.base.topology.normaliser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.base.topology.model.MOClassList;
import com.base.topology.parser.TopologyParser;

public class TopologyNormaliserTest {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub

		List<Integer> abcd = new ArrayList<Integer>();
		int a =10;
		abcd.add(a);
		a--;
		System.out.println(abcd.get(0));
		

	}

}
