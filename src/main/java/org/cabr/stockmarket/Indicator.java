package org.cabr.stockmarket;

import java.util.Date;
import java.util.HashMap;

import org.cabr.stockmarket.utils.Interval;
import org.cabr.stockmarket.utils.Quotes;

public abstract class Indicator {
	
	protected HashMap<Date, Quotes> ralliesValues;
	
	public abstract HashMap<Date, Double> generateIndicatorValues(Date start, Date end, String symbol, Interval interval);
	public abstract HashMap<Date, Double> updateIndicatorValues(Date start, Date end, String symbol, Interval interval);
	
	
	
	
	protected void getValuesForSymbol(Date start, Date end, String symbol) {
		ralliesValues = downloadValues(start, end, symbol);
		
	}
	
	protected int countNumberOfValues(Date start, Date end, Interval interval) {
		//TO-DO Create query to database and extract number of entries between provided dates		
		return 0;
	}
	
	
	private HashMap<Date, Quotes> downloadValues(Date start, Date end,
			String symbol) {
		//TO-DO Create connection to database and extract values;
		return null;
	}
	
}
