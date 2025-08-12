package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.ClimbOff;
import org.firstinspires.ftc.teamcode.Commands.ClimbOnCommand;
import org.firstinspires.ftc.teamcode.Commands.ResetCollectionPos;
import org.firstinspires.ftc.teamcode.Commands.ResetIntakePos;
import org.firstinspires.ftc.teamcode.Commands.UnitCollectionPos;
import org.firstinspires.ftc.teamcode.Subsystem.Climb;
import org.firstinspires.ftc.teamcode.Subsystem.Collection;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.Stopper;
import org.firstinspires.ftc.teamcode.Subsystem.TankDriveSimple;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "Main FGC Practice", group = "Linear OpMode")
public class MainTeleOp extends LinearOpMode {
    private TankDriveSimple drivetrain;
    private Climb climb;
    private Collection collection;
    private Intake intake;

    private Stopper stopper;

    private GamepadEx driver;
    private GamepadEx operator;

    @Override
    public void runOpMode() {
        drivetrain = new TankDriveSimple(hardwareMap);
        climb = new Climb(hardwareMap, telemetry);
        collection = new Collection(hardwareMap, telemetry);
        intake = new Intake(hardwareMap, telemetry);
        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            drivetrain.drive(gamepad1.left_stick_x, gamepad1.right_stick_y);

            CommandScheduler.getInstance().run();

            driver.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                    new UnitCollectionPos(collection)
            );

            driver.getGamepadButton(GamepadKeys.Button.B).whenPressed(
                    new ResetCollectionPos(collection)
            );


            // Example commented commands:
            // driver.getGamepadButton(GamepadKeys.Button.A).whenPressed(
            //         new ClimbOnCommand(climb)
            // );
            //
            // driver.getGamepadButton(GamepadKeys.Button.B).whenPressed(
            //         new ClimbOff(climb)
            // );
            //
            // driver.getGamepadButton(GamepadKeys.Button.LEFT_STICK_BUTTON).whenPressed(
            //         new SequentialCommandGroup(
            //                 new ResetIntakePos(intake),
            //                 new ResetCollectionPos(collection)
            //         )
            // );
        }
    }
}
