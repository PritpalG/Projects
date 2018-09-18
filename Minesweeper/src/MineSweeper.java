import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;  

// Pritpal Garcha Minesweeper - 2018

public class MineSweeper extends Application implements EventHandler<MouseEvent>{	
		
	
	//Is it first click
	boolean isFirstClick=true;
	
	// Button that will reset game -initialized later on
	SmileButton smile = null;
	
	//Represents the buttons clicked identity
	int GameState, FlagState=0, ClickState=0;
	
	//Keeps track of pressed buttons for win condition
	int buttonsClicked=0;
	
	//Game dimensions and Mines
	int Width=16, Height=16, Mines=40;
	
	//Will hold info on buttons GameState identity
	int[][] playField = new int[Width][Height];     
	
	//Array of buttons
	GameButton GameButtons[][] = new GameButton[Width][Height];
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void handle(MouseEvent event) {
		
	}
	
	@Override                                                
	public void start(Stage primaryStage) throws Exception{ 
		
	  //GUI Setup
		
		//General layout
		BorderPane myBorder = new BorderPane();       
		HBox myHBox = new HBox();
		VBox myVBox = new VBox();
		GridPane myPane = new GridPane();  
		
		//Setting window title
		primaryStage.setTitle("Minesweeper"); 
		
		//MinesLeft and Timer configuration
		Label FlagsLeft = new Label("" + Mines);  
		Label Timer = new Label("000");    
		FlagsLeft.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 45));
		Timer.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 45));
		Timer.setAlignment(Pos.CENTER_RIGHT);        
		Timer.setPadding(new Insets(0,0,0,20));      
		FlagsLeft.setAlignment(Pos.CENTER_LEFT);         
		FlagsLeft.setPadding(new Insets(0,20,0,0));      
		
		//Smile Button
		smile = new SmileButton(GameButtons, smile, playField, Mines,
				buttonsClicked, FlagsLeft, myPane, isFirstClick);
		smile.setOnAction(smile); 
		
		//HBox configuration                                             
		myHBox.setPadding(new Insets(10, 12, 12, 10)); 
		myHBox.setAlignment(Pos.CENTER);                                                      
		myHBox.getChildren().add(FlagsLeft);       
		myHBox.getChildren().add(smile);       
		myHBox.getChildren().add(Timer);
		
		//Setting up menu 
		MenuBar menuBar = new MenuBar();
		Menu Difficulty = new Menu("Options");
	    MenuItem exit = new MenuItem("Exit");
		Difficulty.getItems().add(exit);
		menuBar.getMenus().add(Difficulty);
				
		//VBOX setup
		myVBox.getChildren().add(menuBar);
		myVBox.getChildren().add(myHBox);
		
		//Centering general layout                                             
		myPane.setAlignment(Pos.CENTER);                                                    
		myBorder.setCenter(myPane);                  
		myBorder.setTop(myVBox);   
		
		
		//Initializes the game buttons
		for(int row = 0; row < Width; row++){                                                                                
			for(int col = 0; col < Height; col++){                                                                                                                                                                  
				if (playField[row][col] == 9) {                                                                        
					GameState = 9;                                                                                  
					GameButtons[row][col] = new GameButton(GameState, FlagState, ClickState, row,col, GameButtons,
							playField, buttonsClicked, smile, FlagsLeft, Mines, myPane, isFirstClick);          
					GameButtons[row][col].setOnMouseClicked(GameButtons[row][col]);                                                      
					myPane.add(GameButtons[row][col], row, col); 
					
				}else if(playField[row][col]!=9){                                                                      
					GameState = playField[row][col];                                                                    
					GameButtons[row][col] = new GameButton(GameState, FlagState, ClickState, row,col, GameButtons,
							playField, buttonsClicked, smile, FlagsLeft, Mines, myPane, isFirstClick);          
					GameButtons[row][col].setOnMouseClicked(GameButtons[row][col]);                                                      
					myPane.add(GameButtons[row][col], row, col);  
					
				}else {                                                                                            
					GameState = 0;                                                                                  
					GameButtons[row][col] = new GameButton(GameState, FlagState, ClickState, row, col, GameButtons,
							playField, buttonsClicked, smile, FlagsLeft, Mines, myPane, isFirstClick);          
					GameButtons[row][col].setOnMouseClicked(GameButtons[row][col]);                                                      
					myPane.add(GameButtons[row][col], row, col);                                                               
				}                                                                                                  
						                                                                                                   
			}                                                                                                      
		}
		
		//Completing overall scene
		Scene myScene = new Scene(myBorder);         
		primaryStage.setScene(myScene);              
		primaryStage.show(); 
		
		exit.setOnAction(e -> {
			System.exit(0);
		});
		
	}

	
}

