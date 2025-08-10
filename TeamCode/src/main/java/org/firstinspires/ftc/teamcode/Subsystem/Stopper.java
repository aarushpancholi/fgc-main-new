package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Stopper implements Subsystem {

    private final Servo leftStopper, rightStopper;

    public Stopper(HardwareMap hardwareMap, Telemetry telemetry) {
        leftStopper = hardwareMap.get(Servo.class, "leftStopper");
        rightStopper = hardwareMap.get(Servo.class, "rightStopper");
    }

    public void zero() {
        leftStopper.setPosition(0);
        rightStopper.setPosition(0);
    }

    public void filter() {
        leftStopper.setPosition(0.7);
        rightStopper.setPosition(0.7);
    }

    public void rightStop() {
        rightStopper.setPosition(0.35);
    }

    public void leftStop() {
        leftStopper.setPosition(0.35);
    }

}
