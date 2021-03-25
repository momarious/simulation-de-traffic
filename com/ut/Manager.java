package com.ut;

import java.util.List;

public class Manager extends Thread {

	private Segment segment;

	public Manager(Segment segment) {
		this.segment = segment;
	}

	public synchronized void acceder(Vehicle v) {
		System.out.println("\n" + v);
		// || v.getDirection() != segment.trafficDirection()
		while (segment.trafficSize() != 0 && segment.trafficDirection()  != v.getDirection()) {
			try {
				System.out.println("\n" + "v" + v.getId() + " est en attente active");
				wait();
			} catch (Exception e) {
			}
		}
		segment.addVehicle(v);
		segment.setTrafficDirection(v.getDirection());
		// segment.occuper();
		System.out.println("\n" + "v" + v.getId() + " occupe la ressource pour " + v.getTime() + "s");
	}

	public synchronized void liberer(Vehicle v) {
		segment.liberer();
		segment.removeVehicle(0);
		if (segment.trafficSize() == 0) {
			notifyAll();
		}

		// if (segment.estLibre() && segment.trafficDirection() != v.getDirection()) {
		// 	notifyAll();
		// }
		System.out.println("\n" + "v" + v.getId() + " libere la ressource");
	}

	public Segment getSegment(){
		return segment;
	}

	

}
