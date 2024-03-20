package frc.robot.OI.axis.NT_MIDI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI.axis.AxisType;

public enum NTSliderAxis implements AxisType {

    PitchBend("bend"),
    Modulation("mod");

    private String pos;

    NTSliderAxis(String pos) {
        this.pos = pos;
    }

    @Override
    public double getPos() {
        return SmartDashboard.getNumber("midi/" + getPos(), .5);
    }

}
