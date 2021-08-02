/*
    TOPIC FOR OOP PROJECT: PROGRAMMIN G

ABCDEFG
    
    THE PROJECT IDEA CONSISTED OF 3 GAMES TO BE MADE FOR YOUNG CHILDREN
    TO SET THEM ON A LEARNING PATH FOR PROGRAMMING BY PROVIDING THEM 
    SUCH GAMES THAT DEPICT CERTAIN PROGRAMMING CONCEPTS.
    
    WRITTEN BY: AHMAD TASHFEEN - BSCS 10C (CMS: 345308)

    GAME CHOSEN OUT OF THE THREE: SEQUENCE
    
    IN THIS GAME, THE USER IS SHOWN IMAGES AND TASKED TO SELECT THEM IN 
    THEIR CORRECT SEQUENCE.
    
 */
package project;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sequence extends Application {

    private final String[] easyAnswer = {"A", "C", "B"}, //ANSWER ARRAYS
            mediumAnswer = {"B", "F", "C", "D", "A", "E"},
            hardAnswer = {"C", "E", "J", "G", "A", "I"};

    private int i = 0, mistakes = 0;

    private final Button option1 = new Button("A"), //OPTION BUTTONS 1 - 10
            option2 = new Button("B"),
            option3 = new Button("C"),
            option4 = new Button("D"),
            option5 = new Button("E"),
            option6 = new Button("F"),
            option7 = new Button("G"),
            option8 = new Button("H"),
            option9 = new Button("I"),
            option10 = new Button("J"),
            exitButton = new Button("EXIT"),
            enterButton = new Button("ENTER"),
            playLevelEasy = new Button("EASY"),
            playLevelMedium = new Button("MEDIUM"),
            playLevelHard = new Button("HARD"),
            checkButton = new Button("CHECK FINAL GRADE"),
            leaderboardButton = new Button("LEADERBOARD");

    private final Text correctOptionSelected = new Text("CORRECT"),
            correctPrompt = new Text("CORRECT WILL BE SHOWN HERE"),
            incorrectOptionSelected = new Text("INCORRECT"),
            incorrectPrompt = new Text("INCORRECT WILL BE SHOWN HERE"),
            easyLevelName = new Text("LEVEL: EASY"),
            mediumLevelName = new Text("LEVEL: MEDIUM"),
            hardLevelName = new Text("LEVEL: HARD"),
            usernameOutput = new Text();

    private final TextField usernameTextField = new TextField();

    //'hb' IS SHORT FOR 'HORIZONTAL BOX
    private final HBox hbFirstStageHeading = new HBox(),
            hbFirstStageSubHeading = new HBox(),
            hbFirstStageSubHeading2 = new HBox(),
            hbFirstStageSubHeading3 = new HBox(),
            hbFirstStageTextField = new HBox(),
            hbFirstStageOptionButtons = new HBox(),
            hbEasyOptions = new HBox(),
            hbMediumOptionsRow1 = new HBox(),
            hbMediumOptionsRow2 = new HBox(),
            hbHardOptionsRow1 = new HBox(),
            hbHardOptionsRow2 = new HBox(),
            hbHardOptionsRow3 = new HBox(),
            hbCheckStageFinalGrade = new HBox(),
            hbCheckStageExit = new HBox(),
            hbEasyMain = new HBox(),
            hbEasyHeading = new HBox(),
            hbMediumMain = new HBox(),
            hbMediumHeading = new HBox(),
            hbHardMain = new HBox(),
            hbHardHeading = new HBox(),
            hbCorrect1 = new HBox(),
            hbCorrect2 = new HBox(),
            hbCorrect3 = new HBox(),
            hbCorrect4 = new HBox(),
            hbCorrect5 = new HBox(),
            hbCorrect6 = new HBox(),
            hbIncorrect1 = new HBox(),
            hbIncorrect2 = new HBox(),
            hbIncorrect3 = new HBox(),
            hbIncorrect4 = new HBox(),
            hbIncorrect5 = new HBox(),
            hbIncorrect6 = new HBox(),
            hbCheckButton = new HBox();

    //'vb' IS SHORT FOT VERTICAL BOX
    private final VBox vbFirstStage = new VBox(),
            vbOption1 = new VBox(),
            vbOption2 = new VBox(),
            vbOption3 = new VBox(),
            vbOption4 = new VBox(),
            vbOption5 = new VBox(),
            vbOption6 = new VBox(),
            vbOption7 = new VBox(),
            vbOption8 = new VBox(),
            vbOption9 = new VBox(),
            vbOption10 = new VBox(),
            vbEasyOptions = new VBox(),
            vbEasyIncorrect = new VBox(),
            vbEasyCorrect = new VBox(),
            vbEasyLevel = new VBox(),
            vbMediumOptions = new VBox(),
            vbMediumIncorrect = new VBox(),
            vbMediumCorrect = new VBox(),
            vbMediumLevel = new VBox(),
            vbHardOptions = new VBox(),
            vbHardIncorrect = new VBox(),
            vbHardCorrect = new VBox(),
            vbHardLevel = new VBox(),
            vbCheckStage = new VBox();

    private final Stage easyLevelStage = new Stage(),
            mediumLevelStage = new Stage(),
            hardLevelStage = new Stage();

    private final String usernameMax7 = new String();

    private String optionSelected = new String(), //ANSWER SELECTED BY USER
            Grade = new String(), //GRADE USER GETS IN THE END
            finalGrade = new String(), //MESSAGE + GRADE
            username = new String(),
            levelName = new String();

    private final ImageView A = new ImageView(new Image("/images/a.PNG")), //IMAGEVIEWS CONTAINING IMAGES OF OPTIONS
            B = new ImageView(new Image("/images/b.PNG")),
            C = new ImageView(new Image("/images/c.PNG")),
            D = new ImageView(new Image("/images/d.PNG")),
            E = new ImageView(new Image("/images/e.PNG")),
            F = new ImageView(new Image("/images/f.PNG")),
            G = new ImageView(new Image("/images/g.PNG")),
            H = new ImageView(new Image("/images/h.PNG")),
            I = new ImageView(new Image("/images/i.PNG")),
            J = new ImageView(new Image("/images/j.PNG"));

    private final StringBuilder sevenLetterUsername = new StringBuilder();

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        playLevelEasy.setOnAction((ActionEvent e) -> {
            try {
                if (e.getSource() == playLevelEasy) {
                    levelName = easyLevelName.getText().toString();
                    playLevelEasy();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Sequence.class.getName()).log(Level.SEVERE, null, ex);
            }
            easyLevelStage.show();
        });

        playLevelMedium.setOnAction((ActionEvent e) -> {
            try {
                if (e.getSource() == playLevelMedium) {
                    levelName = mediumLevelName.getText().toString();
                    playLevelMedium();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Sequence.class.getName()).log(Level.SEVERE, null, ex);
            }
            mediumLevelStage.show();
        });

        playLevelHard.setOnAction((ActionEvent e) -> {
            try {
                if (e.getSource() == playLevelHard) {
                    levelName = hardLevelName.getText().toString();
                    playLevelHard();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Sequence.class.getName()).log(Level.SEVERE, null, ex);
            }
            hardLevelStage.show();
        }
        );

        firstStage(stage);
    }

    public void firstStage(Stage stage) {   //OPENS HOMEPAGE

        stage.setTitle("SEQUENCE");

        Label heading = new Label("WELCOME TO SEQUENCE!");

        Label subHeading = new Label("PICK A DIFFICULTY TO TEST YOURSELF");

        Label subHeading2 = new Label("\tHOW TO PLAY?\n\n"
                + "\tPICTURES DESCRIBE A PLANT'S GROWTH FORM START TO FINISH\n\n"
                + "\tCLICK THE BUTTONS IN CORRECT SEQUENCE TO WIN!");
        subHeading2.setId("sh");    //ASSIGNED CSS ID

        Label subHeading3 = new Label("ENTER A NAME (MUST BE LESS THAN 7 CHARACTERS), THEN CLICK 'ENTER' BELOW");
        subHeading3.setFont(Font.font("Georgia", 15));

        hbFirstStageHeading.getChildren().add(heading); //HORIZONTAL BOX CONTAINS HEADING
        hbFirstStageHeading.setAlignment(Pos.BASELINE_CENTER);

        hbFirstStageSubHeading.getChildren().add(subHeading);//HORIZONTAL BOX CONTAINS SUBHEADING
        hbFirstStageSubHeading.setAlignment(Pos.BASELINE_CENTER);

        hbFirstStageSubHeading2.getChildren().add(subHeading2);//HORIZONTAL BOX CONTAINS SECOND SUBHEADING
        hbFirstStageSubHeading2.setAlignment(Pos.BASELINE_CENTER);

        hbFirstStageSubHeading3.getChildren().add(subHeading3);
        hbFirstStageSubHeading3.setAlignment(Pos.BASELINE_CENTER);

        hbFirstStageTextField.setSpacing(20);
        hbFirstStageTextField.setAlignment(Pos.BASELINE_CENTER);
        enterButton.getStyleClass().add("buttonEnter");//ADDING STYLESHEET
        usernameTextField.setId("tf");  //ASSIGNED CSS ID
        hbFirstStageTextField.getChildren().addAll(usernameTextField, enterButton);

        hbFirstStageOptionButtons.setSpacing(20);
        hbFirstStageOptionButtons.setAlignment(Pos.BASELINE_CENTER);
        playLevelEasy.getStyleClass().add("buttonEasy");//ADDING STYLESHEET TO DIFFICULTY LEVELS
        playLevelMedium.getStyleClass().add("buttonMedium");
        playLevelHard.getStyleClass().add("buttonHard");
        hbFirstStageOptionButtons.getChildren().addAll(playLevelEasy, playLevelMedium, playLevelHard);

        vbFirstStage.getChildren().addAll(hbFirstStageHeading, hbFirstStageSubHeading,
                hbFirstStageSubHeading2, hbFirstStageSubHeading3,
                hbFirstStageTextField, hbFirstStageOptionButtons);//ALL HORIZONTAL BOXES PLACED IN ONE MAIN VERTICAL BOX
        vbFirstStage.setSpacing(30);
        vbFirstStage.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbFirstStage, 550, 400);
        scene.getStylesheets().add(Sequence.class.getResource("/stylesheets/first.css").toExternalForm());

        stage.setOnCloseRequest((x) -> {
            System.exit(0);
        });

        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);   //DEFAULTS STAGE SIZE TO MAXIMUM

        enterButton.setOnAction((ActionEvent z) -> {
            usernameOutput.setText(usernameTextField.getText());    //USERNAME ENTERED IN TEXTFIELD IS STORED IN 'usernameOutput'
        });

        FileCreator();
    }

    public void playLevelEasy() throws FileNotFoundException {

        imageDimensions(A);
        imageDimensions(F);
        imageDimensions(C);

        //BUTTONS AND IMAGES ADDED TO VERTICAL BOXES
        vbOption1.setSpacing(5);
        vbOption1.getChildren().addAll(A, option1);

        vbOption2.setSpacing(5);
        vbOption2.getChildren().addAll(F, option2);

        vbOption3.setSpacing(5);
        vbOption3.getChildren().addAll(C, option3);

        buttonDimensions(option1);
        option1.setId("b1");    //ASSIGNED CSS ID

        buttonDimensions(option2);
        option2.setId("b2");    //ASSIGNED CSS ID

        buttonDimensions(option3);
        option3.setId("b3");    //ASSIGNED CSS ID

        Label l1 = new Label("LEVEL: EASY");
        l1.setId("l1");         //ASSIGNED CSS ID

        hbEasyOptions.setSpacing(10);
        hbEasyOptions.getChildren().addAll(vbOption1, vbOption2, vbOption3);//HORIZONTAL BOX CONTAINS ALL VERTICAL BOXES OF BUTTONS AND IMAGES

        vbEasyOptions.getChildren().add(hbEasyOptions);//HORIZONTAL BOX ADDED TO VERTICAL BOX
        vbEasyOptions.setAlignment(Pos.CENTER);

        vbEasyIncorrect.getChildren().add(incorrectPrompt);
        vbEasyIncorrect.setAlignment(Pos.TOP_LEFT);
        vbEasyIncorrect.setPrefWidth(100);

        vbEasyCorrect.getChildren().add(correctPrompt);
        vbEasyCorrect.setAlignment(Pos.TOP_RIGHT);
        vbEasyCorrect.setPrefWidth(100);

        hbEasyMain.getChildren().addAll(vbEasyIncorrect, vbEasyOptions, vbEasyCorrect);//ALL VERTICAL BOXES ADDED TO A HORIZONTAL BOX
        hbEasyMain.setSpacing(10);
        hbEasyMain.setAlignment(Pos.CENTER);

        hbEasyHeading.getChildren().add(l1);
        hbEasyHeading.setAlignment(Pos.CENTER);

        vbEasyLevel.getChildren().addAll(hbEasyHeading, hbEasyMain, hbCheckButton);//ALL HORIZONTAL BOXES ADDED TO MAIN VERTICAL BOX
        vbEasyLevel.setSpacing(50);
        vbEasyLevel.setAlignment(Pos.CENTER);

        correctPrompt.setFont(Font.font(20));
        correctPrompt.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        correctPrompt.setFill(Color.LIGHTSKYBLUE);

        incorrectPrompt.setFont(Font.font(20));
        incorrectPrompt.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        incorrectPrompt.setFill(Color.LIGHTSKYBLUE);

        buttonActionEasy(option1);
        buttonActionEasy(option2);
        buttonActionEasy(option3);

        checkButton.setId("cb");    //ASSIGNED CSS ID

        easyLevelStage.setOnCloseRequest((x) -> {
            System.exit(0);
        });

        Scene scene = new Scene(vbEasyLevel, 950, 400);
        scene.getStylesheets().add(Sequence.class.getResource("/stylesheets/easy.css").toExternalForm());//ADDING STYLESHEET
        easyLevelStage.setScene(scene);
        easyLevelStage.setTitle("LEVEL: EASY");
        easyLevelStage.setMaximized(true);//WINDOW IS MAXIMIZED WHEN OPENS
    }

    public void playLevelMedium() throws FileNotFoundException {

        imageDimensions(E);
        imageDimensions(A);
        imageDimensions(C);
        imageDimensions(D);
        imageDimensions(F);
        imageDimensions(B);

        //BUTTONS AND IMAGES ADDED TO VERTICAL BOXES
        vbOption1.setSpacing(5);
        vbOption1.getChildren().addAll(E, option1);

        vbOption2.setSpacing(5);
        vbOption2.getChildren().addAll(A, option2);

        vbOption3.setSpacing(5);
        vbOption3.getChildren().addAll(C, option3);

        vbOption4.setSpacing(5);
        vbOption4.getChildren().addAll(D, option4);

        vbOption5.setSpacing(5);
        vbOption5.getChildren().addAll(F, option5);

        vbOption6.setSpacing(5);
        vbOption6.getChildren().addAll(B, option6);

        buttonDimensions(option1);
        option1.setId("b1");    //ASSIGNED CSS ID

        buttonDimensions(option2);
        option2.setId("b2");    //ASSIGNED CSS ID

        buttonDimensions(option3);
        option3.setId("b3");    //ASSIGNED CSS ID

        buttonDimensions(option4);
        option4.setId("b4");    //ASSIGNED CSS ID

        buttonDimensions(option5);
        option5.setId("b5");    //ASSIGNED CSS ID

        buttonDimensions(option6);
        option6.setId("b6");    //ASSIGNED CSS ID

        Label l1 = new Label("LEVEL: MEDIUM");
        l1.setId("l1");         //ASSIGNED CSS ID

        hbMediumOptionsRow1.setSpacing(5);
        hbMediumOptionsRow1.getChildren().addAll(vbOption1, vbOption2, vbOption3);

        hbMediumOptionsRow2.setSpacing(5);
        hbMediumOptionsRow2.getChildren().addAll(vbOption4, vbOption5, vbOption6);

        vbMediumOptions.getChildren().addAll(hbMediumOptionsRow1, hbMediumOptionsRow2);//ADDING HORIZONTAL BOXES TO VERTICAL BOX
        vbMediumOptions.setSpacing(10);
        vbMediumOptions.setAlignment(Pos.CENTER);

        vbMediumIncorrect.getChildren().add(incorrectPrompt);
        vbMediumIncorrect.setAlignment(Pos.TOP_LEFT);
        vbMediumIncorrect.setPrefWidth(100);

        vbMediumCorrect.getChildren().add(correctPrompt);
        vbMediumCorrect.setAlignment(Pos.TOP_RIGHT);
        vbMediumCorrect.setPrefWidth(100);

        hbMediumMain.getChildren().addAll(vbMediumIncorrect, vbMediumOptions, vbMediumCorrect);//ADDING VERTICAL BOXES TO A HORIZONTAL BOX
        hbMediumMain.setSpacing(10);
        hbMediumMain.setAlignment(Pos.CENTER);

        hbMediumHeading.getChildren().add(l1);
        hbMediumHeading.setAlignment(Pos.CENTER);

        vbMediumLevel.getChildren().addAll(hbMediumHeading, hbMediumMain, hbCheckButton);//ADDING ALL HORIZONTAL BOXES TO A VERTICAL BOX
        vbMediumLevel.setSpacing(50);
        vbMediumLevel.setAlignment(Pos.CENTER);

        correctPrompt.setFont(Font.font(20));
        correctPrompt.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        correctPrompt.setFill(Color.GOLDENROD);

        incorrectPrompt.setFont(Font.font(20));
        incorrectPrompt.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        incorrectPrompt.setFill(Color.GOLDENROD);

        buttonActionMedium(option1);
        buttonActionMedium(option2);
        buttonActionMedium(option3);
        buttonActionMedium(option4);
        buttonActionMedium(option5);
        buttonActionMedium(option6);

        checkButton.setId("cb");    //ASSIGNED CSS ID

        mediumLevelStage.setOnCloseRequest((x) -> {
            System.exit(0);
        });

        Scene scene = new Scene(vbMediumLevel, 1070, 400);
        scene.getStylesheets().add(Sequence.class.getResource("/stylesheets/medium.css").toExternalForm());//ADDING STYLESHEET
        mediumLevelStage.setTitle("LEVEL: MEDIUM");
        mediumLevelStage.setScene(scene);
        mediumLevelStage.show();
        mediumLevelStage.setMaximized(true);//WINDOW IS MAXIMISED WHEN LAUNCHED
    }

    public void playLevelHard() throws FileNotFoundException {

        imageDimensions(E);
        imageDimensions(G);
        imageDimensions(A);
        imageDimensions(H);
        imageDimensions(B);
        imageDimensions(J);
        imageDimensions(D);
        imageDimensions(I);
        imageDimensions(F);
        imageDimensions(C);

        //BUTTONS AND IMAGES ADDED TO VERTICAL BOXES
        vbOption1.setSpacing(5);
        vbOption1.getChildren().addAll(E, option1);

        vbOption2.setSpacing(5);
        vbOption2.getChildren().addAll(G, option2);

        vbOption3.setSpacing(5);
        vbOption3.getChildren().addAll(A, option3);

        vbOption4.setSpacing(5);
        vbOption4.getChildren().addAll(H, option4);

        vbOption5.setSpacing(5);
        vbOption5.getChildren().addAll(B, option5);

        vbOption6.setSpacing(5);
        vbOption6.getChildren().addAll(J, option6);

        vbOption7.setSpacing(5);
        vbOption7.getChildren().addAll(D, option7);

        vbOption8.setSpacing(5);
        vbOption8.getChildren().addAll(I, option8);

        vbOption9.setSpacing(5);
        vbOption9.getChildren().addAll(F, option9);

        vbOption10.setSpacing(5);
        vbOption10.getChildren().addAll(C, option10);

        buttonDimensions(option1);
        option1.setId("b1");    //ASSIGNED CSS ID

        buttonDimensions(option2);
        option2.setId("b2");    //ASSIGNED CSS ID

        buttonDimensions(option3);
        option3.setId("b3");    //ASSIGNED CSS ID

        buttonDimensions(option4);
        option4.setId("b4");    //ASSIGNED CSS ID

        buttonDimensions(option5);
        option5.setId("b5");    //ASSIGNED CSS ID

        buttonDimensions(option6);
        option6.setId("b6");    //ASSIGNED CSS ID

        buttonDimensions(option7);
        option7.setId("b7");    //ASSIGNED CSS ID

        buttonDimensions(option8);
        option8.setId("b8");    //ASSIGNED CSS ID

        buttonDimensions(option9);
        option9.setId("b9");    //ASSIGNED CSS ID

        buttonDimensions(option10);
        option10.setId("b10");  //ASSIGNED CSS ID

        Label l1 = new Label("LEVEL: HARD");
        l1.setId("l1");         //ASSIGNED CSS ID

        hbHardOptionsRow1.setSpacing(10);
        hbHardOptionsRow1.getChildren().addAll(vbOption1, vbOption2, vbOption3);
        hbHardOptionsRow1.setAlignment(Pos.CENTER);

        hbHardOptionsRow2.setSpacing(10);
        hbHardOptionsRow2.getChildren().addAll(vbOption4, vbOption5, vbOption6);
        hbHardOptionsRow2.setAlignment(Pos.CENTER);

        hbHardOptionsRow3.setSpacing(10);
        hbHardOptionsRow3.getChildren().addAll(vbOption7, vbOption8, vbOption9, vbOption10);
        hbHardOptionsRow3.setAlignment(Pos.CENTER);

        vbHardOptions.getChildren().addAll(hbHardOptionsRow1, hbHardOptionsRow2, hbHardOptionsRow3);//ADDING HORIZONTAL BOXES TO VERTICAL BOX
        vbHardOptions.setSpacing(10);
        vbHardOptions.setAlignment(Pos.CENTER);

        vbHardIncorrect.getChildren().add(incorrectPrompt);
        vbHardIncorrect.setAlignment(Pos.TOP_LEFT);
        vbHardIncorrect.setPrefWidth(100);

        vbHardCorrect.getChildren().add(correctPrompt);
        vbHardCorrect.setAlignment(Pos.TOP_RIGHT);
        vbHardCorrect.setPrefWidth(100);

        hbHardMain.getChildren().addAll(vbHardIncorrect, vbHardOptions, vbHardCorrect);//ADDING VERTICAL BOXES TO A HORIZONTAL BOX
        hbHardMain.setSpacing(10);
        hbHardMain.setAlignment(Pos.CENTER);

        hbHardHeading.getChildren().add(l1);
        hbHardHeading.setAlignment(Pos.CENTER);

        vbHardLevel.getChildren().addAll(hbHardHeading, hbHardMain, hbCheckButton);//ADDING ALL HORIZONTAL BOXES TO A VERTICAL BOX
        vbHardLevel.setSpacing(50);
        vbHardLevel.setAlignment(Pos.CENTER);

        correctPrompt.setFont(Font.font(20));
        correctPrompt.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        correctPrompt.setFill(Color.RED);

        incorrectPrompt.setFont(Font.font(20));
        incorrectPrompt.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        incorrectPrompt.setFill(Color.RED);

        buttonActionHard(option1);
        buttonActionHard(option2);
        buttonActionHard(option3);
        buttonActionHard(option4);
        buttonActionHard(option5);
        buttonActionHard(option6);
        buttonActionHard(option7);
        buttonActionHard(option8);
        buttonActionHard(option9);
        buttonActionHard(option10);

        checkButton.setId("cb");        //ASSIGNED CSS ID

        hardLevelStage.setOnCloseRequest((x) -> {
            System.exit(0);
        });

        Scene scene = new Scene(vbHardLevel, 1200, 400);
        scene.getStylesheets().add(Sequence.class.getResource("/stylesheets/hard.css").toExternalForm());//ADDING STYLESHEET
        hardLevelStage.setTitle("LEVEL: HARD");
        hardLevelStage.setScene(scene);
        hardLevelStage.show();
        hardLevelStage.setMaximized(true);//WINDOW IS MAXIMISED WHEN LAUNCHED
    }

    public void checkStage(int incorrectOptionSelected) {
        Stage finalStage = new Stage();

        Grade = grade(incorrectOptionSelected);
        finalGrade = "FINAL GRADE: " + Grade;

        Label l2 = new Label(finalGrade);
        l2.setId("l2");         //ASSIGNED CSS ID

        exitButton.setOnAction((x) -> {
            System.exit(0);
        });
        exitButton.setId("eb"); //ASSIGNED CSS ID

        leaderboardButton.setOnAction((x) -> {
            FileOpener();
        });
        leaderboardButton.setId("lb");  //ASSIGNED CSS ID

        hbCheckStageFinalGrade.getChildren().add(l2);
        hbCheckStageFinalGrade.setAlignment(Pos.BASELINE_CENTER);

        hbCheckStageExit.getChildren().addAll(exitButton, leaderboardButton);//BUTTONS ADDED TO HORIZONTAL BOX
        hbCheckStageExit.setSpacing(20);
        hbCheckStageExit.setAlignment(Pos.BASELINE_CENTER);

        vbCheckStage.getChildren().addAll(hbCheckStageFinalGrade, hbCheckStageExit);//HORIZONTAL BOXES ADDED TO A VERTICAL BOX
        vbCheckStage.setSpacing(40);
        vbCheckStage.setAlignment(Pos.CENTER);

        FileWriter();

        finalStage.setOnCloseRequest((x) -> {
            System.exit(0);
        });

        Scene scene = new Scene(vbCheckStage, 1000, 400);
        scene.getStylesheets().add(Sequence.class.getResource("/stylesheets/final.css").toExternalForm());//ADDING STYLESHEET
        finalStage.setScene(scene);
        finalStage.setTitle("GAME ENDED");
        finalStage.showAndWait();
        finalStage.setMaximized(true);//WINDOW MAXIMISED WHEN LAUNCHED
    }

    public void imageDimensions(ImageView img) {
        img.setFitHeight(100);
        img.setFitWidth(100);
        img.setPreserveRatio(true);
    }

    public void buttonDimensions(Button button) {
        button.setMinSize(92, 20);
    }

    public void buttonActionEasy(Button button) {
        button.setOnAction((ActionEvent e) -> {
            if (e.getSource() == button) {
                optionSelected = button.getText().toString();//TEXT FROM SELECTED OPTION BUTTON CASTED TO A STRING
                if (optionSelected.equals(easyAnswer[i])) {//COMPARING SELECTED OPTION WITH ANSWER IN ARRAY
                    i++;//INCREMENT IN 'i' WHENEVER CORRECT OPTION BUTTON IS PRESSED
                    switch (i) {
                        case 1:
                            correctOptionSelected.setFill(Color.WHITESMOKE);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect1.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect1.setAlignment(Pos.BASELINE_RIGHT);
                            vbEasyCorrect.getChildren().add(hbCorrect1);
                            break;
                        case 2:
                            correctOptionSelected.setFill(Color.SKYBLUE);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect2.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect2.setAlignment(Pos.BASELINE_RIGHT);
                            vbEasyCorrect.getChildren().add(hbCorrect2);
                            break;
                        case 3:
                            correctOptionSelected.setFill(Color.MOCCASIN);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect3.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect3.setAlignment(Pos.BASELINE_RIGHT);
                            vbEasyCorrect.getChildren().add(hbCorrect3);
                            break;
                        default:
                            break;
                    }
                    if (i == 3) {       //'i' REACHES 3 WHEN ALL CORRECT OPTIONS ARE CLICKED IN ORDER
                        hbCheckButton.getChildren().add(checkButton);//BUTTON ADDED TO HORIZONTAL BOX
                        hbCheckButton.setAlignment(Pos.CENTER);
                        checkButton.setOnAction(e1 -> checkStage(mistakes));//BUTTON OPENS FINAL STAGE
                    }
                } else {
                    mistakes++;//'mistakes' INCREMENTED WHENEVER INCORRECT OPTION IS SELECTED
                    switch (i) {
                        case 0:
                            incorrectOptionSelected.setFill(Color.WHITESMOKE);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect1.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbEasyIncorrect.getChildren().add(hbIncorrect1);
                            break;
                        case 1:
                            incorrectOptionSelected.setFill(Color.SKYBLUE);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect2.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbEasyIncorrect.getChildren().add(hbIncorrect2);
                            break;
                        case 2:
                            incorrectOptionSelected.setFill(Color.MOCCASIN);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect3.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbEasyIncorrect.getChildren().add(hbIncorrect3);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    public void buttonActionMedium(Button button) {
        button.setOnAction((ActionEvent e) -> {
            if (e.getSource() == button) {
                optionSelected = button.getText().toString();//TEXT FROM SELECTED OPTION BUTTON CASTED TO A STRING
                if (optionSelected.equals(mediumAnswer[i])) {//COMPARING SELECTED OPTION WITH ANSWER IN ARRAY
                    i++;//INCREMENT IN 'i' WHENEVER CORRECT OPTION BUTTON IS PRESSED
                    switch (i) {
                        case 1:
                            correctOptionSelected.setFill(Color.WHITESMOKE);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect1.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect1.setAlignment(Pos.BASELINE_RIGHT);
                            vbMediumCorrect.getChildren().add(hbCorrect1);
                            break;
                        case 2:
                            correctOptionSelected.setFill(Color.SKYBLUE);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect2.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect2.setAlignment(Pos.BASELINE_RIGHT);
                            vbMediumCorrect.getChildren().add(hbCorrect2);
                            break;
                        case 3:
                            correctOptionSelected.setFill(Color.MOCCASIN);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect3.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect3.setAlignment(Pos.BASELINE_RIGHT);
                            vbMediumCorrect.getChildren().add(hbCorrect3);
                            break;
                        case 4:
                            correctOptionSelected.setFill(Color.TURQUOISE);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect4.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect4.setAlignment(Pos.BASELINE_RIGHT);
                            vbMediumCorrect.getChildren().add(hbCorrect4);
                            break;
                        case 5:
                            correctOptionSelected.setFill(Color.PAPAYAWHIP);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect5.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect5.setAlignment(Pos.BASELINE_RIGHT);
                            vbMediumCorrect.getChildren().add(hbCorrect5);
                            break;
                        case 6:
                            correctOptionSelected.setFill(Color.PALEGREEN);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect6.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect6.setAlignment(Pos.BASELINE_RIGHT);
                            vbMediumCorrect.getChildren().add(hbCorrect6);
                            break;
                        default:
                            break;
                    }
                    if (i == 6) {//'i' REACHES 6 WHEN ALL CORRECT OPTIONS ARE CLICKED IN ORDER
                        hbCheckButton.getChildren().add(checkButton);//BUTTON ADDED TO HORIZONTAL BOX
                        hbCheckButton.setAlignment(Pos.CENTER);
                        checkButton.setOnAction(e1 -> checkStage(mistakes));//BUTTON OPENS FINAL STAGE
                    }
                } else {
                    mistakes++;//'mistakes' INCREMENTED WHENEVER INCORRECT OPTION IS SELECTED
                    switch (i) {
                        case 0:
                            incorrectOptionSelected.setFill(Color.WHITESMOKE);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect1.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbMediumIncorrect.getChildren().add(hbIncorrect1);
                            break;
                        case 1:
                            incorrectOptionSelected.setFill(Color.SKYBLUE);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect2.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbMediumIncorrect.getChildren().add(hbIncorrect2);
                            break;
                        case 2:
                            incorrectOptionSelected.setFill(Color.MOCCASIN);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect3.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbMediumIncorrect.getChildren().add(hbIncorrect3);
                            break;
                        case 3:
                            incorrectOptionSelected.setFill(Color.TURQUOISE);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect4.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbMediumIncorrect.getChildren().add(hbIncorrect4);
                            break;
                        case 4:
                            incorrectOptionSelected.setFill(Color.PAPAYAWHIP);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect5.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbMediumIncorrect.getChildren().add(hbIncorrect5);
                            break;
                        case 5:
                            incorrectOptionSelected.setFill(Color.PALEGREEN);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect6.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbMediumIncorrect.getChildren().add(hbIncorrect6);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    public void buttonActionHard(Button button) {
        button.setOnAction((ActionEvent e) -> {
            if (e.getSource() == button) {
                optionSelected = button.getText().toString();//TEXT FROM SELECTED OPTION BUTTON CASTED TO A STRING
                if (optionSelected.equals(hardAnswer[i])) {//COMPARING SELECTED OPTION WITH ANSWER IN ARRAY
                    i++;//INCREMENT IN 'i' WHENEVER CORRECT OPTION BUTTON IS PRESSED
                    switch (i) {
                        case 1:
                            correctOptionSelected.setFill(Color.WHITESMOKE);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect1.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect1.setAlignment(Pos.BASELINE_RIGHT);
                            vbHardCorrect.getChildren().add(hbCorrect1);
                            break;
                        case 2:
                            correctOptionSelected.setFill(Color.PALEGREEN);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect2.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect2.setAlignment(Pos.BASELINE_RIGHT);
                            vbHardCorrect.getChildren().add(hbCorrect2);
                            break;
                        case 3:
                            correctOptionSelected.setFill(Color.MOCCASIN);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect3.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect3.setAlignment(Pos.BASELINE_RIGHT);
                            vbHardCorrect.getChildren().add(hbCorrect3);
                            break;
                        case 4:
                            correctOptionSelected.setFill(Color.TURQUOISE);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect4.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect4.setAlignment(Pos.BASELINE_RIGHT);
                            vbHardCorrect.getChildren().add(hbCorrect4);
                            break;
                        case 5:
                            correctOptionSelected.setFill(Color.WHITESMOKE);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect5.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect5.setAlignment(Pos.BASELINE_RIGHT);
                            vbHardCorrect.getChildren().add(hbCorrect5);
                            break;
                        case 6:
                            correctOptionSelected.setFill(Color.PALEGREEN);
                            correctOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbCorrect6.getChildren().add(correctOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            hbCorrect6.setAlignment(Pos.BASELINE_RIGHT);
                            vbHardCorrect.getChildren().add(hbCorrect6);
                            break;
                        default:
                            break;
                    }
                    if (i == 6) {//'i' REACHES 6 WHEN ALL CORRECT OPTIONS ARE CLICKED IN ORDER
                        hbCheckButton.getChildren().add(checkButton);//BUTTON ADDED TO HORIZONTAL BOX
                        hbCheckButton.setAlignment(Pos.CENTER);
                        checkButton.setOnAction(e1 -> checkStage(mistakes));//BUTTON OPENS FINAL STAGE
                    }
                } else {
                    mistakes++;
                    switch (i) {
                        case 0:
                            incorrectOptionSelected.setFill(Color.WHITESMOKE);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect1.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbHardIncorrect.getChildren().add(hbIncorrect1);
                            break;
                        case 1:
                            incorrectOptionSelected.setFill(Color.SKYBLUE);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect2.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbHardIncorrect.getChildren().add(hbIncorrect2);
                            break;
                        case 2:
                            incorrectOptionSelected.setFill(Color.MOCCASIN);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect3.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbHardIncorrect.getChildren().add(hbIncorrect3);
                            break;
                        case 3:
                            incorrectOptionSelected.setFill(Color.TURQUOISE);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect4.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbHardIncorrect.getChildren().add(hbIncorrect4);
                            break;
                        case 4:
                            incorrectOptionSelected.setFill(Color.PAPAYAWHIP);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect5.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbHardIncorrect.getChildren().add(hbIncorrect5);
                            break;
                        case 5:
                            incorrectOptionSelected.setFill(Color.PALEGREEN);
                            incorrectOptionSelected.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
                            hbIncorrect6.getChildren().add(incorrectOptionSelected);//MESSAGE ADDED TO HORIZONTAL BOX
                            vbHardIncorrect.getChildren().add(hbIncorrect6);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    public String grade(int num) {
        switch (num) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            default:
                return "F";
        }
    }

    public void FileCreator() {
        try {
            File file = new File("C:\\Users\\HP\\Desktop\\file.txt");   //NEW FILE OBJECT
            if (file.createNewFile()) {
                System.out.println("File " + file.getName() + " created");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void FileWriter() {
        try {
            try (FileWriter fileWriter = new FileWriter("C:\\Users\\HP\\Desktop\\file.txt", true)) {//FILEWRITER OBJECT CREATED
                username = usernameOutput.getText().toString();//'usernameOutput' CONVERTED TO STRING AND STORED IN 'username'
                if (username.length() > 7) {
                    for (int iteration = 0; iteration < 7; iteration++) {
                        //FIRST SEVEN CHARACTERS OF ENTERED USERNAME APPENDED IN 'usernameMax7' USING STRINGBUILDER 'sevenLetterUsername'
                        sevenLetterUsername.append(usernameMax7).append(username.charAt(iteration));
                    }
                    fileWriter.write(sevenLetterUsername
                            + "\t"
                            + finalGrade
                            + "\t"
                            + levelName
                            + "\n");
                } else {
                    fileWriter.write(username
                            + "\t"
                            + finalGrade
                            + "\t"
                            + levelName
                            + "\n");
                }

            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void FileOpener() {
        try {
            File file = new File("C:\\Users\\HP\\Desktop\\file.txt");//FILE OBJECT CREATED 
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();//DESKTOP OBJECT CREATED
                if (file.exists()) {
                    desktop.open(file);//OPENS TEXT FILE
                }
            } else {
                System.out.println("FILE NOT FOUND");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
