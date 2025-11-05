package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Feeder extends SubsystemBase {

    private DcMotorEx feeder;

    HardwareMap hardwareMap;

    public Feeder (HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;

        feeder = hardwareMap.get(DcMotorEx.class, "feeder");

        feeder.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setPower(double power) {

        feeder.setPower(power);}

    public void setPosition(int position, double power) {

        feeder.setPower(power);
        feeder.setTargetPosition(position);
        feeder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}



