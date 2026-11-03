package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.DcMotors;
import org.firstinspires.ftc.teamcode.subsystems.Odometry;
import org.firstinspires.ftc.teamcode.subsystems.TankDriving;
import org.firstinspires.ftc.teamcode.subsystems.Vision;

/**
 * To be run in every opmode/driving file.
 * Allows each opmode to access subsystems: hardware and helping files.
 * In a test, allows access to things like the camera and for the main
 * files, gives access to the entire bot.
 */
public class Robot {

    public final TankDriving tankDriving;
    public final Odometry odometry;

    // ----- Optional ----- (declared private)
    private Vision vision = null;

    /**
     * Finds the hardware and gives specific hardware to subsystems that need it.
     */
    public Robot(HardwareMap hardwareMap, Gamepad gamepad) {
        // ----- Hardware Lookup -----
        DcMotors dcMotors = new DcMotors();
        dcMotors.backRight = hardwareMap.get(DcMotor.class, Constants.WheelBR);
        dcMotors.backLeft = hardwareMap.get(DcMotor.class, Constants.WheelBL);
        dcMotors.frontRight = hardwareMap.get(DcMotor.class, Constants.WheelFR);
        dcMotors.frontRight = hardwareMap.get(DcMotor.class, Constants.WheelFL);

        IMU imu = hardwareMap.get(IMU.class, Constants.IMU);

        // ----- Optional ----- (Uses tryGet which returns null when not configured);
        WebcamName webcamName = hardwareMap.tryGet(WebcamName.class, Constants.WEBCAM_NAME);

        // ----- Building Subsystems -----
        tankDriving = new TankDriving(gamepad, dcMotors);
        odometry = new Odometry(dcMotors, imu);

        // ----- Optional -----
        if (webcamName != null) {
            vision = new Vision(webcamName);
        }
    }

    public Vision getVision() {
        return vision;
    }
}
