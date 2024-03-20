package frc.robot.OI.button.NT_MIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum NTPitchButton implements ButtonType {

    UP(0),
    DOWN(1);

    public int value;

    NTPitchButton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> {
            if (input == 0) return Math.floor(SmartDashboard.getNumber("midi/bend", .5) * 10) / 10 > .5;
            else return Math.floor(SmartDashboard.getNumber("midi/bend", .5) * 10) / 10 < .5;
        });
    }

}
