package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
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
        rightPower(gamepad.right_stick_y);
        leftPower(gamepad.left_stick_y);
    }

    private void rightPower(float power) {
        Br.setPower(power);
        Fr.setPower(power);
    }

    private void leftPower(float power) {
        Bl.setPower(power);
        Br.setPower(power);
    }
}
