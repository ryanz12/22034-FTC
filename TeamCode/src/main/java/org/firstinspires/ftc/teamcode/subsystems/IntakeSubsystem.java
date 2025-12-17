package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem extends SubsystemBase {
    private final DcMotor IntakeMotor;
    private final DcMotor LauncherIntakeMotor;
    private static final double INTAKE_POWER = -1.0;
    private static final double LAUNCHERINTAKE_POWER = 1.0;
    public IntakeSubsystem(HardwareMap hardwareMap){
        IntakeMotor = hardwareMap.get(DcMotor.class, "groundIntake");
        LauncherIntakeMotor = hardwareMap.get(DcMotor.class, "transferMotor");

        IntakeMotor.setDirection(DcMotor.Direction.FORWARD);
        LauncherIntakeMotor.setDirection(DcMotor.Direction.FORWARD);

        IntakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LauncherIntakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void runGroundIntake() { IntakeMotor.setPower(INTAKE_POWER);}
    public void runTransfer() {LauncherIntakeMotor.setPower(LAUNCHERINTAKE_POWER);}

    public void runFullIntake() {
        runGroundIntake();
        runTransfer();
    }
    public void runFullReverse() {
        // We use the negative of the defined power constants
        IntakeMotor.setPower(-INTAKE_POWER);
        LauncherIntakeMotor.setPower(-LAUNCHERINTAKE_POWER);
    }
    public void stopGroundIntake() {
        IntakeMotor.setPower(0);
    }

    /**
     * Stops the transfer motor.
     */
    public void stopTransfer() {
        LauncherIntakeMotor.setPower(0);
    }

    /**
     * Stops all intake motors. This is essential.
     */
    public void stop() {
        stopGroundIntake();
        stopTransfer();
    }
}

