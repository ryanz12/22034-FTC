package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSubsystem extends SubsystemBase {
    private DcMotorEx LeftMotor;
    private DcMotorEx RightMotor;
    private static final double LeftMotorPower = -1.0;
    private static final double RightMotorPower = 1.0;

    public FlywheelSubsystem(HardwareMap hwMap){
        LeftMotor = hwMap.get(DcMotorEx.class,"outtakeRight");
        RightMotor = hwMap.get(DcMotorEx.class,"outtakeLeft");
        RightMotor.setDirection(DcMotor.Direction.REVERSE);

        LeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        LeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);






    }
}
