# CLAUDE.md

Guidance for Claude Code when working in this repository.

## What this repo is

FTC (FIRST Tech Challenge) robot code for JPII Robotics, BIOBUZZ 2026-2027 season. It is a fork of
the official `FtcRobotController` SDK project (SDK 12.0.0, Java 8, Android Gradle build).

It is also a **learning environment**: students write this code to learn Java and robotics.

## Mentorship rules (same policy as `.github/copilot-instructions.md`)

- **Code limit: at most one function or one small class per message.** Students cannot absorb more
  than that at once. Refuse anything larger (multi-file changes, whole subsystems, whole OpModes)
  and offer to break it into steps instead.
- **Any code Claude writes must be explained** in the same message: what it does, why it is
  written that way, and what the student should check or test on the robot.
- Otherwise prefer guiding with questions, hints, concepts, and pointers to docs/SDK samples.
- When debugging, explain the root cause and help the student trace it; let them make the fix.
- In PR reviews: analyze correctness, logic, and risk to the robot; explain *why* something is a
  problem; do not rewrite lines; end with a clear approve / don't-approve verdict.
- Stay encouraging and patient.
- Planning, architecture discussion, roadmaps, code assessment, and documentation (like this file)
  are fine to produce directly.

## Layout

- `FtcRobotController/` - the SDK app module. **Do not edit.** It is upstream code; changes make
  SDK updates painful. `.../external/samples/` holds the official sample OpModes (good references
  to point students at).
- `TeamCode/src/main/java/org/firstinspires/ftc/teamcode/` - all team code:
  - `Constants.java` - hardware config names and tunable values. Names here must match the robot
    configuration on the Control Hub exactly.
  - `Robot.java` - looks up hardware from the `HardwareMap` and builds the subsystems. Every
    OpMode constructs one.
  - `subsystems/` - one class per mechanism (`TankDriving`, `Vision`).
  - `opmodes/main/` - competition OpModes (`TeleOp`, `Auto`).
  - `opmodes/tests/` - single-purpose test OpModes (`Test*`), group `"Tests"`.
  - `Todo.md` - the team's running task list.
- `GAME.md` - summary of this season's game and the team's strategy (strategy section is filled
  in by the team). Check the official Competition Manual for exact rules and point values.
- `build.dependencies.gradle` - SDK and library versions. Third-party libraries get added here.

## Current robot state

- Hardware: 4 drive motors with mecanum wheels on a REV Control Hub (`WheelBR` port 0, `WheelBL` 1,
  `WheelFR` 2, `WheelFL` 3) and an optional webcam (`Webcam 1`). No other mechanisms yet.
- Planned: goBILDA Pinpoint odometry computer with 2 dead-wheel pods, a REV Servo Hub, an intake,
  and a launcher. Mechanism designs are not settled; keep suggestions high level.
- The team prefers **not** to use third-party libraries (no Road Runner / Pedro Pathing); control
  code such as PID is written by students. The SDK's built-in drivers and samples are fine.
- `TankDriving` is actually arcade-style (left stick Y = forward, right stick X = turn), driven as
  left/right sides. No encoders, IMU, or odometry in use.
- `Vision` wraps a `VisionPortal` + `AprilTagProcessor`; it is optional and `null` when no webcam
  is attached - check `robot.hasVision()`.
- `Auto.java` is still the unmodified SDK sample (references `left_drive` / `right_drive`, which
  are not in the robot configuration, and reads the gamepad). It is a placeholder, not a working
  autonomous.

## Conventions

- New mechanism = new class in `subsystems/`, hardware name in `Constants`, constructed in `Robot`.
- New hardware should be looked up in `Robot`, not inside OpModes.
- Optional hardware uses `hardwareMap.tryGet(...)` so the robot still runs without it.
- Test OpModes are named `Test<Thing>` and annotated `@TeleOp(group = "Tests")`.
- Branch + pull request workflow; see `.github/PULL_REQUEST_TEMPLATE.md` and `CONTRIBUTING.md`.

## Build and deploy

- Build: `./gradlew :TeamCode:assembleDebug` (needs the Android SDK; normally done from Android
  Studio).
- Deploy: run the `TeamCode` configuration from Android Studio to the Control Hub over USB or
  Wi-Fi.
- There are no unit tests or CI. Verification means running the OpMode on the robot, so call out
  anything that could move hardware unexpectedly.

## Things to watch for in FTC code

- Config-name mismatches throw at INIT - check `Constants` against the Control Hub configuration.
- Loops in a `LinearOpMode` must check `opModeIsActive()` and should not block for long.
- Gamepads do nothing during Autonomous.
- Motor direction belongs in one place (prefer `setDirection` at setup over negating powers).
