package frc.robot.OI.button.NT_MIDI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum NTKeyButton implements ButtonType {

    c4(48),
    c_4(49),
    d4(50),
    d_4(51),
    e4(52),
    f4(53),
    f_4(54),
    g4(55),
    g_4(56),
    a4(57),
    a_4(58),
    b4(59),
    c5(60),
    c_5(61),
    d5(62),
    d_5(63),
    e5(64),
    f5(65),
    f_5(66),
    g5(67),
    g_5(68),
    a5(69),
    a_5(70),
    b5(71),
    c6(72);

    public int pos;

    NTKeyButton(int pos) {
        this.pos = pos;
    }

    public int getValue() {
        return pos;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> SmartDashboard.getBoolean("midi/k" + input, false));
    }

}
