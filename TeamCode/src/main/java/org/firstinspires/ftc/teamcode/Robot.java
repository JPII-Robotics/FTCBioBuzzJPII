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

    public final TankDriving tankDriving;

    /**
     * Optional subsystem. Null when no webcam is configured or plugged in,
     * so the robot can still run without a camera. Check {@link #hasVision()} first. hi
     */
    public final Vision vision;

    /**
     * Finds the hardware and gives specific hardware to subsystems that need it.
     *
     * @param hardwareMap is given
     */
    public Robot(HardwareMap hardwareMap, Gamepad gamepad) {
        // ----- Hardware Lookup -----
        DcMotor[] dcMotors = new DcMotor[4];
        dcMotors[0] = hardwareMap.get(DcMotor.class, Constants.WheelBR);
        dcMotors[1] = hardwareMap.get(DcMotor.class, Constants.WheelBL);
        dcMotors[2] = hardwareMap.get(DcMotor.class, Constants.WheelFR);
        dcMotors[3] = hardwareMap.get(DcMotor.class, Constants.WheelFL);

        // tryGet returns null instead of throwing when the webcam isn't in the configuration
        WebcamName webcamName = hardwareMap.tryGet(WebcamName.class, Constants.WEBCAM_NAME);

        // ----- Building Subsystems -----
        tankDriving = new TankDriving(gamepad, dcMotors);
        vision = buildVision(webcamName);
    }

    /**
     * @return True if a webcam was found and the Vision subsystem is available.
     */
    public boolean hasVision() {
        return vision != null;
    }

    /**
     * Only builds Vision if the webcam is configured and physically attached.
     * Any failure starting the camera is swallowed so driving still works.
     */
    private static Vision buildVision(WebcamName webcamName) {
        if (webcamName == null || !webcamName.isAttached()) {
            return null;
        }
        try {
            return new Vision(webcamName);
        } catch (RuntimeException e) {
            return null;
        }
    }
}
