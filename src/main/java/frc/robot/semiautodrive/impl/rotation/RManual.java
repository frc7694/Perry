package frc.robot.semiautodrive.impl.rotation;

import edu.wpi.first.math.MathUtil;
import frc.robot.OI.axis.XBox.JoystickAxis;
import frc.robot.semiautodrive.RotationController;
import frc.robot.values.Constants.OIConstants;

public class RManual implements RotationController {
    @Override
    public double getR() {
        return -MathUtil.applyDeadband(JoystickAxis.RX.getPos(), OIConstants.kDriveDeadband);
    }
}
