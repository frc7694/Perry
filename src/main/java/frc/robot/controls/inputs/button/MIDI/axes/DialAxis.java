package frc.robot.controls.inputs.button.MIDI.axes;

public enum DialAxis implements AxisType {

    E1("d0"),
    E2("d1"),
    E3("d2"),
    E4("d3"),
    E5("d4"),
    E6("d5"),
    E7("d6"),
    E8("d7");

    public String pos;

    DialAxis(String pos) {
        this.pos = pos;
    }

    @Override
    public String getPos() {
        return pos;
    }

}
