package frc.robot.controls.commands.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OffsettableGyro;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RunningConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class BalanceCommand extends CommandBase {

    List<Long> wasBalanced;
    boolean wasFOD;
    double speed;
    long speedDecreased;

    public BalanceCommand() {
        super();
        wasBalanced = new ArrayList<>();
        speed = .2;
        speedDecreased = 0;
    }

    public static boolean isBalanced() {
        return Math.abs(OffsettableGyro.getRoll()) < 2;
    }

    @Override
    public void initialize() {
        wasFOD = RunningConfig.fod;
        RunningConfig.perryIsControllingHimselfAgainOhNo = true;
        RunningConfig.fod = false;
        wasBalanced = new ArrayList<>();
        speed = .2;
        speedDecreased = 0;
        super.initialize();
    }

    @Override
    public void execute() {
        if (Math.abs(OffsettableGyro.getRoll()) < 2) wasBalanced.add(System.currentTimeMillis());
        int wasSize = wasBalanced.size();
        wasBalanced = wasBalanced.stream().filter((time) -> System.currentTimeMillis() - time < 1000).collect(Collectors.toList());
        if (OffsettableGyro.getRoll() > 2) {
            RobotContainer.m_robotDrive.drive(0, -speed, 0, true, true);
        } else if (OffsettableGyro.getRoll() < -2) {
            RobotContainer.m_robotDrive.drive(0, speed, 0, true, true);
        }
        SmartDashboard.putNumber("wasBalanced", wasBalanced.size());
        SmartDashboard.putNumber("speed", speed);
        if (wasBalanced.size() > 2 && System.currentTimeMillis() - speedDecreased > 1500) {
            if (speed == .2) speed = .15;
            else if (speed == .15) speed = .125;
            speedDecreased = System.currentTimeMillis();
        }
    }

    @Override
    public boolean isFinished() {
        return wasBalanced.size() > 30;
    }

    @Override
    public void end(boolean interrupted) {
        RunningConfig.perryIsControllingHimselfAgainOhNo = false;
        RunningConfig.fod = wasFOD;
        super.end(interrupted);
    }

}
