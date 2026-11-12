# Roadmap - BIOBUZZ 2026-2027

The high-level plan for the robot's software. It is kept general on purpose: mechanism designs are
not settled, and the programmers decide how each step is built.

See `GAME.md` for the game summary and team strategy.

## Steps

1. **Driving** - mecanum TeleOp with strafing and a choice of control schemes.
2. **Odometry** - the robot knows where it is on the field.
3. **Intake** - driver-controlled, on a button.
4. **Shooter** - launches reliably from a known spot.
5. **Turret** - can be pointed where we want.
6. **Auto-aim** - the turret aims itself using the robot's position, and driver 2 is told when a
   shot looks good.
7. **Autonomous driving** - the robot drives itself to places on the field, then scores in AUTO.

## Order

- **1 comes first.** It needs no new hardware.
- **2, 3, 4 and 5 can go in any order,** as each mechanism arrives from the build team.
- **6 needs 2, 4 and 5.**
- **7 needs 1 and 2,** so driving itself around can start before the shooter is done. Scoring in
  AUTO needs 6.

## Milestones

- **First complete version:** steps 1-6. Driver 1 drives and runs the intake. Driver 2 watches the
  robot's shot feedback and presses shoot.
- **Fallback if odometry is late:** steps 1, 3, 4 and 5 with manual aiming.
