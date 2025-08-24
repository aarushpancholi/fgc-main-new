package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

// Subsystem for BDU collection - only servos
public class Collection implements Subsystem {

    private final Servo leftServo;
    private final Servo rightServo;

    public Collection(HardwareMap hardwareMap, Telemetry telemetry) {
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");

        // Set initial position (90 degrees)
        leftServo.setPosition(1.0);
        rightServo.setPosition(0.0);

        rightServo.setDirection(Servo.Direction.REVERSE);

    }

    // Move to 0 degrees-
    public void reset() {
        leftServo.setPosition(1.0);
        rightServo.setPosition(0.8);
    }

    // Move back to 90 degrees
    public void collect() {
        leftServo.setPosition(0.425);
        rightServo.setPosition(0.25);
    }

    public double getLeftPosition() {
        return leftServo.getPosition();
    }

    public double getRightPosition() {
        return rightServo.getPosition();
    }
}
