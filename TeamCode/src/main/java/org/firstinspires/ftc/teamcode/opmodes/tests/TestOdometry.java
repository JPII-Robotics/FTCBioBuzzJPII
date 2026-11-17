package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Odometry;
import org.firstinspires.ftc.teamcode.subsystems.TankDriving;

/**
 * Tests the dead wheels and Pinpoint while driving with tank controls.
 * The robot starts at (0, 0) facing heading 0.
 * <p>
 * Checklist (push the robot by hand or drive it):
 * <ol>
 *     <li>Status says READY before pressing START. FAULT_X/Y_POD_NOT_DETECTED means a pod is unplugged.</li>
 *     <li>Push forward 24 in: Raw X goes up, X reads about +24, Y stays near 0.</li>
 *     <li>Push sideways to the left 24 in: Raw Y goes up, Y reads about +24, X stays near 0.</li>
 *     <li>Turn left 90 degrees in place: Heading reads about +90, X and Y barely change.
 *         If X/Y drift a lot while turning in place, the pod offsets are wrong.</li>
 *     <li>Drive around and come back to the start: X, Y, heading should all be close to 0.</li>
 * </ol>
 * Press A to set the position back to (0, 0, 0) at any time.
 */
@TeleOp(name = "TestOdometry", group = "Tests")
public class TestOdometry extends LinearOpMode {
    @Override
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap);
        TankDriving tankDriving = robot.tankDriving;
        Odometry odometry = robot.odometry;

        // Start at (0, 0) heading 0. Recalibrates the IMU, so the robot must be still.
        odometry.reset();

        // Shows the status during init so we know the Pinpoint is READY before starting.
        while (opModeInInit()) {
            odometry.update();
            telemetry.addLine("Keep the robot still. Press START when Status is READY.");
            odometryTelemetry(odometry);
            sleep(20);
        }

        while (opModeIsActive()) {
            odometry.update();

            // Stick y is negative when pushed forward, so it is flipped.
            tankDriving.update(gamepad1.right_stick_x, -gamepad1.left_stick_y);

            if (gamepad1.aWasPressed()) {
                odometry.setPose(0, 0, 0);
            }

            telemetry.addLine("Press A to set position to (0, 0, 0)");
            odometryTelemetry(odometry);
        }

        tankDriving.stop();
    }

    private void odometryTelemetry(Odometry odometry) {
        telemetry.addData("Status", odometry.getStatus());
        telemetry.addData("X (in)", "%.2f", odometry.getX());
        telemetry.addData("Y (in)", "%.2f", odometry.getY());
        telemetry.addData("Heading (deg)", "%.2f", odometry.getHeading());
        telemetry.addData("Raw X / Raw Y (ticks)", "%d / %d", odometry.getRawX(), odometry.getRawY());
        telemetry.addData("Pinpoint read rate (Hz)", "%.0f", odometry.getFrequency());
        telemetry.update();
    }
}
