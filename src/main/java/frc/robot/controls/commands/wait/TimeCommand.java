package frc.robot.controls.commands.wait;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TimeCommand extends CommandBase {

    long start;
    long length;

    public TimeCommand(long length) {
        super();
        this.length = length;
    }

    @Override
    public void initialize() {
        this.start = System.currentTimeMillis();
        super.initialize();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - start > length;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

}
