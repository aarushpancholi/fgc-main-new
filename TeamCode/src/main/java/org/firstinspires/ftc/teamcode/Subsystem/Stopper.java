package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Stopper implements Subsystem {

    private final CRServo leftStopper, rightStopper;

    public Stopper(HardwareMap hardwareMap, Telemetry telemetry) {
        leftStopper = hardwareMap.get(CRServo.class, "leftStopper");
        rightStopper = hardwareMap.get(CRServo.class, "rightStopper");

        leftStopper.setDirection(CRServo.Direction.REVERSE);
        rightStopper.setDirection(CRServo.Direction.FORWARD);
    }

    // Close both stoppers
//    public void leftzero() {
//        leftStopper.setPosition(1);
//    }
//
//    public void rightzero() {
//        rightStopper.setPosition(0);
//    }

    public void close() {
        leftStopper.setPower(1);
        rightStopper.setPower(1);
    }

    public void open() {
        leftStopper.setPower(-1);
        rightStopper.setPower(-1);
    }

//    public void rightStop() {
//        rightStopper.setPosition(0.37);
//    }
//
//    public void leftStop() {
//        leftStopper.setPosition(0.50);
//    }

    public void stop() {
        leftStopper.setPower(0);
        rightStopper.setPower(0);
    }

//    public double getLeftPosition() {
//        return leftStopper.getPosition();
//    }
//
//    public double getRightPosition() {
//        return rightStopper.getPosition();
//    }
}
