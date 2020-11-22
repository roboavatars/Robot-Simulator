package App;

import Utilities.AutoPathsUtil;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static App.Robot.robotLength;

public class AutoPlanner extends PlannerBase {

    private Group pathsGroup = new Group();
    private int colorValue = 255;
    private final static double colorInterval = 20;
    private AutoPathsUtil pathsUtil = new AutoPathsUtil(pathsGroup, colorValue, colorInterval);

    public void launch(Stage primaryStage) {
        super.launch(primaryStage);

        simSettings.setPadding(new Insets(5, 5, 5, 5));

        corLb.setFont(Font.font(20)); commaLb.setFont(Font.font(20));
        angleLb1.setFont(Font.font(20)); angleLb2.setFont(Font.font(20));
        angleLb3.setFont(Font.font(20));

        robot = new Robot(robotLength, robotLength);

        pathsUtil.drawAutoPaths();

        updateRobotPos(2, null);
        simPane.getChildren().addAll(robot, pathsGroup);
        robot.toFront();

        mainPane.setBottom(simSettings);
        Scene scene = new Scene(mainPane, CombinedSim.sceneWidth, CombinedSim.sceneWidth + 35);
        primaryStage.setTitle("Auto Planner");
        primaryStage.setScene(scene);
    }
}
