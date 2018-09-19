
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MovieReview extends Application implements EventHandler<MouseEvent>{
	
	
	public static void main(String[] args) {
		launch(args);
	}

	
	@Override
	public void handle(MouseEvent event) {
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		BorderPane Border = new BorderPane();
		VBox MainMenuButtons = new VBox();
		HBox HomeMenuHBox = new HBox();
		VBox FunctionButtons = new VBox();
		HBox ExitButtonHBox = new HBox();
		
		primaryStage.setTitle("Movie Review Word Search");
		
		Label Logo = new Label();
		Logo.setStyle("-fx-background-radius: 5em");	
		Logo.setGraphic(new ImageView(new Image("file:res/Logo.png")));
		HomeMenuHBox.setPadding(new Insets(20, 0, -50, 0)); 
		HomeMenuHBox.setAlignment(Pos.CENTER);
		HomeMenuHBox.getChildren().add(Logo);
		
		
		FunctionButtons.setAlignment(Pos.CENTER);
		FunctionButtons.setSpacing(20);
		
		//First function button
		Button GetWord = new Button("Get Word Score");
		GetWord.setStyle("-fx-background-radius: 5em;" +
				"-fx-background-color: #CECEA7");
		GetWord.setMinSize(300, 60);
		GetWord.setFont(new Font("Arial", 30));
		GetWord.setOnAction(e -> {
			GetWordProcedure(Border);
		});
		FunctionButtons.getChildren().add(GetWord);
		
		//Second function button
		Button GetSentence = new Button("Get Sentence Score");
		GetSentence.setStyle("-fx-background-radius: 5em;" +
				"-fx-background-color: #CECEA7");
		GetSentence.setMinSize(300, 60);
		GetSentence.setFont(new Font("Arial", 30));
		GetSentence.setOnAction(e -> {
			GetSentenceProcedure(Border);
		});
		FunctionButtons.getChildren().add(GetSentence);
		
	/*	//Third function button
		Button TopFivePositive = new Button("Top 5 Positive");
		TopFivePositive.setStyle("-fx-background-radius: 5em;" +
				"-fx-background-color: #CECEA7");
		TopFivePositive.setMinSize(300, 60);
		TopFivePositive.setFont(new Font("Arial", 30));
		TopFivePositive.setOnAction(e -> {
			Top5PosProcedure(Border);
		});
		FunctionButtons.getChildren().add(TopFivePositive); */
		
		//Fourth function button
	/*	Button TopFiveNegative = new Button("Top 5 Negative");
		TopFiveNegative.setStyle("-fx-background-radius: 5em;" +
				"-fx-background-color: #CECEA7");
		TopFiveNegative.setMinSize(300, 60);
		TopFiveNegative.setFont(new Font("Arial", 30));
		TopFiveNegative.setOnAction(e -> {
			Top5NegProcedure(Border);
		});
		FunctionButtons.getChildren().add(TopFiveNegative);   */
		
		//Exit button
		Button Exit = new Button();
		Exit.setStyle("-fx-background-radius: 6em");	
		Exit.setGraphic(new ImageView(new Image("file:res/Exit.png")));
		Exit.setPadding(Insets.EMPTY);
		Exit.setOnAction(e -> {
			System.exit(0);
		});
		ExitButtonHBox.setPadding(new Insets(-50, 0, 30, 0)); 
		ExitButtonHBox.setAlignment(Pos.CENTER);
		ExitButtonHBox.getChildren().add(Exit);
		
		
		MainMenuButtons.getChildren().add(HomeMenuHBox);
		MainMenuButtons.getChildren().add(FunctionButtons);
		MainMenuButtons.getChildren().add(ExitButtonHBox);
		Border.setStyle("-fx-background-color: #1621C7;");
		Border.setTop(HomeMenuHBox);
		Border.setCenter(FunctionButtons);
		Border.setBottom(ExitButtonHBox);
		Border.getChildren().add(MainMenuButtons);
		
		Scene myScene = new Scene(Border, 400, 600);
		primaryStage.setScene(myScene);
		
		primaryStage.show();
		
	}
	
	
	//Method for main menu state
	public static void mainMenu(BorderPane Border) {
		Border.getChildren().clear();
		
		VBox MainMenuButtons = new VBox();
		HBox HomeMenuHBox = new HBox();
		VBox FunctionButtons = new VBox();
		HBox ExitButtonHBox = new HBox();
		
		Label Logo = new Label();
		Logo.setStyle("-fx-background-radius: 5em");	
		Logo.setGraphic(new ImageView(new Image("file:res/Logo.png")));
		HomeMenuHBox.setPadding(new Insets(20, 0, -50, 0)); 
		HomeMenuHBox.setAlignment(Pos.CENTER);
		HomeMenuHBox.getChildren().add(Logo);
		
		FunctionButtons.setAlignment(Pos.CENTER);
		FunctionButtons.setSpacing(20);
		
		//First function button
		Button GetWord = new Button("Get Word Score");
		GetWord.setStyle("-fx-background-radius: 5em;" +
				"-fx-background-color: #CECEA7");
		GetWord.setMinSize(300, 60);
		GetWord.setFont(new Font("Arial", 30));
		GetWord.setOnAction(e -> {
			GetWordProcedure(Border);
		});
		FunctionButtons.getChildren().add(GetWord);
				
		//Second function button
		Button GetSentence = new Button("Get Sentence Score");
		GetSentence.setStyle("-fx-background-radius: 5em;" +
				"-fx-background-color: #CECEA7");
		GetSentence.setMinSize(300, 60);
		GetSentence.setFont(new Font("Arial", 30));
		GetSentence.setOnAction(e -> {
			GetSentenceProcedure(Border);
		});
		FunctionButtons.getChildren().add(GetSentence);
				
/*		//Third function button
		Button TopFivePositive = new Button("Top 5 Positive");
		TopFivePositive.setStyle("-fx-background-radius: 5em;" +
				"-fx-background-color: #CECEA7");
		TopFivePositive.setMinSize(300, 60);
		TopFivePositive.setFont(new Font("Arial", 30));
		TopFivePositive.setOnAction(e -> {
			Top5PosProcedure(Border);
		});
		FunctionButtons.getChildren().add(TopFivePositive);   */
				
	/*	//Fourth function button
		Button TopFiveNegative = new Button("Top 5 Negative");
		TopFiveNegative.setStyle("-fx-background-radius: 5em;" +
				"-fx-background-color: #CECEA7");
		TopFiveNegative.setMinSize(300, 60);
		TopFiveNegative.setFont(new Font("Arial", 30));
		TopFiveNegative.setOnAction(e -> {
			Top5NegProcedure(Border);
		});
		FunctionButtons.getChildren().add(TopFiveNegative);    */
				
		//Exit button
		Button Exit = new Button();
		Exit.setStyle("-fx-background-radius: 20em");	
		Exit.setGraphic(new ImageView(new Image("file:res/Exit.png")));
		Exit.setPadding(Insets.EMPTY);
		Exit.setOnAction(e -> {
			System.exit(0);
		});
		ExitButtonHBox.setPadding(new Insets(-50, 0, 30, 0)); 
		ExitButtonHBox.setAlignment(Pos.CENTER);
		ExitButtonHBox.getChildren().add(Exit);
				
				
		MainMenuButtons.getChildren().add(HomeMenuHBox);
		MainMenuButtons.getChildren().add(FunctionButtons);
		MainMenuButtons.getChildren().add(ExitButtonHBox);
		Border.setStyle("-fx-background-color: #1621C7;");
		Border.setTop(HomeMenuHBox);
		Border.setCenter(FunctionButtons);
		Border.setBottom(ExitButtonHBox);
		Border.getChildren().add(MainMenuButtons);
		
		
	}
	
	
	public static String checkConnotation(double d) {
		if(d<=4)
			return "Negative";
		if( (d>4)&&(d<=6) )
			return "Neutral";
		if(d>6)
			return "Positive";
		return "";
		
	}
	
	
	public static void GetWordProcedure(BorderPane Border) {
		Border.getChildren().clear();
		VBox newNodeStack = new VBox();
		HBox TopLevel = new HBox();
		HBox MiddleHighLevel = new HBox();
		HBox MiddleLowLevel = new HBox();
		HBox MiddleLowestLevel = new HBox();
		HBox LowestHBox = new HBox();
		
		
		newNodeStack.setSpacing(20);
		//Top Level HBox
		ImageView Back = new ImageView(new Image("file:res/Back.png"));
		Button back = new Button();
		back.setGraphic(Back);
		back.setPadding(Insets.EMPTY);
		Label getWordLabel = new Label();
		getWordLabel.setText("Get Word");
		getWordLabel.setMinWidth(Region.USE_PREF_SIZE);
		getWordLabel.setPadding(new Insets(20, 0, 0, 35));
		getWordLabel.setStyle("-fx-text-fill: #010101;" +
							"-fx-font-size: 4em;" +
							"-fx-underline: true;");
		TopLevel.setAlignment(Pos.CENTER);
		TopLevel.setPadding(new Insets(10, 20, 20, 20));
		TopLevel.getChildren().add(back);
		TopLevel.getChildren().add(getWordLabel);
		
		
		//MiddleHighLevel HBox
		Label Spectrum = new Label();
		Spectrum.setGraphic(new ImageView(new Image("file:res/Spectrum.png")));
		Spectrum.setPadding(new Insets(-10, 40, 0, 50));
		MiddleHighLevel.getChildren().add(Spectrum);
		
		
		//MiddleLowLevel HBox
		Label Description = new Label();
		Description.setText("Get the score of a specific word:");
		Description.setPadding(new Insets(0, 0, 0, 5));
		Description.setStyle("-fx-text-fill: #010101;" +
							"-fx-font-size: 2em;");
		Description.setMinWidth(Region.USE_PREF_SIZE);
		MiddleLowLevel.getChildren().add(Description);
		
		
		//MiddleLowestLevel HBox
		TextField WordToSearch = new TextField ();
		Button search = new Button("Search");
		search.setMinWidth(Region.USE_PREF_SIZE);
		WordToSearch.setMinWidth(Region.USE_PREF_SIZE);
		MiddleLowestLevel.setSpacing(20);
		MiddleLowestLevel.setPadding(new Insets(-5, 0, 0, 75));
		MiddleLowestLevel.getChildren().add(WordToSearch);
		MiddleLowestLevel.getChildren().add(search);
		
		
		//Lowest HBox
		TextArea output = new TextArea();
		output.setEditable(false);
		output.setMinSize(360, 260);
		output.setStyle("-fx-background-color: white;" +
				"-fx-font-size: 1.3em;");
		LowestHBox.setPadding(new Insets(5,0,0,20));
		LowestHBox.getChildren().add(output);
		
		search.setOnAction(e -> {
			if(WordToSearch.getText().equals(""))
				return;
			try {
				String[] CheckWord = WordToSearch.getText().split(" ");
				output.setText("Your word was: " + CheckWord[0] + "\n" + "\n" +
						"The average number was " + getWord(CheckWord[0].toLowerCase(), Border, Spectrum));
			}catch(Exception StringIndexOutOfBoundsException) {
				output.setText("Word is invalid, try again.");
				Spectrum.setGraphic(new ImageView(new Image("file:res/Spectrum.png")));
			}
		});
		
		
		
		newNodeStack.getChildren().add(TopLevel);
		newNodeStack.getChildren().add(MiddleHighLevel);
		newNodeStack.getChildren().add(MiddleLowLevel);
		newNodeStack.getChildren().add(MiddleLowestLevel);
		newNodeStack.getChildren().add(LowestHBox);
		
		Border.getChildren().add(newNodeStack);
		
		back.setOnAction(e -> {
			mainMenu(Border);
		});
		
	}
	
	
	public static String getWord(String data, BorderPane border, Label Spectrum) {
		ArrayList<String> matchingWords = new ArrayList<String>();
		File file = new File("res/ReviewData.txt");
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				if(readFile.nextLine().toLowerCase().contains(data)) {
					matchingWords.add(readFile.nextLine());
				}
			}
			readFile.close();
		}catch(Exception FileNotFound) {
			mainMenu(border);
		}
		
		double[] scores = new double[matchingWords.size()];
		for(int i=0;i<scores.length;i++) {
			scores[i] = Integer.parseInt(matchingWords.get(i).substring(0, 1));
		}
		
		
		//Takes Averages Of Values
		double avg = 0;
		for(int i=0; i<scores.length; i++) {
			avg+=scores[i]*2.5;
		}
		avg = avg/scores.length;
		String connotation = checkConnotation(avg);
		String res = Double.toString(avg);
		
		if(checkConnotation(avg).equals("Positive"))
			Spectrum.setGraphic(new ImageView(new Image("file:res/greenSpectrum.png")));
		else if(checkConnotation(avg).equals("Neutral"))
			Spectrum.setGraphic(new ImageView(new Image("file:res/yellowSpectrum.png")));
		else if(checkConnotation(avg).equals("Negative"))
			Spectrum.setGraphic(new ImageView(new Image("file:res/redSpectrum.png")));
			
		return res.substring(0, 4) + " out of 10." + "\n" + "\n" +
				"Overall it is a " + connotation + " word.";
		
	}

	
	public static void GetSentenceProcedure(BorderPane Border) {
		Border.getChildren().clear();
		VBox newNodeStack = new VBox();
		HBox TopLevel = new HBox();
		HBox MiddleHighLevel = new HBox();
		HBox MiddleLowLevel = new HBox();
		HBox MiddleLowestLevel = new HBox();
		HBox LowestHBox = new HBox();
		
		
		newNodeStack.setSpacing(20);
		//Top Level HBox
		ImageView Back = new ImageView(new Image("file:res/Back.png"));
		Button back = new Button();
		back.setGraphic(Back);
		back.setPadding(Insets.EMPTY);
		Label getWordLabel = new Label();
		getWordLabel.setText("Get Sentence");
		getWordLabel.setMinWidth(Region.USE_PREF_SIZE);
		getWordLabel.setPadding(new Insets(20, 0, 0, 25));
		getWordLabel.setStyle("-fx-text-fill: #010101;" +
							"-fx-font-size: 3em;" +
							"-fx-underline: true;");
		TopLevel.setAlignment(Pos.CENTER);
		TopLevel.setPadding(new Insets(10, 20, 20, 20));
		TopLevel.getChildren().add(back);
		TopLevel.getChildren().add(getWordLabel);
		
		
		//MiddleHighLevel HBox
		Label Spectrum = new Label();
		Spectrum.setGraphic(new ImageView(new Image("file:res/Spectrum.png")));
		Spectrum.setPadding(new Insets(0, 40, 0, 50));
		MiddleHighLevel.getChildren().add(Spectrum);
		
		
		//MiddleLowLevel HBox
		Label Description = new Label();
		Description.setText("Get the score of a sentence:");
		Description.setPadding(new Insets(0, 0, 0, 25));
		Description.setStyle("-fx-text-fill: #010101;" +
							"-fx-font-size: 2em;");
		Description.setMinWidth(Region.USE_PREF_SIZE);
		MiddleLowLevel.getChildren().add(Description);
		
		
		//MiddleLowestLevel HBox
		TextField WordsToSearch = new TextField ();
		Button search = new Button("Search");
		search.setMinWidth(Region.USE_PREF_SIZE);
		WordsToSearch.setMinWidth(Region.USE_PREF_SIZE);
		MiddleLowestLevel.setSpacing(20);
		MiddleLowestLevel.setPadding(new Insets(-5, 0, 0, 75));
		MiddleLowestLevel.getChildren().add(WordsToSearch);
		MiddleLowestLevel.getChildren().add(search);
		
		
		//Lowest HBox
		TextArea output = new TextArea();
		output.setEditable(false);
		output.setMinSize(360, 255);
		output.setStyle("-fx-background-color: white;" + 
						"-fx-font-size: 1.5em;");
		LowestHBox.setPadding(new Insets(5,0,0,20));
		LowestHBox.getChildren().add(output);
		search.setOnAction(e -> {
			if(WordsToSearch.getText().equals(""))
				return;
			try {
				String[] CheckWord = WordsToSearch.getText().split(" ");
				output.setText("The words in your sentence produced\nan average score " +
						"of: " + getSentence(CheckWord, Border, Spectrum));
			}catch(Exception StringIndexOutOfBoundsException) {
				output.setText("Sentence is invalid, try again.");
				Spectrum.setGraphic(new ImageView(new Image("file:res/Spectrum.png")));
			}
		});
		
		
		
		newNodeStack.getChildren().add(TopLevel);
		newNodeStack.getChildren().add(MiddleHighLevel);
		newNodeStack.getChildren().add(MiddleLowLevel);
		newNodeStack.getChildren().add(MiddleLowestLevel);
		newNodeStack.getChildren().add(LowestHBox);
		
		Border.getChildren().add(newNodeStack);
		
		back.setOnAction(e -> {
			mainMenu(Border);
		});
	}

	
	public static String getSentence(String[] data, BorderPane border, Label Spectrum) {
		ArrayList<Double> EachWordAverage = new ArrayList<Double>();
		for(int i=0;i<data.length;i++) {
			ArrayList<String> matchingWords = new ArrayList<String>();
			File file = new File("res/ReviewData.txt");
			boolean found = false;
			try {
				Scanner readFile = new Scanner(file);
				while(readFile.hasNextLine()) {
					if(readFile.nextLine().toLowerCase().contains(data[i])) {
						matchingWords.add(readFile.nextLine());
						found = true;
					}
				}
				readFile.close();
				if(!found)
					continue;
			}catch(Exception FileNotFound) {
				mainMenu(border);
			}
		
			double[] scores = new double[matchingWords.size()];
			for(int j=0;j<scores.length;j++) {
				scores[j] = Integer.parseInt(matchingWords.get(j).substring(0, 1));
			}
			
		
		
			//Takes Averages Of Values
			double avg = 0;
			for(int z=0; z<scores.length; z++) {
				avg+=scores[z]*2.5;
			}
			avg = avg/scores.length;
			EachWordAverage.add(avg);
		}
		
		
		double finalAvg = 0;
		for(int i=0;i<EachWordAverage.size();i++) {
			finalAvg+= EachWordAverage.get(i);
		}
		finalAvg = finalAvg/EachWordAverage.size();
		String connotation = checkConnotation(finalAvg);
		String res = Double.toString(finalAvg);
		
		if(checkConnotation(finalAvg).equals("Positive"))
			Spectrum.setGraphic(new ImageView(new Image("file:res/greenSpectrum.png")));
		else if(checkConnotation(finalAvg).equals("Neutral"))
			Spectrum.setGraphic(new ImageView(new Image("file:res/yellowSpectrum.png")));
		else if(checkConnotation(finalAvg).equals("Negative"))
			Spectrum.setGraphic(new ImageView(new Image("file:res/redSpectrum.png")));
		
		return res.substring(0, 4) + " out of 10." + "\n" + "\n" +
			"Overall it is a " + connotation + " sentence.";
		
	}

	
	public static void Top5PosProcedure(BorderPane Border) {
		Border.getChildren().clear();
		VBox newNodeStack = new VBox();
		HBox TopLevel = new HBox();
		HBox MiddleHighLevel = new HBox();
		HBox MiddleLowLevel = new HBox();
		HBox MiddleLowestLevel = new HBox();
		HBox LowestHBox = new HBox();
		
		
		newNodeStack.setSpacing(20);
		//Top Level HBox
		ImageView Back = new ImageView(new Image("file:res/Back.png"));
		Button back = new Button();
		back.setGraphic(Back);
		back.setPadding(Insets.EMPTY);
		Label getWordLabel = new Label();
		getWordLabel.setText("Top 5 Positive");
		getWordLabel.setMinWidth(Region.USE_PREF_SIZE);
		getWordLabel.setPadding(new Insets(20, 0, 0, 25));
		getWordLabel.setStyle("-fx-text-fill: #010101;" +
							"-fx-font-size: 3em;" +
							"-fx-underline: true;");
		TopLevel.setAlignment(Pos.CENTER);
		TopLevel.setPadding(new Insets(10, 20, 20, 20));
		TopLevel.getChildren().add(back);
		TopLevel.getChildren().add(getWordLabel);
		
		
		//MiddleHighLevel HBox
		Label Spectrum = new Label();
		Spectrum.setGraphic(new ImageView(new Image("file:res/greenSpectrum.png")));
		Spectrum.setPadding(new Insets(0, 40, 0, 50));
		MiddleHighLevel.getChildren().add(Spectrum);
		
		
		//MiddleLowLevel HBox
		Label Description = new Label();
		Description.setText("The top 5 most positive words:");
		Description.setPadding(new Insets(0, 0, 0, 20));
		Description.setStyle("-fx-text-fill: #010101;" +
							"-fx-font-size: 2em;");
		Description.setMinWidth(Region.USE_PREF_SIZE);
		MiddleLowLevel.getChildren().add(Description);
		
		//Lowest HBox
		TextArea output = new TextArea();
		output.setEditable(false);
		output.setMinSize(360, 300);
		output.setStyle("-fx-background-color: white;");
		
		//THIS NEEDS TO WORK HERE
		generateMap(Border, output);
		
		LowestHBox.setPadding(new Insets(-20,0,0,20));
		LowestHBox.getChildren().add(output);
		
		
		
		newNodeStack.getChildren().add(TopLevel);
		newNodeStack.getChildren().add(MiddleHighLevel);
		newNodeStack.getChildren().add(MiddleLowLevel);
		newNodeStack.getChildren().add(MiddleLowestLevel);
		newNodeStack.getChildren().add(LowestHBox);
		
		Border.getChildren().add(newNodeStack);
		
		back.setOnAction(e -> {
			mainMenu(Border);
		});
	}
			
	
	public static void Top5NegProcedure(BorderPane Border) {
		Border.getChildren().clear();
		VBox newNodeStack = new VBox();
		HBox TopLevel = new HBox();
		HBox MiddleHighLevel = new HBox();
		HBox MiddleLowLevel = new HBox();
		HBox MiddleLowestLevel = new HBox();
		HBox LowestHBox = new HBox();
		
		
		newNodeStack.setSpacing(20);
		//Top Level HBox
		ImageView Back = new ImageView(new Image("file:res/Back.png"));
		Button back = new Button();
		back.setGraphic(Back);
		back.setPadding(Insets.EMPTY);
		Label getWordLabel = new Label();
		getWordLabel.setText("Top 5 Negative");
		getWordLabel.setMinWidth(Region.USE_PREF_SIZE);
		getWordLabel.setPadding(new Insets(20, 0, 0, 15));
		getWordLabel.setStyle("-fx-text-fill: #010101;" +
							"-fx-font-size: 3em;" +
							"-fx-underline: true;");
		TopLevel.setAlignment(Pos.CENTER);
		TopLevel.setPadding(new Insets(10, 20, 20, 20));
		TopLevel.getChildren().add(back);
		TopLevel.getChildren().add(getWordLabel);
		
		
		//MiddleHighLevel HBox
		Label Spectrum = new Label();
		Spectrum.setGraphic(new ImageView(new Image("file:res/redSpectrum.png")));
		Spectrum.setPadding(new Insets(0, 40, 0, 50));
		MiddleHighLevel.getChildren().add(Spectrum);
		
		
		//MiddleLowLevel HBox
		Label Description = new Label();
		Description.setText("The top 5 most Negative words:");
		Description.setPadding(new Insets(0, 0, 0, 15));
		Description.setStyle("-fx-text-fill: #010101;" +
							"-fx-font-size: 2em;");
		Description.setMinWidth(Region.USE_PREF_SIZE);
		MiddleLowLevel.getChildren().add(Description);
		
		
		//Lowest HBox
		TextArea output = new TextArea();
		output.setEditable(false);
		output.setMinSize(360, 300);
		output.setStyle("-fx-background-color: white;");
		LowestHBox.setPadding(new Insets(-20,0,0,20));
		LowestHBox.getChildren().add(output);
		
		
		
		newNodeStack.getChildren().add(TopLevel);
		newNodeStack.getChildren().add(MiddleHighLevel);
		newNodeStack.getChildren().add(MiddleLowLevel);
		newNodeStack.getChildren().add(MiddleLowestLevel);
		newNodeStack.getChildren().add(LowestHBox);
		
		Border.getChildren().add(newNodeStack);
		
		back.setOnAction(e -> {
			mainMenu(Border);
		});
	}



	//FINISH THIS METHOD
	public static void generateMap(BorderPane border, TextArea output) {
		ArrayList<WordObject> data = new ArrayList<WordObject>();
		File file = new File("res/ReviewData.txt");
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNext()) {
				String nextWord = readFile.next();
				data.add(new WordObject(nextWord, 1, score(nextWord)));	
				break;
			}
			readFile.close();
				
		}catch(Exception FileNotFound) {
				mainMenu(border);
		}
		
		Collections.sort(data);
		
		output.setText(data.get(0).getData());	
	}
	
	//FINISH THIS EFFICIENTLY
	public static double score(String s) {
		
		double score = 0;
		File file = new File("res/ReviewData.txt");
		ArrayList<String> matchingWords = new ArrayList<String>();
		try {
			Scanner readFile = new Scanner(file);
			while(readFile.hasNextLine()) {
				if(readFile.nextLine().toLowerCase().contains(s)) {
					matchingWords.add(readFile.nextLine());
				}
			}
			readFile.close();
		}catch(Exception FileNotFound) {
			
		}
		
		double[] scores = new double[matchingWords.size()];
		for(int i=0;i<scores.length;i++) {
			scores[i] = Integer.parseInt(matchingWords.get(i).substring(0, 1));
		}
		
		
		//Takes Averages Of Values
		double avg = 0;
		for(int i=0; i<scores.length; i++) {
			avg+=scores[i]*2.5;
		}
		avg = avg/scores.length;
		
		return score;
	}
	
	
}



class WordObject implements Comparable<WordObject>{
	
	private String data;
	private int count;
	private double score;
	
	
	public WordObject(String data, int count, double score) {
		this.data=data;
		this.count=count;
		this.score=score;
	}
	
	public String getData() {
		return data;
	}
	
	public int getCount() {
		return count;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setData(String s) {
		data = s;
	}
	
	public void setCount(int x) {
		count = x;
	}
	
	public void setScore(double d) {
		score=d;
	}
	
	public String toString() {
		return data + ": " + "Count: " + count + " Score: " + score;
	}

	@Override
	public boolean equals(Object object) {
		if(object instanceof WordObject && ((WordObject)object).getData() == this.data) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int compareTo(WordObject o) {
		return Double.compare(this.score, score);
	}
	
}




