package org.firstinspires.ftc.teamcode.TTCode.auto.currentAuto;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.TTCode.auto.currentAuto.pedroPathing.Constants;

@Autonomous (name="Kool Kids Auto")
public class mock2Auto extends OpMode {


    private Follower follower;
    private Timer pathTimer, opModeTimer;


    // Enumeration of the different States
    public enum PathState {
        startPos_shootPos,
        // shoot pos to each set
        shootPos_set1,
        shootPos_set2,
        shootPos_set3,
        // each intake to shoot pos
        intake1_shootPos,
        intake2_shootPos,
        intake3_shootPos,
        // intake
        intake1,
        intake2,
        intake3,
        // end state moving to get ready to open the gate
        shootPos_endPos,
        // shoots the artifacts from the same shot position
        shootArtifacts,

    }
    PathState pathState;



    // Positions on the field
    private final Pose startPos = new Pose(24.3590333716916,127.59493670886077,Math.toRadians(143.5));
    private final Pose shootPos = new Pose(48.22094361334867,107.37859608745686,Math.toRadians(143.5));
    private final Pose set1Pos = new Pose(48.05523590333716,84.34522439585731,Math.toRadians(180));
    private final Pose set2Pos = new Pose(48.05523590333716,59.9861910241657,Math.toRadians(180));
    private final Pose set3Pos = new Pose(48.05523590333716,35.4614499424626,Math.toRadians(180));
    private final Pose intake1Pos = new Pose(14.085155350978136,84.34522439585731,Math.toRadians(180));
    private final Pose intake2Pos = new Pose(14.085155350978136,59.9861910241657,Math.toRadians(180));
    private final Pose intake3Pos = new Pose(14.085155350978136,35.4614499424626,Math.toRadians(180));
    private final Pose endPos = new Pose(18.890678941311855,70.9228998849252,Math.toRadians(90));



    // Paths between positions
    PathChain startToShootPos, toSet1, toSet2, toSet3, intake1, intake2, intake3, toShootPos1, toShootPos2, toShootPos3, endPath;
    // Function to build path
    public PathChain buildPath(Pose start, Pose end) {
        return follower.pathBuilder()
                .addPath(new BezierLine(start, end) )
                .setLinearHeadingInterpolation(start.getHeading(),end.getHeading())
                .build();
    }
    // Init Function for paths
    public void buildPaths() {
        // Start to shoot pos
        startToShootPos = buildPath(startPos, shootPos);
        // shoot pos to set pos
        toSet1 = buildPath(shootPos, set1Pos);
        toSet2 = buildPath(shootPos, set2Pos);
        toSet3 = buildPath(shootPos, set3Pos);
        // intakes each
        intake1 = buildPath(set1Pos, intake1Pos);
        intake2 = buildPath(set2Pos, intake2Pos);
        intake3 = buildPath(set3Pos, intake3Pos);
        // return to shoot pos
        toShootPos1 = buildPath(intake1Pos, shootPos);
        toShootPos2 = buildPath(intake2Pos, shootPos);
        toShootPos3 = buildPath(intake3Pos, shootPos);
        // end pos (prepares to open the gate)
        endPath = buildPath(shootPos, endPos);
    }




    // State Machine
    boolean set1Completed = false;
    boolean set2Completed = false;
    boolean set3Completed = false;
    public void statePathUpdate() {

        switch(pathState) {
            case startPos_shootPos:
                follower.followPath(startToShootPos, true);
                setPathState(PathState.shootArtifacts);
                break;
            case shootArtifacts:
                if (!follower.isBusy()) {
                    // TODO shooter function
                    telemetry.addLine("shooting");

                    if (!set1Completed) {
                        setPathState(PathState.shootPos_set1);
                    } if (!set2Completed) {
                        setPathState(PathState.shootPos_set2);
                    } if (!set3Completed) {
                        setPathState(PathState.shootPos_set3);
                    } else {
                        setPathState(PathState.shootPos_endPos);
                    }
                }
                break;

            // Set 1
            case shootPos_set1:
                if (!follower.isBusy() && pathTimer.getElapsedTime() > 5) {
                    follower.followPath(toSet1, true);
                    setPathState(PathState.intake1);
                }
                break;
            case intake1:
                if (!follower.isBusy()) {
                    // TODO intake function (power motors)
                    follower.followPath(intake1, true);
                    setPathState(PathState.intake1_shootPos);
                }
                break;
            case intake1_shootPos:
                if (!follower.isBusy()) {
                    // TODO intake function (unpowers motors)
                    follower.followPath(toShootPos1, true);
                    set1Completed = true;
                    setPathState(PathState.shootArtifacts);
                }
                break;
            // Set 2
            case shootPos_set2:
                if (!follower.isBusy() && pathTimer.getElapsedTime() > 5) {
                    follower.followPath(toSet2, true);
                    setPathState(PathState.intake2);
                }
                break;
            case intake2:
                if (!follower.isBusy()) {
                    // TODO intake function (power motors)
                    follower.followPath(intake2, true);
                    setPathState(PathState.intake2_shootPos);
                }
                break;
            case intake2_shootPos:
                if (!follower.isBusy()) {
                    // TODO intake function (unpowers motors)
                    follower.followPath(toShootPos2, true);
                    set2Completed = true;
                    setPathState(PathState.shootArtifacts);
                }
                break;
            // Set 3
            case shootPos_set3:
                if (!follower.isBusy() && pathTimer.getElapsedTime() > 5) {
                    follower.followPath(toSet3, true);
                    setPathState(PathState.intake3);
                }
                break;
            case intake3:
                if (!follower.isBusy()) {
                    // TODO intake function (power motors)
                    follower.followPath(intake3, true);
                    setPathState(PathState.intake3_shootPos);
                }
                break;
            case intake3_shootPos:
                if (!follower.isBusy()) {
                    // TODO intake function (unpowers motors)
                    follower.followPath(toShootPos3, true);
                    set3Completed = true;
                    setPathState(PathState.shootArtifacts);
                }
                break;

            case shootPos_endPos:
                if (!follower.isBusy()) {
                    follower.followPath(endPath, true);
                }

            default:
                telemetry.addLine("No Current State");
                break;
        }
    }

    public void setPathState(PathState newState) {
        pathState = newState;
        pathTimer.resetTimer();
    }


    @Override
    public void init() {
        pathState = PathState.startPos_shootPos;
        pathTimer = new Timer();
        opModeTimer = new Timer();
        follower = Constants.createFollower(hardwareMap);
        // TODO init motors

        follower.setPose(startPos);
        buildPaths();
    }

    public void start() {
        opModeTimer.resetTimer();
        setPathState(pathState);
    }

    @Override
    public void loop() {
        follower.update();
        statePathUpdate();

        // TODO Telemetry
    }
}
