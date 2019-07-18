package org.firstinspires.ftc.teamcode.movement;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MovementMotors {
    private DcMotor fl, fr, bl, br;
    private Telemetry console;

    public MovementMotors(HardwareMap hardwareMap, Telemetry telemetry) {

        console = telemetry;
        console.addData("MovementMotors class", "Setting Up.");
        console.update();

        this.fl = hardwareMap.get(DcMotor.class, "motorFL");
        this.fr = hardwareMap.get(DcMotor.class, "motorFR");
        this.bl = hardwareMap.get(DcMotor.class, "motorBL");
        this.br = hardwareMap.get(DcMotor.class, "motorBR");

        console.addData
                ("MovementMotors class", "Done with set up.");
    }

    public void setPower(Power power) {
        this.fl.setPower(power.fl);
        this.fr.setPower(power.fr);
        this.bl.setPower(power.bl);
        this.br.setPower(power.br);

        //console.addData("DEBUG", fl.toString() + " " +
                //fr.toString() + " " + bl.toString() + " " + br.toString());
        //console.update();
    }



}
