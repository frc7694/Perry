package frc.robot.OI.axis.XBox;

import frc.robot.OI.Controller;
import frc.robot.OI.axis.AxisType;

public enum TriggerAxis implements AxisType {

    LT(2),
    RT(3);

    private int axis;

    TriggerAxis(int axis) {
        this.axis = axis;
    }

    @Override
    public double getPos() {
        return Controller.XBox.getRawAxis(axis);
    }

}
