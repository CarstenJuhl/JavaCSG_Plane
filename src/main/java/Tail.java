import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Tail {

    JavaCSG csg = JavaCSGFactory.createDefault();

    public Geometry3D AirplaneTail(){
        Geometry3D bum = csg.cone3D(3000,400,4000,100,true);
        bum = csg.rotate3DX(csg.degrees(90)).transform(bum);

        var finalTail1 = csg.union3D(bum,Tail());

        var finalTail = csg.union3D(finalTail1,Rudders());
        finalTail = csg.translate3D(0,-12000,0).transform(finalTail);


        return finalTail;
    }

    //Building the tail for the rudders
    public Geometry3D Tail(){
        Geometry3D tail = csg.box3D(500,2000,2500,true);
        tail = csg.rotate3DX(csg.degrees(15)).transform(tail);
        Geometry3D cutout = csg.box3D(550,2000,4000,true);
        cutout = csg.rotate3DX(csg.degrees(50)).transform(cutout);
        cutout = csg.translate3D(0,150,1250).transform(cutout);
        var winglessTail = csg.difference3D(tail,cutout);
        winglessTail = csg.translate3D(0,0,1500).transform(winglessTail);
        return winglessTail;
    }
//Create the rudders
    public Geometry3D Rudders(){
        Geometry3D rudder = csg.box3D(8000,1500,250,true);
        Geometry3D cutout1 = csg.box3D(8500,1500,300,true);
        Geometry3D cutout2 = cutout1;
        Geometry3D cutout3 = cutout1;
        Geometry3D cutout4 = cutout1;
        Geometry3D cutout5 = cutout1;
        cutout1 = csg.translate3D(-4200,-1100,0).transform(cutout1);
        cutout1 = csg.rotate3DZ(csg.degrees(7)).transform(cutout1);
        Geometry3D newRudder = csg.difference3D(rudder,cutout1);

        cutout2 = csg.translate3D(4200,-1100,0).transform(cutout2);
        cutout2 = csg.rotate3DZ(csg.degrees(353)).transform(cutout2);
        Geometry3D newRudder2 = csg.difference3D(newRudder,cutout2);

        cutout3 = csg.translate3D(-4000,1200,0).transform(cutout3);
        cutout3 = csg.rotate3DZ(csg.degrees(15)).transform(cutout3);
        Geometry3D newRudder3 = csg.difference3D(newRudder2,cutout3);

        cutout4 = csg.translate3D(4000,1200,0).transform(cutout4);
        cutout4 = csg.rotate3DZ(csg.degrees(345)).transform(cutout4);
        Geometry3D newRudder4 = csg.difference3D(newRudder3,cutout4);

        cutout5 = csg.translate3D(0,1200,0).transform(cutout5);

        var rudders = csg.difference3D(newRudder4,cutout5);

        rudders =csg.translate3D(0,-650,1600).transform(rudders);


        return rudders;
    }
}
