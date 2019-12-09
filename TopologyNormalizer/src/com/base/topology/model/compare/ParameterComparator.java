package com.base.topology.model.compare;

import java.util.Comparator;

import com.nokia.cm.converter.parameter.dto.P;

public class ParameterComparator implements Comparator<P> {

	@Override
	public int compare(P o1, P o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
