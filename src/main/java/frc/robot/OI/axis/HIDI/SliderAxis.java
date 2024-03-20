package frc.robot.OI.axis.HIDI;

import frc.robot.OI.Controller;
import frc.robot.OI.axis.AxisType;

public enum SliderAxis implements AxisType {

    PITCH_BEND(1),
    MODULATION(2);

    private int axis;

    SliderAxis(int axis) {
        this.axis = axis;
    }

    @Override
    public double getPos() {
        return Controller.HIDI3.getRawAxis(axis);
    }

}
