package org.firstinspires.ftc.teamcode.subsystems;


import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FlywheelSubsystem extends SubsystemBase {
    private static final double TICKS_PER_REV = 28;
    private static final double GEAR_RATIO = 1.0;
    private DcMotorEx LeftMotor;
    private DcMotorEx RightMotor;
    private static final double LeftMotorPower = -1.0;
    private static final double RightMotorPower = 1.0;
    private Telemetry telemetry;

    public FlywheelSubsystem(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        LeftMotor = hwMap.get(DcMotorEx.class, "outtakeRight");
        RightMotor = hwMap.get(DcMotorEx.class, "outtakeLeft");
        RightMotor.setDirection(DcMotor.Direction.REVERSE);

        LeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        LeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void periodic() {
        double leftRPM = getLeftRPM();
        double rightRPM = getRightRPM();

        // --- NOW THIS WILL WORK ---
        // Use "this.telemetry" to be explicit, or just "telemetry"
        this.telemetry.addData("Outtake RPM Left", "%.2f", leftRPM);
        this.telemetry.addData("Outtake RPM Right", "%.2f", rightRPM);
        // The main OpMode's run() loop will call telemetry.update()
    }

    public double getLeftRPM() {
        return (LeftMotor.getVelocity() * 60) / (TICKS_PER_REV * GEAR_RATIO);
    }

    public double getRightRPM() {
        return (RightMotor.getVelocity() * 60) / (TICKS_PER_REV * GEAR_RATIO);
    }


    public void setPower(double power) {
        if (LeftMotor.getMode() != DcMotor.RunMode.RUN_USING_ENCODER) {
            setPowerControl();
        }
        LeftMotor.setPower(power);
        RightMotor.setPower(power);
    }
    public void setRPM(double rpm) {
        double ticksPerSecond = (rpm * TICKS_PER_REV * GEAR_RATIO) / 60.0;
        LeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LeftMotor.setVelocity(ticksPerSecond);
        RightMotor.setVelocity(ticksPerSecond);
    }
    private void setPowerControl() {
        LeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        RightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void shoot() {
        setPowerControl();
        setPower(1.0);
    }

    public void reverse() {
        setPowerControl();
        setPower(-1.0);
    }
    public void stop() {
        setPower(0);
    }
}
