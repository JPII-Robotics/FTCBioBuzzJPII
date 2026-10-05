package org.firstinspires.ftc.teamcode.subsystems;


import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


public class Vision {
    // Vision Portal is what takes pictures and feeds images to processors
    // Needs the webcam name and processors
    private final VisionPortal visionPortal;
    // Holds code that takes an image and finds the april tags
    private final AprilTagProcessor aprilTagProcessor;

    //Tracks the number of images taken
    private int captureCounter = 0;
    private final String timestamp;


    public Vision(WebcamName webcamName) {
        // Holds code that finds april tags in images.
        aprilTagProcessor = new AprilTagProcessor.Builder().build();
        // The thing that takes images needs the name of the camera and the code to run (processor) on every image taken
        // Builds the visionPortal and automatically starts the camera stream.
        visionPortal = new VisionPortal.Builder().setCamera(webcamName).addProcessor(aprilTagProcessor).build();

        // Records the time of this run; formatted
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd_HH-mm-ss_SSS", Locale.US);
        timestamp = sdf.format(System.currentTimeMillis());

    }

    /**
     * Takes the latest image from the stream and saves it to "/sdcard/VisionPortal-<name>.png"
     * <Name> is based on image number and time of this run.
     *
     * @return True if the image captures and false otherwise.
     */
    public boolean captureImage() {
        //If camera not ready, return false
        if (!(visionPortal.getCameraState() == (VisionPortal.CameraState.STREAMING))) {
            return false;
        }
        captureCounter++;
        String fileName = "Capture" + captureCounter + "_" + timestamp;
        visionPortal.saveNextFrameRaw(fileName);
        return true;
    }

    /**
     * Creates a list with all the april tags detected in the
     * most recent image streamed (not captured).
     *
     * @return A List object with all the April Tags detected.
     */
    public List<AprilTagDetection> aprilTags() {
        return aprilTagProcessor.getDetections();
    }

    /**
     * Closes the camera
     */
    public void close() {
        visionPortal.close();
    }
}
