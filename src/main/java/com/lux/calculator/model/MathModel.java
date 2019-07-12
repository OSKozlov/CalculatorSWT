package com.lux.calculator.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.lux.calculator.listener.MathModelChangeListener;

public class MathModel {
	
	private List<MathModelChangeListener> observers;
	
    private Double firstOperand;
    private Double secondOperand;

    private boolean isOnFlyMode;
    private boolean isPressedBtnCalculate;
    
    private String sign;


	public void registerObserver(MathModelChangeListener o) {
		observers.add(o);
	}

	public void removeObserver(MathModelChangeListener o) {
		observers.remove(o);
	}

	public void notifyObservers(Map params) {
		if (!isValid()) return;
		for(MathModelChangeListener observer : observers) {
			observer.update(params);
		}
	}
	

	public List<MathModelChangeListener> getObservers() {
		return observers;
	}

	
	public double getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(double firstOperand) {
		this.firstOperand = firstOperand;
		notifyObservers(getParams());
	}

	public double getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(double secondOperand) {
		this.secondOperand = secondOperand;
		notifyObservers(getParams());
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
		notifyObservers(getParams());
	}

	public MathModel() {
		observers = new LinkedList<>();
	}
	
	public boolean isOnFlyMode() {
		return isOnFlyMode;
	}

	public void setOnFlyMode(boolean isOnFlyMode) {
		this.isOnFlyMode = isOnFlyMode;
		notifyObservers(getParams());
	}

	public void setPressedBtnCalculate(boolean isPressedBtnCalculate) {
		this.isPressedBtnCalculate = isPressedBtnCalculate;
		notifyObservers(getParams());
	}
	
	private Map getParams() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstOperand", firstOperand);
		map.put("secondOperand", secondOperand);
		map.put("sign", sign);
		map.put("onFlyMode", isOnFlyMode);
		return map;
	}
	
	private boolean isValid() {
		if (firstOperand != null && secondOperand != null && sign != null) { 
			return true;
		} else return false;
	}

}
