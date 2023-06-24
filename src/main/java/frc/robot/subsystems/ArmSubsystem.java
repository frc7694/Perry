package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.UUID;

public class ArmSubsystem extends SubsystemBase {

    PIDController pid;
    PneumaticHub pHub = new PneumaticHub(10);
    Compressor compressor = new Compressor(10, PneumaticsModuleType.REVPH);
    Solenoid stage1 = new Solenoid(10, PneumaticsModuleType.REVPH, 2);
    CANSparkMax stage2 = new CANSparkMax(9, CANSparkMaxLowLevel.MotorType.kBrushless);
    Solenoid grabber = new Solenoid(10, PneumaticsModuleType.REVPH, 7);

    public ArmSubsystem() {
        pid = new PIDController(0.04, 0, 0);
        pid.setTolerance(2);
    }

    public void setSetpoint(double setpoint) {
        pid.setSetpoint(setpoint);
    }

    public double calculate(double measurement) {
        return pid.calculate(measurement);
    }

    public boolean atSetpoint() {
        return pid.atSetpoint();
    }

    public void moveStage2(int direction) {
        double maxSpeed = .75;
        stage2.set(maxSpeed * direction);
    }
    public void pidStage2(double pid) {
        stage2.set(pid);

    }

    public void brakeStage2() {
        stage2.set(.015);
    }

    public void setStage1(boolean value) {
        stage1.set(value);
    }

    public void toggleStage1() {
        stage1.set(!stage1.get());
    }

    public void setGrabber(boolean value) {
        grabber.set(value);
    }

    public void toggleGrabber() {
        grabber.set(!grabber.get());
    }

    public void enableCompressor() {
        int max = 120;
        compressor.enableAnalog(max - 20, max);
    }

    public void toggleCompressor() {
        if (compressor.isEnabled()) {
            compressor.disable();
        } else {
            enableCompressor();
        }
    }

    public PneumaticHub getpHub() {
        return pHub;
    }

    public void resetStage2() {
        stage2.getEncoder().setPosition(0);
        setSetpoint(0);
    }

    public double getEncoderPos() {
        return stage2.getEncoder().getPosition();
    }

}
