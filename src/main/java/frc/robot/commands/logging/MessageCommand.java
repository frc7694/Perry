package frc.robot.commands.logging;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class MessageCommand extends InstantCommand {

    public MessageCommand(String message) {
        super(() -> SmartDashboard.putString("consoleMessage", message));
    }

    @Override
    public boolean runsWhenDisabled() {
        return true;
    }
}
