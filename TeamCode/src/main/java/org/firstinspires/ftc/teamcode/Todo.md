TODO - Rewrite TestGamepadInput to show gamepad1 and gamepad2.
(Robot.java no longer handles gamepads; op modes read gamepad1/gamepad2
directly and pass numbers to the subsystems.)

TODO - Rewrite TestAprilTag troubleshoot why only one april tag is detected each image.

TODO - Finish Odometry.java (see the TODOs in the file):
1. Measure the pod offsets and fill in setOffsets() in configure().
2. Set the encoder resolution for our dead wheels in configure().
3. Fill in reset(), setPose() and update().
4. Run TestOdometry and set encoder directions so X goes up forward and Y goes up left.
5. Check the TestOdometry checklist (24 in forward, 24 in left, 90 deg turn in place).
