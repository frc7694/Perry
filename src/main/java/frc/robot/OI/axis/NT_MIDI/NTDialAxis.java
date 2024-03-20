package frc.robot.OI.axis.NT_MIDI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI.axis.AxisType;

public enum NTDialAxis implements AxisType {

    E1("d0"),
    E2("d1"),
    E3("d2"),
    E4("d3"),
    E5("d4"),
    E6("d5"),
    E7("d6"),
    E8("d7");

    private String pos;

    NTDialAxis(String pos) {
        this.pos = pos;
    }

    @Override
    public double getPos() {
        return SmartDashboard.getNumber("midi/" + getPos(), .5);
    }

}
