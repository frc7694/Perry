package frc.robot.controls.commands.position;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RunningConfig;
import frc.robot.subsystems.ArmSubsystem;

public class ArmPIDCommand extends CommandBase {

    ArmSubsystem arm = RobotContainer.m_robotArm;

    public ArmPIDCommand() {
        super();
        addRequirements(RobotContainer.m_robotArm);
    }

    @Override
    public void initialize() {
        RunningConfig.pid = true;
        RobotContainer.m_robotArm.setSetpoint(RobotContainer.m_robotArm.getEncoderPos());
        super.initialize();
    }

    @Override
    public void execute() {
        RobotContainer.m_robotArm.pidStage2(arm.calculate(RobotContainer.m_robotArm.getEncoderPos()));
    }

    @Override
    public boolean isFinished() {
        return RunningConfig.perrysArmIsControllingItselfAgainOhNo;
    }

    @Override
    public void end(boolean interrupted) {
        RunningConfig.pid = false;
        super.end(interrupted);
    }

}
