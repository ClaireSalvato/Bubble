import java.awt.*;

public class star {
    //VARIABLE DECLARATION SECTION
    public String name;                //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.

    public Rectangle rec;

    public boolean isCrashing;



// METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 3 parameters.  This allows us to specify the hero's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.

    public star(int pXpos, int pYpos) {
        xpos = pXpos;
        ypos = pYpos;
        dx =5;
        dy =-5;
        width = 80;
        height = 80;
        isAlive = true;
        rec = new Rectangle(xpos, ypos, width, height);

    } // constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {

        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos, ypos, width, height);


    }

    public void bounce() {
        if(xpos>940) { // bounce off the west wall
            dx = -dx;
        }
        // bounce east wall

        if(ypos>640) { // bounce off bottom
            dy = -dy;
        }

        if(xpos>0) { // bounce of east wall
            dx = -dx;

        }

        if(ypos>0) { // bounce off top
            dy = -dy;
        }

        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos, ypos, width, height);

    }

    public void wrap(){
        //wrap east wall
        if(xpos<0){
            xpos = 1000-width;
        }

        // wrap north
        if(ypos<0){
            ypos = 700-height;
        }

        //south wall
        if(ypos>640){
            ypos=0;
        }

        //wrap for west
        if(xpos>940){
            xpos = 0;
        }

        xpos = xpos + dx;
        ypos = ypos + dy;
        rec = new Rectangle(xpos,ypos, width, height);
    }


}
