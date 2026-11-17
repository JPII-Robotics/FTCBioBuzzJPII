package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

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
 * <p>
 * Robot does not read the gamepads. Op modes read gamepad1/gamepad2 themselves
 * and pass plain numbers to the subsystems, so the same subsystems can be
 * driven by autonomous code.
 */
public class Robot {

    public final TankDriving tankDriving;
    public final Odometry odometry;

    // ----- Optional ----- (declared private)
    private Vision vision = null;

    /**
     * Finds the hardware and gives specific hardware to subsystems that need it.
     */
    public Robot(HardwareMap hardwareMap) {
        // ----- Hardware Lookup -----
        DcMotors dcMotors = new DcMotors();
        dcMotors.backRight = hardwareMap.get(DcMotor.class, Constants.WheelBR);
        dcMotors.backLeft = hardwareMap.get(DcMotor.class, Constants.WheelBL);
        dcMotors.frontRight = hardwareMap.get(DcMotor.class, Constants.WheelFR);
        dcMotors.frontLeft = hardwareMap.get(DcMotor.class, Constants.WheelFL);

        // The two dead wheels plug into the Pinpoint, not the Control Hub.
        GoBildaPinpointDriver pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, Constants.PINPOINT);

        // ----- Optional ----- (Uses tryGet which returns null when not configured);
        WebcamName webcamName = hardwareMap.tryGet(WebcamName.class, Constants.WEBCAM_NAME);

        // ----- Building Subsystems -----
        tankDriving = new TankDriving(dcMotors);
        odometry = new Odometry(pinpoint);

        // ----- Optional -----
        if (webcamName != null) {
            vision = new Vision(webcamName);
        }
    }

    /**
     * @return The Vision subsystem, or null if no webcam is configured.
     */
    public Vision getVision() {
        return vision;
    }
}
