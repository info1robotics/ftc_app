package org.firstinspires.ftc.teamcode.movement;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MoveRobotLinear {
    private MovementMotors motorsController;
    private Power movementPower;


    public MoveRobotLinear(Telemetry telemetry, HardwareMap hardwareMap,
                           LinearOpMode opMode) {
        motorsController = new MovementMotors(hardwareMap, telemetry);
        movementPower = new Power(1);
    }

    private void move(Power direction) {
        motorsController.setPower(movementPower.multiply(direction));
    }

    public void moveForward(double speed) {
        movementPower.setPower(speed);
        move(Signs.FORWARD);
    }

    public void moveBackward(double speed) {
        movementPower.setPower(speed);
        move(Signs.BACKWARD);
    }

    public void moveLeft(double speed) {
        movementPower.setPower(speed);
        move(Signs.LEFT);
    }

    public void moveRight(double speed) {
        movementPower.setPower(speed);
        move(Signs.RIGHT);
    }


    public void spin(double power, double direction) {
        if (direction != 1 && direction != -1) return;
        Power resultingPower = (new Power(power))
                .multiply(new Power(direction));
        motorsController.setPower(resultingPower);
    }

    public void stopAll() {
        motorsController.setPower(new Power());
    }

}
