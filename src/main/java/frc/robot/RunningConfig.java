package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.controls.commands.position.Position;

public class RunningConfig {
    public static long autoTime  = 0;
    public static Position pos = Position.HOME;
    public static boolean fod = true;
    public static boolean perryIsControllingHimselfAgainOhNo = false;
    public static boolean perrysArmIsControllingItselfAgainOhNo = false;
    public static boolean pid = false;
    public static PIDController rotationPID = getRotationPID();
    public static double lastModPressed = .5;
//    public static SwerveModuleState[] lastStates = {
//            new SwerveModuleState(0, Rotation2d.fromDegrees(45)),
//            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
//            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
//            new SwerveModuleState(0, Rotation2d.fromDegrees(45))
//
//    };

    public static PIDController getRotationPID() {
        PIDController pid = new PIDController(-.01, 0, 0);
        pid.enableContinuousInput(0, 360);
        return pid;
    }

}
