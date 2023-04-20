import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Main
{
	public static void main(String[] args) {
		Body body = new Body();
		Cockpit cockpit = new Cockpit();
		Wings wing = new Wings();
		Tail tail = new Tail();
		Landingear landingear = new Landingear();
		JavaCSG csg;




		csg = JavaCSGFactory.createDefault();

		var airplane1 = csg.union3D(body.PlaneBody(), cockpit.Cockpit());
		var airplane = csg.union3D(airplane1, tail.AirplaneTail());
		var airplaneWings = csg.union3D(wing.LeftWing(), wing.rightWing());
		var finalAirplane = csg.union3D(airplane, airplaneWings);

		csg.view(finalAirplane);

	}
}
