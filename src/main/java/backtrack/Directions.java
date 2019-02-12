package backtrack;


public class Directions {

    private Position up = new Position(1, 0);
    private Position down = new Position(-1,0);
    private Position left = new Position(0,-1);
    private Position right = new Position(0,1);
    public Directions(){

    }

    public Position moveUp(){
        return up;
    }

    public Position moveDown(){
        return down;
    }

    public Position moveLeft(){
        return left;
    }

    public Position moveRight(){
        return right;
    }
}
