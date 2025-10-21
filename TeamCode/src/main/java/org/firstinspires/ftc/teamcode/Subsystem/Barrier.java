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
public class Barrier implements Subsystem {

    private final DcMotorEx barrier;

    public Barrier(HardwareMap hardwareMap, Telemetry telemetry) {
        barrier = hardwareMap.get(DcMotorEx.class, "barrier");

        barrier.setDirection(DcMotorEx.Direction.FORWARD);

        barrier.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);


    }

    public void extend() {
        barrier.setPower(1);
    }

    public void stop() {
        barrier.setPower(0);
    }

    public void retract() {
        barrier.setPower(-1);


    }

}
