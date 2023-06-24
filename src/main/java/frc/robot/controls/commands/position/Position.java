package frc.robot.controls.commands.position;

import frc.robot.controls.commands.pneumatics.State;

public enum Position {
    HOME(State.UP, 9),
    TOP(State.OUT, 90),
    MID(State.OUT, 81),
    LOW(State.UP, 27),
    PICKUP1(State.OUT, 22),
    PICKUP2(State.OUT, 32),
    SINGLE(State.UP, 5),
    DOUBLE(State.UP, 45),
    RESET(State.UP, 56);

    State stage1;
    int stage2;

    Position(State stage1, int stage2) {
        this.stage1 = stage1;
        this.stage2 = stage2;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
