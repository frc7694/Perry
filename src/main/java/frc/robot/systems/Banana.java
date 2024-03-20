package frc.robot.systems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import frc.robot.values.Constants.OIConstants;

public class Banana {

    static UsbCamera cam0;
    static UsbCamera cam1;

    public static void init() {
        cam0 = CameraServer.startAutomaticCapture();
        cam0.setFPS(OIConstants.kCameraFPS);
        cam1 = CameraServer.startAutomaticCapture();
        cam1.setFPS(OIConstants.kCameraFPS);
    }

    public static boolean isPeelable() {
        return !Orangutan.isPeelable();
    }

    public static boolean isEdible() {
        return !Orangutan.isEdible();
    }

}