class GameButton extends Button implements EventHandler<MouseEvent>{
	
	//Instance variables
	int buttonsClicked, Mines;
	int GameState, FlagState, ClickState=0,  row, col;
	boolean isFirstClick;
	int[][] playField;
	Label FlagsLeft;
	SmileButton smile;
	GridPane myPane;
	GameButton[][] GameButtons;
	
	//All possible GameState identities 
	ImageView imageCover, oneMine, twoMine, threeMine, fourMine,
	fiveMine, sixMine, sevenMine, eightMine, bomb, redBomb, blank, flag, dead;
	
	//Constructor
	public GameButton(int GameState, int FlagState, int ClickState, int row, int col, GameButton[][] GameButtons, int[][] playField,
			int buttonsClicked, SmileButton smile, Label FlagsLeft, int Mines, GridPane myPane, boolean isFirstClick) {
		
		//Initializing 
		this.smile = smile;
		this.GameState = GameState;
		this.FlagState = FlagState;
		this.isFirstClick = isFirstClick;
		this.row = row;
		this.col = col;
		this.GameButtons = GameButtons;
		this.buttonsClicked = buttonsClicked;
		this.playField = playField;
		double size = 32;
		this.ClickState = ClickState;
		this.FlagsLeft = FlagsLeft;
		this.Mines = Mines;
		this.myPane = myPane;
		
		//Configuring buttons
		prefWidth(size);
		prefHeight(size);
		setPadding(Insets.EMPTY);
		
		//GameState Images
		imageCover = new ImageView(new Image("file:res/cover.png"));
		oneMine = new ImageView(new Image("file:res/1.png"));
		twoMine = new ImageView(new Image("file:res/2.png"));
		threeMine = new ImageView(new Image("file:res/3.png"));
		fourMine = new ImageView(new Image("file:res/4.png"));
		fiveMine = new ImageView(new Image("file:res/5.png"));
		sixMine = new ImageView(new Image("file:res/6.png"));
		sevenMine = new ImageView(new Image("file:res/7.png"));
		eightMine = new ImageView(new Image("file:res/8.png"));
		bomb= new ImageView(new Image("file:res/mine-grey.png"));
		redBomb= new ImageView(new Image("file:res/mine-red.png"));
		blank = new ImageView(new Image("file:res/0.png"));
		dead = new ImageView(new Image("file:res/face-dead.png"));
		
		//FlagState Image
		flag = new ImageView(new Image("file:res/flag.png"));
		
		setGraphic(imageCover);	
		
	}
	
	
	@Override
	public void handle(MouseEvent event) {
		MouseButton button = event.getButton();
		
		//If left click, will handle normally unless there's a flag there
		if(button == MouseButton.PRIMARY) {	
			
			//Checks if game over
			if( (playField[row][col] == 9) && (isFirstClick) ) {
				GameButtons[row][col].setGraphic(redBomb);
				gameOver(GameButtons, smile, playField, row, col);
				smile.setGraphic(dead);
				myPane.setMouseTransparent(true);
				return;
			}
			
			//FirstClick procedure will place mines
			if( (GameButtons[0][0].isFirstClick) ){
				for(int r=0; r<playField.length; r++) {
					for(int c=0; c<playField[0].length; c++) {
						playField[r][c]=0;
						GameButtons[r][c].GameState=0;
					}
				}
				setMines(playField, Mines, row, col);
				HandleClick(row, col);
				GameButtons[0][0].isFirstClick = false;
				return;
			}
			
			//Non-FirstClick procedure
			if((GameButtons[row][col].FlagState == 0) && (GameButtons[row][col].ClickState == 0)){
				HandleClick(row, col);
				return;
			}
			
			//Handles click on clicked tile to open neighbors, may induce a gameOver if user not careful
			if(GameButtons[row][col].ClickState == 1) {
				UserWantsToCheckForMine(row, col);
				return;
			}
			
		//If right click, will toggle flag and decrease amount available
		}else if( (button == MouseButton.SECONDARY) && (GameButtons[row][col].ClickState != 1) ) {
			
			//If there's a flag, remove it
			if(GameButtons[row][col].FlagState == 1) {
				GameButtons[row][col].FlagState = 0;
				GameButtons[row][col].setGraphic(new ImageView(new Image("file:res/cover.png")));
				GameButtons[0][0].Mines++;
				FlagsLeft.setText("" + GameButtons[0][0].Mines);
			}
			
			//If there's no flag, add one
			else if(GameButtons[row][col].FlagState == 0){
				GameButtons[row][col].FlagState = 1;
				GameButtons[row][col].setGraphic(new ImageView(new Image("file:res/flag.png")));
				GameButtons[0][0].Mines--;
				FlagsLeft.setText("" + GameButtons[0][0].Mines);
			}
		}
		
	}


