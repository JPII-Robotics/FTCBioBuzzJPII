package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

public class Odometry {
    private double x;
    private double y;
    private double heading;

    public Odometry(DcMotors dcMotors, IMU imu) {

    }

    public void update() {
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeading() {
        return heading;
    }
}
