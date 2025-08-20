//package org.firstinspires.ftc.teamcode.opmodes.teleop;
//
//import com.acmerobotics.dashboard.message.redux.ReceiveGamepadState;
//import com.arcrobotics.ftclib.command.CommandOpMode;
//import com.arcrobotics.ftclib.command.InstantCommand;
//import com.arcrobotics.ftclib.command.ParallelCommandGroup;
//import com.arcrobotics.ftclib.command.SequentialCommandGroup;
//import com.arcrobotics.ftclib.command.WaitCommand;
//import com.arcrobotics.ftclib.command.button.GamepadButton;
//import com.arcrobotics.ftclib.gamepad.GamepadEx;
//import com.arcrobotics.ftclib.gamepad.GamepadKeys;
//
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//
//
//
//@TeleOp(name = "Servo Position Test")
//public class ServoPositionTest extends CommandOpMode {
//
//    //    private DriveSubsystem m_drive;
////    private DefaultDrive m_driveCommand;
//    private IntakeSubsystem     intakeSubsystem;
//    private TransferSubsystem   transferSubsystem;
//    //    private SlidesSubsystem     slidesSubsystem;
//    private RobotStateSubsystem robotState;
//    private AscentSubsystem ascent;
//    private double driveSpeed = 1.0;
//
//
//
//    private GamepadEx driver;
//    private GamepadEx operator;
//
//
//    @Override
//    public void initialize() {
//        // 1) Gamepads
//        driver   = new GamepadEx(gamepad1);
//        operator = new GamepadEx(gamepad2);
//
//        ascent = new AscentSubsystem(hardwareMap);
//
//
////        intakeSubsystem   = new IntakeSubsystem(hardwareMap, telemetry);
////        transferSubsystem = new TransferSubsystem(hardwareMap);
//////
//////        slidesSubsystem = new SlidesSubsystem(hardwareMap, telemetry);
////        robotState = new RobotStateSubsystem();
////        m_drive = new DriveSubsystem(hardwareMap, telemetry);
//
////        m_driveCommand = new DefaultDrive(m_drive, () -> driver.getLeftX(),  () -> driver.getLeftY(), () -> driver.getRightX() * 0.5 , ()-> driveSpeed);
////
////
////        register(m_drive);
////        m_drive.setDefaultCommand(m_driveCommand);
//
//        //Sample Intake
//
////        driver.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(
////                new FireOneShotCommand(intakeSubsystem)
////        );
////
////        driver.getGamepadButton(GamepadKeys.Button.B).whenPressed(
////                new SequentialCommandGroup(
////                        new ClawCloseCommand(intakeSubsystem),
////                        //Retract for Transfer
////                        new IntakePivotUpCommand(intakeSubsystem, robotState),
////
////                                new TurretResetTransferCommand(intakeSubsystem),
////                                new IntakeSlidesInCommand(intakeSubsystem, transferSubsystem),
////                                new WaitCommand(1000),
////                                new ClawLooseCommand(intakeSubsystem)
////
////                )
////        );
////
////
////
////        driver.getGamepadButton(GamepadKeys.Button.DPAD_DOWN).whenPressed(
////                new ResetArmForIntakeCommand(intakeSubsystem)
////        );
////
////        driver.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT).whenPressed(
////                new TurretResetTransferCommand(intakeSubsystem)
////        );
////
////        driver.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(
////                new IntakePivotUpCommand(intakeSubsystem, robotState)
////        );
////
////        driver.getGamepadButton(GamepadKeys.Button.DPAD_LEFT).whenPressed(
////                new IntakePivotUpCommand(intakeSubsystem, robotState)
////        );
////
////        driver.getGamepadButton(GamepadKeys.Button.X).whenPressed(
////                new IntakePivotDownCommand(intakeSubsystem, robotState)
////        );
////
////        ascent = new AscentSubsystem(hardwareMap);
////        register(ascent);
//
//        // Bind buttons (using FTCLib's Button helper)
//
//        driver.getGamepadButton(GamepadKeys.Button.X)
//                .whenPressed(new InstantCommand(ascent::ptoBase));
//
//        driver.getGamepadButton(GamepadKeys.Button.B)
//                .whenPressed(new InstantCommand(ascent::ptoSwitch));
//
//
////        driver.getGamepadButton(GamepadKeys.Button.B)
////                .whenPressed(new TransferBackwardCommand(transferSubsystem));
////
////        driver.getGamepadButton(GamepadKeys.Button.Y)
////                .whenPressed(    ascent::moveBackward)
////                .whenReleased(   ascent::stop);
//
//
//
//        telemetry.addLine("A: extend/stow");
//        telemetry.addLine("B: fire one-shot");
//        telemetry.addLine("X: reset arm");
//        telemetry.update();
//    }
//}
//
