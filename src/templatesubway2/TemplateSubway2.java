package templatesubway2;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Ahmed
 */
public class TemplateSubway2 extends Application {
    private static final double DESIRED_WIDTH = 1084;  // Set the desired width //+200
    private static final double DESIRED_HEIGHT = 604; // Set the desired height
    
    private int WIDTH=60;
    private ObservableList<Node> OBSTACLE_CHILDREN;
    
    private ImageView GOLDIMAGE;
    
    // audio
    private MediaPlayer CRASHED;
    private MediaPlayer GOLDCOLLECTING;
    private MediaPlayer MEDIASAFTYFINISHPLAYER;
    private MediaPlayer MEDIASAFTYSTARTPLAYER;
    private MediaPlayer mediaStartPlay;
    
    private double PLAYER_X = 247.0; // as a player center
    private double GOLD_X = 0.0; // as a player center
    private double OBSTACLE1_X = 0.0; // as a player center
    private double OBSTACLE2_X = 0.0; // as a player center

    
     private String COLLISION_RESULT = ""; // as a player center
     
     private boolean IS_SAFE = false;
     private boolean safty = false;
     private boolean saftyTimer = false;
     private boolean GOLDVALUE = false;
     private boolean GOLDVALUETIMER = false;
     private boolean BIGTRAFFICCHECK = false;
     private boolean LOST = false;
     private boolean GAME_IS_ON = false;
     private boolean RESTARTED = false;
     private boolean JUMPED = false;
     private boolean BIGOBSTACLE1 = false;
     private boolean BIGOBSTACLE2 = false;
     private boolean BIGOBSTACLE3 = false;    
     
