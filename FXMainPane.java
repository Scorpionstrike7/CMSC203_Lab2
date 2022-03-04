


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textField
	Button hellobtn;
	Button howdybtn;
	Button chinesebtn;
	Button japanesebtn;
	Button clearbtn;
	Button exitbtn;
	
	Label myLabel;
	
	TextField myTextField;
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager datamanager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	@SuppressWarnings("null")
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textField
		Button helloBtn;
		hellobtn = new Button("Hello");
		howdybtn = new Button("Howdy");
		chinesebtn = new Button("Chinese");
		japanesebtn = new Button("Japanese");
		clearbtn = new Button("Clear");
		exitbtn = new Button("Exit");
		
		myLabel = new Label("Feedback");
		
		myTextField = new TextField();
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		datamanager = new DataManager();
		Insets insets = new Insets(10);
		//  set margins and set alignment of the components
		HBox.setMargin(hellobtn, insets);
		HBox.setMargin(howdybtn, insets);
		HBox.setMargin(chinesebtn, insets);
		HBox.setMargin(japanesebtn, insets);
		HBox.setMargin(clearbtn, insets);
		HBox.setMargin(exitbtn, insets);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and TextField to one of the HBoxes
		hbox1.getChildren().addAll(myLabel, myTextField);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(hellobtn, howdybtn, chinesebtn, japanesebtn, clearbtn, exitbtn);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
	
	//Task #4:
	
	hellobtn.setOnAction(new ButtonHandler());
	howdybtn.setOnAction(new ButtonHandler());
	chinesebtn.setOnAction(new ButtonHandler());
	japanesebtn.setOnAction(new ButtonHandler());
	clearbtn.setOnAction(new ButtonHandler()); 
	exitbtn.setOnAction(new ButtonHandler());
	}
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			if(event.getTarget() == hellobtn){
				myTextField.setText(datamanager.getHello());
			}
			else if(event.getTarget() == howdybtn){
				myTextField.setText(datamanager.getHowdy());
			}
			else if(event.getTarget() == chinesebtn){
				myTextField.setText(datamanager.getChinese());
			}
			else if(event.getTarget() == japanesebtn){
				myTextField.setText(datamanager.getJapanese());
			}
			else if(event.getTarget() == clearbtn){
				myTextField.setText("");
			}
			else if(event.getTarget() == exitbtn){
				Platform.exit();
				System.exit(0);
			}
			else {
			}
		}
	}
}