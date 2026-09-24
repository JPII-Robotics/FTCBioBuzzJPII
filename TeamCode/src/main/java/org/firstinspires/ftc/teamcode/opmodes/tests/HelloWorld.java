package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;


/*
 * This is an example of a Linear Op Mode where we just run a test to run code on the robot
 */

@TeleOp(name = "Hello World", group = "Tests")
public class HelloWorld extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            telemetry.addData("Run Time", runtime.toString());

            // Face buttons (bool)
            telemetry.addData("A / B / X / Y", "%b / %b / %b / %b",
                    gamepad1.a, gamepad1.b, gamepad1.x, gamepad1.y);

            // D-pad (bool)
            telemetry.addData("D-pad U/D/L/R", "%b / %b / %b / %b",
                    gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);

            // Bumpers (bool)
            telemetry.addData("Bumpers L/R", "%b / %b",
                    gamepad1.left_bumper, gamepad1.right_bumper);

            // Triggers (float 0.0-1.0)
            telemetry.addData("Triggers L/R", "%.2f / %.2f",
                    gamepad1.left_trigger, gamepad1.right_trigger);

            // Joysticks (-1.0 to 1.0)
            telemetry.addData("Left Stick X/Y", "%.2f / %.2f",
                    gamepad1.left_stick_x, gamepad1.left_stick_y);
            telemetry.addData("Right Stick X/Y", "%.2f / %.2f",
                    gamepad1.right_stick_x, gamepad1.right_stick_y);

            // Elapsed Game Time
            telemetry.addData("Status", "Run Time: " + runtime.toString());

            telemetry.update();
        }
    }
}