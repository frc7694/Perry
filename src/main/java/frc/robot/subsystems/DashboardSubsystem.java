package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.values.Constants.DriveConstants;
import frc.robot.values.Variables;
import frc.robot.commands.auto.AutoDisabled;
import frc.robot.systems.Orangutan;

public class DashboardSubsystem extends SubsystemBase {

    private SendableChooser<Command> m_autoChooser = new SendableChooser<>();
    private SendableChooser<Double> m_speedChooser = new SendableChooser<>();

    public DashboardSubsystem() {}

    public void init() {
        m_autoChooser.setDefaultOption("Disabled", new AutoDisabled());
        SmartDashboard.putData(m_autoChooser);
        m_speedChooser.setDefaultOption("Vroom: 4", DriveConstants.kDriverSpeedyAF);
        m_speedChooser.setDefaultOption("Joey: 3", DriveConstants.kDriverFast);
        m_speedChooser.addOption("Mitch: 1.5", DriveConstants.kDriverSlow);
        SmartDashboard.putData(m_speedChooser);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("nav/yaw", Orangutan.get());
        SmartDashboard.putNumber("nav/pitch", Orangutan.getPitch());
        SmartDashboard.putNumber("nav/roll", Orangutan.getRoll());
        SmartDashboard.putBoolean("fieldOriented", Variables.fod);
    }

    @Override
    public void simulationPeriodic() {
        SmartDashboard.putNumber("nav/yaw", Orangutan.get());
        SmartDashboard.putNumber("nav/pitch", Orangutan.getPitch());
        SmartDashboard.putNumber("nav/roll", Orangutan.getRoll());
        SmartDashboard.putBoolean("fieldOriented", Variables.fod);
    }

    public Command getAutonomousCommand() {
        return m_autoChooser.getSelected();
    }

    public double getSpeed() {
        return m_speedChooser.getSelected();
    }

}
