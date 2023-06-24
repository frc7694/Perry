package frc.robot.controls.commands.pneumatics;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class PneumaticCommand extends CommandBase {

    Pneumatic pneumatic;
    State state;

    public PneumaticCommand(Pneumatic pneumatic, State state) {
        super();
        this.pneumatic = pneumatic;
        this.state = state;
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        // didn't use switch cuz it was being a lil funky
        // monkey and firing both at the same time when i
        // tried to fire the grabber
        if (state == State.SWITCH) {
            if (pneumatic == Pneumatic.Stage1) {
                RobotContainer.m_robotArm.toggleStage1();
            }
            if (pneumatic == Pneumatic.Grabber) {
                RobotContainer.m_robotArm.toggleGrabber();
            }
        } else {
            if (pneumatic == Pneumatic.Stage1) {
                RobotContainer.m_robotArm.setStage1(state.value);
            }
            if (pneumatic == Pneumatic.Grabber) {
                RobotContainer.m_robotArm.setGrabber(state.value);
            }
        }
        super.end(interrupted);
    }

}
