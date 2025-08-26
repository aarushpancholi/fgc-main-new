package org.firstinspires.ftc.teamcode.Subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class TankDriveSimple {

    DcMotor leftFront, leftBack, rightFront, rightBack;
//    IMU imu; // kept in case you still want telemetry later; not used for driving here

    public TankDriveSimple(HardwareMap hardwareMap) {
        leftFront  = hardwareMap.get(DcMotor.class, "front_left");
        leftBack   = hardwareMap.get(DcMotor.class, "back_left");
        rightFront = hardwareMap.get(DcMotor.class, "front_right");
        rightBack  = hardwareMap.get(DcMotor.class, "back_right"); // fixed mapping

//        // Optional: keep IMU init if you still want to read angles elsewhere
//        imu = hardwareMap.get(IMU.class, "imu");
//        IMU.Parameters parameters = new IMU.Parameters(
//                new RevHubOrientationOnRobot(
//                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
//                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
//                )
//        );
//        imu.initialize(parameters);

        // Set motor directions so +power drives forward for both sides
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        // Recommended defaults
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /**
     * Arcade drive:
     * *  - left_y: forward/back (push forward = positive; invert if needed)
     *  - right_x: turn right/left
     *  - right_y: unused
     */
    public void drive(float left_x, float right_y, float driveSens) {
        double turn = left_x;   // invert to make stick forward = forward robot
        double drive = -right_y;

        double leftPower  = drive + turn;
        double rightPower = drive - turn;

        leftPower  = Range.clip(leftPower,  -1.0, 1.0)/driveSens;
        rightPower = Range.clip(rightPower, -1.0, 1.0)/driveSens;

        leftFront.setPower(leftPower);
        leftBack.setPower(-leftPower);
        rightFront.setPower(rightPower);
        rightBack.setPower(rightPower);
    }
}