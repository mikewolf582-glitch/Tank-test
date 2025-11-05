package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorGoBildaPinpoint;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Utils.Pinpoint;

public class DriveTrain extends SubsystemBase       {

    private DcMotorEx leftMotor, RightMotor;

    private HardwareMap hardwareMap;

    private Telemetry telemetry;

    Pinpoint pinpoint;

    public DriveTrain(HardwareMap hardwareMap,Telemetry telemetry){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        leftMotor = hardwareMap.get(DcMotorEx.class,"leftmotor");
        RightMotor = hardwareMap.get(DcMotorEx.class,"rightmotor");
        pinpoint = hardwareMap.get(Pinpoint.class, "pinpoint");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        pinpoint.setEncoderDirections(Pinpoint.EncoderDirection.REVERSED, Pinpoint.EncoderDirection.REVERSED);
        pinpoint.resetPosAndIMU();
        pinpoint.setOffsets(55, 55, DistanceUnit.MM);



    }

    public void drive(double drive, double turn){
        double leftPower =  drive + turn;
        double rightPower = drive - turn;

        leftMotor.setPower(leftPower);
        RightMotor.setPower(rightPower);
    }

    public void recalibrateIMU(){
        pinpoint.recalibrateIMU();
    }

    public void resetHeading(){
        pinpoint.resetPosAndIMU();
    }

    public Pose2d getPose(){
        return new Pose2d(pinpoint.getPosX(DistanceUnit.CM), pinpoint.getPosY(DistanceUnit.CM),
                new Rotation2d(pinpoint.getPosition().getHeading(AngleUnit.DEGREES)));
    }

    public void update(){
        pinpoint.update();
    }

    public double heading(){
       return pinpoint.getHeading(AngleUnit.DEGREES);
    }



    @Override
    public void periodic() {
        telemetry.addData("Encoder Y", pinpoint.getEncoderY());
        telemetry.addData("Encoder X",pinpoint.getEncoderX());
    }
}


