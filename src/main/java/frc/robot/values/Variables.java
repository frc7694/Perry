package frc.robot.values;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.values.Constants.*;

// like Constants.java but for things that aren't constant
public class Variables {
    public static long autoTime  = 0;
    public static boolean fod = OIConstants.kDefualtFODState;
    // TODO: phase out perryIsControllingHimselfAgainOhNo in favor of the SemiAutoSubsystem
    public static boolean perryIsControllingHimselfAgainOhNo = false;
    public static PIDController rotationPID = getRotationPID();
    private static PIDController getRotationPID() {
        PIDController pid = new PIDController(
                PIDConstants.kDriveRotationP,
                PIDConstants.kDriveRotationI,
                PIDConstants.kDriveRotationD);
        pid.setTolerance(PIDConstants.kDriveRotationT);
        pid.enableContinuousInput(GyroConstants.kAlsoSS, GyroConstants.kSS);
        return pid;
    }

}
