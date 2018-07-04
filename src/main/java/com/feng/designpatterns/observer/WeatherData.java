package com.feng.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private float tempreture;
	private float humidity;
	private float pressure;
	List<Observer> observers;

	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(tempreture, humidity, pressure);
		}
	}

	public void setMeasurements(float tempreture, float humidity, float pressure) {
		this.tempreture = tempreture;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObservers();
	}
}
