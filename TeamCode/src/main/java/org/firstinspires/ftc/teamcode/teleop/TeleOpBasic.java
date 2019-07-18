package org.firstinspires.ftc.teamcode.teleop;

import android.widget.Button;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.movement.MoveRobotLinear;
import org.firstinspires.ftc.teamcode.movement.Power;

import java.util.HashSet;

/**
 *      Initial (not elegant) implementation of a TeleOp class.
 *
 *      Supports
 *          * Initializing the required handlers.
 *          * Mapping controller buttons to actions.
 */

@TeleOp
public class  TeleOpBasic extends LinearOpMode {

    MoveRobotLinear movementController;
    HashSet<Button> buttonsList;
    double MOVEMENT_SPEED = 1;

    @Override
    public void runOpMode() throws InterruptedException {

        movementController = new MoveRobotLinear(this.telemetry,
                this.hardwareMap, this);
        buttonsList = new HashSet<>();

        telemetry.update();


        while(!isStarted() && !isStopRequested()) {
            telemetry.addData("status", "waiting for start command");
            telemetry.update();
            sleep(200);
        }


        while (opModeIsActive()) {
            if (gamepad1.dpad_down) Utilities.moveBackward(movementController,
                    gamepad1, this, MOVEMENT_SPEED);
            if (gamepad1.dpad_up) Utilities.moveForward(movementController,
                    gamepad1, this, MOVEMENT_SPEED);
            if (gamepad1.dpad_right) Utilities.moveRight(movementController,
                    gamepad1, this, MOVEMENT_SPEED);
            if (gamepad1.dpad_left) Utilities.moveLeft(movementController,
                    gamepad1, this, MOVEMENT_SPEED);

            if (gamepad1.left_trigger > 0)
                Utilities.spinLeft(movementController, gamepad1, this);
            if (gamepad1.right_trigger > 0)
                Utilities.spinRight(movementController, gamepad1, this);

            idle();
            telemetry.addLine("Connection active");
            telemetry.update();
        }

    }

}