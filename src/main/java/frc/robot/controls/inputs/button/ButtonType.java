package frc.robot.controls.inputs.button;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface ButtonType {

    int getValue();
    Trigger getSupplier(XboxController controller, int input);

}
