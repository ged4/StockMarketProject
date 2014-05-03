package org.cabr.stockmarket;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import org.cabr.stockmarket.utils.Interval;
import org.cabr.stockmarket.utils.Quotes;

public class SimpleMovingAverage extends Indicator {

	private int numberOfValuesToCalculateAverage;
	private HashMap<Date, Double> calculatedAverage = new HashMap<Date,Double>();
	
	public SimpleMovingAverage() {
		numberOfValuesToCalculateAverage = 20;
	}
	
	public SimpleMovingAverage(int numberOfValues) {
		numberOfValuesToCalculateAverage = numberOfValues;
	}
	
	@Override
	public HashMap<Date, Double> generateIndicatorValues(Date start, Date end, String symbol, Interval interval) {
		getValuesForSymbol(start, end, symbol);
		
		Set<Entry<Date, Quotes>> entrySet = ralliesValues.entrySet();		
		Queue<Double> calculationsQueue = new ArrayDeque<Double>();
		
		
		for (Entry<Date,Quotes> entry : entrySet){
			calculationsQueue.add(entry.getValue().getMinimal());			
			if (calculationsQueue.size() == numberOfValuesToCalculateAverage){
				calculatedAverage.put(entry.getKey(), calculateAverage(calculationsQueue));
				calculationsQueue.poll();
			}			
		}
			
		return calculatedAverage;
	}	

	@Override
	public HashMap<Date, Double> updateIndicatorValues(Date start, Date end, String symbol, Interval interval) {
		getValuesForSymbol(start, end, symbol);
		return null;
	}
	
	private Double calculateAverage(Queue<Double> calculationsQueue) {
		Double valueOfCalculation = new Double(0.0);
		for (Double value : calculationsQueue) {
			valueOfCalculation = valueOfCalculation + value;
		}
		return valueOfCalculation/numberOfValuesToCalculateAverage;
		
	}

}
