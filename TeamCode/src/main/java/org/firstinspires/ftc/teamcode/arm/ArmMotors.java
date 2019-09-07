package org.firstinspires.ftc.teamcode.arm;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmMotors {
    private DcMotor baseMotorLeft, baseMotorRight;
    private DcMotor extenderMotor;
    private DcMotor hookMotorRotator;
    private Telemetry console;

    private final double BASE_MOTORS_SPEED = 1.0;
    private final double EXTENDER_MOTOR_SPEED = 1.0;
    private final double HOOK_MOTOR_ROTATOR_SPEED = 0.5;

    public ArmMotors(HardwareMap hardwareMap, Telemetry telemetry) {
        baseMotorLeft = hardwareMap.get(DcMotor.class, "baseMotorLeft");
        baseMotorRight = hardwareMap.get(DcMotor.class, "baseMotorRight");
        extenderMotor = hardwareMap.get(DcMotor.class, "extenderMotor");
        hookMotorRotator = hardwareMap.get(DcMotor.class, "hookMotorRotator");

        console = telemetry;
        console.addData("ArmMotors class", "Set up.");
    }

    public void raiseArm(double powerFactor) {
        /*console.addData("Motor1 power", powerFactor * MotorSpeeds.COLLECT_MOTOR_MOVE_1_RIGHT);
        console.addData("Motor2 power", -1.0 * powerFactor * MotorSpeeds.COLLECT_MOTOR_MOVE_2_RIGHT);
        console.addData("Motor1 ticks", armsMotors.collectMotorMove1.getCurrentPosition());
        console.addData("Motor2 ticks", armsMotors.collectMotorMove2.getCurrentPosition());
        console.addData("Motors ticks (avg)", (armsMotors.collectMotorMove2.getCurrentPosition() +
                armsMotors.collectMotorMove1.getCurrentPosition()) / 2);
        console.update();*/
        baseMotorLeft.setPower(powerFactor * BASE_MOTORS_SPEED);
        baseMotorRight.setPower(-1.0 * powerFactor * BASE_MOTORS_SPEED);
        console.addLine("Raising arm");
        console.update();
    }

    public void lowerArm(double powerFactor) {
        baseMotorLeft.setPower(-1.0 * powerFactor * BASE_MOTORS_SPEED);
        baseMotorRight.setPower(powerFactor * BASE_MOTORS_SPEED);

        console.addLine("Lowered arm");
        console.update();
    }

    public void extendArm(double powerFactor) {
        extenderMotor.setPower(powerFactor * EXTENDER_MOTOR_SPEED);
    }

    public void contractArm(double powerFactor) {
        extenderMotor.setPower(-1.0 * powerFactor * EXTENDER_MOTOR_SPEED);
    }

    public void raiseHookRotator(double powerFactor) {
        hookMotorRotator.setPower(powerFactor * HOOK_MOTOR_ROTATOR_SPEED);
    }

    public void lowerHookRotator(double powerFactor) {
        hookMotorRotator.setPower(-1.0 * powerFactor * HOOK_MOTOR_ROTATOR_SPEED);
    }
    public void stopAll() {
        baseMotorLeft.setPower(0);
        baseMotorRight.setPower(0);
        extenderMotor.setPower(0);

        console.addLine("Stopped arm completely");
        console.update();
    }
}
