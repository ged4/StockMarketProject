package org.cabr.stockmarket.utils;

public class Quotes {

	private String symbol;
	private Double opening;
	private Double closing;
	private Double minimal;
	private Double maximal;
	private Double volumen;
	
	public String getSymbol() {
		return symbol;
	}
	public Double getOpening() {
		return opening;
	}
	public Double getClosing() {
		return closing;
	}
	public Double getMinimal() {
		return minimal;
	}
	public Double getMaximal() {
		return maximal;
	}
	public Double getVolumen() {
		return volumen;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public void setOpening(Double opening) {
		this.opening = opening;
	}
	public void setClosing(Double closing) {
		this.closing = closing;
	}
	public void setMinimal(Double minimal) {
		this.minimal = minimal;
	}
	public void setMaximal(Double maximal) {
		this.maximal = maximal;
	}
	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}	
	
}
