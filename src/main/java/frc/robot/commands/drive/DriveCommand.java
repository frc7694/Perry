package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

import java.util.function.BooleanSupplier;

public class DriveCommand extends CommandBase {

    double xSpeed;
    double ySpeed;
    double rot;
    BooleanSupplier done;
    long start;
    long time;

    public DriveCommand(double xSpeed, double ySpeed, double rot, BooleanSupplier done) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.rot = rot;
        this.done = done;
    }

    public DriveCommand(double xSpeed, double ySpeed, double rot, long time) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.rot = rot;
        this.time = time;
        this.done = () -> System.currentTimeMillis() - start > time;
    }

    @Override
    public void initialize() {
        this.start = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        RobotContainer.m_robotDrive.drive(xSpeed, ySpeed, rot, true, true);
    }

    @Override
    public boolean isFinished() {
        return done.getAsBoolean();
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.m_robotDrive.drive(0, 0, 0, true, true);
        super.end(interrupted);
    }

}
