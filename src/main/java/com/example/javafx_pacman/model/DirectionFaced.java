package com.example.javafx_pacman.model;


public class DirectionFaced {
    private Direction direction;

    private Orientation toFollow;

    public DirectionFaced(double currentAngle){
        AngleFaced(currentAngle);
        DirectionToFollow();
    }
    /**
     * Represents a direction with an angle.
     * The angle is used to determine the direction (UP, DOWN, LEFT, RIGHT).
     * The direction is then used to determine the orientation (x,y) of the direction.
     */
    private void AngleFaced(double currentAngle) {
        switch ((int) currentAngle){
            case 0 -> this.direction = Direction.UP;
            case 90 -> this.direction = Direction.RIGHT;
            case 180 -> this.direction = Direction.DOWN;
            case 270 -> this.direction = Direction.LEFT;
            default -> this.direction = Direction.UP;
        }
    }
   /*
   * This method returns the direction of the PacMan.
   * */
    private void DirectionToFollow(){
        switch (this.direction){
            case UP -> this.toFollow = new Orientation(0,-1);
            case DOWN -> this.toFollow = new Orientation(0,1);
            case LEFT -> this.toFollow = new Orientation(-1,0);
            case RIGHT -> this.toFollow = new Orientation(1,0);
        }
    }
    /*
    * This method returns the direction of the PacMan.
    * */
    public Orientation getToFollow() {
        return this.toFollow;
    }


    /*
    * This method is used to switch the direction of the PacMan.
    * */
    public void switchDirections(double angle){
        AngleFaced(angle);
        DirectionToFollow();
    }
}
