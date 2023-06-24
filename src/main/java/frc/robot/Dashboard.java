package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.controls.commands.auto.AutoCommands;
import frc.robot.controls.commands.auto.AutoMode;

public class Dashboard {

    static SendableChooser<Command> m_autoChooser = new SendableChooser<>();
    static SendableChooser<Double> m_speedChooser = new SendableChooser<>();

    public static void initDashboard() {
        m_autoChooser.setDefaultOption("Balance", new AutoCommands(AutoMode.Balance));
        m_autoChooser.addOption("Score", new AutoCommands(AutoMode.Score));
        m_autoChooser.addOption("Disabled", new AutoCommands(AutoMode.None));
        m_autoChooser.addOption("195", new AutoCommands(AutoMode.Balance2));
        SmartDashboard.putData(m_autoChooser);
        m_speedChooser.setDefaultOption("Joey: 3", 3.0);
        m_speedChooser.addOption("Mitch: 1.5", 1.5);
        SmartDashboard.putData(m_speedChooser);
    }

    public static void update() {
        SmartDashboard.putNumber("compressorAmt0", RobotContainer.m_robotArm.getpHub().getPressure(0));
        SmartDashboard.putNumber("nav/yaw", OffsettableGyro.get());
        SmartDashboard.putNumber("nav/pitch", OffsettableGyro.getPitch());
        SmartDashboard.putNumber("nav/roll", OffsettableGyro.getRoll());
        SmartDashboard.putNumber("stage2", RobotContainer.m_robotArm.getEncoderPos());
        SmartDashboard.putBoolean("fieldOriented", RunningConfig.fod);
        SmartDashboard.putString("position", RunningConfig.pos.toString());
    }

    public static void simUpdate() {
        SmartDashboard.putNumber("nav/yaw", OffsettableGyro.get());
        SmartDashboard.putNumber("nav/pitch", OffsettableGyro.getPitch());
        SmartDashboard.putNumber("nav/roll", OffsettableGyro.getRoll());
        SmartDashboard.putNumber("stage2", RobotContainer.m_robotArm.getEncoderPos());
        SmartDashboard.putBoolean("fieldOriented", RunningConfig.fod);
        SmartDashboard.putString("position", RunningConfig.pos.toString());
    }

    public static Command getAutonomousCommand() {
        return m_autoChooser.getSelected();
    }

    public static double getSpeed() {
        return m_speedChooser.getSelected();
    }

}