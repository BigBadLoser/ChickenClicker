import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.concurrent.Task;
import javafx.scene.image.*;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import java.util.*;
import javafx.beans.*;
import javafx.animation.*;
import javafx.util.Duration;
import java.lang.*;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import java.math.*;
import java.text.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class chickenClicker extends Application {
//Feather related variables
long feathers = 0;
long feathersPerSecond = 0;
long feathersPerClick  = 1;
//Farm hand varibales
long farmHandIncome = 0;
double farmHandCost = 15;
long amountOfFarmhands = 0;
long farmhandIncomeRate = 1;

//Rooster variables
long roosterIncome = 0;
double roosterCost = 100;
long amountOfRoosters = 0;
long roosterIncomeRate = 2;

//Henhouse variables
long henHouseIncome = 0;
double henHouseCost = 500;
long amountOfHenHouses = 0;
long henHouseIncomeRate = 4;

//Farm variables
long farmIncome = 0;
double farmCost = 3000;
long amountOfFarms = 0;
long farmIncomeRate = 10;

//Factory variables
long factoryIncome = 0;
double factoryCost = 10000;
long amountOfFactories = 0;
long factoryIncomeRate = 40;

//Distrubtion Center variables
long distributionCenterIncome = 0;
double distributionCenterCost = 40000;
long amountOfDistributionCenters = 0;
long distributionCenterIncomeRate = 100;

//Rocket variables
long rocketIncome = 0;
double rocketCost = 200000;
long amountOfRockets = 0;
long rocketIncomeRate = 400;

//Portal variables
long portalIncome = 0;
double portalCost = 1666666;
long amountOfPortals = 0;
long portalIncomeRate = 6666;

//Time Machine variables
long timeMachineIncome = 0;
double timeMachineCost = 123456789L;
long amountOfTimeMachines = 0;
long timeMachineIncomeRate = 98765;

//Matter Condenser
long matterCondenserIncome = 0;
long matterCondenserCost = 3999999999L;
long amountOfMatterCondensers = 0;
long matterCondenserIncomeRate = 999999L;

//Feather Prism variables
long featherPrismIncome = 0;
long featherPrismCost = 75000000000L;
long amountOfFeatherPrisms = 0;
long featherPrismIncomeRate = 10000000L;

//Feather Temple variables
long featherTempleIncome = 0;
long featherTempleCost = 100000000000L;
long amountOfFeatherTemples = 0;
long featherTempleIncomeRate = 100000000L;


//Random
Random rand = new Random();
int r = rand.nextInt(300);

   public void start(Stage primaryStage) throws Exception {
      Timer timer = new Timer();
      timer.schedule(new doMeEverySecond(), 0, 1000);
   
      primaryStage.setTitle("Chicken Clicker by Trey Gaulin");// Sets the title of the stage.
      Label label1 = new Label("Feathers: " + 0);//Creates a new label called label1 to keep track of the player's feathers. This should have a better name
      label1.setFont(new Font("'Roboto'", 12.5));
      Label feathersPerSecondLabel = new Label("Feathers Per Second: " + feathersPerSecond); //Creates a label called feathersPerSecondLabel to show the player his income per second
      feathersPerSecondLabel.setFont(new Font("Roboto", 12.5));
      
      //ImageView chicken = new ImageView(new Image("/resources/images/chicken.jpg"));
      
      
      /* This sets a tutorial alert, but I'm not quite happy with how this looks atm, so it's disabled.
      Alert alert = new Alert(AlertType.INFORMATION, "content text");
      alert.getDialogPane().getChildren().stream().filter(node -> node instanceof Label).forEach(node -> ((Label)node).setMinHeight(Region.USE_PREF_SIZE));
      alert.setHeaderText("Chicken Clicker Information");
      alert.setContentText("Welcome to Chicken Clicker, by Trey Gaulin. \n Test 123");
      alert.setTitle("Chicken Clicker");
      alert.showAndWait();
      */
      
//-- MAIN BUTTON START --
      Label actionsLabel = new Label("Actions");
      HBox actionsTitle = new HBox(actionsLabel);
      actionsTitle.setAlignment(Pos.TOP_CENTER);
      actionsTitle.getStyleClass().add("actionsLabel");
      actionsLabel.getStyleClass().add("shopLabel");
      
      Button mainButton = new Button("Click me to get feathers");
      mainButton.setMaxWidth(300);
      mainButton.setPrefHeight(100);
      mainButton.getStyleClass().add("mainButton");
      Button testButton = new Button("lorem ipsum dorem kaltor zezima");
      testButton.setMaxWidth(300);
      mainButton.setOnAction((e) -> {

            feathers += feathersPerClick;
            label1.setText("Feathers: " + feathers);
      });
//-- MAIN BUTTON END --     

      
      VBox leftBox = new VBox(mainButton, testButton); 
      leftBox.setPrefHeight(645);
      leftBox.getStyleClass().add("actionsBox");
      VBox leftSide = new VBox(actionsTitle, leftBox);
      leftSide.setPrefWidth(300);

//--SHOP VBOX START --
NumberFormat nf = new DecimalFormat("##.###");
      
//Shop Buttons
      //Button 1, farmhands
      Button shopButton1 = new Button();
      Label shopButton1Label1 = new Label("Farmhand \n" + nf.format(farmHandCost) + " feathers");
      Label shopButton1Label2 = new Label("" + amountOfFarmhands);
      shopButton1Label2.getStyleClass().add("itemQuantity");
      shopButton1Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton1Label1, Priority.ALWAYS);
      HBox shopButton1HBox = new HBox(shopButton1Label1, shopButton1Label2);
      shopButton1.setGraphic(shopButton1HBox);
      shopButton1.setPrefWidth(300);
      shopButton1Label1.getStyleClass().add("shopButton");
      shopButton1.setPrefHeight(45);
      shopButton1.getStyleClass().add("shopButtonContainer");

      shopButton1.setOnAction((e) -> {
         if (feathers >= farmHandCost){
            feathers -= farmHandCost;
            amountOfFarmhands++;
            farmHandCost = Math.round(15 * Math.pow(1.15,amountOfFarmhands));
            farmHandIncome += farmhandIncomeRate;
            shopButton1Label1.setText("Farmhand \n" + nf.format(farmHandCost) + " feathers");
            shopButton1Label2.setText("" + amountOfFarmhands);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
      Button shopToolTip1 = new Button("An extra farmhand to help out around the farm. \nIncreases your FPS by 1");
      shopToolTip1.setPrefWidth(300);
      shopToolTip1.setPrefHeight(45);
      //shopToolTip1.getStyleClass().add("testClass");
      shopToolTip1.setVisible(false);
      shopButton1.setOnMouseEntered((e) -> {
         shopToolTip1.setVisible(true);
         shopToolTip1.setLayoutX(690 - 300);
         shopToolTip1.setLayoutY(209);
         
      });
      shopButton1.setOnMouseExited((e) -> {
         shopToolTip1.setVisible(false);
      });

      
      
      //Button 2      
      Button shopButton2 = new Button();
      Label shopButton2Label1 = new Label("Rooster \n" + nf.format(roosterCost) + " feathers");
      Label shopButton2Label2 = new Label("" + amountOfFarmhands);
      shopButton2Label2.getStyleClass().add("itemQuantity");
      shopButton2Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton2Label1, Priority.ALWAYS);
      HBox shopButton2HBox = new HBox(shopButton2Label1, shopButton2Label2);
      shopButton2.setGraphic(shopButton2HBox);
      shopButton2.setPrefWidth(300);
      shopButton2Label1.getStyleClass().add("shopButton");
            
      
      shopButton2.setOnAction((e) -> {
         if (feathers >= roosterCost){
            feathers -= roosterCost;
            amountOfRoosters++;
            roosterCost = Math.round(100 * Math.pow(1.15,amountOfRoosters));
            roosterIncome += roosterIncomeRate;
            shopButton2Label1.setText("Rooster \n" + nf.format(roosterCost) + " feathers");
            shopButton2Label2.setText("" + amountOfRoosters);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
         
      //Do something here...
      });
      
      Button shopToolTip2 = new Button("An extra Hen House to help out around the farm. \nIncreases your FPS by 4");
      shopToolTip2.setPrefWidth(300);
      shopToolTip2.setPrefHeight(45);
      shopToolTip2.setVisible(false);
      shopButton2.setOnMouseEntered((e) -> {
         shopToolTip2.setVisible(true);
         shopToolTip2.setLayoutX(690 - 300);
         shopToolTip2.setLayoutY(254);
         
      });
      shopButton2.setOnMouseExited((e) -> {
         shopToolTip2.setVisible(false);
      });

      //Button 3      
      Button shopButton3 = new Button();
      Label shopButton3Label1 = new Label("??? \n" + nf.format(henHouseCost) + " feathers");
      Label shopButton3Label2 = new Label("" + amountOfHenHouses);
      shopButton3Label2.getStyleClass().add("itemQuantity");
      shopButton3Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton3Label1, Priority.ALWAYS);
      HBox shopButton3HBox = new HBox(shopButton3Label1, shopButton3Label2);
      shopButton3.setGraphic(shopButton3HBox);
      shopButton3.setPrefWidth(300);
      shopButton3Label1.getStyleClass().add("shopButton");
            
      shopButton3.setOnAction((e) -> {
         if (feathers >= henHouseCost){
            feathers -= henHouseCost;
            amountOfHenHouses++;
            henHouseCost = Math.round(1000 * Math.pow(1.15,amountOfHenHouses));
            henHouseIncome += henHouseIncomeRate;
            shopButton3Label1.setText("Hen House \n" + nf.format(henHouseCost) + " feathers");
            shopButton3Label2.setText("" + amountOfHenHouses);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
      Button shopToolTip3 = new Button("An extra Rooster to help out around the farm. \nIncreases your FPS by 2");
      shopToolTip3.setPrefWidth(300);
      shopToolTip3.setPrefHeight(45);
      shopToolTip3.setVisible(false);
      shopButton3.setOnMouseEntered((e) -> {
         shopToolTip3.setVisible(true);
         shopToolTip3.setLayoutX(690 - 300);
         shopToolTip3.setLayoutY(299);
         
      });
      shopButton3.setOnMouseExited((e) -> {
         shopToolTip3.setVisible(false);
      });

      
      //Button 4
      Button shopButton4 = new Button();
      Label shopButton4Label1 = new Label("??? \n" + nf.format(farmCost) + " feathers");
      Label shopButton4Label2 = new Label("" + amountOfFarms);
      shopButton4Label2.getStyleClass().add("itemQuantity");
      shopButton4Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton4Label1, Priority.ALWAYS);
      HBox shopButton4HBox = new HBox(shopButton4Label1, shopButton4Label2);
      shopButton4.setGraphic(shopButton4HBox);
      shopButton4.setPrefWidth(300);
      shopButton4Label1.getStyleClass().add("shopButton");
            
      shopButton4.setOnAction((e) -> {
         if (feathers >= farmCost){
            feathers -= farmCost;
            amountOfFarms++;
            farmCost = Math.round(10000 * Math.pow(1.15,amountOfFarms));
            farmIncome += farmIncomeRate;
            shopButton4Label1.setText("Farm \n" + nf.format(factoryCost) + " feathers");
            shopButton4Label2.setText("" + amountOfFarms);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
      //Button 5
      Button shopButton5 = new Button();
      Label shopButton5Label1 = new Label("??? \n" + nf.format(factoryCost) + " feathers");
      Label shopButton5Label2 = new Label("" + amountOfFactories);
      shopButton5Label2.getStyleClass().add("itemQuantity");
      shopButton5Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton5Label1, Priority.ALWAYS);
      HBox shopButton5HBox = new HBox(shopButton5Label1, shopButton5Label2);
      shopButton5.setGraphic(shopButton5HBox);
      shopButton5.setPrefWidth(300);
      shopButton5Label1.getStyleClass().add("shopButton");
      
      shopButton5.setOnAction((e) -> {
         if (feathers >= factoryCost){
            feathers -= factoryCost;
            amountOfFactories++;
            factoryCost = Math.round(25000 * Math.pow(1.15,amountOfFactories));
            factoryIncome += factoryIncomeRate;
            shopButton5Label1.setText("Factory \n" + nf.format(factoryCost) + " feathers");
            shopButton5Label2.setText("" + amountOfFactories);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      //Distribution Center Button
      Button shopButton6 = new Button();
      Label shopButton6Label1 = new Label("??? \n" + nf.format(distributionCenterCost) + " feathers");
      Label shopButton6Label2 = new Label("" + amountOfDistributionCenters);
      shopButton6Label2.getStyleClass().add("itemQuantity");
      shopButton6Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton6Label1, Priority.ALWAYS);
      HBox shopButton6HBox = new HBox(shopButton6Label1, shopButton6Label2);
      shopButton6.setGraphic(shopButton6HBox);
      shopButton6.setPrefWidth(300);
      shopButton6Label1.getStyleClass().add("shopButton");
      
      shopButton6.setOnAction((e) -> {
         if (feathers >= distributionCenterCost){
            feathers -= distributionCenterCost;
            amountOfDistributionCenters++;
            distributionCenterCost = Math.round(50000 * Math.pow(1.15,amountOfDistributionCenters));
            distributionCenterIncome += distributionCenterIncomeRate;
            shopButton6Label1.setText("Distribution Center \n" + nf.format(distributionCenterCost) + " feathers");
            shopButton6Label2.setText("" + amountOfDistributionCenters);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
      //Shop Button 7, Rockets!
      Button shopButton7 = new Button();
      Label shopButton7Label1 = new Label("??? \n" + nf.format(rocketCost) + " feathers");
      Label shopButton7Label2 = new Label("" + amountOfRockets);
      shopButton7Label2.getStyleClass().add("itemQuantity");
      shopButton7Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton7Label1, Priority.ALWAYS);
      HBox shopButton7HBox = new HBox(shopButton7Label1, shopButton7Label2);
      shopButton7.setGraphic(shopButton7HBox);
      shopButton7.setPrefWidth(300);
      shopButton7Label1.getStyleClass().add("shopButton");
      
      shopButton7.setOnAction((e) -> {
         if (feathers >= rocketCost){
            feathers -= rocketCost;
            amountOfRockets++;
            rocketCost = Math.round(50000 * Math.pow(1.15,amountOfRockets));
            rocketIncome += rocketIncomeRate;
            shopButton7Label1.setText("Rocket \n" + nf.format(rocketCost) + " feathers");
            shopButton7Label2.setText("" + amountOfRockets);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
      //Shop Button 8, Portals!
      Button shopButton8 = new Button();
      Label shopButton8Label1 = new Label("??? \n" + nf.format(portalCost) + " feathers");
      Label shopButton8Label2 = new Label("" + amountOfPortals);
      shopButton8Label2.getStyleClass().add("itemQuantity");
      shopButton8Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton8Label1, Priority.ALWAYS);
      HBox shopButton8HBox = new HBox(shopButton8Label1, shopButton8Label2);
      shopButton8.setGraphic(shopButton8HBox);
      shopButton8.setPrefWidth(300);
      shopButton8Label1.getStyleClass().add("shopButton");
      
      shopButton8.setOnAction((e) -> {
         if (feathers >= portalCost){
            feathers -= portalCost;
            amountOfPortals++;
            portalCost = Math.round(50000 * Math.pow(1.15,amountOfPortals));
            portalIncome += portalIncomeRate;
            shopButton8Label1.setText("Portal \n" + nf.format(portalCost) + " feathers");
            shopButton8Label2.setText("" + amountOfPortals);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
      //Shop Button 9, Time Machine!
      Button shopButton9 = new Button();
      Label shopButton9Label1 = new Label("??? \n" + nf.format(timeMachineCost) + " feathers");
      Label shopButton9Label2 = new Label("" + amountOfTimeMachines);
      shopButton9Label2.getStyleClass().add("itemQuantity");
      shopButton9Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton9Label1, Priority.ALWAYS);
      HBox shopButton9HBox = new HBox(shopButton9Label1, shopButton9Label2);
      shopButton9.setGraphic(shopButton9HBox);
      shopButton9.setPrefWidth(300);
      shopButton9Label1.getStyleClass().add("shopButton");
      
      shopButton9.setOnAction((e) -> {
         if (feathers >= timeMachineCost){
            feathers -= timeMachineCost;
            amountOfTimeMachines++;
            timeMachineCost = Math.round(50000 * Math.pow(1.15,amountOfTimeMachines));
            timeMachineIncome += timeMachineIncomeRate;
            shopButton9Label1.setText("Time Machine \n" + timeMachineCost + " feathers");
            shopButton9Label2.setText("" + amountOfTimeMachines);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
      //Shop Button 10, Matter Condenser!
      Button shopButton10 = new Button();
      Label shopButton10Label1 = new Label("??? \n" + matterCondenserCost + " feathers");
      Label shopButton10Label2 = new Label("" + amountOfMatterCondensers);
      shopButton10Label2.getStyleClass().add("itemQuantity");
      shopButton10Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton10Label1, Priority.ALWAYS);
      HBox shopButton10HBox = new HBox(shopButton10Label1, shopButton10Label2);
      shopButton10.setGraphic(shopButton10HBox);
      shopButton10.setPrefWidth(300);
      shopButton10Label1.getStyleClass().add("shopButton");
      
      shopButton10.setOnAction((e) -> {
         if (feathers >= matterCondenserCost){
            feathers -= matterCondenserCost;
            amountOfMatterCondensers++;
            matterCondenserCost = Math.round(50000 * Math.pow(1.15,amountOfMatterCondensers));
            matterCondenserIncome += matterCondenserIncomeRate;
            shopButton10Label1.setText("Matter Condenser \n" + matterCondenserCost + " feathers");
            shopButton10Label2.setText("" + amountOfMatterCondensers);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
      //Shop Button 11, Feather Prism!
      Button shopButton11 = new Button();
      Label shopButton11Label1 = new Label("??? \n" + featherPrismCost + " feathers");
      Label shopButton11Label2 = new Label("" + amountOfFeatherPrisms);
      shopButton11Label2.getStyleClass().add("itemQuantity");
      shopButton11Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton11Label1, Priority.ALWAYS);
      HBox shopButton11HBox = new HBox(shopButton11Label1, shopButton11Label2);
      shopButton11.setGraphic(shopButton11HBox);
      shopButton11.setPrefWidth(300);
      shopButton11Label1.getStyleClass().add("shopButton");
      
      shopButton11.setOnAction((e) -> {
         if (feathers >= featherPrismCost){
            feathers -= featherPrismCost;
            amountOfFeatherPrisms++;
            featherPrismCost = Math.round(50000 * Math.pow(1.15,amountOfFeatherPrisms));
            featherPrismIncome += featherPrismIncomeRate;
            shopButton11Label1.setText("Feather Prism \n" + featherPrismCost + " feathers");
            shopButton11Label2.setText("" + amountOfFeatherPrisms);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      
     //Shop Button 12, Feather Temple!
      Button shopButton12 = new Button();
      Label shopButton12Label1 = new Label("??? \n" + featherTempleCost + " feathers");
      Label shopButton12Label2 = new Label("" + amountOfFeatherTemples);
      shopButton12Label2.getStyleClass().add("itemQuantity");
      shopButton12Label1.setMaxWidth(Long.MAX_VALUE);
      HBox.setHgrow(shopButton12Label1, Priority.ALWAYS);
      HBox shopButton12HBox = new HBox(shopButton12Label1, shopButton12Label2);
      shopButton12.setGraphic(shopButton12HBox);
      shopButton12.setPrefWidth(300);
      shopButton12Label1.getStyleClass().add("shopButton");
      
      shopButton12.setOnAction((e) -> {
         if (feathers >= featherTempleCost){
            feathers -= featherTempleCost;
            amountOfFeatherTemples++;
            featherTempleCost = Math.round(50000 * Math.pow(1.15,amountOfFeatherTemples));
            featherTempleIncome += featherTempleIncomeRate;
            shopButton12Label1.setText("Feather Temple \n" + featherTempleCost + " feathers");
            shopButton12Label2.setText("" + amountOfFeatherTemples);
            feathersPerSecondLabel.setText("Feathers Per Second: " + feathersPerSecond);
         }
         updateIncome();
      //Do something here...
      });
      Label shopLabel = new Label("Shop");
      HBox shopTitle = new HBox(shopLabel);
      shopTitle.setAlignment(Pos.TOP_CENTER);
      shopTitle.getStyleClass().add("titleBox");
      shopLabel.getStyleClass().add("shopLabel");
      
      VBox shopBox = new VBox(shopButton1, shopButton2, shopButton3, shopButton4, shopButton5,shopButton6, shopButton7, shopButton8, shopButton10, shopButton11, shopButton12);
      VBox shopVBox = new VBox(shopTitle, shopBox);
      shopVBox.setPadding(new Insets(10, 0, 0, 0));
      shopBox.getStyleClass().add("shopBox");
      shopVBox.setPrefWidth(300);
    
      
      
     
      
//--SHOP VBOX END --

//--UPGRADE HBOX START --
   //Upgrade Label
      
      Label upgradesLabel = new Label("Upgrades");
      HBox upgradesTitle = new HBox(upgradesLabel);
      upgradesTitle.setAlignment(Pos.TOP_CENTER);
      upgradesTitle.getStyleClass().add("titleBox");
      upgradesLabel.getStyleClass().add("upgradesLabel");
   //Button 1, farmHand upgrades
      Button upgradeButton1 = new Button("1");
      upgradeButton1.setPrefWidth(50);
      upgradeButton1.setPrefHeight(50);
      //on click ->
      upgradeButton1.setOnAction((e) -> {
         farmHandIncome = farmHandIncome * 2;
         feathersPerClick *=2;
         farmhandIncomeRate = farmhandIncomeRate * 2;
         updateIncome();
      });
      Button upgradeToolTip1 = new Button("Increases your Farmhand efficiency by 2! \nDoubles the amount of feathers you get per click!");
      upgradeToolTip1.setPrefWidth(300);
      upgradeToolTip1.setPrefHeight(50);
      //shopToolTip1.getStyleClass().add("testClass");
      upgradeToolTip1.setVisible(false);
      upgradeButton1.setOnMouseEntered((e) -> {
         upgradeToolTip1.setVisible(true);
         upgradeToolTip1.setLayoutX(690 - 300);
         upgradeToolTip1.setLayoutY(75);
         
      });
      upgradeButton1.setOnMouseExited((e) -> {
         upgradeToolTip1.setVisible(false);
      });
      
   //Button 2
      Button upgradeButton2 = new Button("2");
      upgradeButton2.setStyle("-fx-padding: 0;");
      upgradeButton2.setPrefWidth(50);
      upgradeButton2.setPrefHeight(50);
   //Button 3      
      Button upgradeButton3 = new Button("3");
      upgradeButton3.setStyle("-fx-padding: 0;");
      upgradeButton3.setPrefWidth(50);
      upgradeButton3.setPrefHeight(50);
   //Button 4      
      Button upgradeButton4 = new Button("4");
      upgradeButton4.setStyle("-fx-padding: 0;");
      upgradeButton4.setPrefWidth(50);
      upgradeButton4.setPrefHeight(50);
   //Button 5      
      Button upgradeButton5 = new Button("5");
      upgradeButton5.setStyle("-fx-padding: 0;");
      upgradeButton5.setPrefWidth(50);
      upgradeButton5.setPrefHeight(50);
   //Button 6      
      Button upgradeButton6 = new Button("6");
      upgradeButton6.setStyle("-fx-padding: 0;");
      upgradeButton6.setPrefWidth(50);
      upgradeButton6.setPrefHeight(50);
      
      
      HBox upgradeHBox1 = new HBox(upgradeButton1, upgradeButton2, upgradeButton3, upgradeButton4, upgradeButton5, upgradeButton6); //creates a HBox for the first row of the upgrades
      upgradeHBox1.getStyleClass().add("upgradeBox");
     
      upgradeHBox1.setPrefWidth(300);
      
    //Button 7
      Button upgradeButton7 = new Button("7");
      upgradeButton7.setPrefWidth(50);
      upgradeButton7.setPrefHeight(50);
      
   //Button 8
      Button upgradeButton8 = new Button("8");
      upgradeButton8.setStyle("-fx-padding: 0;");
      upgradeButton8.setPrefWidth(50);
      upgradeButton8.setPrefHeight(50);
   //Button 9  
      Button upgradeButton9 = new Button("9");
      upgradeButton9.setStyle("-fx-padding: 0;");
      upgradeButton9.setPrefWidth(50);
      upgradeButton9.setPrefHeight(50);
   //Button 10     
      Button upgradeButton10 = new Button("10");
      upgradeButton10.setStyle("-fx-padding: 0;");
      upgradeButton10.setPrefWidth(50);
      upgradeButton10.setPrefHeight(50);
   //Button 11     
      Button upgradeButton11 = new Button("11");
      upgradeButton11.setStyle("-fx-padding: 0;");
      upgradeButton11.setPrefWidth(50);
      upgradeButton11.setPrefHeight(50);
   //Button 12   
      Button upgradeButton12 = new Button("12");
      upgradeButton12.setStyle("-fx-padding: 0;");
      upgradeButton12.setPrefWidth(50);
      upgradeButton12.setPrefHeight(50);
      HBox upgradeHBox2 = new HBox(upgradeButton7, upgradeButton8, upgradeButton9, upgradeButton10, upgradeButton11, upgradeButton12); //creates a 2nd HBox for the 2nd row of upgrades
      upgradeHBox2.getStyleClass().add("upgradeBox");
      upgradeHBox2.setPrefWidth(300);
//--UPGRADE HBOX END --
//-- BORDER PANE PANE START --  
      BorderPane borderPane = new BorderPane(); //creates a new borderpane layout
      borderPane.setLeft(leftSide);
     
      VBox rightSide = new VBox(upgradesTitle, upgradeHBox1, upgradeHBox2, shopVBox);
      borderPane.setRight(rightSide);
      
//-- CENTER BOX START --
      Label statsLabel = new Label("Statistics");
      HBox statsTitle = new HBox(statsLabel);
      statsTitle.setAlignment(Pos.TOP_CENTER);
      statsTitle.getStyleClass().add("titleBox");
      statsLabel.getStyleClass().add("statsLabel");
      
      Label feathersPerSecondBreakdown = new Label("Feathers per Second Breakdown: ");
      feathersPerSecondBreakdown.getStyleClass().add("fpsB");
      feathersPerSecondBreakdown.setAlignment(Pos.CENTER);
      Label farmHandStats = new Label("Farmhand: \t" + farmHandIncome);
      farmHandStats.getStyleClass().add("statsContent");
      Label roosterStats = new Label("Rooster: \t" + roosterIncome);
      roosterStats.getStyleClass().add("statsContent");
      VBox statsBox = new VBox(feathersPerSecondBreakdown, farmHandStats, roosterStats);
      statsBox.setPrefHeight(645);
      statsBox.getStyleClass().add("statsBox");
      
            
      
      
      VBox centerBox = new VBox(statsTitle, statsBox);
      centerBox.setPadding(new Insets(10, 0, 10, 0));
      
      
      centerBox.setMinSize(380,720);
      borderPane.setCenter(centerBox);
      rightSide.setPadding(new Insets(10, 10, 10, 10));
      leftSide.setPadding(new Insets(10, 10, 10, 10));
     
//-- BORDER PANE END   

Timeline updateLabels = new Timeline(new KeyFrame(Duration.seconds(.1), new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
      //Updates the feather text ever .1 seconds.
        label1.setText("Feathers: " + feathers);
        feathersPerSecondLabel.setText("Feathers Per Second: "  + feathersPerSecond);
        //These if statements disable and enable buttons as the player has enough money for them
        if (feathers < farmHandCost){
                        shopButton1.setDisable(true);
                     }
                     else{
                        shopButton1.setDisable(false);
                     }
        if (feathers < roosterCost){
                        shopButton2.setDisable(true);
                     }
                     else{
                        shopButton2.setDisable(false);
                        
                     }
                        
        if (feathers < henHouseCost){
                        shopButton3.setDisable(true);
                     }
                     else{
                        shopButton3.setDisable(false);
                     }
       if (feathers < farmCost){
                        shopButton4.setDisable(true);
                     }
                     else{
                        shopButton4.setDisable(false);
                     }
       if (feathers < factoryCost){
                        shopButton5.setDisable(true);
                     }
                     else{
                        shopButton5.setDisable(false);
                     }
      if (feathers < distributionCenterCost){
                        shopButton6.setDisable(true);
                     }
                     else{
                        shopButton6.setDisable(false);
                     }
      if (feathers < rocketCost){
                        shopButton7.setDisable(true);
                     }
                     else{
                        shopButton7.setDisable(false);
                     }
      if (feathers < portalCost){
                        shopButton8.setDisable(true);
                     }
                     else{
                        shopButton8.setDisable(false);
                     }
      if (feathers < timeMachineCost){
                        shopButton10.setDisable(true);
                     }
                     else{
                        shopButton10.setDisable(false);
                     }
      if (feathers < featherPrismCost){
                        shopButton11.setDisable(true);
                     }
                     else{
                        shopButton11.setDisable(false);
                     }
     if (feathers < featherTempleCost){
                        shopButton12.setDisable(true);
                     }
                     else{
                        shopButton12.setDisable(false);
                     }


    }
}));
updateLabels.setCycleCount(Timeline.INDEFINITE);
updateLabels.play();




//TESTING      
      
      VBox topLeftStats = new VBox(label1, feathersPerSecondLabel);
      label1.getStyleClass().add("toolBarLabel");
      feathersPerSecondLabel.getStyleClass().add("toolBarLabel");
      topLeftStats.getStyleClass().add("toolBarVBox");
      topLeftStats.setPrefWidth(290);
      //topLeftStats.setPrefHeight(200);
      topLeftStats.setPadding(new Insets(15, 5, 5, 5));
      ToolBar toolBar = new ToolBar(topLeftStats);
      toolBar.getStyleClass().add("toolBar");
      borderPane.setTop(toolBar);
      
      
      //Pane toolTips = new Pane(shopToolTip1, shopToolTip2, shopToolTip3, shopToolTip4, shopToolTip5, shopToolTip6, shopToolTip7, shopToolTip8, shopToolTip9, shopToolTip10, shopToolTip11, shopToolTip1);
      Pane toolTips = new Pane(upgradeToolTip1, shopToolTip1, shopToolTip2, shopToolTip3);
      toolTips.setMouseTransparent(true);
      
      Pane behindPane = new Pane();
      behindPane.setMouseTransparent(true);
      
      
//-- Anything underneath this should be last  
      
      StackPane root = new StackPane(behindPane, borderPane, toolTips);  
      //Group root = new Group(borderPane);//Put every object you want in your scene in this object
      Scene scene = new Scene(root, 1000, 750);
      primaryStage.setScene(scene);
      scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Roboto");
      scene.getStylesheets().add("resources/css/stylesheet.css");  

      primaryStage.show();
      
   //Weird system to get "+1" to come up when you click, works technically
    mainButton.setOnMouseClicked(new EventHandler<MouseEvent>() { //fires when you click the main button
    @Override
    public void handle(MouseEvent event) { // changes the handle of the event
      Label plusOne = new Label("+" + feathersPerClick); //creates a new label with text "+1"
      toolTips.getChildren().add(plusOne); //adds the plusOne object to the toolTips layer (this layer is above all other elements)
      plusOne.getStyleClass().add("plusOne"); //sets the css style
      r = rand.nextInt(300);
      Timeline timeline = new Timeline(); //creates a new timeline named, you guessed it, "timeline"
      timeline.getKeyFrames().addAll(
          new KeyFrame(new Duration(.001), // set end position at 40s
              new KeyValue(plusOne.translateYProperty(), event.getSceneY()),
              new KeyValue(plusOne.translateXProperty(), event.getSceneX() + 10)),
         new KeyFrame(new Duration(2000), // set end position at 40s
              new KeyValue(plusOne.translateYProperty(), -300), //makes it float up
              new KeyValue(plusOne.translateXProperty(), 9 + r))
       );
       
    

timeline.play();
    }
});
    }
    public static void main(String[] args) {
        Application.launch(args);
        
    }
    class doMeEverySecond extends TimerTask{
      public void run(){
         feathers+= feathersPerSecond;
      }
    }
    public void updateIncome(){
      feathersPerSecond = farmHandIncome + roosterIncome + henHouseIncome + farmIncome + factoryIncome + distributionCenterIncome + rocketIncome + portalIncome + timeMachineIncome + matterCondenserIncome + featherPrismIncome + featherTempleIncome;
    }
}