    @Override
    public void start(Stage primaryStage) throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException {
 
  //Update in code !! 5/17
  // 1.  added a mehtod to  make random obstacles
     


  //Update in code !! 5/15
  // 1.  stackPaneMain is the new main laoyout (arg in scene)
  // 2.  hbox and stackCollector are siblings in stackPaneMain
  // 3.  inside stackCollector there is the game layers zero and middle (obstacle) and the lastone is first.
  // 4.  added lines to firstStackPane and align them      
  // 5.  NOTICE: COORDS are (90,0) (275,0) (460,0) these coords are the mid points of street
       
  
        //Start button      
 
        //continue button
        Button btncont = new Button();
        btncont.setText("Continue?");
        btncont.setPrefSize(120, 50);
        btncont.setTranslateY(80);
        btncont.setStyle("-fx-background-color :linear-gradient(#ffff20,#3cd500);"
                + "-fx-font-size : 17px ;"
                + "-fx-font-weight : bold;"
                + "-fx-background-radius : 35px;"
                + "-fx-text-fill: #6b6b6b;"
        );
        
        Button btnRes = new Button();
        btnRes.setText("Restart");
        btnRes.setPrefSize(120, 50);
        btnRes.setTranslateY(80);
        btnRes.setStyle("-fx-background-color :linear-gradient(#ffff20,#3cd500);"
                + "-fx-font-size : 17px ;"
                + "-fx-font-weight : bold;"
                + "-fx-background-radius : 35px;"
                + "-fx-text-fill: #6b6b6b;"
        );
        
        
        VBox vbox1 = new VBox();
        vbox1.setTranslateY(0);
        Label lblCont = new Label();
        lblCont.setText("Note! You will lose 300 coin");
        lblCont.setPadding(new Insets(20));
        lblCont.setAlignment(Pos.CENTER);
        lblCont.setStyle("-fx-background-color :#f8e16c;"
                + "-fx-font-size : 17px ;"
                + "-fx-font-weight : bold;"
                + "-fx-background-radius : 10px;"
                + "-fx-text-fill: #6b6b6b;"
        );

        //exit button
        Button btnExit = new Button();
        btnExit.setText("Exit");
        btnExit.setPrefSize(70, 70);
        btnExit.setLayoutX(63);
        btnExit.setLayoutY(500);
        btnExit.setStyle("-fx-background-color :linear-gradient(#ffff20,#3cd500);"
                + "-fx-font-size : 17px ;"
                + "-fx-font-weight : bold;"
                + "-fx-background-radius : 35px;"
                + "-fx-text-fill: #6b6b6b;"
        );


        Button btnOk = new Button();
        btnOk.setText("Ok");
        btnOk.setPrefSize(70, 70);
        btnOk.setLayoutX(63);
        btnOk.setLayoutY(500);
        btnOk.setStyle("-fx-background-color :linear-gradient(#ffff20,#3cd500);"
                + "-fx-font-size : 17px ;"
                + "-fx-font-weight : bold;"
                + "-fx-background-radius : 35px;"
                + "-fx-text-fill: #6b6b6b;"
        );
                Button btnBack = new Button();

        btnBack.setText("Back");
        btnBack.setPrefSize(70, 70);
        btnBack.setLayoutX(-7);
        btnBack.setLayoutY(500);
        btnBack.setStyle("-fx-background-color :linear-gradient(#ffff20,#3cd500);"
                + "-fx-font-size : 17px ;"
                + "-fx-font-weight : bold;"
                + "-fx-background-radius : 35px;"
                + "-fx-text-fill: #6b6b6b;"
        );
        

        
        
        lblCont.setPrefSize(300, 70);
        
        VBox vbox = new VBox();
        vbox.setStyle(
                "-fx-background-color : #acb388;"
        );
        HBox hbox1 = new HBox();
        hbox1.getChildren().addAll(btnOk,btnBack, btnExit);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(50);
        vbox1.getChildren().addAll(lblCont, hbox1);
        vbox1.setStyle("-fx-background-color :#f8e16c;");
        vbox1.setPadding(new Insets(10));
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setPrefWidth(100);
        vbox.getChildren().addAll(btncont,btnRes, vbox1);
        vbox.setAlignment(Pos.CENTER);
        
        vbox1.setVisible(false);
        vbox.setSpacing(20);
        


        
//Start button
        Button btnPlay = new Button();
        btnPlay.setText("GO!");
        btnPlay.setPrefSize(70, 70);
        btnPlay.setLayoutX(85);
        btnPlay.setLayoutY(350);
        btnPlay.setStyle("-fx-background-color :linear-gradient(#5d781b,#9dffb3);"
                + "-fx-font-size : 20px ;"
                + "-fx-font-weight : bold;"
                + "-fx-background-radius : 35px;"
                + "-fx-text-fill: white;"
        );

        Pane panePlay = new Pane();
//        panePlay.setPadding(new Insets(100));
        
        panePlay.getChildren().add(btnPlay);
        
        Button btnStart = new Button();
        btnStart.setText("Tap To Start");
        btnStart.setPrefSize(200,60);
        btnStart.setLayoutX(450);
        btnStart.setLayoutY(460);
        
        btnStart.setStyle("-fx-background-color :#b58f36;"
                +"-fx-font-size : 23px;"
                +"-fx-background-radius:60;"
        );
        
        // IMPORTANT!!!!!!!!1
        ImageView img = new ImageView(new Image(getClass().getResourceAsStream("back.png")));

        img.setFitWidth(480);
        img.setFitHeight(480);

        StackPane root1 = new StackPane();
        root1.setStyle(
                "-fx-background :linear-gradient(#ffd89b , #4d6242);"
        );
        Path pathStart = new Path();
        pathStart.getElements().add(new MoveTo(250, -100));
        pathStart.getElements().add(new LineTo(250, 150));
        PathTransition pathS2 = new PathTransition();
        pathS2.setDuration(javafx.util.Duration.millis(2000));
        pathS2.setPath(pathStart);
        pathS2.setNode(img);
        pathS2.setCycleCount(1);
        pathS2.play();

        TranslateTransition translateStart = new TranslateTransition();
        translateStart.setDuration(javafx.util.Duration.millis(7000));
        translateStart.setNode(img);
        translateStart.setByY(-600);
        translateStart.setCycleCount(1);

        btnStart.setTranslateY(120);

        
        root1.getChildren().addAll(img, btnStart);

        Scene scene1 = new Scene(root1, 1084, 604);

        primaryStage.setTitle("Start");
        primaryStage.setScene(scene1);
        primaryStage.show();

        
        
        
        //finish 
  
  
        
        
    // collecting images    
        File file = new File("../templateSubway2/src/templatesubway2/play ground");
        File file2 = new File("../templateSubway2/src/templatesubway2/character");
        File file3 = new File("../templateSubway2/src/templatesubway2/obstacles");
        File file4 = new File("../templateSubway2/src/templatesubway2/sound");

        String fileUrl = file.toURI().toURL().toString();
        String fileUrl2 = file2.toURI().toURL().toString();
        String fileUrl3 = file3.toURI().toURL().toString();
        String fileUrl4 = file4.toURI().toURL().toString();

        
        System.out.print(fileUrl);
     
        ImageView leftGrass = new ImageView(new Image(fileUrl+"grass.jpg"));
        ImageView rightGrass = new ImageView(new Image(fileUrl+"grass.jpg"));
        ImageView street1 = new ImageView(new Image(fileUrl+"street.png"));
        ImageView street2 = new ImageView(new Image(fileUrl+"street.png"));
        ImageView street3 = new ImageView(new Image(fileUrl+"street.png"));
        ImageView street4 = new ImageView(new Image(fileUrl+"street.png"));
        ImageView street5 = new ImageView(new Image(fileUrl+"street.png"));
        ImageView street6 = new ImageView(new Image(fileUrl+"street.png"));


        ImageView gold = new ImageView(new Image(fileUrl+"gold.png"));
         ImageView goldIncrease = new ImageView(new Image(fileUrl+"2x.png"));
        ImageView safty = new ImageView(new Image(fileUrl+"safty.png"));
        ImageView car = new ImageView(new Image(fileUrl3+"car.png"));
        ImageView car2 = new ImageView(new Image(fileUrl3+"car2.png"));
        ImageView leftBox = new ImageView(new Image(fileUrl3+"left-box-removebg-preview.png"));
        ImageView bigBox = new ImageView(new Image(fileUrl3+"big-box.png"));
        ImageView bigTraffic = new ImageView(new Image(fileUrl3+"big-traffic.png"));
        ImageView roadCone = new ImageView(new Image(fileUrl3+"roadCone.png"));
        ImageView traffic = new ImageView(new Image(fileUrl3+"traffic.png"));
        ImageView bigWoodBox = new ImageView(new Image(fileUrl3+"big_wood_box.png"));
        
        Media media = new Media(fileUrl2+"player.mp4");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView character = new MediaView(mediaPlayer);
        
    

 
       Media mediaCollect= new Media(fileUrl4+"collectingGold.mp3");
      GOLDCOLLECTING = new MediaPlayer(mediaCollect);

       Media mediaStart= new Media(fileUrl4+"music.mp3");
      mediaStartPlay = new MediaPlayer(mediaStart);
              mediaStartPlay.setCycleCount(MediaPlayer.INDEFINITE);
//            mediaStartPlay.setCycleCount(3);

//      
       Media mediaCrash = new Media(fileUrl4+"playerCrashed.mp3");
      CRASHED = new MediaPlayer(mediaCrash);
      CRASHED.setCycleCount(1);


       Media mediaSaftyStarted = new Media(fileUrl4+"saftyStarted.mp3");
      MEDIASAFTYSTARTPLAYER = new MediaPlayer(mediaSaftyStarted);
            MEDIASAFTYSTARTPLAYER.setCycleCount(1);

      
       Media mediaSaftyFinished = new Media(fileUrl4+"saftyFinished.mp3");
      MEDIASAFTYFINISHPLAYER = new MediaPlayer(mediaSaftyFinished);
      MEDIASAFTYFINISHPLAYER.setCycleCount(1);

// finish     

        
    // COLLECT THE OBSTACLES IN AN ARRAY
    
    
    
       // Images sizing and video sizing
 leftGrass.setFitWidth(260);//+100
 leftGrass.setFitHeight(600);
 rightGrass.setFitWidth(260);//+100
 rightGrass.setFitHeight(600);
 street1.setFitWidth(180); // HALF cord is (257,0)
 street1.setFitHeight(600);
 street2.setFitWidth(180);// HALF cord is (442,0)
 street2.setFitHeight(600);
 street3.setFitWidth(180);// HALF cord is (627,0)
 street3.setFitHeight(600);    
 
  street4.setFitWidth(180);// HALF cord is (627,0)
 street4.setFitHeight(600);    
   street5.setFitWidth(180);// HALF cord is (627,0)
 street5.setFitHeight(600);    
 
   street6.setFitWidth(180);// HALF cord is (627,0)
 street6.setFitHeight(600);    
 
 
 gold.setFitWidth(25);
 gold.setFitHeight(25);
 
 safty.setFitHeight(40);
 safty.setFitWidth(40);
 
 goldIncrease.setFitHeight(37);
 goldIncrease.setFitWidth(37);
 character.setFitHeight(120);
 character.setFitWidth(60);

   // finish
        
 
   

   
   
// setting stackPane as a layout 
StackPane  stackPaneG1=new StackPane();
StackPane  stackPaneG2=new StackPane();
StackPane  stackPaneS1=new StackPane();
StackPane  stackPaneS2=new StackPane();
StackPane  stackPaneS3=new StackPane();
StackPane  stackPaneEnd = new StackPane();

StackPane stackPaneMain = new StackPane();//604x804
StackPane zeroStackPane = new StackPane();//600 x 550 -->> 717 is the end of third street 167 is the start of the first street 717-167 =550
StackPane obstacleStackPane = new StackPane();//600 x 550 -->> 717 is the end of third street 167 is the start of the first street 717-167 =550
StackPane firstStackPane = new StackPane();//600 x 550 -->> 717 is the end of third street 167 is the start of the first street 717-167 =550
StackPane stackCollector = new StackPane();
//// we move the player to zeroStackPane when we press arrow down
//// obstacleLayout is in the middle between zero and first stackpanes 
//// we move the player to firstStackPane when we press arrow UP

stackPaneG1.setPrefWidth(260);//+100
stackPaneG1.setPrefHeight(600);
stackPaneG2.setPrefWidth(260);//+100
stackPaneG2.setPrefHeight(600);
stackPaneS1.setPrefWidth(180);
stackPaneS1.setPrefHeight(600);
stackPaneS2.setPrefWidth(180);
stackPaneS2.setPrefHeight(600);
stackPaneS3.setPrefWidth(180);
stackPaneS3.setPrefHeight(600);


//this code is optional you can delete them
zeroStackPane.setPrefWidth(550);
zeroStackPane.setPrefHeight(600);

stackPaneEnd.setPrefWidth(550);
stackPaneEnd.setPrefHeight(600);

obstacleStackPane.setPrefWidth(550);
obstacleStackPane.setPrefHeight(600);

firstStackPane.setPrefWidth(550);
firstStackPane.setPrefHeight(600);
//finish-optional

stackCollector.setStyle("-fx-translate-x: 167px; -fx-translate-y: 2px;");//start from street1
stackCollector.setStyle("-fx-max-height: 600px; -fx-max-width: 550px;");//ends in street3
stackPaneEnd.getChildren().add(vbox);
stackPaneEnd.setVisible(false);
//finish

//adding image 
stackPaneG1.getChildren().add(leftGrass);
stackPaneG2.getChildren().add(rightGrass);
stackPaneS1.getChildren().addAll(street1,street6);
stackPaneS2.getChildren().addAll(street2,street5);
stackPaneS3.getChildren().addAll(street3,street4);
 

        TranslateTransition translateStreet1 = new TranslateTransition();
        translateStreet1.setDuration(javafx.util.Duration.millis(100));
        translateStreet1.setNode(street4);
        translateStreet1.setByY(25);
        translateStreet1.setCycleCount(Timeline.INDEFINITE);
//                translateStreet1.play();

                TranslateTransition translateStreet2 = new TranslateTransition();
        translateStreet2.setDuration(javafx.util.Duration.millis(100));
        translateStreet2.setNode(street5);
        translateStreet2.setByY(25);
        translateStreet2.setCycleCount(Timeline.INDEFINITE);
//                translateStreet2.play();

                TranslateTransition translateStreet3 = new TranslateTransition();
        translateStreet3.setDuration(javafx.util.Duration.millis(100));
        translateStreet3.setNode(street6);
        translateStreet3.setByY(25);
        translateStreet3.setCycleCount(Timeline.INDEFINITE);
//        translateStreet.setAutoReverse(true);
//        translateStreet3.play();



stackCollector.getChildren().addAll(zeroStackPane,obstacleStackPane,firstStackPane,stackPaneEnd); // here we collcet all the layouts the player will move to 

// finish
   
 
   
 



// Adding player
  
obstacleStackPane.getChildren().add(character);
mediaPlayer.play();
mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);


//finish
    
// score
Label lblScore = new Label("Score: ");
lblScore.setFont(new Font("Arial", 20)); // set font family to Arial and size to 24
Label scoreResult = new Label("0");
scoreResult.setFont(new Font("Arial", 20)); // set font family to Arial and size to 24   // edited to 20 instead of 18   hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
 


HBox hLblScr =new HBox();          
hLblScr.getChildren().addAll(lblScore,scoreResult);
hLblScr.setMaxHeight(30);
hLblScr.setMaxWidth(200);
hLblScr.setAlignment(Pos.CENTER);
hLblScr.setOpacity(0.8);
hLblScr.setStyle("-fx-background-color: lightgray ;"
        + " -fx-background-radius:20; "
        + "-fx-border-radius:20;"
        + "-fx-border-width: 1px ; "
        + "-fx-border-color: gray ; "
        + "-fx-border-style: solid ;");    
 

Label lblMaxScore = new Label("Max Score: ");
lblMaxScore.setFont(new Font("Arial", 20)); // set font family to Arial and size to 24
Label MaxScoreResult = new Label("0");
MaxScoreResult.setFont(new Font("Arial", 20)); // set font family to Arial and size to 24

//adding max score to Hbox

HBox hLblMax =new HBox();
hLblMax.getChildren().addAll(lblMaxScore,MaxScoreResult);
hLblMax.setMinHeight(30);
hLblMax.setPrefWidth(200);
hLblMax.setMaxWidth(250);
hLblMax.setAlignment(Pos.CENTER);
hLblMax.setOpacity(0.8);
hLblMax.setStyle("-fx-background-color: lightgray ;"
        + " -fx-background-radius:20; "
        + "-fx-border-radius:20;"
        + "-fx-border-width: 1px ; "
        + "-fx-border-color: gray ; "
        + "-fx-border-style: solid ;");
 

// adding coins and its label to HBox
HBox hCoins = new HBox();// the Hbox contains number of collected coins

Label lblCoinsValue = new Label("0");  
lblCoinsValue.setFont(new Font("Arial", 20)); // set font family to Arial and size to 24
hCoins.getChildren().addAll(gold,lblCoinsValue);
hCoins.setMaxHeight(30);
hCoins.setPrefWidth(100);
hCoins.setMaxWidth(100);
hCoins.setAlignment(Pos.CENTER_LEFT);
hCoins.setOpacity(0.8);
hCoins.setStyle("-fx-background-color: lightgray ;"
        + " -fx-background-radius:20; "
        + "-fx-border-radius:20;"
        + "-fx-border-width: 1px ; "
        + "-fx-border-color: gray ; "
        + "-fx-border-style: solid ;");



// adding the hbox of score and coins to another hbox


VBox vscrr = new VBox();
vscrr.getChildren().addAll(hLblScr,hCoins);
vscrr.setAlignment(Pos.TOP_LEFT);

vscrr.setSpacing(20);
vscrr.setPadding(new Insets(10));




// adding the hscrr to stackpane

StackPane stackpaneff = new StackPane();
stackpaneff.getChildren().addAll(vscrr);
stackpaneff.setAlignment(Pos.TOP_LEFT);
stackpaneff.setPadding(new Insets(0));







//finish


// super power icons
        VBox vSuperPower = new VBox();
        vSuperPower.setPadding(new Insets(15)); // space around the nodes 
        vSuperPower.setSpacing(20);
        vSuperPower.setAlignment(Pos.TOP_RIGHT);
        vSuperPower.setPadding(new Insets(30));

