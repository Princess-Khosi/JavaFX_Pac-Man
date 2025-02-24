package com.example.javafx_pacman.controller;

import com.example.javafx_pacman.model.DirectionFaced;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

import java.util.HashMap;

public class Gameplay {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Arc PacMan;
    private double speed = 2;
    private DirectionFaced currentDirection = new DirectionFaced(0);
    private AnimationTimer animationTimer;

    @FXML
    private Line leftBorder, rightBorder, topBorder, bottomBorder;


    /**
     * Initializes the scene and sets up key press event handlers to update
     * the rotation of PacMan and its current direction based on arrow key presses.
     * Ensures the root pane is focusable and requests focus to capture key events.
     */
    public void init(){

        rootPane.sceneProperty().addListener((obs,scene, newScene) ->{
            if (scene != null) {
                scene.setOnKeyPressed(event -> {
                    switch (event.getCode()) {
                        case UP -> PacMan.setRotate(0);
                        case DOWN -> PacMan.setRotate(180);
                        case LEFT -> PacMan.setRotate(270);
                        case RIGHT -> PacMan.setRotate(90);
                    }
                    System.out.println(PacMan.getRotate());
                    currentDirection.switchDirections(PacMan.getRotate());
                });
            }
        });
        rootPane.setFocusTraversable(true);
        rootPane.requestFocus();
    }

    /**
     * Called when the "Play" button is clicked. Initializes the scene and key press handlers if they haven't already been initialized,
     * and starts the animation timer.
     */
    @FXML
    private void onPlay() {
        init();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updatePosition();
            }
        };
        animationTimer.start();
    }
    /*
    * This method stops the animation timer when the "Stop" button is clicked.
    * */
    @FXML
    private void onStop() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
    }
    /*
    * This simply updates the position of PacMan based on the current direction and speed.
    *
    * */
    private void updatePosition() {
        if (currentDirection == null){
            currentDirection = new DirectionFaced(PacMan.getStartAngle());
        }
        double deltaX = currentDirection.getToFollow().getX() * speed;
        double deltaY = currentDirection.getToFollow().getY() * speed;

        double newX = PacMan.getCenterX() + deltaX;
        double newY = PacMan.getCenterY() + deltaY;

        PacMan.setCenterX(newX);
        PacMan.setCenterY(newY);
    }

}
