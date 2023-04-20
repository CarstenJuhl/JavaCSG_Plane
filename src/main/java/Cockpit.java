import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Cockpit {

    JavaCSG csg = JavaCSGFactory.createDefault();


    public Geometry3D Cockpit(){
        Geometry3D cockpit = csg.cone3D(3000,300,3500,100,true);
        Geometry3D tipCutout = csg.cone3D(800,400,1000,100,true);
        Geometry3D tip = csg.sphere3D(500,100,true);
        Geometry3D windowSide = csg.box3D(2000,700,350,true);
        Geometry3D windowFront = csg.box3D(2000,600,350,true);
        Geometry3D cockpitFill = csg.box3D(1100,300,250,true);
        tip = csg.translate3D(0,800,0).transform(tip);
        tipCutout = csg.translate3D(0,0,1600).transform(tipCutout);
        cockpit = csg.rotate3DX(csg.degrees(270)).transform(cockpit);
        tipCutout = csg.rotate3DX(csg.degrees(270)).transform(tipCutout);
        windowSide = csg.translate3D(0,-700,700).transform(windowSide);
        windowFront = csg.translate3D(0,0,700).transform(windowFront);
        cockpitFill = csg.translate3D(0,-350,650).transform(cockpitFill);
        cockpit = csg.difference3D(cockpit,cockpitFill);
        cockpit = csg.difference3D(cockpit,windowSide);
        cockpit = csg.difference3D(cockpit,windowFront);
        Geometry3D finalCockpit2 = csg.difference3D(cockpit,tipCutout);
        var finalCockpit = csg.union3D(finalCockpit2,tip);
        finalCockpit = csg.translate3D(0,11700,0).transform(finalCockpit);

        return finalCockpit;
    }







}