        VBox vSuperPowerImageSpeed = new VBox();
        Label lblGold = new Label("press S");
        lblGold.setFont(new Font("Arial", 21)); // set font family to Arial and size to 24
        lblGold.setStyle("-fx-border-color: none;"
                + "-fx-background-color :linear-gradient(#ffff20,#3cd500);"
                + "-fx-padding : 10px;"
                + "-fx-background-radius:20;"
                +"-fx-text-fill : #6b6b6b;"
        );
        lblGold.setPrefWidth(120);
        lblGold.setAlignment(Pos.CENTER);
        vSuperPowerImageSpeed.getChildren().addAll(goldIncrease, lblGold);
        vSuperPowerImageSpeed.setAlignment(Pos.CENTER);
        vSuperPowerImageSpeed.setSpacing(15);

        VBox vSuperPowerImageSafty = new VBox();
        Label lblSafty = new Label("press F");
        lblSafty.setFont(new Font("Arial", 21)); // set font family to Arial and size to 24
        lblSafty.setStyle("-fx-border-color: none;"
                + "-fx-padding : 10px;"
                + "-fx-background-color :linear-gradient(#ffff20,#3cd500);"
                + " -fx-background-radius:20;"
                +"-fx-text-fill : #6b6b6b;"
        );
        lblSafty.setPrefWidth(120);
        lblSafty.setAlignment(Pos.CENTER);
        vSuperPowerImageSafty.getChildren().addAll(safty, lblSafty);
        vSuperPowerImageSafty.setAlignment(Pos.CENTER);
        vSuperPowerImageSafty.setSpacing(15);

