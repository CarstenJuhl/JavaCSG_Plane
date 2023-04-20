import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Wings {

    JavaCSG csg = JavaCSGFactory.createDefault();

    Geometry3D wing = csg.box3D(15000,6000,500,true);
    Geometry3D wingCutout = csg.box3D(20000,6000,550,true);



    public Geometry3D LeftWing(){

    Geometry3D leftWing = wing;
    Geometry3D cutout1 = wingCutout;
    Geometry3D cutout2 = wingCutout;
    cutout1 = csg.rotate3DZ(csg.degrees(160)).transform(cutout1);
    cutout1 = csg.translate3D(0,4000,0).transform(cutout1);
    Geometry3D leftWing1 = csg.difference3D(leftWing,cutout1);

    cutout2 = csg.rotate3DZ(csg.degrees(170)).transform(cutout2);
    cutout2 = csg.translate3D(0,-4800,0).transform(cutout2);

    var leftWing2 = csg.difference3D(leftWing1,cutout2);
        leftWing2 = csg.translate3D(8000,-500,-300).transform(leftWing2);

        return leftWing2;
    }

    public Geometry3D rightWing(){

        Geometry3D rightWing = wing;
        Geometry3D cutout1 = wingCutout;
        Geometry3D cutout2 = wingCutout;

        cutout1 = csg.rotate3DZ(csg.degrees(20)).transform(cutout1);
        cutout1 = csg.translate3D(0,4000,0).transform(cutout1);
        Geometry3D rightWing1 = csg.difference3D(rightWing,cutout1);

        cutout2 = csg.rotate3DZ(csg.degrees(10)).transform(cutout2);
        cutout2 = csg.translate3D(0,-4800,0).transform(cutout2);

        var rightWing2 = csg.difference3D(rightWing1,cutout2);
        rightWing1 = csg.translate3D(-8000,-500,-300).transform(rightWing2);

        return rightWing1;
    }




}
