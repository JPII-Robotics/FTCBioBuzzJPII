package org.firstinspires.ftc.teamcode.opmodes.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Vision;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import java.util.List;

/**
 * This op mode tests capturing images and checking aprilTags in the image
 */
@TeleOp(name = "TestAprilTag", group = "Tests")
public class TestAprilTag extends LinearOpMode {
    private Vision vision;

    @Override
    public void runOpMode() {
        // Gets the vision object from Robot.java
        Robot robot = new Robot(hardwareMap);
        vision = robot.vision;

        // When in the init phase, print out the state of the camera
        while (opModeInInit()) {
            telemetry.addData("Camera State", vision.getCameraState());
            telemetry.update();
            sleep(50);
        }

        // Loop that captures images and updates telemetry upon A click
        while (opModeIsActive()) {

            if (gamepad1.aWasPressed()) {
                if (!vision.captureImage()) {
                    telemetry.addLine("An image could not be captured");
                }
                telemetryAprilTag();
            }
            sleep(50);
        }

        // Stops camera
        vision.close();
    }

    /**
     * Gets latest april tag detections and prints out info to telemetry.
     */
    private void telemetryAprilTag() {
        List<AprilTagDetection> currentDetections = vision.aprilTags();
        telemetry.addData("# AprilTags Detected", currentDetections.size());

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection aprilTag : currentDetections) {
            if (aprilTag instanceof AprilTagSingleDetection) {
                AprilTagSingleDetection single = (AprilTagSingleDetection) aprilTag;
                if (single.metadata != null) {
                    telemetry.addData("ID", single.id);
                    telemetry.addData("Range", single.ftcPose.range);
                    telemetry.addData("Bearing", single.ftcPose.bearing);
                    telemetry.addData("Yaw", single.ftcPose.yaw);
                    telemetry.addLine("");
                } else {
                    telemetry.addLine("metadata was empty");
                }
            }
        }

        telemetry.update();
    }
}
