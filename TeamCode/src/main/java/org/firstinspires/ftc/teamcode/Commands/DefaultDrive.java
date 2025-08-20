//package org.firstinspires.ftc.teamcode.Commands;
//
//import com.arcrobotics.ftclib.command.CommandBase;
//import org.firstinspires.ftc.teamcode.Subsystem.TankDriveSimple;
//import java.util.function.DoubleSupplier;
//
//public class DefaultDrive extends CommandBase {
//
//    private final TankDriveSimple drivetrain;
//    private final DoubleSupplier forwardSupplier;
//    private final DoubleSupplier rotateSupplier;
//    private final DoubleSupplier scaleSupplier;
//
//    public DefaultDrive(TankDriveSimple drivetrain,
//                        DoubleSupplier forwardSupplier,
//                        DoubleSupplier rotateSupplier,
//                        DoubleSupplier scaleSupplier) {
//        this.drivetrain = drivetrain;
//        this.forwardSupplier = forwardSupplier;
//        this.rotateSupplier = rotateSupplier;
//        this.scaleSupplier = scaleSupplier;
//        addRequirements(drivetrain);
//    }
//
//    @Override
//    public void execute() {
//        double forward = forwardSupplier.getAsDouble();
//        double rotate = rotateSupplier.getAsDouble();
//        double scale = scaleSupplier.getAsDouble();
//
//        drivetrain.drive(forward, rotate, scale);
//    }
//
//    @Override
//    public boolean isFinished() {
//        return false; // Default command never ends
//    }
//}
