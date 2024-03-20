package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI.Controller;

public class LauncherSubsystem extends SubsystemBase {

    CANSparkMax left = new CANSparkMax(10, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax right = new CANSparkMax(9, CANSparkMaxLowLevel.MotorType.kBrushless);

    @Override
    public void periodic() {
        double speed = (Controller.HIDI1.getRawAxis(3) + 1) / 2;
        left.set(speed * 1);
        right.set(speed * -1);
    }

}
