package frc.robot.semiautodrive.impl.rotation;

import frc.robot.OI.Controller;
import frc.robot.RobotContainer;
import frc.robot.semiautodrive.RotationController;
import frc.robot.systems.Orangutan;
import frc.robot.values.Variables;

public class RPID implements RotationController {

    double desiredState;

    public RPID(double desiredState) {
        this.desiredState = desiredState;
    }

    @Override
    public void initialize() {
        Variables.perryIsControllingHimselfAgainOhNo = true;
        Variables.rotationPID.setSetpoint(desiredState);
    }

    @Override
    public double getR() {
        return Variables.rotationPID.calculate(Orangutan.get());
    }

    @Override
    public boolean isFinished() {
        return Variables.rotationPID.atSetpoint() || Controller.XBox.getYButton();
    }

    @Override
    public void end() {
        RobotContainer.setX();
        Variables.perryIsControllingHimselfAgainOhNo = false;
    }

}
