package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Vision;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.List;

/**
 * This op mode tests capturing images and checking aprilTags in the image
 */
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

    /**
     * Gets latest april tag detections and prints out info to telemetry.
     */
}