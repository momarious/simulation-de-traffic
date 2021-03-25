package com.ut;

import java.io.Serializable;
import java.util.List;

public class Vehicle extends Thread implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static Manager manager;
	private Thread timer = null;
	private Route currentRoute;
	private int time;
	private Direction direction;

	@Override
	public void run() {
		manager.acceder(this);
		// occuper();
		occuper(manager.getSegment().getVehicles());
		manager.liberer(this);
	}

	@Override
	public synchronized void start() {
		if (timer == null) {
			timer = new Thread(this);
			timer.start();
		}
	}

	public void occuper(List<Vehicle> listVehicles) {
		// for (Vehicle vehicle : listVehicles) {
		// 	System.out.print("v" + vehicle.getId() + "[" + vehicle.getTime() + "s] - ");
		// }
		try {
			while (this.time > 0) {

				// System.out.print("v" + this.getId() + " " + this.time + "s restants");
			System.out.print("v" + this.getId() + "[" + this.getTime() + "s]  -- ");

				sleep(1000);
				this.time--;
			}
			System.out.println("\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void occuper() {
		try {
			while (this.time > 0) {
				System.out.println("v" + this.getId() + " " + this.time + "s restants");
				sleep(1000);
				this.time--;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = Direction.valueOf(direction);
	}

	public void setManager(Manager manager) {
		Vehicle.manager = manager;
	}

	public int getTime() {
		return this.time;
	}

	public void setRandomTime(int max, int min) {
		this.time = max - (int) Math.round(Math.random() * (max - min));
	}

	public void setRoute(Route route) {
		this.currentRoute = route;
	}

	public void setRoute(Carrefour cd, Carrefour cg) {
		this.currentRoute = direction.equals(Direction.RIGHT) ? cg.getRandomRoute() : cd.getRandomRoute();
	}

	@Override
	public String toString() {
		return "v" + this.getId() + " [" + this.direction + " currentRoute=" + currentRoute + ", duree=" + time + "]";
	}

}
