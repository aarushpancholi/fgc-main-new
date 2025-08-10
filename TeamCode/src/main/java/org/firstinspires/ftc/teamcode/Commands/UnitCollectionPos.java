package org.firstinspires.ftc.teamcode.Commands;
import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.Climb;
import org.firstinspires.ftc.teamcode.Subsystem.Collection;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;

public class UnitCollectionPos extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Collection collection;
    public UnitCollectionPos(Collection subsystem) {
        collection = subsystem;

        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        //turn outtake on
        collection.collect();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}


