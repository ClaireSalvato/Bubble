import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

//

//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

    //Variable Definition Section
    //Declare the variables used in the program
    //You can set their initial values too

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;
    public Image bubblePic;
    public Image background;
    public Bubble b1;
    public Sound themeMusic;
    public Sound efx1;
    public Platypus p1;
    public Image PlatypusPic;
    public star s1;
    public Image StarPic;
    public Perry pp1;
    public Image PerryPic;
    public Sound thememusic;



    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }


    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public BasicGameApp() {

        setUpGraphics();

        //variable and objects
        //create (construct) the objects needed for the game and load up
        bubblePic = Toolkit.getDefaultToolkit().getImage("bubble.png"); //load the picture
        //   bubblePic = new Bubble(10, 100);
        b1 = new Bubble((int)(Math.random()*800),600);

        PlatypusPic = Toolkit.getDefaultToolkit().getImage("platypus.png"); //load the picture
        //   platypusPic = new Platypus(10, 100);
        p1 = new Platypus(700, 600);

        StarPic = Toolkit.getDefaultToolkit().getImage("star.png"); //load the picture
        //   starPic = new Star(50, 50);
        s1 = new star(500, 500);

        PerryPic = Toolkit.getDefaultToolkit().getImage("perry.png"); //load the picture
        //   perryPic = new Perry(50, 50);
        pp1 = new Perry(400,400);


        background = Toolkit.getDefaultToolkit().getImage("moonlight.jpeg"); //load the picture

    }// BasicGameApp()

//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {

        //for the moment we will loop things forever.
        while (true) {

            moveThings();  //move all the game objects
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }


    public void moveThings() {
        //calls the move( ) code in the objects
        b1.bounce();

        //calls the move() code in the objects

        //calls the move() code in the objects

        p1.wrap();

        s1.wrap();

        pp1.bounce();


        if (b1.rec.intersects(s1.rec) && b1.isCrashing == false) {
            b1.isCrashing = false;
            System.out.println("Crash 1");
            b1.dx = 20;
            //astro.dx = -astro.dx;
            //astro2.dx = -astro.dx;
            b1.height = b1.height + 5;
            b1.width = b1.width + 5;
            b1.isCrashing = true;
        }

        if (b1.rec.intersects(s1.rec) == false) {
            b1.isCrashing = false;
        }

        if (b1.rec.intersects(p1.rec) && b1.isCrashing == false) {
            b1.isCrashing = false;
            System.out.println("Crash");
            b1.dx = 20;
            //astro.dx = -astro.dx;
            //astro3.dx = -astro.dx;
            b1.height = b1.height + 5;
            b1.width = b1.width + 5;
            b1.isCrashing = true;

        }

        if (b1.rec.intersects(p1.rec) == false) {
            b1.isCrashing = false;
        }


    }


        private void setUpGraphics () {
            frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

            panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
            panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
            panel.setLayout(null);   //set the layout

            // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
            // and trap input events (Mouse and Keyboard events)
            canvas = new Canvas();
            canvas.setBounds(0, 0, WIDTH, HEIGHT);
            canvas.setIgnoreRepaint(true);

            panel.add(canvas);  // adds the canvas to the panel.

            // frame operations
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
            frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
            frame.setResizable(false);   //makes it so the frame cannot be resized
            frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

            // sets up things so the screen displays images nicely.
            canvas.createBufferStrategy(2);
            bufferStrategy = canvas.getBufferStrategy();
            canvas.requestFocus();
            System.out.println("DONE graphic setup");

        }

        private void render () {
            Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
            g.clearRect(0, 0, WIDTH, HEIGHT);

            //draw the background
            g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);

            //draw the image of the astronaut
            g.drawImage(bubblePic, b1.xpos, b1.ypos, b1.width, b1.height, null);
//        g.drawImage(bubblePic, bubble2.xpos, bubble2.ypos, bubble2.width, bubble2.height, null);
//        g.drawImage(bubblePic, bubble3.xpos, bubble3.ypos, bubble3.width, bubble3.height, null);

            //draw the image of the platypus
            g.drawImage(PlatypusPic, p1.xpos, p1.ypos, p1.width, p1.height, null);

            //draw the image of the star
            g.drawImage(StarPic, s1.xpos, s1.ypos, s1.width, s1.height, null);

            //draw the image of the Perry
            g.drawImage(PerryPic, pp1.xpos, pp1.ypos, pp1.width, pp1.height, null);



            bufferStrategy.show();
        }

        //Pauses or sleeps the computer for the amount specified in milliseconds
        public void pause ( int time ){
            //sleep
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {

            }

            //construct the soundFile objects.
            //specify the filename of the sound
            efx1 = new Sound("happybirthday.wav");
            themeMusic = new Sound("happybirthday.wav");


            //plays the soundFile themeMusic
            themeMusic.play();


        }

    }




