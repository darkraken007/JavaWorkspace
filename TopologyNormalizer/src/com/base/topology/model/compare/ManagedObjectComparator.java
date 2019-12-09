package com.base.topology.model.compare;

import java.util.Comparator;

import com.nokia.cm.converter.parameter.dto.ManagedObject;

public class ManagedObjectComparator implements Comparator<ManagedObject> {

	@Override
	public int compare(ManagedObject o1, ManagedObject o2) {
		return o1.getClazz().compareTo(o2.getClazz());
	}

}
