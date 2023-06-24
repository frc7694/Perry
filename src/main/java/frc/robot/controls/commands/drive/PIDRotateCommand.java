package frc.robot.controls.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OffsettableGyro;
import frc.robot.RobotContainer;
import frc.robot.RunningConfig;
import frc.robot.controls.inputs.Controller;

public class PIDRotateCommand extends CommandBase {

    double desiredState;

    public PIDRotateCommand(double desiredState) {
        super();
        this.desiredState = desiredState;
    }

    @Override
    public void initialize() {
        RunningConfig.perryIsControllingHimselfAgainOhNo = true;
        RunningConfig.rotationPID.setSetpoint(desiredState);
        super.initialize();
    }

    @Override
    public void execute() {
        RobotContainer.m_robotDrive.drive(0, 0, RunningConfig.rotationPID.calculate(OffsettableGyro.get()), true, true);
    }

    @Override
    public boolean isFinished() {
        return OffsettableGyro.is(desiredState) || Controller.XBox.getYButton();
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.setX();
        RunningConfig.perryIsControllingHimselfAgainOhNo = false;
        super.end(interrupted);
    }

}