        VBox VSuper = new VBox();

        VSuper.getChildren().addAll(vSuperPowerImageSpeed, vSuperPowerImageSafty);
        VSuper.setSpacing(20);

        vSuperPower.getChildren().addAll(hLblMax, VSuper);
        StackPane stackpaneMax = new StackPane();
        stackpaneMax.getChildren().add(vSuperPower);
        stackpaneMax.setAlignment(Pos.TOP_RIGHT);
        stackpaneMax.setPadding(new Insets(15));

        stackPaneG2.getChildren().add(vSuperPower);
        HBox hbox = new HBox();
        hbox.setPrefWidth(980);  //+50
        hbox.setPrefHeight(700);
        hbox.setSpacing(5);
        hbox.setStyle("-fx-border-width: 2px; -fx-border-color: black; -fx-border-style: solid;");


//finish

//Positioning the player

obstacleStackPane.setAlignment(character,Pos.BOTTOM_CENTER);
character.setTranslateY(-60);//


//finish

// moving player on horezontal line



//

  
hbox.getChildren().addAll(stackPaneG1,stackPaneS1,stackPaneS2,stackPaneS3,stackPaneG2);
stackPaneMain.getChildren().addAll(hbox,stackpaneff,stackpaneMax,panePlay,stackCollector);

stackPaneMain.setAlignment(Pos.CENTER);
     

Scene scene = new Scene(stackPaneMain, 1084, 604);
      
scene.setOnKeyPressed(event -> {
            try {
                handleKeyPress(event.getCode(),character,firstStackPane,zeroStackPane,obstacleStackPane,character,lblCoinsValue,safty,lblSafty,goldIncrease,lblGold);
            } catch (MalformedURLException ex) {
                Logger.getLogger(TemplateSubway2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

// actions
btnStart.setOnAction(event ->{
        primaryStage.setScene(scene);
   // adjusting maxWidth and maxHeight of the window
        primaryStage.setMinWidth(DESIRED_WIDTH);
        primaryStage.setMaxWidth(DESIRED_WIDTH);
        primaryStage.setMinHeight(DESIRED_HEIGHT);
        primaryStage.setMaxHeight(DESIRED_HEIGHT);
 }
); 


btnPlay.setOnAction(event ->{
                    translateStreet1.play();
                    translateStreet2.play();
                    translateStreet3.play();
            GOLDCOLLECTING.stop();
            mediaStartPlay.play();
            RESTARTED=false;
            GAME_IS_ON = true;
            try {
                createObstacle(obstacleStackPane);
                scoreIncrease(scoreResult,MaxScoreResult,10);
            obstacleMover(obstacleStackPane,stackPaneEnd,lblCoinsValue);
            } catch (MalformedURLException ex) {
                Logger.getLogger(TemplateSubway2.class.getName()).log(Level.SEVERE, null, ex);
            }
       btnPlay.setVisible(false);

 }
);


 btncont.setOnAction(e -> {
   vbox1.setVisible(true);
   btncont.setVisible(false);
 });
 

btnRes.setOnAction(e -> {
     CRASHED.stop();
     RESTARTED = true;
     safty(character, safty,lblSafty);
     
     translateStreet1.pause();
     translateStreet2.pause();
     translateStreet3.pause();
     lblCoinsValue.setText(String.valueOf(Integer.parseInt("0")));

     stackPaneEnd.setVisible(false);
     btnPlay.setVisible(true);
 });

 
 btnOk.setOnAction(e->{     
          if(Integer.parseInt(lblCoinsValue.getText())>=300){
              lblCoinsValue.setText(String.valueOf(Integer.parseInt(lblCoinsValue.getText()) - 300));
                 btncont.setVisible(true);       
                 stackPaneEnd.setVisible(false);
                 vbox1.setVisible(false);
                 btnPlay.setVisible(true);
                 translateStreet1.pause();
                 translateStreet2.pause();
                 translateStreet3.pause();
                 CRASHED.stop();
                 GOLDCOLLECTING.play();
          }else{
              lblCont.setText("You don't' have enough coins !");
             lblCont.setTextFill(Color.RED);
             btnOk.setOpacity(0.5);
          }
        });



btnBack.setOnAction(e->{
             btnOk.setOpacity(1);
             lblCont.setText("Note! You will lose 300 coin");
             lblCont.setTextFill(Color.BLACK);

             btncont.setVisible(true); 
             vbox1.setVisible(false);

    });

//
        
 btnExit.setOnAction(e->{  
        primaryStage.close();
 });
        
        
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////

    
    private Image randomObstacleViewer() throws MalformedURLException {
      

// Create a new obstacle with a different color
        String obstacle;
        String[] obstacleArray = {"car.png","car2.png","left-box-removebg-preview.png","big-box.png","big-traffic.png","roadCone.png","traffic.png","big_wood_box.png"};
        File file3 = new File("../templateSubway2/src/templatesubway2/obstacles");
        String fileUrl3 = file3.toURI().toURL().toString();
        int random = (int) (Math.random() * obstacleArray.length);
        obstacle= obstacleArray[random];


        if(obstacle=="big-traffic.png"){

            BIGTRAFFICCHECK = true; 
    
            };

        return new Image(fileUrl3+obstacle) ;         
    
}
    private boolean obstacleTypeChecker(Image img) {
        // Create a background fill with the specified color
        String imageUrl = img.impl_getUrl();
        String imageFullName;      
        imageFullName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
        ImageView obstacleImageView = new ImageView(img);
        
      return "car.png".equals(imageFullName)||"car2.png".equals(imageFullName)||"big-box.png".equals(imageFullName);
         
    }
    //line 315
    private void createObstacle(StackPane stackPane) throws MalformedURLException {
   BIGOBSTACLE1=false;
   BIGOBSTACLE2=false;
   BIGOBSTACLE3=false;

        if(GAME_IS_ON){        

        // Create the obstacle image
        Image goldObstacle = goldCreator();
        ImageView gold = new ImageView(goldObstacle); // creating the gold image
        gold.setFitHeight(30);
        gold.setFitWidth(30);
        Image obstacleImage = randomObstacleViewer();   
        ImageView firstObstacleImageView = new ImageView(obstacleImage);
        Image secondObstacleImage = randomObstacleViewer();   
        ImageView secondObstacleImageView = new ImageView(secondObstacleImage);
             
        // setting style to obstacle
        if(obstacleTypeChecker(obstacleImage))// we used obstacleTypeChecker() method to check if it a big obstacle -> 120X60 px or small obstacle 60X60 px
        {
        firstObstacleImageView.setFitHeight(120);
        firstObstacleImageView.setFitWidth(60);
       }else{
        firstObstacleImageView.setFitHeight(60);
        firstObstacleImageView.setFitWidth(60);

        }
        
        if(obstacleTypeChecker(secondObstacleImage))// we used obstacleTypeChecker() method to check if it a big obstacle -> 120X60 px or small obstacle 60X60 px
        {
        secondObstacleImageView.setFitHeight(120);
        secondObstacleImageView.setFitWidth(60);
       }else{
        secondObstacleImageView.setFitHeight(60);
        secondObstacleImageView.setFitWidth(60);
        }
        
        
        
        stackPane.getChildren().add(firstObstacleImageView);
        
        stackPane.getChildren().add(secondObstacleImageView);
        stackPane.getChildren().add(gold);
        GOLDIMAGE = gold;       
        
       
        

       // positioning the obstacles to roads
       int randomRoad =(int) (Math.random() *3)+1;//choose which way the image will be created
       int leftOrRight = (int) (Math.random() *2)+1;// choose the left way od the right way of the obstacle
              
       firstObstacleImageView.setTranslateY(-120); // move the obstacle 
       secondObstacleImageView.setTranslateY(-120); // Move line 200 pixels down 
       gold.setTranslateY(-120); // Move line 200 pixels down y=500

       // the switch case decides the path of two the obstacles
       
switch (randomRoad) {
    case 1:
        if(firstObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE1=true;
        
        stackPane.setAlignment(firstObstacleImageView, Pos.TOP_CENTER);
        firstObstacleImageView.setTranslateX(-185);
        
        if (leftOrRight == 1) {
         if(secondObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE2=true;
        
            stackPane.setAlignment(secondObstacleImageView, Pos.TOP_CENTER);
            stackPane.setAlignment(gold, Pos.TOP_CENTER);
            gold.setTranslateX(185);

        } else {
         if(secondObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE3=true;

            stackPane.setAlignment(secondObstacleImageView, Pos.TOP_CENTER);
            secondObstacleImageView.setTranslateX(185);
            stackPane.setAlignment(gold, Pos.TOP_CENTER);

        }
        break;
    case 2:
        stackPane.setAlignment(firstObstacleImageView, Pos.TOP_CENTER);
        if(firstObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE2=true;

        if (leftOrRight == 1) {
            if(secondObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE3=true;
            stackPane.setAlignment(secondObstacleImageView, Pos.TOP_CENTER);
            secondObstacleImageView.setTranslateX(185);
            stackPane.setAlignment(gold, Pos.TOP_CENTER);
            gold.setTranslateX(-185);
        } else {
             if(secondObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE1=true;

            stackPane.setAlignment(secondObstacleImageView, Pos.TOP_CENTER);
            secondObstacleImageView.setTranslateX(-185);
            stackPane.setAlignment(gold, Pos.TOP_CENTER);
            gold.setTranslateX(185);
        }
        break;
    case 3:
        stackPane.setAlignment(firstObstacleImageView, Pos.TOP_CENTER);
        firstObstacleImageView.setTranslateX(185);
        if(firstObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE3=true;

        if (leftOrRight == 1) {
              if(secondObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE2=true;

            stackPane.setAlignment(secondObstacleImageView, Pos.TOP_CENTER);
            stackPane.setAlignment(gold, Pos.TOP_CENTER);
            gold.setTranslateX(-185);
        } else {
         if(secondObstacleImageView.getFitHeight()==120.0)BIGOBSTACLE3=true;

            stackPane.setAlignment(secondObstacleImageView, Pos.TOP_CENTER);
            secondObstacleImageView.setTranslateX(-185);
            stackPane.setAlignment(gold, Pos.TOP_CENTER);
            
        }
        break;
    default:
        // Handle invalid randomRoad value
        break;

}
OBSTACLE_CHILDREN=stackPane.getChildren();
GOLD_X = gold.getBoundsInParent().getMinX();
OBSTACLE1_X=firstObstacleImageView.getBoundsInParent().getMinX();
OBSTACLE2_X=secondObstacleImageView.getBoundsInParent().getMinX();

   }
   } 
    private Image goldCreator() throws MalformedURLException {
        // Create a background fill with the specified color
        File file = new File("../templateSubway2/src/templatesubway2/play ground");
        String fileUrl = file.toURI().toURL().toString();
        // Create a background with the fill
        return new Image(fileUrl+"gold.png") ;         
    }
    private void obstacleMover(StackPane stackpane,StackPane stackEnd,Label gold)throws MalformedURLException{        
    ObservableList<Node> children = stackpane.getChildren();

    if(GAME_IS_ON){        
        for (Node child : children) // looping over the children array list
        {// check if the type of the child is image 
         
            if (child instanceof ImageView) {

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1800),child);// move obstacle
            translateTransition.setToY(600);// reach player
            translateTransition.play();

             }

           }

        
            PauseTransition deleter = new PauseTransition(Duration.millis(1800)); // delete passed obstacle
            deleter.setOnFinished(event -> {

            deleteMethod(stackpane);
            });
            deleter.play();
             PauseTransition replacer = new PauseTransition(Duration.millis(2000)); // regenerate the obstacles
            replacer.setOnFinished(event -> {
        try {
            createObstacle(stackpane);
            obstacleMover(stackpane,stackEnd,gold);

        } catch (MalformedURLException ex) {
            Logger.getLogger(TemplateSubway2.class.getName()).log(Level.SEVERE, null, ex);
        }
                });
            replacer.play();

     PauseTransition gameChecker = new PauseTransition(Duration.millis(1200));//1350 
            gameChecker.setOnFinished(event -> {

            try {
                gameChecker2(stackpane);
            } catch (MalformedURLException ex) {
                Logger.getLogger(TemplateSubway2.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            visibility(stackEnd,mediaStartPlay);
            if(COLLISION_RESULT.equals("GOLD")){
                gold.setText(String.valueOf(Integer.parseInt(gold.getText()) + 30));
            }
             COLLISION_RESULT ="";
            LOST = false;
              
            });

        gameChecker.play();
}
 }

    /**
     * @param args the command line arguments
     */  
    private void scoreIncrease(Label lbl,Label maxlbl,Integer t ) throws MalformedURLException {
         //variables referenced from a lambda expression must be final or effectively final in Java.
             int[] scoreValue = {Integer.parseInt(lbl.getText())};
             boolean[] gameContenu = {true};

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(t),
                e->{        
                    if(RESTARTED){
                        scoreValue[0]=0;
                    }
                    
                    if(gameContenu[0]){
                        scoreValue[0]++;
                        lbl.setText(String.valueOf(scoreValue[0]));
                       if(!GAME_IS_ON)// here we check if the game is ended or not
                        {
                        gameContenu[0] = false;
                             }
                    }
                    else
                    {
                    lbl.setText(String.valueOf(scoreValue[0]));
                    if(Integer.parseInt(maxlbl.getText())<Integer.parseInt(lbl.getText()))
                    maxlbl.setText(String.valueOf(scoreValue[0]));
                    }
                
                }
                )
                
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
         


    }

    private void deleteMethod(StackPane stackpane) {
        if(GAME_IS_ON){        

        for(int i =  stackpane.getChildren().size() - 1; i>0  ;i--){

            stackpane.getChildren().remove(i);
                }
        }
    }
    
// moving player Left and right up and down   
    private void movePlayerRight(MediaView media) {
                if(media.getTranslateX()!=185){
                    media.setTranslateX(media.getTranslateX()+185);
                    PLAYER_X +=185.0; 

                }
    }
    private void movePlayerLeft(MediaView media) {
        if(media.getTranslateX()!=-185){
            media.setTranslateX(media.getTranslateX()-185);
                     PLAYER_X -=185.0;

        }

    }    
    private void movePlayerUp(MediaView media,StackPane stackpane,StackPane obstacle) {
                    JUMPED = true;
                    WIDTH = 80;
      Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(500), new KeyValue(media.fitWidthProperty(), 60)),
                new KeyFrame(Duration.millis(200), new KeyValue(media.fitWidthProperty(), 80))
                );  
                if (!stackpane.getChildren().contains(media)){ 
                     obstacle.getChildren().remove(media);
                     stackpane.getChildren().add(media);
                    }
                timeline.play();
                
     PauseTransition widthIncrease = new PauseTransition(Duration.millis(500));
        widthIncrease.setOnFinished(event -> {
                            WIDTH = 60;
                            JUMPED = false;

        });
        widthIncrease.setCycleCount(1);
          widthIncrease.play();

  }
    private void movePlayerDown(MediaView media,StackPane stackpane,StackPane obstacle) {
                     WIDTH = 40;

      Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(500), new KeyValue(media.fitWidthProperty(), 60)),
                new KeyFrame(Duration.millis(200), new KeyValue(media.fitWidthProperty(), 40)));
        if (!stackpane.getChildren().contains(media)){ 
            obstacle.getChildren().remove(media);
            stackpane.getChildren().add(media);
        }
        media.setFitWidth(40);
        timeline.play();
             PauseTransition widthDecrease = new PauseTransition(Duration.millis(500));
        widthDecrease.setOnFinished(event -> {
                            WIDTH = 60;
        });
        widthDecrease.setCycleCount(1);
          widthDecrease.play();
        
  }
//    
    private void safty(MediaView player,ImageView saftyImage,Label fletter) {

        if(!safty){
            if(!RESTARTED){
        IS_SAFE=true;
   MEDIASAFTYFINISHPLAYER.stop();

   MEDIASAFTYSTARTPLAYER.play();
         saftyTimer = false;   
         safty = true;  
            
         //fade fore image    
        FadeTransition fadeInTransition2 = new FadeTransition(Duration.seconds(15)/*safty time to be available*/, saftyImage);
        fadeInTransition2.setFromValue(0.0);
        fadeInTransition2.setToValue(1.0);
        fadeInTransition2.setCycleCount(1);
        fadeInTransition2.play();

        // Create a FadeTransition for fading in
        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(1), player);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);

        // Create a FadeTransition for fading out
        FadeTransition fadeOutTransition = new FadeTransition(Duration.seconds(1), player);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
 
//          if(RESTARTED) {
        // Create a SequentialTransition for alternating fade in and fade out
        SequentialTransition sequence = new SequentialTransition( fadeOutTransition,fadeInTransition);
        sequence.setCycleCount(5);
        sequence.setAutoReverse(true);

      

        // Play the fade-in and fade-out sequence
        sequence.play();
            }else{
            player.setOpacity(1);
                 IS_SAFE = false;
                 safty = false;
                 saftyTimer = false;
            }
         }
         if(!saftyTimer){
              if(!RESTARTED){
             
          fletter.setOpacity(0);
          PauseTransition timer = new PauseTransition(Duration.seconds(20));
            timer.setOnFinished(event -> {  
              saftyTimer = true;
              safty = false;  
               fletter.setOpacity(1);
               MEDIASAFTYSTARTPLAYER.stop();
           
        });        
          PauseTransition saftytimer = new PauseTransition(Duration.seconds(10));
            saftytimer.setOnFinished(event -> {  
                IS_SAFE=false;
                MEDIASAFTYFINISHPLAYER.play();

        });
        saftytimer.play();

        timer.play();
              }else{
                             fletter.setOpacity(1);
                                            MEDIASAFTYSTARTPLAYER.stop();
                                               MEDIASAFTYFINISHPLAYER.stop();
              }
        
         }
      
    }
    private void goldIncreaser(Label scoreLbl,ImageView goldImage, Label sLetter) throws MalformedURLException {

       if(!GOLDVALUE){
           GOLDCOLLECTING.play();
         scoreLbl.setText(String.valueOf(Integer.parseInt(scoreLbl.getText())+100)); 

         GOLDVALUETIMER = false;   
         GOLDVALUE = true;
                 
        FadeTransition fadeInTransition = new FadeTransition(Duration.seconds(60)/*safty time to be available*/, goldImage);
        fadeInTransition.setFromValue(0.0);
        fadeInTransition.setToValue(1.0);
        fadeInTransition.setCycleCount(1);
        fadeInTransition.play();
         
                 }
        if(!GOLDVALUETIMER){
          sLetter.setOpacity(0);
          PauseTransition timer = new PauseTransition(Duration.seconds(60));
            timer.setOnFinished(event -> {  
              GOLDVALUETIMER = true;
              GOLDVALUE = false;  
               sLetter.setOpacity(1);
               GOLDCOLLECTING.stop();

        });        
        timer.play();
         }
       

    }
   
    private void handleKeyPress(KeyCode keyCode,MediaView media,StackPane first,StackPane zero,StackPane obstacle,MediaView player,Label goldLbl,ImageView saftyImage,Label fletter,ImageView goldImage,Label sLetter) throws MalformedURLException {

if(GAME_IS_ON){ 

        switch (keyCode) {
            case RIGHT:


                movePlayerRight(media);
                break;
            case LEFT:
                movePlayerLeft(media);


                break;
            case UP:
                    if(!JUMPED){
                        movePlayerUp(media,first,obstacle);
                    }


                break;
            case DOWN:
                
                movePlayerDown(media,zero,obstacle);


                break;
            case F:
                if(!safty)safty(player,saftyImage,fletter);


                break;
            case S:
                if(!GOLDVALUE)goldIncreaser(goldLbl,goldImage,sLetter);


                break;    
                
            default:
                // Ignore other keys
        }
}
    }
 
    private String gameChecker2(StackPane stackpane) throws MalformedURLException{
   

     
     for(Node child: OBSTACLE_CHILDREN)  {    
              if(child instanceof ImageView ){

          if(child.getBoundsInParent().getMaxY()>400&& child.getBoundsInParent().getMaxY()<590){ //400
             if(!LOST){
             if(OBSTACLE2_X==(PLAYER_X-247.0)|| OBSTACLE1_X==(PLAYER_X-247.0) ){
             LOST= true;                    
            switch (WIDTH) {
            case 60:
                if(!IS_SAFE){
                   COLLISION_RESULT ="60 LOST";
                    CRASHED.play();
                    GOLDCOLLECTING.stop();
                  GAME_IS_ON=false;       

                }
                break;
            case 80: //System.out.println("player jumped");// player survived
                if(!IS_SAFE){

                if(checkBigObstacle()){
                   COLLISION_RESULT ="80 LOST";
                    CRASHED.play();
                      GOLDCOLLECTING.stop();

                  GAME_IS_ON=false;  
//                   SCENE_CHANGED=false;
                   
                }
      

             }else{
                 COLLISION_RESULT ="NO COLLISION";  
             }
                break;
             case 40:
            if(((ImageView) child).getImage().impl_getUrl().contains("big-traffic.png")) // check if the image was big-traffic
                 {
                  COLLISION_RESULT ="NO COLLISION";
                 }else{
                   if(!IS_SAFE){
                   COLLISION_RESULT ="40 LOST";
                   CRASHED.play();
                  GOLDCOLLECTING.stop();
                  GAME_IS_ON=false;  

                   }

            }
                break;
            default:
////                 Ignore other keys
                }
               }else if(GOLD_X==(PLAYER_X-247.0)&&!LOST){ // if image is gold
              if(WIDTH<=60){
              COLLISION_RESULT ="GOLD";
             if(((ImageView) child).getImage().impl_getUrl().contains("gold.png"))child.setOpacity(0); // check if the image was big-traffic
              }
                LOST = false;

               }        
             }
             }
              
              }
                }
     return COLLISION_RESULT ;
 }   
    private boolean checkBigObstacle(){
    boolean[] x = {false};
//
         switch((int)PLAYER_X) {
            case 62:
if(BIGOBSTACLE1) x[0]=true;
                break;
            case 247: 
if(BIGOBSTACLE2) x[0]=true;

                break;
             case 432:
if(BIGOBSTACLE3) x[0]=true;

                break;
            default:
////                 Ignore other keys
                }
     return x[0];
}
  
    private void visibility(StackPane stackpane, MediaPlayer  mediaStartPlay) {
        // Create a background fill with the specified color
           if(!GAME_IS_ON){
               stackpane.setVisible(true);
               mediaStartPlay.stop();

                       };
        
    }

  public static void main(String[] args) {
        launch(args);
        
    }

  private String StringValueOf(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
