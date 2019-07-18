package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.movement.MoveRobotLinear;


/**
 *      Class defining all required actions for a controlled stage.
 *
 *      Supports
 *          * Moving the robot on all 4 axes.
 *          * Moving the mineral arm.
 *          * Extending/ Contracting the robot arm.
 *          * Spinning the robot.
 *          * Changing the direction of the mineral brush.
 *          * Tilting the mineral box at 90/ 45 degrees from the mineral arm.
 *          * Turning the correction on/ off.
 */

public class Utilities {

    public static void moveForward(MoveRobotLinear movementController, Gamepad gamepad, LinearOpMode opMode, double speed) {
        while(opMode.opModeIsActive() && gamepad.dpad_up) {
            movementController.moveForward(speed);
            opMode.idle();
            opMode.telemetry.addLine("Moving Forward");
            opMode.telemetry.update();
        }
        opMode.telemetry.addLine("Stopped");
        opMode.telemetry.update();
        movementController.stopAll();
    }

    public static void moveBackward(MoveRobotLinear movementHandler, Gamepad gamepad, LinearOpMode opMode, double speed) {
        while(opMode.opModeIsActive() && gamepad.dpad_down) {
            movementHandler.moveBackward(speed);
            opMode.idle();
            opMode.telemetry.addLine("Moving Backward");
            opMode.telemetry.update();

        }
        opMode.telemetry.addLine("Stopped");
        opMode.telemetry.update();
        movementHandler.stopAll();
    }

    public static void moveRight(MoveRobotLinear movementHandler, Gamepad gamepad, LinearOpMode opMode, double speed) {
        while(opMode.opModeIsActive() && gamepad.dpad_right) {
            movementHandler.moveRight(speed);
            opMode.idle();
            opMode.telemetry.addLine("Moving Right");
            opMode.telemetry.update();
        }

        opMode.telemetry.addLine("Stopped");
        opMode.telemetry.update();
        movementHandler.stopAll();
    }

    public static void moveLeft(MoveRobotLinear movementHandler, Gamepad gamepad, LinearOpMode opMode, double speed) {
        while(opMode.opModeIsActive() && gamepad.dpad_left) {
            movementHandler.moveLeft(speed);
            opMode.idle();
            opMode.telemetry.addLine("Moving Left");
            opMode.telemetry.update();
        }

        opMode.telemetry.addLine("Stopped");
        opMode.telemetry.update();
        movementHandler.stopAll();
    }


    public static void spinLeft(MoveRobotLinear movementHandler, Gamepad gamepad, LinearOpMode opMode) {
        while(opMode.opModeIsActive() && gamepad.left_trigger != 0) {
            double speed = gamepad.left_trigger;
            movementHandler.spin(speed, 1);
            opMode.idle();
        }
        movementHandler.stopAll();
    }

    public static void spinRight(MoveRobotLinear movementHandler
            , Gamepad gamepad, LinearOpMode opMode) {
        while (opMode.opModeIsActive() && gamepad.right_trigger != 0) {
            double speed = gamepad.right_trigger;
            movementHandler.spin(speed, -1);
            opMode.idle();
        }
        movementHandler.stopAll();
    }


}