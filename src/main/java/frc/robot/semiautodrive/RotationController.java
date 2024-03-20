package frc.robot.semiautodrive;

import frc.robot.values.Constants;

public interface RotationController {
    default void initialize() {}
    default void end() {}
    default double getR() {
        return Constants.OIConstants.kStopped;
    }
    default boolean isFinished() {
        return false;
    }
}
