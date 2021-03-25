package com.ut;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carrefour {

	private String name;
	private List<Route> listRoutes;

	public Carrefour(String name) {
		this.name = name;
		this.listRoutes = new ArrayList<Route>();
	}

	public void addRoute(Route e) {
		this.listRoutes.add(e);
	}

	public int getNbRoutes() {
		return listRoutes.size() - 1;
	}

	public Route getRandomRoute() {
		Random r = new Random();
		Route randomRoute = null;
		int randomInt = 0;
		do {
			randomInt = r.nextInt(getNbRoutes());
			randomRoute = listRoutes.get(randomInt + 1);
		} while (randomRoute.getName().equals("Segment etroit") || !randomRoute.estLibre());
		randomRoute.occuper();
		return randomRoute;
	}

	@Override
	public String toString() {
		return "Carrefour [name=" + name + ", listRoutes=" + listRoutes + "]";
	}



	public String getName() {
		return name;
	}

}
