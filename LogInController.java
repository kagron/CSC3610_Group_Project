package CSC3610_Group_Project;

import java.io.IOException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserSceneController extends Application {
	
	public static String firstName, lastName, phone, email, address, userName, password;
	public static LocalDate DOB; 
	public static String SSN;
	
	private Stage primaryStage;
	private AnchorPane controlsData;
	private AnchorPane registerLayout;
	
	@FXML
	private TextArea txtDisplayArea; 
	
	@FXML
	private Button btnDisplayInfo;
	
	@FXML
	private Button btnUpdateInfo;
	
	@FXML
	private Button btnCustomize;
	
	@FXML
	private Button btnCart;

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Tesla: Customer Info");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UserSceneController.class.getResource("UserScene.fxml"));
		
		try{
			controlsData = (AnchorPane) loader.load();
		}
		catch(IOException e){
			e.printStackTrace();			
		}
		
		Scene scene = new Scene(controlsData);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//Update Info button
	 @FXML
	private void initialize() {
	
	//closes program
	btnUpdateInfo.setOnAction((event) ->{
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LogInController.class.getResource("RegisterScene.fxml"));
			try {
				registerLayout = (AnchorPane) loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			MasterPaneController.masterLayout.setCenter(registerLayout);
	});
		
		txtDisplayArea.setText(MasterPaneController.userMap.get(LogInController.userName).toString());

		
	 }
		public static void main(String[] args){
		launch(args);
		}		
}
