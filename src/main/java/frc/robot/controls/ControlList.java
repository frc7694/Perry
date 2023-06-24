package frc.robot.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.controls.inputs.button.ButtonType;

public interface ControlList {

    XboxController getController();
    ButtonType getType();
    When getWhen();
    Command getFunction();

}
