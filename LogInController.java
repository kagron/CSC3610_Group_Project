package CSC3610_Group_Project;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LogInController extends Application{

	private Stage primaryStage;
	private BorderPane rootLayout;
	private BorderPane registerLayout;
	private BorderPane userLayout;
	@FXML
	private TextField txtUsername;
	@FXML
	private TextField txtPassword;
	@FXML
	private Button btnLogIn;
	@FXML
	private Button btnRegister;
	@FXML
	private MenuBar mbMenu;
	@FXML
	private Menu mFile;
	@FXML
	private Menu mEdit;
	@FXML
	private Menu mHelp;
	@FXML
	private MenuItem miClose;
	@FXML
	private MenuItem miDelete;
	@FXML
	private MenuItem miAbout;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Log In");


		FXMLLoader logInLoader = new FXMLLoader();
		logInLoader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
		
		try{
			rootLayout = (BorderPane) logInLoader.load();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	@FXML
	public void btRegisterAction(ActionEvent e){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LogInController.class.getResource("RegisterScene.fxml"));
			registerLayout = (BorderPane) loader.load();
			Stage stage = new Stage();
			stage.setTitle("Register");
			stage.setScene(new Scene(registerLayout));
			stage.show();
			
			
		}catch (IOException ex){
			ex.printStackTrace();
		}
		
	}
	
	@FXML
	public void btLogInAction(ActionEvent e){
		
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(LogInController.class.getResource("UserScene.fxml"));
			userLayout = (BorderPane) loader.load();
			Stage stage = new Stage();
			stage.setTitle("User");
			stage.setScene(new Scene(userLayout));
			stage.show();
			
		}catch (IOException ex){
			ex.printStackTrace();
		}
	}
	
	@FXML
	public void miCloseAction(ActionEvent e){
		System.exit(0);
	}
	
	
	@FXML
	public void miAboutAction(ActionEvent e){
		
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
}
