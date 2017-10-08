package CSC3610_Group_Project;

import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MasterPaneController extends Application{
		protected static BorderPane masterLayout;
		protected static HashMap<String, Person> userMap = new HashMap<>();
		private AnchorPane loaderScene;
		private Stage primaryStage;
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
		private MenuItem miSignOut;
		@FXML
		private MenuItem miAbout;
		
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Tesla");

			//loads master pane 
			FXMLLoader masterLoader = new FXMLLoader();
			masterLoader.setLocation(MasterPaneController.class.getResource("MasterStage.fxml"));
			
			try{
				masterLayout = (BorderPane) masterLoader.load();
			}catch (IOException e){
				e.printStackTrace();
			}
			
			//Load LogIn scene into center of master pane
			FXMLLoader sceneLoader = new FXMLLoader();
			sceneLoader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
			
			try{
				loaderScene = (AnchorPane) sceneLoader.load();
			}catch (IOException e){
				e.printStackTrace();
			}
			
			masterLayout.setCenter(loaderScene);
			
			Scene scene = new Scene(masterLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		//Exit GUI when File -> Close is clicked
		@FXML
		public void miCloseAction(ActionEvent e){
			System.exit(0);
		}
		@FXML
		public void miSignOut(ActionEvent e){
			//Load LogIn scene into center of master pane
			FXMLLoader sceneLoader = new FXMLLoader();
			sceneLoader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
			
			try{
				loaderScene = (AnchorPane) sceneLoader.load();
			}catch (IOException a){
				a.printStackTrace();
			}
			
			masterLayout.setCenter(loaderScene);
		}
		
		@FXML
		public void miAboutAction(ActionEvent e){
			
		}

		public static void main(String[] args) {
			launch(args);
		}
	}
