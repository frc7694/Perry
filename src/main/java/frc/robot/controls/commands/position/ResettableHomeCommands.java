package frc.robot.controls.commands.position;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ResettableHomeCommands extends SequentialCommandGroup {

    public ResettableHomeCommands() {
        addCommands(new PositionCommand(Position.RESET));
        addCommands(new PositionCommand(Position.HOME));
    }

}