	//Method to recursively open neighbor tiles 
	public void HandleClick( int row, int col) {
		
		//Making sure its in bounds
		if( !(((row >= 0) && (row < playField[0].length)) && ((col >= 0) && (col < playField.length))) ) {
			return;
		}
		
		//Checks if already open
		if(GameButtons[row][col].ClickState == 1) {
			return;
		}
		
		//Check if game won
		gameWon(smile, GameButtons, playField.length, playField[0].length, Mines, myPane);
		
		//Sets Graphic with its appropriate GameState identity 
		if(playField[row][col] < 9)
			GameButtons[row][col].setGraphic(new ImageView(new Image("file:res/" + playField[row][col] + ".png")));
		else if(playField[row][col] == 9)
			gameOver(GameButtons, smile, playField, row, col);
		
		//Changes button to its clicked state
		GameButtons[row][col].ClickState = 1;
		
		//If the uncovered button is blank, try it's neighbors 
		if(playField[row][col] == 0)	{
			HandleClick(row+1,col);
			HandleClick(row-1,col);
			HandleClick(row,col+1);
			HandleClick(row,col-1);
			HandleClick(row+1,col+1);
			HandleClick(row-1,col-1);
			HandleClick(row+1,col-1);
			HandleClick(row-1,col+1);
		}
		
	}
	
	
	//Game over procedure
	public static void gameOver(GameButton[][] GameButtons, SmileButton smile, int[][] playField, int row, int col) {
		
		ImageView redBomb, dead;
		redBomb = new ImageView(new Image("file:res/mine-red.png"));
		dead = new ImageView(new Image("file:res/face-dead.png"));
		smile.setGraphic(dead);
		
		//Reveals all mines if one is clicked on
		for(int r=0; r<playField.length; r++) {
			for(int c=0; c<playField[0].length; c++) {
				if(playField[r][c]==9) {
					GameButtons[r][c].setGraphic(new ImageView(new Image("file:res/mine-grey.png")));
				}
			}
		}
		smile.setGraphic(dead);
		GameButtons[row][col].setGraphic(redBomb);
		
	}
	
	
	//Method for checking if the game has been won
	public void gameWon(SmileButton smile, GameButton[][] GameButtons, int Width, int Height, int Mines, GridPane myPane) {
		
		ImageView smileWin;
		smileWin = new ImageView(new Image("file:res/face-win.png"));
		
		//Calculating the amount of pressed buttons
		int ClickedCount = 1;
		for(int r=0;r<Width;r++) {
			for(int c=0;c<Height;c++) {
				if(GameButtons[r][c].ClickState == 1) {
					ClickedCount++;
				}
			}
		}
		
		//Checking if win condition is met
		int WinCondition = (Width * Height) - Mines;
		if(ClickedCount == WinCondition) {
			smile.setGraphic(smileWin);
			myPane.setMouseTransparent(true);
			for(int r=0;r<Width;r++) {
				for(int c=0;c<Height;c++) {
					if(playField[r][c] == 9) {
						GameButtons[r][c].setGraphic(new ImageView(new Image("file:res/flag.png")));
					}
				}
			}
		}
		
	}
	
	
	//Sets Mines while avoiding setting a mine on neighbor of click location
	public static void setMines(int[][] playField, int Mines, int AvoidRow, int AvoidCol) {  
		
		int GridWidth = playField.length;
		int GridHeight = playField[0].length;
		int minesToBePlaced = Mines; 
		boolean safe;
		Random rand = new Random(); 
		int randX=rand.nextInt(GridWidth), randY=rand.nextInt(GridHeight);                                                                                                                                                      
		
		while(minesToBePlaced > 0) { 
			safe = false;
			
			//Makes sure generated random values are safe for placement
			while(!(safe)){
				randX = rand.nextInt(GridWidth);         
				randY = rand.nextInt(GridHeight);
				if( (randX!=AvoidRow && randX!=AvoidRow-1 && randX!= AvoidRow+1) && (randY!=AvoidCol && randY!=AvoidCol-1 && randY!= AvoidCol+1) ) {
					safe = true;
				}					
			}
			

			// Setting the mine identity to be a mine
			if(playField[randX][randY] == 9) {
				continue;
			}else {
				playField[randX][randY] = 9;   
			}
			

			//Incrementing according to mine placement
			if(playField[randX][randY] == 9) {    
				//Top left corner                                                                                 
				if(randX-1 >= 0 && randY-1 >= 0 && playField[randX-1][randY-1] != 9) {                            
					playField[randX-1][randY-1]++;  
				}                                                                                                 
				//Up                                                                                              
				if(randX-1 >= 0 && playField[randX-1][randY] != 9){                                               
					playField[randX-1][randY]++;                                                              
				} 
				//Top right corner                
				if(randX-1 >= 0 && randY + 1 <= GridHeight-1 && playField[randX-1][randY+1] != 9) {                 
					playField[randX-1][randY+1]++;                                                            
				}                                                                                                 
				//Right                                                                                           
				if(randY+1 <= GridHeight-1 && playField[randX][randY+1] != 9) {                                     
					playField[randX][randY+1]++;                                                              
				}                                                                                                 
				//Bottom right corner                                                                             
				if(randX+1 <= GridWidth-1 && randY+1 <= GridHeight-1 && playField[randX+1][randY+1] != 9) {          
					playField[randX+1][randY+1]++;                                                            
				}                                                                                                 
				//Down                                                                                            
				if(randX+1 <= GridWidth-1 && playField[randX+1][randY] != 9) {                                     
					playField[randX+1][randY]++;                                                              
				}                                                                                                 
				//Bottom left corner                                                                              
				if(randX+1 <= GridWidth-1 && randY-1 >= 0 && playField[randX+1][randY-1] != 9) {                   
					playField[randX+1][randY-1]++;                                                            
				}                                                                                                 
				//Left                                                                                            
				if(randY-1 >= 0 && playField[randX][randY-1] != 9) {                                              
					playField[randX][randY-1]++;                                                              
				}
			}                                                                                                     
			minesToBePlaced--;   
		}
		safe = false;
		
	}
	
	
	public void UserWantsToCheckForMine(int row, int col) {
		if( (GameButtons[row][col].ClickState==1) && (row>0) && (row<GameButtons[0].length-1) 
				&& (col>0) && (col<GameButtons.length-1) ) {
			for(int r=row-1;r<row+2;r++) {
				for(int c=col-1;c<col+2;c++) {
					if(!(GameButtons[r][c].FlagState == 1)) {
						if(!(playField[r][c] == 9)) {
							GameButtons[r][c].setGraphic(new ImageView(new Image("file:res/" + playField[r][c] + ".png")));
							GameButtons[r][c].ClickState = 1;
						}
						else {
							gameOver(GameButtons, smile, playField, r, c);
							smile.setGraphic(dead);
							myPane.setMouseTransparent(true);
						}
					}
				}
			}
		}	
	}
	
	
}



