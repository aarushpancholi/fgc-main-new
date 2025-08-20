//package org.firstinspires.ftc.teamcode.Commands;
//import com.arcrobotics.ftclib.command.CommandBase;
//
//import org.firstinspires.ftc.teamcode.Subsystem.Climb;
//import org.firstinspires.ftc.teamcode.Subsystem.Intake;
//import org.firstinspires.ftc.teamcode.Subsystem.Stopper;
//
//public class LeftStop extends CommandBase{
//    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//    private final Stopper stopper;
//    public LeftStop(Stopper subsystem) {
//        stopper = subsystem;
//
//        addRequirements(subsystem);
//    }
//
//    @Override
//    public void initialize() {
//        //turn outtake on
//        stopper.leftStop();
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
