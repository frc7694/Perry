package frc.robot.semiautodrive;

import frc.robot.values.Constants;

public interface StrafeController {
    default void initialize() {}
    default void end() {}
    default double getX() {
        return Constants.OIConstants.kStopped;
    }
    default double getY() {
        return Constants.OIConstants.kStopped;
    }
    default boolean getBrake() {
        return false;
    }
    default boolean isFinished() {
        return false;
    }
}
