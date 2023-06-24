package frc.robot.controls.inputs.button.MIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.controls.inputs.button.ButtonType;

public enum ModButton implements ButtonType {

    MOD;

    public int getValue() {
        return 0;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> SmartDashboard.getBoolean("midi/modChanged", false));
    }

}
