package com.lux.calculator.logic;

import java.util.Map;

public interface Observable {
	void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Map params);
}
