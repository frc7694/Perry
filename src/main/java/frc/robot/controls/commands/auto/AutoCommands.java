package frc.robot.controls.commands.auto;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.OffsettableGyro;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.controls.commands.drive.BalanceCommand;
import frc.robot.controls.commands.drive.BrakeCommand;
import frc.robot.controls.commands.drive.DriveCommand;
import frc.robot.controls.commands.drive.PIDRotateCommand;
import frc.robot.controls.commands.pneumatics.Pneumatic;
import frc.robot.controls.commands.pneumatics.PneumaticCommand;
import frc.robot.controls.commands.pneumatics.State;
import frc.robot.controls.commands.position.Position;
import frc.robot.controls.commands.position.ArmPIDCommand;
import frc.robot.controls.commands.position.PositionCommand;
import frc.robot.controls.commands.position.ResettableHomeCommands;
import frc.robot.controls.commands.wait.TimeCommand;

public class AutoCommands extends SequentialCommandGroup {

    public AutoCommands(AutoMode mode) {
        switch (mode) {
            case Balance: {
                //TODO add autobalance command
                addCommands(new PositionCommand(Position.LOW));
                addCommands(new ParallelCommandGroup(
                        new PositionCommand(Position.HOME),
                        new DriveCommand(-2, 0, 0, (long) ((Units.feetToMeters(16) / Constants.AutoConstants.kMaxSpeedMetersPerSecond) * 1000))
                ));
                addCommands(new PIDRotateCommand(90));
                addCommands(new DriveCommand(.9, 0, 0, (long) ((Units.feetToMeters(6) / Constants.AutoConstants.kMaxSpeedMetersPerSecond) * 1000)));
                addCommands(new InstantCommand(RobotContainer::resetFOD));
                addCommands(new BalanceCommand());
                addCommands(new BrakeCommand(() -> !BalanceCommand.isBalanced()));
                addCommands(new BalanceCommand());
                addCommands(new BrakeCommand(() -> !BalanceCommand.isBalanced()));
                addCommands(new BalanceCommand());
                addCommands(new BrakeCommand(() -> !BalanceCommand.isBalanced()));
                addCommands(new BalanceCommand());
                addCommands(new BrakeCommand(() -> !BalanceCommand.isBalanced()));
                addCommands(new BalanceCommand());
                addCommands(new BrakeCommand(() -> !BalanceCommand.isBalanced()));
                addCommands(new BalanceCommand());
                addCommands(new BrakeCommand(() -> !BalanceCommand.isBalanced()));
                addCommands(new BalanceCommand());
                addCommands(new BrakeCommand(() -> !BalanceCommand.isBalanced()));
            }
            case Score: {
                addCommands(new PositionCommand(Position.HOME));
                addCommands(new PneumaticCommand(Pneumatic.Grabber, State.CLOSE));
                addCommands(new TimeCommand(750));
                addCommands(new DriveCommand(-1, 0, 0, (long) ((Units.feetToMeters(2) / Constants.AutoConstants.kMaxSpeedMetersPerSecond) * 1000)));
                addCommands(new PositionCommand(Position.RESET));
                addCommands(new PneumaticCommand(Pneumatic.Stage1, State.OUT));
                addCommands(new TimeCommand(500));
                addCommands(new PositionCommand(Position.TOP));
                addCommands(new DriveCommand(1, 0, 0, (long) ((Units.feetToMeters(1.5) / Constants.AutoConstants.kMaxSpeedMetersPerSecond) * 1000)));
                addCommands(new TimeCommand(500));
                addCommands(new PneumaticCommand(Pneumatic.Grabber, State.OPEN));
                addCommands(new PneumaticCommand(Pneumatic.Stage1, State.UP));
                addCommands(new TimeCommand(500));
                addCommands(new DriveCommand(-1, 0, 0, (long) ((Units.feetToMeters(2) / Constants.AutoConstants.kMaxSpeedMetersPerSecond) * 1000)));
                addCommands(new PositionCommand(Position.RESET));
                addCommands(new PositionCommand(Position.HOME));
                addCommands(new DriveCommand(-1, 0, 0, (long) ((Units.feetToMeters(2) / Constants.AutoConstants.kMaxSpeedMetersPerSecond) * 1000)));
                addCommands(new DriveCommand(0, 0, 1, () -> OffsettableGyro.is(360) ));
                //addCommands(new InstantCommand(RobotContainer::resetFOD));
                addCommands(new DriveCommand(-1, 0, 0, (long) ((Units.feetToMeters(20) / Constants.AutoConstants.kMaxSpeedMetersPerSecond) * 1000)));
            }
            case Balance2: {
                addCommands(new PositionCommand(Position.LOW));
            }
            case None: {
                addCommands(new InstantCommand(RobotContainer::resetFOD));
            }
        }
    }

}
