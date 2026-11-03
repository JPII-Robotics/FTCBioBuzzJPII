package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Odometry;
import org.firstinspires.ftc.teamcode.subsystems.TankDriving;

/**
 * Reference test op mode for creating new motor test files.
 * Disabled so it does not appear on the Driver Station.
 */
@Disabled
@TeleOp(name = "TestMotor", group = "Tests")
public class TestOdometry extends LinearOpMode {
    @Override
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap, gamepad1);
        TankDriving tankDriving = robot.tankDriving;
        Odometry odometry = robot.odometry;

        waitForStart();

        while (opModeIsActive()) {
            odometry.update();
            tankDriving.update();

            odometryTelemetry(odometry);
        }
    }

    private void odometryTelemetry(Odometry odometry) {
        double x = odometry.getX();
        double y = odometry.getY();
        double heading = odometry.getHeading();
    }
}