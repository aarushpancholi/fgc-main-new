package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystem.Barrier;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.TankDriveSimple;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.Climb;
import org.firstinspires.ftc.teamcode.Subsystem.TankDriveSimple;

@TeleOp(name = "Internationals FGC Teleop", group = "Linear OpMode")
public class MainTeleOp extends LinearOpMode {

    private TankDriveSimple drivetrain;
    private Intake intake;
    private Climb climb;

    private Barrier barrier;

    @Override
    public void runOpMode() {
        // Initialize subsystems
        drivetrain = new TankDriveSimple(hardwareMap);
        intake = new Intake(hardwareMap, telemetry);
        climb = new Climb(hardwareMap, telemetry);
        barrier = new Barrier(hardwareMap, telemetry);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double speedMode = (gamepad1.right_trigger > 0.1) ? 2.0 : 1.0;
            drivetrain.drive(gamepad1.left_stick_y, gamepad1.right_stick_x, (float) speedMode);

            boolean intakeForward = gamepad1.circle;
            boolean intakeReverse = gamepad1.cross;

            if (intakeReverse) {
                intake.out();
            } else if (intakeForward) {
                intake.on();
            } else {
                intake.off();
            }

            // ---------------- CLIMB ----------------
            if (gamepad2.a | gamepad1.dpad_up) {
                climb.climbUp();
            }
            if (gamepad2.b | gamepad1.dpad_down) {
                climb.climbDown();
            }
            if (gamepad2.x | gamepad1.dpad_left) {
                climb.stopClimb();
            }


            // ---------------- BARRIER ---------------
            if (gamepad2.right_bumper) {
                barrier.extend();
            } else if (gamepad2.left_bumper) {
                barrier.retract();
            } else {
                barrier.stop();
            }

            // ---------------- TELEMETRY ----------------
            telemetry.addData("Drive Speed Mode", speedMode);
            telemetry.addData("Intake", intakeReverse ? "REVERSING" : (intakeForward ? "FORWARD" : "OFF"));
            telemetry.update();

            // Don’t block the loop — one pass per cycle.
            idle();
        }
    }
}
