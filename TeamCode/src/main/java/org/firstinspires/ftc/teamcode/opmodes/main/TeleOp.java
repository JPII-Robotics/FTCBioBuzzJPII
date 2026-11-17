package org.firstinspires.ftc.teamcode.opmodes.main;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.TankDriving;
import org.firstinspires.ftc.teamcode.subsystems.Vision;

/*
 * This is an iterative Op Mode
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp", group = "Main")
public class TeleOp extends OpMode {
    // Declare OpMode members.
    private final ElapsedTime runtime = new ElapsedTime();

    private Robot robot = null;
    private TankDriving tankDriving = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        robot = new Robot(hardwareMap);
        tankDriving = robot.tankDriving;
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit START
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits START
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits START but before they hit STOP
     */
    @Override
    public void loop() {
        // Stick y is negative when pushed forward, so it is flipped.
        tankDriving.update(gamepad1.right_stick_x, -gamepad1.left_stick_y);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        Vision vision = robot.getVision();
        if (vision != null) {
            vision.close();
        }
    }

}
