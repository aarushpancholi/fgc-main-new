package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystem.Climb;
import org.firstinspires.ftc.teamcode.Subsystem.Collection;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.Stopper;
import org.firstinspires.ftc.teamcode.Subsystem.TankDriveSimple;

@TeleOp(name = "Main FGC Practice", group = "Linear OpMode")
public class MainTeleOp extends LinearOpMode {
    private TankDriveSimple drivetrain;
    private Climb climb;
    private Collection collection;
    private Intake intake;
    private Stopper stopper;

    // Toggle states
    private boolean rightStopperOpen = false;
    private boolean leftStopperOpen = false;
    private boolean prevRightBumper = false;
    private boolean prevLeftBumper = false;

    @Override
    public void runOpMode() {
        // Initialize subsystems
        drivetrain = new TankDriveSimple(hardwareMap);
        climb = new Climb(hardwareMap, telemetry);
        collection = new Collection(hardwareMap, telemetry);
        intake = new Intake(hardwareMap, telemetry);
        stopper = new Stopper(hardwareMap, telemetry);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Gamepad1
            //DRIVETRAIN
            drivetrain.drive(gamepad1.left_stick_y, gamepad1.right_stick_x);

            //INTAKE SERVO
            if (gamepad1.b) {
                intake.on();
            }
            if (gamepad1.x) {
                intake.out();
            }
            if (gamepad1.y) {
                intake.off();
            }

            //CLIMB OFF + REVERSE
            if (gamepad1.dpad_left) {
                climb.stopClimb();
            }
            if (gamepad1.dpad_right) {
                climb.climbDown();
            }

            //Gamepad2
            //STOPPER POS



            if (gamepad2.right_bumper) {
                stopper.rightStop();
            }
            if (gamepad2.left_bumper) {
                stopper.leftStop();
            }
            //STOPPER RESET
            if (gamepad2.dpad_left) {
                stopper.leftzero();
            }
            if (gamepad2.dpad_right) {
                stopper.rightzero();
            }

            //COLLECTION POS
            if (gamepad2.y) {
                collection.collect();
            }
            //COLLECTION RESET
            if (gamepad2.dpad_up) {
                collection.reset();
            }

            if (gamepad2.b) {
                stopper.filter();
            }

            //INTAKE POS
            if (gamepad2.x) {
                intake.mainPos();
            }
            //INTAKE RESET
            if (gamepad2.dpad_down) {
                intake.zeroPos();
            }

            //CLIMB
            if (gamepad2.a) {
                climb.climbUp();
            }

            // Telemetry
            telemetry.addData("Climb Motor Power", climb.getPower());
            telemetry.addData("Collection Left Pos", collection.getLeftPosition());
            telemetry.addData("Collection Right Pos", collection.getRightPosition());
            telemetry.addData("Right Bumper", stopper.getRightPosition());
            telemetry.addData("Left Bumper", stopper.getLeftPosition());
            telemetry.addData("Left Intake Motor Pos", intake.getLeftPosition());
            telemetry.addData("Right Intake Motor Pos", intake.getRightPosition());
            telemetry.update();
        }
    }
}
