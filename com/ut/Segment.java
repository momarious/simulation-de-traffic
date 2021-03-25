package com.ut;

import java.util.ArrayList;
import java.util.List;

public class Segment extends Route {

	private Direction direction;
	private static List<Vehicle> vehicles = new ArrayList<Vehicle>() ;

	public Segment(String name) {
		super(name);
	}

	public void setTrafficDirection(Direction direction) {
		this.direction  = direction;
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	public void removeVehicle(int i) {
		this.vehicles.remove(i);
	}

	public int trafficSize() {
		return this.vehicles.size();
	}

	public Direction trafficDirection() {
		return this.direction;
	}
	
	
	public Vehicle getVehicule(int index) {
		return this.vehicles.get(index);
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

}
