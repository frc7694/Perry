package frc.robot.semiautodrive.impl.strafe;

import edu.wpi.first.math.MathUtil;
import frc.robot.OI.axis.XBox.JoystickAxis;
import frc.robot.semiautodrive.StrafeController;
import frc.robot.values.Constants.OIConstants;

public class XYManual implements StrafeController {
    @Override
    public double getX() {
        return -MathUtil.applyDeadband(JoystickAxis.LX.getPos(), OIConstants.kDriveDeadband);
    }

    @Override
    public double getY() {
        return -MathUtil.applyDeadband(JoystickAxis.LX.getPos(), OIConstants.kDriveDeadband);
    }
}
