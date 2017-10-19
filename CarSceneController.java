package CSC3610_Group_Project;

import java.io.IOException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CarSceneController extends Application {
	
	public static Person loggedInUser;
	
	
	private Stage primaryStage;
	private AnchorPane controlsData;
	private AnchorPane userLayout;
	
	@FXML
	private Button btnCart;
	@FXML
	private Button btnBack;
	@FXML
	private Button btn75D;
	@FXML
	private Button btn100D;
	@FXML
	private Button btnP100D;
	@FXML
	private ComboBox<String> cboColor;
	@FXML
	private ComboBox<String> cboInterior;
	@FXML
	private ComboBox<String> cboWheels;
	@FXML
	private ComboBox<String> cboRoof;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	}
	
	//Update Info button
	 @FXML
	private void initialize() {
	
		 
		
	 }
	 
	 @FXML
	 public void goBack(ActionEvent e){	
			FXMLLoader userLoader = new FXMLLoader();
			userLoader.setLocation(LogInController.class.getResource("HomeScene.fxml"));
			try {
				userLayout = (AnchorPane) userLoader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			MasterPaneController.masterLayout.setCenter(userLayout);
	 }
}





