package frc.robot.controls.commands.position;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RunningConfig;

public class PositionCommand extends CommandBase {

    Position pos;
    long start = 0;

    public PositionCommand(Position pos) {
        super();
        this.pos = pos;
    }

    @Override
    public void initialize() {
        RobotContainer.m_robotArm.setStage1(pos.stage1.value);
        start = System.currentTimeMillis();
        if (pos.stage2 <= Position.RESET.stage2) RobotContainer.m_robotArm.setSetpoint(pos.stage2);
        if (!RunningConfig.pid) new ArmPIDCommand().schedule();
        super.initialize();
    }

    @Override
    public void execute() {
//        if (RunningConfig.pos == Position.RESET)
        if (RunningConfig.pos != Position.RESET || System.currentTimeMillis() - start > 1000)
        RobotContainer.m_robotArm.setSetpoint(pos.stage2);
    }

    @Override
    public boolean isFinished() {
        return (RunningConfig.pos != Position.RESET || System.currentTimeMillis() - start > 1000) && RobotContainer.m_robotArm.atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
        RunningConfig.pos = pos;
        RobotContainer.m_robotArm.brakeStage2();
        super.end(interrupted);
    }

}
