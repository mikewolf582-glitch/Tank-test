package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter extends SubsystemBase {


    private DcMotorEx shooter;

    private DcMotorEx motorshooter;



    private HardwareMap hardwareMap;


    public Shooter (HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;

         shooter = hardwareMap.get(DcMotorEx.class, "shooter1");
         motorshooter = hardwareMap.get(DcMotorEx.class,"shooter2");


        shooter.setDirection(DcMotorSimple.Direction.REVERSE);//puerto cero
    }
    public void setPower(double power){
        shooter.setPower(power);
        motorshooter.setPower(power);


    }






}





