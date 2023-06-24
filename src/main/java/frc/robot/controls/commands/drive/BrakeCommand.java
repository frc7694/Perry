package frc.robot.controls.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RunningConfig;

import java.util.function.BooleanSupplier;

public class BrakeCommand extends CommandBase {

    BooleanSupplier done;

    public BrakeCommand(BooleanSupplier done) {
        super();
        this.done = done;
    }

    @Override
    public void initialize() {
        RunningConfig.perryIsControllingHimselfAgainOhNo = true;
        super.initialize();
    }

    @Override
    public void execute() {
        RobotContainer.m_robotDrive.setX();
    }

    @Override
    public boolean isFinished() {
        return done.getAsBoolean();
    }

    @Override
    public void end(boolean interrupted) {
        RunningConfig.perryIsControllingHimselfAgainOhNo = false;
        super.end(interrupted);
    }

}
