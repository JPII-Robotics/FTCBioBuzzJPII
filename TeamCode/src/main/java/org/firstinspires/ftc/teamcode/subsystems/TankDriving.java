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

    public TankDriving(Gamepad gamepad, DcMotor[] dcMotors) {
        this.gamepad = gamepad;
        this.Br = dcMotors[0];
        this.Bl = dcMotors[1];
        this.Fr = dcMotors[2];
        this.Fl = dcMotors[3];
    }

    public void updateLoop() {
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
