package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.TankDriving;

/**
 * To be run in every opmode/driving file.
 * Allows each opmode to access subsystems: hardware and helping files.
 * In a test, allows access to things like the camera and for the main
 * files, gives access to the entire bot.
 */
public class Robot {

    public final TankDriving tankDriving;

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

        // ----- Building Subsystems -----
        tankDriving = new TankDriving(gamepad, dcMotors);
    }
}
