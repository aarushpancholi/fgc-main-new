package org.firstinspires.ftc.teamcode.Commands;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.Climb;
import org.firstinspires.ftc.teamcode.Subsystem.Collection;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;

public class ResetCollectionPos extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Collection collection;
    public ResetCollectionPos(Collection subsystem) {
        collection = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        //turn outtake on
        collection.reset();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}


