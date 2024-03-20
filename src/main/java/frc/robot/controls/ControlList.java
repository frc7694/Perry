package frc.robot.controls;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.OI.button.ButtonType;

public interface ControlList {

    XboxController getController();
    ButtonType getType();
    When getWhen();
    Command getFunction();

}
