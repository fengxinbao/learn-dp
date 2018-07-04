package com.feng.designpatterns.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{
	private float temperature;
	private float humidity;
	private float pressure;
	private Subject subject;
	
	public CurrentConditionsDisplay(Subject subject){
		this.subject = subject;
		subject.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Current conditions: " + temperature 
				+ "F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}
