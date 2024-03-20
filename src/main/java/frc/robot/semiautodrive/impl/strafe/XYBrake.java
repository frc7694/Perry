package frc.robot.semiautodrive.impl.strafe;

import frc.robot.semiautodrive.StrafeController;

public class XYBrake implements StrafeController {
    @Override
    public boolean getBrake() {
        return true;
    }
}
