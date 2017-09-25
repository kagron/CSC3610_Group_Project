package CSC3610_Group_Project;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UserSceneController extends Application {
	
	private Stage primaryStage;
	private AnchorPane controlsData;
	private BorderPane registerLayout;
	
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
	
	@FXML
	private MenuItem fileClose;
	
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
				registerLayout = (BorderPane) loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Stage stage = new Stage();
			stage.setTitle("Register");
			stage.setScene(new Scene(registerLayout));
			stage.show();	
	});

		fileClose.setOnAction((event) -> {
			Platform.exit();
		});
		
		
		Customer customer = new Customer();
		String setDescription = "First Name: " + customer.getFirstName() + "\nLast Name: " + customer.getLastName() + "\nPassword: " + customer.getPassword()
									+ "\nUserName: " + customer.getUserName() + "\nPhone Number: " + customer.getPhone() + "\nSSN: " + customer.getSSN()
									+ "\nAddress: " + customer.getAddress() + "\nDOB: " + customer.getDOB() + "\nEmail: "	+ customer.getEmail();
		
		txtDisplayArea.setText(setDescription);

		
	 }
		public static void main(String[] args){
		launch(args);
		}		
}





