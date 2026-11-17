package org.firstinspires.ftc.teamcode;

import android.util.Size;

public class Constants {
    // ----- Hardware Names ----- (must match the Driver Station configuration exactly)
    public static final String WheelBR = "WheelBR"; //ControlHub Motor 0
    public static final String WheelBL = "WheelBL"; //ControlHub Motor 1
    public static final String WheelFR = "WheelFR"; //ControlHub Motor 2
    public static final String WheelFL = "WheelFL"; //ControlHub Motor 3
    public static final String PINPOINT = "pinpoint"; //ControlHub I2C Bus 1, "goBILDA Pinpoint Odometry Computer"
    public static final String WEBCAM_NAME = "Webcam 1";
    public static final String IMU = "imu"; //Built into the Control Hub (I2C Bus 0). Currently unused; the Pinpoint has its own IMU.

    // ----- Misc -----
    public static final Size CAMERA_RESOLUTION = new Size(640, 480);
}
