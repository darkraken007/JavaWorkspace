package com.base.topology.model.compare;

import java.util.Comparator;

import com.base.topology.model.MOClass;

public class MOClassNameComparator implements Comparator<MOClass> {

	@Override
	public int compare(MOClass o1, MOClass o2) {
		// TODO Auto-generated method stub
		return o1.getAbbrName().compareTo(o2.getAbbrName());
		
	}

}
