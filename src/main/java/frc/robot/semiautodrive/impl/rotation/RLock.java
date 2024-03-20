package frc.robot.semiautodrive.impl.rotation;

import frc.robot.semiautodrive.RotationController;
import frc.robot.systems.Orangutan;
import frc.robot.values.Constants.GyroConstants;
import frc.robot.values.Variables;

public class RLock implements RotationController {
    @Override
    public void initialize() {
        Variables.rotationPID.setSetpoint(GyroConstants.kNN);
    }

    @Override
    public double getR() {
        return Variables.rotationPID.calculate(Orangutan.get());
    }
}
