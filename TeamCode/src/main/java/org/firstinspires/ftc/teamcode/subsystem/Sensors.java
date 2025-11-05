package org.firstinspires.ftc.teamcode.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Sensors extends SubsystemBase {

    private Sensors test_color;

    private HardwareMap hardwareMap;

    public  Telemetry telemetry;

    private HardwareMap colors;




    public Sensors(HardwareMap hardwareMap) {
       // this.telemetry = telemetry;
        test_color = hardwareMap.get(Sensors.class, "test_color");

      //  NormalizedRGBA colors = test_color.getNormalizedColors();
        telemetry.update();

        telemetry.addData("Light Detected", ((OpticalDistanceSensor) test_color).getLightDetected());
      //  telemetry.addData("Red", "%.3f", colors.red);
    //    telemetry.addData("Green", "%.3f", colors.green);
       // telemetry.addData("Blue", "%.3f", colors.blue);




    }


}













