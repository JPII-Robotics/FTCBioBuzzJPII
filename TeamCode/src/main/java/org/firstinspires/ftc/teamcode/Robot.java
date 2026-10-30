package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.TankDriving;
import org.firstinspires.ftc.teamcode.subsystems.Vision;

/**
 * To be run in every opmode/driving file.
 * Allows each opmode to access subsystems: hardware and helping files.
 * In a test, allows access to things like the camera and for the main
 * files, gives access to the entire bot.
 */
public class Robot {

    public final Vision vision;
    public final TankDriving tankDriving;

    /**
     * Finds the hardware and gives specific hardware to subsystems that need it.
     *
     * @param hardwareMap is given
     */
    public Robot(HardwareMap hardwareMap, Gamepad gamepad) {
        // ----- Hardware Lookup -----
        WebcamName webcamName = (WebcamName) hardwareMap.get(Constants.WEBCAM_NAME);

        DcMotor[] dcMotors = new DcMotor[4];
        dcMotors[0] = (DcMotor) hardwareMap.get(Constants.WheelBR);
        dcMotors[1] = (DcMotor) hardwareMap.get(Constants.WheelBL);
        dcMotors[2] = (DcMotor) hardwareMap.get(Constants.WheelFR);
        dcMotors[3] = (DcMotor) hardwareMap.get(Constants.WheelFL);

        // ----- Building Subsystems -----
        vision = new Vision(webcamName);
        tankDriving = new TankDriving(gamepad, dcMotors);

    }
}
