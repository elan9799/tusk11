import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(4, 5);
        Feeld feeld = new Feeld(10,10, robot);

        feeld.showFeeld();
        feeld.walkUp();
        feeld.walkUp();
        feeld.walkUp();
        feeld.walkLeft();
        feeld.walkLeft();
        feeld.walkDown();
        feeld.walkDown();
        feeld.walkDown();
        feeld.walkDown();
        feeld.walkDown();
        feeld.walkDown();
        feeld.walkDown();
        feeld.walkDown();
        feeld.walkRight();
        feeld.walkRight();
        feeld.walkRight();
        System.out.println();
        feeld.showFeeld();

    }
}
class Robot {
    Point pos = new Point();
    String c = "#";

    public Robot(int x, int y) {
        this.pos.y = y;
        this.pos.x = x;
    }

}
class Feeld {
    private int a;
    private int b;
    private String[][] array;
    Robot robot;

    public Feeld(int a, int b, Robot robot) {
        this.a = a;
        this.b = b;
        array = new String[a][b];
        array[robot.pos.x][robot.pos.y] = robot.c;
        this.robot = robot;
    }
    public void showFeeld (){
        for (int i = 0; i < a; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
    public void refreshPos (Robot robot , int key){
        if (key == 1){
            array[robot.pos.x + 1][robot.pos.y] = null;
        }
        if (key == 2){
            array[robot.pos.x - 1][robot.pos.y] = null;
        }
        if (key == 3){
            array[robot.pos.x][robot.pos.y - 1] = null;
        }
        if (key == 4){
            array[robot.pos.x][robot.pos.y + 1] = null;
        }

        array[robot.pos.x][robot.pos.y] = robot.c;
    }
    public void walkUp (){
        robot.pos.x -=1;
        refreshPos(robot , 1);
    }
    public void walkDown (){
        robot.pos.x +=1;
        refreshPos(robot, 2);
    }
    public void walkRight (){
        robot.pos.y +=1;
        refreshPos(robot, 3);
    }
    public void walkLeft (){
        robot.pos.y -=1;
        refreshPos(robot , 4);
    }
}