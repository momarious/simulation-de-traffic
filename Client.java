import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.ut.Vehicle;

public class Client {

	public static void main(String[] args)  throws IOException, InterruptedException {
		Socket socket = new Socket("localhost", 7777);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	
		// Scanner sc = new Scanner(System.in);
		// int cpt = 0;

		// while (cpt != 4) {
			//
			// System.out.println("Carrefour d'entree: ");
			// String dir = sc.nextLine();
			// Direction direction = Direction.get(Integer.parseInt(dir));

			// System.out.println("La duree minimum: ");
			// String dureeMin = sc.nextLine();
			String min = "6";

			// System.out.println("La duree maximum: ");
			// String dureeMax = sc.nextLine();
			String max = "8";

			Vehicle v1 = new Vehicle();
			v1.setRandomTime(Integer.parseInt(max), Integer.parseInt(min));
			v1.setDirection("LEFT");
			System.out.println(v1 + " est envoyé au server");
			objectOutputStream.writeObject(v1);
			Thread.sleep(3000);


			Vehicle v2 = new Vehicle();
			v2.setRandomTime(Integer.parseInt(max), Integer.parseInt(min));
			v2.setDirection("RIGHT");
			System.out.println(v2 + " est envoyé au server");
			objectOutputStream.writeObject(v2);
			Thread.sleep(3000);

			Vehicle v3 = new Vehicle();
			v3.setRandomTime(Integer.parseInt(max), Integer.parseInt(min));
			v3.setDirection("RIGHT");
			System.out.println(v3 + " est envoyé au server");
			objectOutputStream.writeObject(v3);
			Thread.sleep(2000);

			Vehicle v4 = new Vehicle();
			v4.setRandomTime(Integer.parseInt(max), Integer.parseInt(min));
			v4.setDirection("LEFT");
			System.out.println(v4 + " est envoyé au server");
			objectOutputStream.writeObject(v4);
			Thread.sleep(8000);

			Vehicle v5 = new Vehicle();
			v5.setRandomTime(Integer.parseInt(max), Integer.parseInt(min));
			v5.setDirection("LEFT");
			System.out.println(v5 + " est envoyé au server");
			objectOutputStream.writeObject(v5);
			Thread.sleep(9000);

			Vehicle v6 = new Vehicle();
			v6.setRandomTime(Integer.parseInt(max), Integer.parseInt(min));
			v6.setDirection("RIGHT");
			System.out.println(v6 + " est envoyé au server");
			objectOutputStream.writeObject(v6);
			Thread.sleep(9000);

		// 	cpt++;
		// }

		objectOutputStream.close();
		socket.close();

	}
}
