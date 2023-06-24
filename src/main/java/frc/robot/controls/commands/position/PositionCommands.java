package frc.robot.controls.commands.position;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import java.util.UUID;

public class PositionCommands extends SequentialCommandGroup {

    public PositionCommands(Position pos1, Position pos2) {
        super(
                new PositionCommand(pos1),
                new InstantCommand(() -> SmartDashboard.putString("e", UUID.randomUUID().toString())),
                new PositionCommand(pos2)
        );
    }

}
