package frc.robot.controls.inputs.button.MIDI.axes;

public enum SliderAxis implements AxisType {

    PitchBend("bend"),
    Modulation("mod");

    public String pos;

    SliderAxis(String pos) {
        this.pos = pos;
    }

    @Override
    public String getPos() {
        return pos;
    }

}
