package Utilities;

public class DataPoint {
    public final double sinceStart, x, y, theta, velocityX, velocityY, velocityTheta,
        accelX, accelY, accelTheta;
    public final int numRings, lastTarget;
    public final boolean magHome, feedHome;

    public DataPoint(double sinceStart, double x, double y, double theta,
                     double velocityX, double velocityY, double velocityTheta,
                     double accelX, double accelY, double accelTheta,
                     int numRings, boolean magHome, boolean feedHome, int lastTarget) {
        this.sinceStart = sinceStart;
        this.x = x;
        this.y = y;
        this.theta = theta;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityTheta = velocityTheta;
        this.accelX = accelX;
        this.accelY = accelY;
        this.accelTheta = accelTheta;
        this.numRings = numRings;
        this.lastTarget = lastTarget;
        this.magHome = magHome;
        this.feedHome = feedHome;
    }
}
