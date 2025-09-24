package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain extends SubsystemBase {

    private DcMotorEx leftMotor, RightMotor;

    private HardwareMap hardwareMap;

    public DriveTrain(HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;

        leftMotor = hardwareMap.get(DcMotorEx.class,"leftmotor");
        RightMotor = hardwareMap.get(DcMotorEx.class,"rightmotor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



    }

    public void drive(double drive, double turn){
        double leftPower =  drive + turn;
        double rightPower = drive - turn;

        leftMotor.setPower(leftPower);
        RightMotor.setPower(rightPower);

    }








}


