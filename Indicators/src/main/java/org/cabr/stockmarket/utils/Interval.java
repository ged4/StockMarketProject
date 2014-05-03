package org.cabr.stockmarket.utils;

public enum Interval {

	MONTH(1),
	WEEK(2),
	DAY(3),
	BIHOUR(4),
	HOUR(5),
	TWENTYMINUTES(6),
	FIVEMINUTES(7),
	MINUTE(8);
	
	int value;
	
	private Interval(int value){
		this.value = value;
	}
	
}
