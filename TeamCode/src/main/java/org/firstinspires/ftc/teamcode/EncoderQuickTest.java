package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name="Encoder Quick Test", group="Test")
public class EncoderQuickTest extends LinearOpMode {
    private DcMotorEx left, right;

    @Override
    public void runOpMode() {
        left  = hardwareMap.get(DcMotorEx.class, "leftMotor_Intake");
        right = hardwareMap.get(DcMotorEx.class, "rightMotor_Intake");

        // 1) Reset encoders
        left.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        // 2) Put them in RUN_USING_ENCODER so ticks should update freely
        left.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        // Optional but nice for sanity
        left.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        waitForStart();

        while (opModeIsActive()) {
            // Slowly drive with left stick to make the motors turn
            double p = -gamepad1.left_stick_y * 0.2;
            left.setPower(p);
            right.setPower(p);

            telemetry.addData("Left pos", left.getCurrentPosition());
            telemetry.addData("Right pos", right.getCurrentPosition());
            telemetry.update();
        }
    }
}
