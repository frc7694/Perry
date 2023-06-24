package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;
import java.util.List;

public class Cameras {

    static UsbCamera cam0;
    static UsbCamera cam1;
    static UsbCamera cam2;
    static VideoSink server;

    public static void init() {
//        for (int i = 0; i < 1; i++) {
//            cams.set(i, CameraServer.startAutomaticCapture());
//            cams.get(i).setFPS(25);
////            cams.get(i).setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
//        }
//        server = CameraServer.getServer();
        cam0 = CameraServer.startAutomaticCapture();
        cam0.setFPS(25);
//        cam0.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
        cam1 = CameraServer.startAutomaticCapture();
        cam1.setFPS(25);
//        cam1.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
        cam2 = CameraServer.startAutomaticCapture();
        cam2.setFPS(25);
//        cam2.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
        server = CameraServer.getServer();
    }

    public static void select(int i) {
        if (Robot.isReal()) {
            switch (i) {
                case 0:
                    server.setSource(cam0);
                    break;
                case 1:
                    server.setSource(cam1);
                    break;
                case 2:
                    server.setSource(cam2);
                    break;
                default:
                    break;
            }
        }
        SmartDashboard.putNumber("cam", i);
    }

}
