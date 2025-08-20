//package org.firstinspires.ftc.teamcode.Commands;
//import com.arcrobotics.ftclib.command.CommandBase;
//
//import org.firstinspires.ftc.teamcode.Subsystem.Climb;
//import org.firstinspires.ftc.teamcode.Subsystem.Intake;
//import org.firstinspires.ftc.teamcode.Subsystem.Stopper;
//
//public class RightStop extends CommandBase{
//    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//    private final Stopper stopper;
//    public RightStop(Stopper subsystem) {
//        stopper = subsystem;
//
//        addRequirements(subsystem);
//    }
//
//    @Override
//    public void initialize() {
//        //turn outtake on
//        stopper.rightStop();
//    }
//
//    @Override
//    public boolean isFinished() {
//        return true;
//    }
//
//}
//
//
