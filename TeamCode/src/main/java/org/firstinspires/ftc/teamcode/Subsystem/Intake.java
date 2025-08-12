package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;


// Subsystem for the main barrier intake - along with the arm itself and servo intake
public class Intake implements Subsystem {

    private final CRServo leftServo, rightServo;
    private final DcMotorEx leftMotor, rightMotor;

    public int mposL = 0;

    public int mposR = 0;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        leftServo = hardwareMap.get(CRServo.class, "leftServo_Intake");
        rightServo = hardwareMap.get(CRServo.class, "rightServo_Intake");
        leftMotor = hardwareMap.get(DcMotorEx.class, "leftMotor_Intake");
        rightMotor = hardwareMap.get(DcMotorEx.class, "rightMotor_Intake");

        leftMotor.setDirection(DcMotorEx.Direction.FORWARD);
        rightMotor.setDirection(DcMotorEx.Direction.FORWARD);

        leftMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);


    }

    public void mainPos() {
        leftMotor.setTargetPosition(mposL);
        rightMotor.setTargetPosition(mposR);
        leftMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        leftMotor.setPower(0.7);
        rightMotor.setPower(0.7);
    }

    public void zeroPos() {
        leftMotor.setTargetPosition(0);
        rightMotor.setTargetPosition(0);
        leftMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        leftMotor.setPower(0.7);
        rightMotor.setPower(0.7);
    }

    public void on() {
        leftServo.setPower(1);
        rightServo.setPower(1);
    }

    public void off() {
        leftServo.setPower(0);
        rightServo.setPower(0);
    }

    public void out() {
        leftServo.setPower(-1);
        rightServo.setPower(-1);


    }

    public double getLeftPosition() {
        return leftMotor.getCurrentPosition();
    }

    public double getRightPosition() {
        return rightMotor.getCurrentPosition();
    }

}
