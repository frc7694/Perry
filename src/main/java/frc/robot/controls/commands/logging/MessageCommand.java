package frc.robot.controls.commands.logging;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class MessageCommand extends InstantCommand {

    public MessageCommand(String message) {
        super(() -> SmartDashboard.putString("consoleMessage", message));
    }

}
