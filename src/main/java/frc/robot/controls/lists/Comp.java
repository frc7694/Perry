package frc.robot.controls.lists;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.OI.button.ButtonType;
import frc.robot.RobotContainer;
import frc.robot.commands.util.InstantNonPhysicalCommand;
import frc.robot.controls.ControlList;
import frc.robot.controls.When;
import frc.robot.OI.Controller;
import frc.robot.OI.button.HID.*;

public enum Comp implements ControlList {

    SetX(            Controller.XBox, ClickableButton.SQUARES, When.WHILE_TRUE, new RunCommand(RobotContainer::setX)),
    XYPanic(         Controller.XBox, ClickableButton.LSTICK, When.ON_TRUE,     new InstantNonPhysicalCommand(RobotContainer::panicXY)),
    RPanic(          Controller.XBox, ClickableButton.RSTICK, When.ON_TRUE,     new InstantNonPhysicalCommand(RobotContainer::panicR)),
    ToggleFOD(       Controller.XBox, ClickableButton.B,       When.ON_TRUE,    new InstantNonPhysicalCommand(RobotContainer::toggleFOD)),
    DriverResetFOD(  Controller.XBox, ClickableButton.X,       When.ON_TRUE,    new InstantNonPhysicalCommand(RobotContainer::resetFOD)),
    ResetFOD(        Controller.HIDI1, ClickableButton.LSTICK,  When.ON_TRUE,    new InstantNonPhysicalCommand(RobotContainer::resetFOD));

//    NN(              Controller.XBox, POVButton.NN,            When.ON_TRUE,    new PIDRotateCommand(180)),
//    SS(              Controller.XBox, POVButton.SS,            When.ON_TRUE,    new PIDRotateCommand(360)),
//    EE(              Controller.XBox, POVButton.EE,            When.ON_TRUE,    new PIDRotateCommand(270)),
//    WW(              Controller.XBox, POVButton.WW,            When.ON_TRUE,    new PIDRotateCommand(90));
//    Test(            Controller.BBox, TriggerButton.DOWN,      When.ON_TRUE,    new PIDRotateCommand(90));


    public final XboxController controller;
    public final ButtonType type;
    public final When when;
    public final Command function;

    Comp(XboxController controller, ButtonType type, When when, Command function) {
        this.controller = controller;
        this.type = type;
        this.when = when;
        this.function = function;
    }

    public XboxController getController() {
        return controller;
    }

    public ButtonType getType() {
        return type;
    }

    public When getWhen() {
        return when;
    }

    public Command getFunction() {
        return function;
    }

}
