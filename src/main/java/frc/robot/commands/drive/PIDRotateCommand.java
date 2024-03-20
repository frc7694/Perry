package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.systems.Orangutan;
import frc.robot.RobotContainer;
import frc.robot.values.Variables;
import frc.robot.OI.Controller;

public class PIDRotateCommand extends CommandBase {

    double desiredState;

    public PIDRotateCommand(double desiredState) {
        super();
        this.desiredState = desiredState;
    }

    @Override
    public void initialize() {
        Variables.perryIsControllingHimselfAgainOhNo = true;
        Variables.rotationPID.setSetpoint(desiredState);
        super.initialize();
    }

    @Override
    public void execute() {
        RobotContainer.m_robotDrive.drive(0, 0, Variables.rotationPID.calculate(Orangutan.get()), true, true);
    }

    @Override
    public boolean isFinished() {
        return Variables.rotationPID.atSetpoint() || Controller.XBox.getYButton();
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.setX();
        Variables.perryIsControllingHimselfAgainOhNo = false;
        super.end(interrupted);
    }

}