class SmileButton extends Button implements EventHandler<ActionEvent>{
	
	int Mines, buttonsClicked;
	boolean isFirstClick;
	int[][] playField;
	SmileButton smile;
	Label FlagsLeft;
	GridPane myPane;
	GameButton[][] GameButtons;
	
	
	public SmileButton(GameButton[][] GameButtons, SmileButton smile, int[][] playField,
			int Mines, int buttonsClicked, Label FlagsLeft, GridPane myPane, boolean isFirstClick) {
		
		//Initializing 
		ImageView smilePic = new ImageView(new Image("file:res/face-smile.png"));
		this.smile = smile;
		this.GameButtons = GameButtons;
		this.playField = playField;
		this.buttonsClicked = buttonsClicked;
		this.isFirstClick = isFirstClick;
		this.Mines = Mines;
		this.FlagsLeft = FlagsLeft;
		this.myPane = myPane;
			
		//Sets default image
		setGraphic(smilePic);  
		
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		resetGame(GameButtons, playField, Mines, buttonsClicked);
			
	}	

	
	//Resets game to its 'new game' state
	public void resetGame(GameButton[][] GameButtons, int[][] playField, int Mines, int buttonsClicked) {		
		
		for(int row=0;row<playField.length;row++) {
			for(int col=0;col<playField[0].length;col++) {
				playField[row][col] = 0;
				GameButtons[row][col].isFirstClick = true;
				GameButtons[row][col].setGraphic(new ImageView(new Image("file:res/cover.png")));
				GameButtons[row][col].FlagState = 0;
				GameButtons[row][col].ClickState = 0;
				GameButtons[row][col].GameState = playField[row][col];
				GameButtons[0][0].Mines = Mines;
				FlagsLeft.setText("" + 40);
			}
		}
		setGraphic(new ImageView(new Image("file:res/face-smile.png")));
		buttonsClicked=0;
		myPane.setMouseTransparent(false);
	}

		
}




