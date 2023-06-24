package frc.robot.controls.inputs.button.MIDI.axes.supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.controls.inputs.button.MIDI.axes.AxisType;

public class DialSliderSupplier {

    public static double get(AxisType axisType) {
        return SmartDashboard.getNumber("midi/" + axisType.getPos(), .5);
    }

}
