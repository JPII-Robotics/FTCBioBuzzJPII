package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

/**
 * Tracks where the robot is on the field using two dead wheels and the
 * goBILDA Pinpoint Odometry Computer.
 * <p>
 * The dead wheels plug into the Pinpoint (not the Control Hub), and the Pinpoint has
 * its own IMU for heading. It does the position math itself about 1500 times a second
 * and we read the result over I2C.
 * <p>
 * Coordinate system (same as the Pinpoint):
 * <ul>
 *     <li>The robot starts at (0, 0) with heading 0.</li>
 *     <li>+X is the direction the robot was facing at the start (forward).</li>
 *     <li>+Y is to the robot's left at the start.</li>
 *     <li>Heading is in degrees, counter-clockwise (turning left) is positive, from -180 to 180.</li>
 * </ul>
 * Units: x and y are in inches, heading is in degrees.
 * <p>
 * NOT FINISHED. configure() still needs our pod offsets, encoder resolution and encoder
 * directions. Until it is filled in, the Pinpoint uses whatever settings it already has,
 * so distances and turning will not be accurate.
 */
public class Odometry {
    private final GoBildaPinpointDriver pinpoint;

    // Latest position, updated by update(). Inches and degrees.
    private double x = 0;
    private double y = 0;
    private double heading = 0;

    public Odometry(GoBildaPinpointDriver pinpoint) {
        this.pinpoint = pinpoint;
        configure();
    }

    /**
     * Tells the Pinpoint about our dead wheels. Runs once, from the constructor.
     */
    private void configure() {
        // TODO 1. Pod offsets: where the dead wheels are relative to the center of the robot.
        //         pinpoint.setOffsets(xOffset, yOffset, DistanceUnit.MM);
        //         xOffset = how far LEFT of center the X (forward) pod is. Right of center is negative.
        //         yOffset = how far FORWARD of center the Y (strafe) pod is. Behind center is negative.
        // TODO 2. Encoder resolution (ticks per mm of the dead wheel).
        //         goBILDA pods have presets: pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        //         Other pods: pinpoint.setEncoderResolution(ticksPerMm, DistanceUnit.MM);
        // TODO 3. Encoder directions: X must count up when pushed forward, Y must count up when pushed left.
        //         pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD,
        //                                       GoBildaPinpointDriver.EncoderDirection.FORWARD);
    }

    /**
     * Sets the position to (0, 0) heading 0 and recalibrates the Pinpoint's IMU.
     * The robot MUST be completely still while this runs (about 0.25 seconds).
     * Call it during init, never while driving.
     */
    public void reset() {
        pinpoint.resetPosAndIMU();
        x = 0;
        y = 0;
        heading = 0;
    }

    /**
     * Tells the odometry where the robot is. Use for an autonomous starting
     * position that isn't (0, 0), or to correct the position from an AprilTag.
     *
     * @param x       Inches.
     * @param y       Inches.
     * @param heading Degrees, counter-clockwise positive.
     */
    public void setPose(double x, double y, double heading) {
        pinpoint.setPosition(new Pose2D(DistanceUnit.INCH, x, y, AngleUnit.DEGREES, heading));
        // Also save it here so getX/getY/getHeading are right before the next update().
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    /**
     * Reads the newest data from the Pinpoint. Call this once at the top of every loop,
     * before using getX(), getY(), getHeading() or any of the diagnostic getters.
     */
    public void update() {
        // Reads position, encoders and status from the Pinpoint in one I2C read.
        pinpoint.update();

        // The Pinpoint already did the odometry math; we just copy its answer.
        Pose2D position = pinpoint.getPosition();
        x = position.getX(DistanceUnit.INCH);
        y = position.getY(DistanceUnit.INCH);
        heading = position.getHeading(AngleUnit.DEGREES);
    }

    // ----- Position -----

    /** @return Inches forward from the starting point. */
    public double getX() {
        return x;
    }

    /** @return Inches left of the starting point. */
    public double getY() {
        return y;
    }

    /** @return Degrees, counter-clockwise positive, -180 to 180. */
    public double getHeading() {
        return heading;
    }

    /** @return The position as one object (useful later for path following). */
    public Pose2D getPose() {
        return new Pose2D(DistanceUnit.INCH, x, y, AngleUnit.DEGREES, heading);
    }

    // ----- Diagnostics ----- (values only change after pinpoint.update() has been called)

    /** @return READY when working. CALIBRATING right after reset. FAULT_... names the problem (e.g. a pod unplugged). */
    public GoBildaPinpointDriver.DeviceStatus getStatus() {
        return pinpoint.getDeviceStatus();
    }

    /** @return Raw encoder count of the X (forward) dead wheel. Should go up when the robot moves forward. */
    public int getRawX() {
        return pinpoint.getEncoderX();
    }

    /** @return Raw encoder count of the Y (strafe) dead wheel. Should go up when the robot moves left. */
    public int getRawY() {
        return pinpoint.getEncoderY();
    }

    /** @return How many times per second the Pinpoint is being read. */
    public double getFrequency() {
        return pinpoint.getFrequency();
    }
}
