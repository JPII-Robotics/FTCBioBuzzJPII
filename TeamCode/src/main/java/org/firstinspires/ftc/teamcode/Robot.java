package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.Vision;

/**
 * To be run in every opmode/driving file.
 * Allows each opmode to access subsystems: hardware and helping files.
 * In a test, allows access to things like the camera and for the main
 * files, gives access to the entire bot.
 */
public class Robot {

    public final Vision vision;

    /**
     * Finds the hardware and gives specific hardware to subsystems that need it.
     *
     * @param hardwareMap is given
     */
    public Robot(HardwareMap hardwareMap) {
        // ----- Hardware Lookup -----
        WebcamName webcamName = (WebcamName) hardwareMap.get(Constants.WEBCAM_NAME);

        // ----- Building Subsystems -----
        vision = new Vision(webcamName);
    }
}
