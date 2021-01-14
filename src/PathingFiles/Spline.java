package PathingFiles;

import org.ejml.simple.SimpleMatrix;

public class Spline {
    private double a0;
    private double a1;
    private double a2;
    private double a3;
    private double a4;
    private double a5;
    private double timeScaling;
    private double[][] ainversearray = {{10,-4,0.5},{-15,7,-1},{6,-3,0.5}};
    private SimpleMatrix ainverse = new SimpleMatrix(ainversearray);

    public Spline(double a0, double a1, double a2, double a3, double a4, double a5){
        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
    }

    public Spline(double startx, double startv, double starta, double endx, double endv,
                  double enda , double time){
        //known coefficients
        this.a0 = startx;
        this.a1 = startv;
        this.a2 = starta/2;

        //constants of system of equation matrix
        double[][] barray = {{endx-startx-startv-starta/2,endv-startv-starta, enda - starta}};
        SimpleMatrix b = new SimpleMatrix(barray);

        //solve for the rest of the coefficients
        SimpleMatrix z = ainverse.mult(b.transpose());

        this.a3 = z.get(0,0);
        this.a4 = z.get(1,0);
        this.a5 = z.get(2,0);
        this.timeScaling = 1/time;

    }

    public double position(double time){
        time = timeScaling*time;
        double position = a0 + a1*time +
                a2*Math.pow(time,2)+a3*Math.pow(time,3)+a4*Math.pow(time,4)+a5*Math.pow(time,5);
        return position;
    }

    public double velocity(double time){
        time = timeScaling*time;
        double velocity = a1 +
                2*a2*time + 3*a3*Math.pow(time,2)+ 4*a4*Math.pow(time,3) + 5*a5*Math.pow(time,4);
        return velocity;
    }
}