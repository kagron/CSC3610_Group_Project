package CSC3610_Group_Project;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ForgotPasswordController extends Application {
	
	private Stage primaryStage;
	private AnchorPane controlsData;
	private BorderPane logInLayout;

	@FXML
	private TextField txtPassword;
	
	@FXML
	private Button btnSave;
	
	@FXML
	private MenuItem fileClose;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Forgot Password");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(UserSceneController.class.getResource("ForgotPasswordScene.fxml"));
		
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
	
	@FXML
	private void initialize(){
		
		//save button action and replace old password
		btnSave.setOnAction((event) ->{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
			try {
				logInLayout = (BorderPane) loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Stage stage = new Stage();
			stage.setTitle("Log IN");
			stage.setScene(new Scene(logInLayout));
			stage.show();	
		});
		
		
		//Exit GUI when file -> close is clicked
		fileClose.setOnAction((event) -> {
			Platform.exit();
		});
	}

	public static void main(String[] args){
		launch(args);
	}		
}
