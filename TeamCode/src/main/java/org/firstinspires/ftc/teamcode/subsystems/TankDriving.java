package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

public class TankDriving {
    Gamepad gamepad;
    DcMotor Br;
    DcMotor Bl;
    DcMotor Fr;
    DcMotor Fl;

    public TankDriving(Gamepad gamepad, DcMotors dcMotors) {
        this.gamepad = gamepad;
        this.Br = dcMotors.backRight;
        this.Bl = dcMotors.backLeft;
        this.Fr = dcMotors.frontRight;
        this.Fl = dcMotors.frontRight;
    }

    public void update() {
        float y = -gamepad.left_stick_y;
        float x = gamepad.right_stick_x;

        float denominator = (float) Math.max(Math.abs(y) + Math.abs(x), 1.0);

        leftPower((y + x) / denominator);
        rightPower((y - x) / denominator);
    }

    private void rightPower(float power) {
        power *= -1;
        Br.setPower(power);
        Fr.setPower(power);
    }

    private void leftPower(float power) {
        Bl.setPower(power);
        Fl.setPower(power);
    }
}
