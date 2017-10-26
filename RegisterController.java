package CSC3610_Group_Project;



import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RegisterController extends Application{

	private Stage primaryStage;
	private AnchorPane rootLayout;
	private AnchorPane logInLayout;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtPhoneNumber;
	@FXML
	private TextField txtEmail;
	@FXML
	private DatePicker dpDOB;
	@FXML
	private TextField txtSocialSecurityNumber;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private TextField txtStreet;
	@FXML
	private TextField txtCity;
	@FXML
	private ComboBox<String> cboState;
	@FXML
	private TextField txtZip;
	@FXML
	private Button btnSave;
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
	@FXML
	private Label lblFName;
	@FXML
	private Label lblLName;
	@FXML
	private Label lblPhone;
	@FXML
	private Label lblEmail;
	@FXML
	private Label lblDOB;
	@FXML
	private Label lblSSN;
	@FXML
	private Label lblStreet;
	@FXML
	private Label lblCity;
	@FXML
	private Label lblZip;
	@FXML
	private Label lblUserName;
	@FXML
	private Label lblPassword;
	@FXML
	private Label lblState;
	
	private ObservableList<String> stateList = FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT",
			"NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT",
			"VA", "WA", "WV", "WI", "WY"); 
	
	@FXML
	public void initialize(){
		cboState.setItems(stateList);
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Register");


		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(RegisterController.class.getResource("RegisterScene.fxml"));
		
		try{
			rootLayout = (AnchorPane) loader.load();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	@FXML
	public void btSaveAction(ActionEvent e){
		boolean correctFields = true;
		// Check each individual fields
		if(txtFirstName.getText().equals("")){
			lblFName.setText("* First Name:");
			lblFName.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblFName.setText("First Name:");
			lblFName.setTextFill(Color.web("#000000"));
		}
		if(txtLastName.getText().equals("")){
			lblLName.setText("* Last Name:");
			lblLName.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblLName.setText("Last Name:");
			lblLName.setTextFill(Color.web("#000000"));
		}
		if(txtPhoneNumber.getText().equals("")){
			lblPhone.setText("* Phone Number:");
			lblPhone.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else if (txtPhoneNumber.getText().matches("[a-zA-Z]+")){
			// Show alert
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setTitle("Error");
		    alert.setHeaderText(" Error");
		    alert.setContentText("Please only use numbers for your Phone number");
		    alert.showAndWait();	
		    lblPhone.setText("* Phone Number:");
			lblPhone.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		}else {
			lblPhone.setText("Phone Number:");
			lblPhone.setTextFill(Color.web("#000000"));
		}
		if(txtEmail.getText().equals("")){
			lblEmail.setText("* Email:");
			lblEmail.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblEmail.setText("Email:");
			lblEmail.setTextFill(Color.web("#000000"));
		}
		if(dpDOB.getValue() == null){
			lblDOB.setText("* Date of Birth:");
			lblDOB.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblDOB.setText("Date of Birth:");
			lblDOB.setTextFill(Color.web("#000000"));
		}
		if(txtSocialSecurityNumber.getText().equals("")){
			lblSSN.setText("* Social Security Number:");
			lblSSN.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else if (txtSocialSecurityNumber.getText().matches("[a-zA-Z]+")){
			// Show alert
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setTitle("Error");
		    alert.setHeaderText(" Error");
		    alert.setContentText("Please only use numbers for your Social Security Number");
		    alert.showAndWait();	
		    lblSSN.setText("* Social Security Number:");
			lblSSN.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		}else {
			lblSSN.setText("Social Security Number:");
			lblSSN.setTextFill(Color.web("#000000"));
		}
		if(txtUsername.getText().equals("")){
			lblUserName.setText("* Username:");
			lblUserName.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblUserName.setText("Username:");
			lblUserName.setTextFill(Color.web("#000000"));
		}
		if(txtPassword.getText().equals("")){
			lblPassword.setText("* Password:");
			lblPassword.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblPassword.setText("Password:");
			lblPassword.setTextFill(Color.web("#000000"));
		}
		if(txtStreet.getText().equals("")){
			lblStreet.setText("* Street:");
			lblStreet.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblStreet.setText("Street:");
			lblStreet.setTextFill(Color.web("#000000"));
		}
		if(txtCity.getText().equals("")){
			lblCity.setText("* City:");
			lblCity.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblCity.setText("City:");
			lblCity.setTextFill(Color.web("#000000"));
		}
		if(cboState.getSelectionModel().isEmpty()){
			lblState.setText("* State:");
			lblState.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblState.setText("State:");
			lblState.setTextFill(Color.web("#000000"));
		}
		if(txtZip.getText().equals("")){
			lblZip.setText("* Zip Code:");
			lblZip.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else if (txtZip.getText().matches("[a-zA-Z]+")){
			// Show alert
			Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setTitle("Error");
		    alert.setHeaderText(" Error");
		    alert.setContentText("Please only use numbers for your Zip Code");
		    alert.showAndWait();	
		    lblZip.setText("* Zip Code:");
			lblZip.setTextFill(Color.web("#FF0000"));
			correctFields = false;
		} else {
			lblZip.setText("Zip Code:");
			lblZip.setTextFill(Color.web("#000000"));
		}
		
		if(correctFields){
			// Only goes through if onlyNumbers stayed true
			Customer customer = new Customer();
			customer.setAddress(txtStreet.getText() + " " + txtCity.getText() + " " + cboState.getValue().toString() + ", " + txtZip.getText());
			customer.setDOB(java.sql.Date.valueOf(dpDOB.getValue()));
			customer.setEmail(txtEmail.getText());
			customer.setFirstName(txtFirstName.getText());
			customer.setLastName(txtLastName.getText());
			customer.setPassword(HashPassword.hashPassword(txtPassword.getText()));
			customer.setUserName(txtUsername.getText());
			customer.setPhone(txtPhoneNumber.getText());
			customer.setSSN(txtSocialSecurityNumber.getText());
			
			// Send in customer to register
			Connect conn = new Connect();
			conn.initalizeDB();
			System.out.println("Sending in customer");
			conn.register(customer);
			conn.closeDB();
			//MasterPaneController.userMap.put(customer.getUserName(), customer);
			// Send it back to the log in scene
			try{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(LogInController.class.getResource("LogInScene.fxml"));
				logInLayout = (AnchorPane) loader.load();
				MasterPaneController.masterLayout.setCenter(logInLayout);
				
			}catch (IOException ex){
				ex.printStackTrace();
			}
		} else {
			showAlert();
		}
	} 
	
	public void showAlert(){
		// Show alert
		Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setTitle("Error");
	    alert.setHeaderText(" Error");
	    alert.setContentText("Please fill out the selected values");
	    alert.showAndWait();
	}
	@FXML
	public void miCloseAction(ActionEvent e){
		System.exit(0);
	}
	
	
	@FXML
	public void miDeleteAction(ActionEvent e){
		clear();
	}
	
	public void clear(){
		txtFirstName.setText(null);
		txtLastName.setText(null);
		txtPhoneNumber.setText(null);
		txtEmail.setText(null);
		dpDOB.setValue(null);
		txtSocialSecurityNumber.setText(null);
		txtUsername.setText(null);
		txtPassword.setText(null);
		txtStreet.setText(null);
		txtCity.setText(null);
		cboState.setValue(null);
		txtZip.setText(null);
	}

	
	
}