package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Basic tank driving. Only includes controls for forwards, backwards, and turning.
 * <p>
 * This class does not read the gamepad. The op mode passes in the stick values,
 * which means autonomous code can drive the robot by calling update() with its own numbers.
 */
public class TankDriving {
    private final DcMotor backRight;
    private final DcMotor backLeft;
    private final DcMotor frontRight;
    private final DcMotor frontLeft;

    public TankDriving(DcMotors dcMotors) {
        this.backRight = dcMotors.backRight;
        this.backLeft = dcMotors.backLeft;
        this.frontRight = dcMotors.frontRight;
        this.frontLeft = dcMotors.frontLeft;

        // The right side motors face the opposite direction, so reverse them once here.
        // Now positive power drives every wheel forward.
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    /**
     * Sets the motor powers. Call this once every loop.
     * <p>
     * Example from an op mode: {@code tankDriving.update(gamepad1.right_stick_x, -gamepad1.left_stick_y);}
     * (The gamepad's stick y is negative when pushed forward, so the op mode flips it.)
     *
     * @param x Turning, from -1 to 1. Positive turns right (clockwise).
     * @param y Forward/backward, from -1 to 1. Positive drives forward.
     */
    public void update(double x, double y) {
        // Scales the powers down so no motor is ever asked for more than 1.0,
        // which keeps the ratio between the left and right sides the same.
        double denominator = Math.max(Math.abs(y) + Math.abs(x), 1.0);

        leftPower((y + x) / denominator);
        rightPower((y - x) / denominator);
    }

    /**
     * Stops all drive motors.
     */
    public void stop() {
        leftPower(0);
        rightPower(0);
    }

    private void rightPower(double power) {
        backRight.setPower(power);
        frontRight.setPower(power);
    }

    private void leftPower(double power) {
        backLeft.setPower(power);
        frontLeft.setPower(power);
    }
}
