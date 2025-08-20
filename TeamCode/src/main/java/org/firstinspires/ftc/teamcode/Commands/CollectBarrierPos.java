//package org.firstinspires.ftc.teamcode.Commands;
//import com.arcrobotics.ftclib.command.CommandBase;
//
//import org.firstinspires.ftc.teamcode.Subsystem.Climb;
//import org.firstinspires.ftc.teamcode.Subsystem.Intake;
//
//public class CollectBarrierPos extends CommandBase{
//    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
//    private final Intake intake;
//    public CollectBarrierPos(Intake subsystem) {
//        intake = subsystem;
//
//        addRequirements(subsystem);
//    }
//
//    @Override
//    public void initialize() {
//        //turn outtake on
//        intake.mainPos();
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
