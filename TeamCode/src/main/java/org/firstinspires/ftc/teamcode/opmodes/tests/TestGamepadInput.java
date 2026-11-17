package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This test displays the values of both controllers when plugged in.
 * "gamepad1" is the controller that is initialized by pressing start + `A` in the driver station.
 * "gamepad2" is the controller that is initialized by pressing start + `B` in the driver station.
 */
@Disabled
@TeleOp(name = "TestGamepadInput", group = "Tests")
public class TestGamepadInput extends LinearOpMode {

    // Declare OpMode members.
    private final ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            gamepadTelemetry("Gamepad 1", gamepad1);
            gamepadTelemetry("Gamepad 2", gamepad2);

            // Elapsed Game Time
            telemetry.addData("Status", "Run Time: " + runtime.toString());

            telemetry.update();
        }
    }

    /**
     * Adds every button, trigger and stick value of one gamepad to telemetry.
     *
     * @param name    The heading shown above this gamepad's values.
     * @param gamepad The gamepad to display (gamepad1 or gamepad2).
     */
    private void gamepadTelemetry(String name, Gamepad gamepad) {
        telemetry.addLine("----- " + name + " -----");

        // Face buttons (bool)
        telemetry.addData("A / B / X / Y", "%b / %b / %b / %b",
                gamepad.a, gamepad.b, gamepad.x, gamepad.y);

        // D-pad (bool)
        telemetry.addData("D-pad U/D/L/R", "%b / %b / %b / %b",
                gamepad.dpad_up, gamepad.dpad_down, gamepad.dpad_left, gamepad.dpad_right);

        // Bumpers (bool)
        telemetry.addData("Bumpers L/R", "%b / %b",
                gamepad.left_bumper, gamepad.right_bumper);

        // Triggers (float 0.0-1.0)
        telemetry.addData("Triggers L/R", "%.2f / %.2f",
                gamepad.left_trigger, gamepad.right_trigger);

        // Joysticks (-1.0 to 1.0)
        telemetry.addData("Left Stick X/Y", "%.2f / %.2f",
                gamepad.left_stick_x, gamepad.left_stick_y);
        telemetry.addData("Right Stick X/Y", "%.2f / %.2f",
                gamepad.right_stick_x, gamepad.right_stick_y);
    }
}
