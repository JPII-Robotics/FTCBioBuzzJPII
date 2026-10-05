package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Vision;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import java.util.List;

/*
 * This op mode tests April Tags...
 */

@TeleOp(name = "TestAprilTag", group = "Tests")
public class TestAprilTag extends LinearOpMode {
    private Vision vision;

    @Override
    public void runOpMode() {
        Robot robot = new Robot(hardwareMap);
        vision = robot.vision;

        while (opModeInInit()) {
            telemetry.addData("Camera State", vision.getCameraState());
            telemetry.update();
        }

        while (opModeIsActive()) {

            if (gamepad1.a) {
                telemetryAprilTag();
            }
            sleep(50);
        }

        vision.close();
    }

    private void telemetryAprilTag() {
        if (!vision.captureImage()) {
            telemetry.addLine("An image could not be captured");
        }

        List<AprilTagDetection> currentDetections = vision.aprilTags();
        telemetry.addData("# AprilTags Detected", currentDetections.size());

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection aprilTag : currentDetections) {
            AprilTagSingleDetection single = (AprilTagSingleDetection) aprilTag;
            if (single.metadata != null) {
                telemetry.addData("ID", single.id);
                telemetry.addData("Range", single.ftcPose.range);
                telemetry.addData("Bearing", single.ftcPose.bearing);
                telemetry.addData("Yaw", single.ftcPose.yaw);
            }
        }

        telemetry.update();
    }
}
