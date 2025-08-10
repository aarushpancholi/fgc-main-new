package org.firstinspires.ftc.teamcode.Commands;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.Climb;

public class ClimbOff extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Climb climb;
    public ClimbOff(Climb subsystem) {
        climb = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        //turn outtake on
        climb.stopClimb();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}


