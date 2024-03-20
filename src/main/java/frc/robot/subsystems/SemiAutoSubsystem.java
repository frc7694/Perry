package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.semiautodrive.RotationController;
import frc.robot.semiautodrive.StrafeController;
import frc.robot.semiautodrive.impl.rotation.RLock;
import frc.robot.semiautodrive.impl.strafe.XYManual;

import java.util.ArrayList;
import java.util.List;

public class SemiAutoSubsystem extends SubsystemBase {

    public List<StrafeController> xyQueue = new ArrayList<>();
    public List<RotationController> rQueue = new ArrayList<>();

    private StrafeController xyCtrl;
    private RotationController rCtrl;

    public SemiAutoSubsystem() {
        setStrafeController(new XYManual());
        setRotationController(new RLock());
    }
    public SemiAutoSubsystem(StrafeController xyCtrl, RotationController rCtrl) {
        setStrafeController(xyCtrl);
        setRotationController(rCtrl);
    }

    @Override
    public void periodic() {
        if (xyCtrl.isFinished()) {
            if (xyQueue.size() > 0) {
                setStrafeController(xyQueue.get(0));
                xyQueue.remove(0);
            } else {
                setStrafeController(new XYManual());
            }
        }
        if (rCtrl.isFinished()) {
            if (rQueue.size() > 0) {
                setRotationController(rQueue.get(0));
                rQueue.remove(0);
            } else {
                setRotationController(new RLock());
            }
        }
    }

    public double getX() {
        return xyCtrl.getX();
    }
    public double getY() {
        return xyCtrl.getY();
    }
    public double getR() {
        return rCtrl.getR();
    }
    public boolean getBrake() {
        return xyCtrl.getBrake();
    }

    public void setStrafeController(StrafeController xyCtrl) {
        this.xyCtrl.end();
        this.xyCtrl = xyCtrl;
        xyCtrl.initialize();
    }

    public void setRotationController(RotationController rCtrl) {
        this.rCtrl.end();
        this.rCtrl = rCtrl;
        rCtrl.initialize();
    }

}
