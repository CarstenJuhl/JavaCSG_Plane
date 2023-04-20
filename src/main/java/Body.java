import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

import java.util.ArrayList;
import java.util.List;

public class Body {

    JavaCSG csg = JavaCSGFactory.createDefault();
    Geometry3D body = csg.cylinder3D(3000,20000,100,true);
    Geometry3D hollowBody = csg.cylinder3D(2950,19990,100,true);
    Geometry3D doorframe = csg.box3D(1500,1200,600,false);
    Geometry3D door = csg.cylinder3D(1490,100,1790,false);

    public Geometry3D PlaneBody(){
        var planeBody = body;
        var hollowPlane = hollowBody;
        planeBody = csg.rotate3DX(csg.degrees(90)).transform(planeBody);
        hollowPlane = csg.rotate3DX(csg.degrees(90)).transform(hollowPlane);
        planeBody = csg.difference3D(planeBody,Windows());
        doorframe = csg.rotate3DY(csg.degrees(90)).transform(doorframe);
        doorframe = csg.translate3D(900,7500,200).transform (doorframe);
        planeBody = csg.difference3D(planeBody,doorframe);
        planeBody = csg.difference3D(planeBody,hollowPlane);

        return planeBody;
    }



    public Geometry3D Windows(){

        Geometry3D window = csg.cylinder3D(500, 3000, 100, true);
        window = csg.rotate3DY(csg.degrees(90)).transform(window);
        List<Geometry3D> allWindows = new ArrayList<>();

        for(int x=0; x< 40; x++ ) {
            var windows = window;
            windows = csg.translate3D(0,-9000,700).transform(windows);
            allWindows.add(windows);

            return windows;
        }

        return null;
    }
}
