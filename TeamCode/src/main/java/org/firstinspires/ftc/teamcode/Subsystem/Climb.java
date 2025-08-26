package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.Subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Climb implements Subsystem {

    private final DcMotorEx climb;

    public Climb(HardwareMap hardwareMap, Telemetry telemetry) {
        climb = hardwareMap.get(DcMotorEx.class, "climb");
        climb.setDirection(DcMotorEx.Direction.FORWARD); // REVERSE if needed
        climb.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        climb.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER); // or WITH_ENCODER if needed
    }

    public void climbUp() {
        climb.setPower(1); // full power (adjust if needed)
    }

    public void stopClimb() {
        climb.setPower(0.0);
    }

    public double getPower() {
        return climb.getPower();
    }
    public void climbDown() {
        climb.setPower(-1); // full power reverse
    }

}
