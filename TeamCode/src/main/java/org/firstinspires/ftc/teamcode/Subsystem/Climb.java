package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Climb implements Subsystem {

    private final DcMotorEx lClimb, rClimb;

    public Climb(HardwareMap hardwareMap, Telemetry telemetry) {
        lClimb = hardwareMap.get(DcMotorEx.class, "lClimb");
        lClimb.setDirection(DcMotorEx.Direction.FORWARD); // REVERSE if needed
        lClimb.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        lClimb.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER); // or WITH_ENCODER if needed

        rClimb = hardwareMap.get(DcMotorEx.class, "rClimb");
        rClimb.setDirection(DcMotorEx.Direction.REVERSE); // REVERSE if needed
        rClimb.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rClimb.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER); // or WITH_ENCODER if needed
    }

    public void climbUp() {
        lClimb.setPower(1);
        rClimb.setPower(1); // full power (adjust if needed)
    }

    public void stopClimb() {
        lClimb.setPower(0);
        rClimb.setPower(0);
    }

    public double getPower() {
        return lClimb.getPower();
    }
    public void climbDown() {
        lClimb.setPower(-1);
        rClimb.setPower(-1); // full power reverse
    }

}
