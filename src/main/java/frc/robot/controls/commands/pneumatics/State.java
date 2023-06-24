package frc.robot.controls.commands.pneumatics;

public enum State {

    // Stage1
    UP(false),
    OUT(true),
    //  Grabber
    OPEN(false),
    CLOSE(true),
    SWITCH(true);

    public boolean value;

    State(boolean value) {
        this.value = value;
    }
}
