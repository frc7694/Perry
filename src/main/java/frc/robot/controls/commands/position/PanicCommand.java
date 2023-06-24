package frc.robot.controls.commands.position;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RunningConfig;

import java.util.function.BooleanSupplier;

public class PanicCommand extends CommandBase {

    long start;
    long time;

    public PanicCommand() {
        super();
        this.time = 500;
    }

    @Override
    public void initialize() {
        this.start = System.currentTimeMillis();
        RunningConfig.perrysArmIsControllingItselfAgainOhNo = true;
        super.initialize();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - start > time;
    }

    @Override
    public void end(boolean interrupted) {
        RunningConfig.perrysArmIsControllingItselfAgainOhNo = false;
        super.end(interrupted);
    }

}
