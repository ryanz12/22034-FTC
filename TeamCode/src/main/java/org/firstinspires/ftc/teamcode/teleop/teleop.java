package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.FlywheelCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

@TeleOp(name = "Main Teleop")
public class teleop extends CommandOpMode {
    private DriveSubsystem driveSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private FlywheelSubsystem flywheelSubsystem;
    private GamepadEx driverController;
    private GamepadEx operatorController;

    @Override
    public void initialize() {
        driverController = new GamepadEx(gamepad1);
        operatorController = new GamepadEx(gamepad2);

        driveSubsystem = new DriveSubsystem(hardwareMap);
        intakeSubsystem = new IntakeSubsystem(hardwareMap);
        flywheelSubsystem = new FlywheelSubsystem(hardwareMap, telemetry);

        driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, driverController));

        flywheelSubsystem.setDefaultCommand(new FlywheelCommand(flywheelSubsystem, operatorController));


        operatorController.getGamepadButton(GamepadKeys.Button.B)
                .whileHeld(new IntakeCommand(intakeSubsystem, IntakeCommand.Intakepart.GROUND));

        operatorController.getGamepadButton(GamepadKeys.Button.Y)
                .whileHeld(new IntakeCommand(intakeSubsystem, IntakeCommand.Intakepart.TRANSFER));

        operatorController.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(new IntakeCommand(intakeSubsystem, IntakeCommand.Intakepart.FULL_INTAKE));

        operatorController.getGamepadButton(GamepadKeys.Button.X)
                .whileHeld(new IntakeCommand(intakeSubsystem, IntakeCommand.Intakepart.FULL_REVERSE));


        operatorController.getGamepadButton(GamepadKeys.Button.DPAD_UP)
                .whileHeld(new InstantCommand(() -> flywheelSubsystem.setRPM(4400), flywheelSubsystem));


        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }


    @Override
    public void run() {
        super.run();
        telemetry.update();
    }
}
