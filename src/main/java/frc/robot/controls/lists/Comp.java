package frc.robot.controls.lists;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Cameras;
import frc.robot.RobotContainer;
import frc.robot.controls.ControlList;
import frc.robot.controls.When;
import frc.robot.controls.inputs.Controller;
import frc.robot.controls.commands.pneumatics.Pneumatic;
import frc.robot.controls.commands.pneumatics.PneumaticCommand;
import frc.robot.controls.commands.pneumatics.State;
import frc.robot.controls.commands.position.*;
import frc.robot.controls.inputs.button.*;
import frc.robot.controls.inputs.button.HID.ClickableButton;
import frc.robot.controls.inputs.button.HID.POVButton;
import frc.robot.controls.inputs.button.HID.TriggerButton;

public enum Comp implements ControlList {

    SetX(            Controller.XBox, ClickableButton.SQUARES, When.WHILE_TRUE, new RunCommand(RobotContainer::setX)),
    ToggleFOD(       Controller.XBox, ClickableButton.B,       When.ON_TRUE,    new InstantCommand(RobotContainer::toggleFOD)),
    DriverResetFOD(  Controller.XBox, ClickableButton.X,       When.ON_TRUE,    new InstantCommand(RobotContainer::resetFOD)),
    Stage1Toggle(    Controller.BBox, POVButton.WW,            When.ON_TRUE,    new PneumaticCommand(Pneumatic.Stage1, State.SWITCH)),
    GrabberToggle(   Controller.BBox, POVButton.EE,            When.ON_TRUE,    new PneumaticCommand(Pneumatic.Grabber, State.SWITCH)),
    Stage2Up(        Controller.BBox, POVButton.NN,            When.WHILE_TRUE, new InstantCommand(() -> RobotContainer.m_robotArm.moveStage2(1), RobotContainer.m_robotArm)),
    Stage2Down(      Controller.BBox, POVButton.SS,            When.WHILE_TRUE, new InstantCommand(() -> RobotContainer.m_robotArm.moveStage2(-1), RobotContainer.m_robotArm)),
    Stage2UpBreak(   Controller.BBox, POVButton.NN,            When.ON_FALSE,   new InstantCommand(RobotContainer.m_robotArm::brakeStage2).andThen(new ArmPIDCommand())),
    Stage2DownBreak( Controller.BBox, POVButton.SS,            When.ON_FALSE,   new InstantCommand(RobotContainer.m_robotArm::brakeStage2).andThen(new ArmPIDCommand())),
    Home(            Controller.BBox, TriggerButton.L,         When.ON_TRUE,    new ResettableHomeCommands()),
    Deploy1(         Controller.BBox, TriggerButton.R,         When.ON_TRUE,    new PositionCommand(Position.LOW)),
    Deploy2(         Controller.BBox, ClickableButton.B,       When.ON_TRUE,    new PositionCommands(Position.RESET, Position.MID)),
    Deploy3(         Controller.BBox, ClickableButton.A,       When.ON_TRUE,    new PositionCommands(Position.RESET, Position.TOP)),
    Pickup1(         Controller.BBox, ClickableButton.RB,      When.ON_TRUE,    new PositionCommands(Position.RESET, Position.PICKUP1)),
    Pickup2(         Controller.BBox, ClickableButton.Y,       When.ON_TRUE,    new PositionCommands(Position.RESET, Position.PICKUP2)),
    PickupSingle(    Controller.BBox, ClickableButton.X,       When.ON_TRUE,    new PositionCommand(Position.SINGLE)),
    PickupDouble(    Controller.BBox, ClickableButton.LB,      When.ON_TRUE,    new PositionCommand(Position.DOUBLE)),
    Panic(           Controller.BBox, ClickableButton.SQUARES, When.ON_TRUE,    new PanicCommand()),
    CompressorToggle(Controller.BBox, ClickableButton.LINES,   When.ON_TRUE,    new InstantCommand(RobotContainer.m_robotArm::toggleCompressor)),
    ResetFOD(        Controller.BBox, ClickableButton.LSTICK,  When.ON_TRUE,    new InstantCommand(RobotContainer::resetFOD)),
    ResetArm0(       Controller.BBox, ClickableButton.RSTICK,  When.ON_TRUE,    new InstantCommand(RobotContainer.m_robotArm::resetStage2)),
    NCam0(           Controller.NPad, ClickableButton.N1,      When.ON_TRUE,    new InstantCommand(() -> Cameras.select(0))),
    NCam1(           Controller.NPad, ClickableButton.N2,      When.ON_TRUE,    new InstantCommand(() -> Cameras.select(1))),
    NCam2(           Controller.NPad, ClickableButton.N3,      When.ON_TRUE,    new InstantCommand(() -> Cameras.select(2))),
    XCam0(           Controller.XBox, POVButton.NN,            When.ON_TRUE,    new InstantCommand(() -> Cameras.select(0))),
    XCam1(           Controller.XBox, POVButton.WW,            When.ON_TRUE,    new InstantCommand(() -> Cameras.select(1))),
    XCam2(           Controller.XBox, POVButton.EE,            When.ON_TRUE,    new InstantCommand(() -> Cameras.select(2)));

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
