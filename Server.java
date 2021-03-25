import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.ut.Carrefour;
import com.ut.Route;
import com.ut.Segment;
import com.ut.Vehicle;
import com.ut.Manager;

public class Server {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

        // System.out.println("Saisir le nombre de route du carrefour de droite: ");
        // int nbRouteAtRight = sc.nextInt();
        int nbRouteAtRight = 5;

        // System.out.println("Saisir le nombre de route du carrefour de gauche: ");
        // int nbRouteAtLeft = sc.nextInt();
        int nbRouteAtLeft = 5;

		Segment segment = new Segment("Segment etroit");

        Carrefour leftRoundAbouts = new Carrefour("Ronds-points du côté gauche");
        for (int i = 0; i < nbRouteAtLeft; i++) {
            leftRoundAbouts.addRoute(new Route("Route gauche " + i));
        }
        leftRoundAbouts.addRoute(segment);

		Carrefour rightRoundAbouts = new Carrefour("Ronds-points du côté droit");
        for (int i = 0; i < nbRouteAtRight; i++) {
            rightRoundAbouts.addRoute(new Route("Route droite " + i));
		}
        rightRoundAbouts.addRoute(segment);

		Manager manager = new Manager(segment);

		ServerSocket listener = new ServerSocket(7777);
		System.out.println("(SERVER) Waiting for client connection...");
		Socket clientSocket = listener.accept();
		System.out.println("(SERVER) Client connected !");

		InputStream inputStream = clientSocket.getInputStream();
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

		Vehicle v = null;
		try {
			while (true) {
				Object object = objectInputStream.readObject();
				if (object instanceof Vehicle) {
					v = (Vehicle) object;
					v.setRoute(rightRoundAbouts, leftRoundAbouts);
					v.setManager(manager);
					v.start();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		// System.out.println("end of ...");
	}

}
