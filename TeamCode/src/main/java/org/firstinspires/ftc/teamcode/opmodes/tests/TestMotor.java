package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

/**
 * Reference test op mode for creating new motor test files.
 * Disabled so it does not appear on the Driver Station.
 */
@Disabled
@TeleOp(name = "TestMotor", group = "Tests")
public class TestMotor extends LinearOpMode {
    @Override
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap);

        DcMotor motor = robot.testMotor;
        waitForStart();

        while (opModeIsActive()) {
            motor.setPower(1.0);
        }
    }
}