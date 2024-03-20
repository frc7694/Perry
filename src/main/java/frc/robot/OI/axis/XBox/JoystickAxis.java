package frc.robot.OI.axis.XBox;

import frc.robot.OI.Controller;
import frc.robot.OI.axis.AxisType;

public enum JoystickAxis implements AxisType {

    LX(0),
    LY(1),
    RX(4),
    RY(5);

    private int axis;

    JoystickAxis(int axis) {
        this.axis = axis;
    }

    @Override
    public double getPos() {
        return Controller.XBox.getRawAxis(axis);
    }

}
