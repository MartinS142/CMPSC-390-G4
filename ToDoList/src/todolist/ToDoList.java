
package todolist;

import java.time.LocalDate;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ToDoList extends Application {
     String task;
     String description;
     LocalDate date;
     int priority;
     ObservableList<String> list;
     
    
  public static void main(String[] args) {
        launch(args);
        
        //calls jsonStorage method, from WriteJson Class, to execute
        WriteJson.jsonStorage();        
    }


    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("ToDoList");
        primaryStage.setScene(scene);
        
        Image image = new Image("resources/logo.png");  
      
      //Setting the image view 
      ImageView imageView = new ImageView(image); 
      
      //Setting the position of the image 
      imageView.setX(0); 
      imageView.setY(0); 
      
      //setting the fit height and width of the image view 
      imageView.setFitHeight(100); 
      imageView.setFitWidth(100); 
      
      //Setting the preserve ratio of the image view 
      imageView.setPreserveRatio(true);  
      
      
      Label title = new Label();
      title.setText("To-Do List");
      title.setLayoutX(250);
      title.setFont(new Font("Arial", 24));
      
       Button createNewTaskBtn = new Button();
        createNewTaskBtn.setText("Create new Task");
        createNewTaskBtn.setLayoutX(250);
        createNewTaskBtn.setLayoutY(100);
        
         Button createNewListBtn = new Button();
        createNewListBtn.setText("Create new List");
        createNewListBtn.setLayoutX(0);
        createNewListBtn.setLayoutY(100);
        
        Label listLabel = new Label();
        listLabel.setText("Lists");
        listLabel.setLayoutX(0);
        listLabel.setLayoutY(150);
        listLabel.setFont(new Font("Arial", 24));
        
        Label taskLabel = new Label();
        taskLabel.setText("Tasks");
        taskLabel.setLayoutX(250);
        taskLabel.setLayoutY(150);
        taskLabel.setFont(new Font("Arial", 24));
        
        //ListView were the tasks will be displayed
        list = FXCollections.<String>observableArrayList();
        ListView<String> tasks = new ListView<>(list);
        tasks.setLayoutX(250);
        tasks.setLayoutY(200);
        tasks.setMaxHeight(200);
        tasks.setMaxWidth(250);
        

        
        Rectangle bottomBorder = new Rectangle(600, 20);
        bottomBorder.setLayoutX(0);
        bottomBorder.setLayoutY(580);
        bottomBorder.setFill(Color.DEEPSKYBLUE);

           
        root.getChildren().add(imageView);
        root.getChildren().add(title);
        root.getChildren().add(createNewTaskBtn);
        root.getChildren().add(createNewListBtn);
        root.getChildren().add(bottomBorder);
        root.getChildren().add(listLabel);
        root.getChildren().add(taskLabel);
        root.getChildren().add(tasks);
        
         createNewTaskBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
             public void handle(ActionEvent event) {
               taskScreen();
            }
        });
         
         
         createNewListBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
             public void handle(ActionEvent event) {
               listScreen();   
                String a = tasks.getOnMouseClicked().toString();
                System.out.print(a);
            }
        });
         
          
        primaryStage.show();
    }

    
    
    public void taskScreen(){
        
        Stage newWindow = new Stage();
               
   
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);
        
        newWindow.setTitle("Task Screen");
        newWindow.setScene(scene);
        
        Image image = new Image("resources/logo.png");  
      
      //Setting the image view 
      ImageView logo = new ImageView(image); 
      
      //Setting the position of the image 
      logo.setX(0); 
      logo.setY(0); 
      
      //setting the fit height and width of the image view 
      logo.setFitHeight(100); 
      logo.setFitWidth(100); 
      
      //Setting the preserve ratio of the image view 
      logo.setPreserveRatio(true);  
      
     
        
        Button enterTaskBtn = new Button();
        enterTaskBtn.setText("Create Task");
        enterTaskBtn.setPrefSize(100, 50);
        enterTaskBtn.setLayoutX(300);
        enterTaskBtn.setLayoutY(400);
        
        TextField taskTextbox = new TextField();
        taskTextbox.setLayoutX(150);
        taskTextbox.setLayoutY(100);
        taskTextbox.setText("Enter your Task....");
  
        
        DatePicker datePicker = new DatePicker();
        datePicker.setLayoutX(150);
        datePicker.setLayoutY(140);

        
        
        TextField descriptionTextbox = new TextField();
        descriptionTextbox.setLayoutX(150);
        descriptionTextbox.setLayoutY(180);    

        
        TextField subTasksTextbox = new TextField();
        subTasksTextbox.setLayoutX(150);
        subTasksTextbox.setLayoutY(220);

        
        TextField priorityTextbox = new TextField();
        priorityTextbox.setLayoutX(150);
        priorityTextbox.setLayoutY(260);

        
        Rectangle bottomBorder = new Rectangle(600, 20);
        bottomBorder.setLayoutX(0);
        bottomBorder.setLayoutY(580);
        bottomBorder.setFill(Color.DEEPSKYBLUE);
        
        enterTaskBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
             public void handle(ActionEvent event) {
              task = taskTextbox.getText();
              list.add(task);
              
              
            }
        });
        
       
        root.getChildren().add(logo);
        root.getChildren().add(enterTaskBtn);
        root.getChildren().add(taskTextbox);
        root.getChildren().add(datePicker);
        root.getChildren().add(descriptionTextbox);
        root.getChildren().add(subTasksTextbox);
        root.getChildren().add(priorityTextbox);
        root.getChildren().add(bottomBorder);
        
        newWindow.show();
    }
    
    
    public void listScreen(){
                   
        Stage newWindow = new Stage();
               
        newWindow.setHeight(300);
        newWindow.setWidth(300);
 
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);
        
        newWindow.setTitle("List Screen");
        newWindow.setScene(scene);
        
        Image image = new Image("resources/logo.png");  
      
      //Setting the image view 
      ImageView logo = new ImageView(image); 
      
      //Setting the position of the image 
      logo.setX(0); 
      logo.setY(0); 
      
      //setting the fit height and width of the image view 
      logo.setFitHeight(50); 
      logo.setFitWidth(50); 
      
      //Setting the preserve ratio of the image view 
      logo.setPreserveRatio(true);  
      
       Button listBtn = new Button();
        listBtn.setText("Create List");
        listBtn.setLayoutX(150);
        listBtn.setLayoutY(100);
        
        TextField listTextbox = new TextField();
        listTextbox.setLayoutX(0);
        listTextbox.setLayoutY(100);
        listTextbox.setText("Enter New List....");
        
        Rectangle bottomBorder = new Rectangle(300, 10);
        bottomBorder.setLayoutX(0);
        bottomBorder.setLayoutY(255);
        bottomBorder.setFill(Color.DEEPSKYBLUE);
        
        
       root.getChildren().add(logo);
       root.getChildren().add(listBtn);
       root.getChildren().add(listTextbox);
       root.getChildren().add(bottomBorder);
      
      newWindow.show();
  
    }
    

    
}

