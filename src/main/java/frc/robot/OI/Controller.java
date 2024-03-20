package frc.robot.OI;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.values.Constants.OIConstants;

public class Controller {

    public static XboxController XBox = new XboxController(OIConstants.kDriverHIDPort);
    public static XboxController HIDI1 = new XboxController(OIConstants.kOperatorMIDI1Port);
    public static XboxController HIDI2 = new XboxController(OIConstants.kOperatorMIDI2Port);
    public static XboxController HIDI3 = new XboxController(OIConstants.kOperatorMIDI3Port);

}
