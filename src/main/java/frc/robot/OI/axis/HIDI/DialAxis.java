package frc.robot.OI.axis.HIDI;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.OI.Controller;
import frc.robot.OI.axis.AxisType;

public enum DialAxis implements AxisType {

    E1(Controller.HIDI1, 1),
    E2(Controller.HIDI1, 2),
    E3(Controller.HIDI1, 3),
    E4(Controller.HIDI1, 4),
    E5(Controller.HIDI2, 1),
    E6(Controller.HIDI2, 2),
    E7(Controller.HIDI2, 3),
    E8(Controller.HIDI2, 4);

    private XboxController ctrl;
    private int axis;

    DialAxis(XboxController ctrl, int axis) {
        this.ctrl = ctrl;
        this.axis = axis;
    }

    @Override
    public double getPos() {
        return ctrl.getRawAxis(axis);
    }

}
