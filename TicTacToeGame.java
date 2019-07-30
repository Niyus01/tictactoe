package tictactoegame;
/**
 * @author 
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

public class TicTacToeGame extends Application {
 // Indicate which player has a turn, initially it is the X player

   
      // Indicate which player has a turn, initially it is the X player
  private char player = 'X';
  private char comp = 'O';
  private int turn= 0; 
 
  
  // Create and initialize cell
  private Cell[][] cell =  new Cell[3][3];
  
  // Create and initialize a status label
  private Label lblStatus = new Label("X's turn to play");
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Pane to hold cell
    GridPane pane = new GridPane(); 
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        pane.add(cell[i][j] = new Cell(), j, i);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(lblStatus);
      
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 450, 250);
    primaryStage.setTitle("TicTacToe"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage   
  }
  
  /** Determine if the cell are all occupied */
  public boolean isFull() {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (cell[i][j].getToken() == ' ')
          return false;
  
    return true;
  }
  
  /** Determine if the player with the specified token wins */
  public boolean isWon(char token) {
    for (int i = 0; i < 3; i++)
      if (cell[i][0].getToken() == token
          && cell[i][1].getToken() == token
          && cell[i][2].getToken() == token) {
        return true;
      }
  
    for (int j = 0; j < 3; j++)
      if (cell[0][j].getToken() ==  token
          && cell[1][j].getToken() == token
          && cell[2][j].getToken() == token) {
        return true;
      }
  
    if (cell[0][0].getToken() == token 
        && cell[1][1].getToken() == token        
        && cell[2][2].getToken() == token) {
      return true;
    }
  
    if (cell[0][2].getToken() == token
        && cell[1][1].getToken() == token
        && cell[2][0].getToken() == token) {
      return true;
    }
  
    return false;
  }
  
  /** Determine if the player has 2 x in the same row  */
  public boolean block(char token) {
   
      if (cell[0][0].getToken() == token
          && cell[1][0].getToken() == token
          && cell[2][0].getToken() == ' ') {
        //   System.out.println("set 2,0");
       cell[2][0].setToken(comp);
       return true;
      }
      else if (cell[0][0].getToken() == token
          && cell[1][0].getToken() == ' '
          && cell[2][0].getToken() == token) {
       cell[1][0].setToken(comp);
       return true;
      // System.out.println("set 1,0");
      }
      else if (cell[0][0].getToken() == ' '
          && cell[1][0].getToken() == token
          && cell[2][0].getToken() == token) {
       cell[0][0].setToken(comp);
       return true;
      // System.out.println("set 0,0");
      }
       else if (cell[0][1].getToken() == token 
             && cell[1][1].getToken() == token 
               &&  cell[2][1].getToken() == ' ') {
            cell[2][1].setToken(comp);
            return true;
            //System.out.println("set 2,1");
      }
    /*  else if (cell[0][1].getToken() == token
          && cell[1][1].getToken() == ' '
          && cell[2][1].getToken() == token) {
       cell[1][1].setToken(comp);
       System.out.println("set 1,1");
      }*/
      else if (cell[0][1].getToken() == ' '
          && cell[1][1].getToken() == token
          && cell[2][1].getToken() == token) {
       cell[0][1].setToken(comp);
       return true;
      // System.out.println("set 0,1");
      }
      else if (cell[0][2].getToken() == token
          && cell[1][2].getToken() == token
          && cell[2][2].getToken() == ' ') {
       cell[2][2].setToken(comp);
       return true;
      // System.out.println("set 2,2");
      }
      else if (cell[0][2].getToken() == token
          && cell[1][2].getToken() == ' '
          && cell[2][2].getToken() == token) {
       cell[1][2].setToken(comp);
       return true;
      // System.out.println("set 1,2");
      }
      else if (cell[0][2].getToken() == ' '
          && cell[1][2].getToken() == token
          && cell[2][2].getToken() == token) {
       cell[0][2].setToken(comp);
       return true;
      // System.out.println("set 0,2");
      }
      else if (cell[0][0].getToken() == token
          && cell[0][1].getToken() == token
          && cell[0][2].getToken() == ' ') {
       cell[0][2].setToken(comp);
       return true;
      // System.out.println("set 0,2");
      }
      else if (cell[0][0].getToken() == token
          && cell[0][1].getToken() == ' '
          && cell[0][2].getToken() == token) {
       cell[0][1].setToken(comp);
       return true;
     //  System.out.println("set 0,1");
      }
      else if (cell[0][0].getToken() == ' '
          && cell[0][1].getToken() == token
          && cell[0][2].getToken() == token) {
       cell[0][0].setToken(comp);
       return true;
     //  System.out.println("set 0,0");
      }
       else if (cell[1][0].getToken() == ' '
          && cell[1][1].getToken() == token
          && cell[1][2].getToken() == token) {
       cell[1][0].setToken(comp);
       return true;
     //  System.out.println("set 1,0");
      }
     /* else if (cell[1][0].getToken() == token
          && cell[1][1].getToken() == ' '  // never [1][1] will be empty
          && cell[1][2].getToken() == token) { 
       cell[1][1].setToken(comp);
     //  System.out.println("set 1,1");
      }*/
      else if (cell[1][0].getToken() == token
          && cell[1][1].getToken() == token
          && cell[1][2].getToken() == ' ') {
       cell[1][2].setToken(comp);
       return true;
       //System.out.println("set 1,2");
      }   
     
      else if (cell[2][0].getToken() == token
          && cell[2][1].getToken() == token
          && cell[2][2].getToken() == ' ') {
       cell[2][2].setToken(comp);
       return true;
      // System.out.println("set 2,2");
      }
      else if (cell[2][0].getToken() == token
          && cell[2][1].getToken() == ' '
          && cell[2][2].getToken() == token) {
       cell[2][1].setToken(comp);
       return true;
      // System.out.println("set 2,1");
      }
      else if (cell[2][0].getToken() == ' '
          && cell[2][1].getToken() == token
          && cell[2][2].getToken() == token) {
       cell[2][0].setToken(comp);
       return true;
      // System.out.println("set 2,0");
      }
      
      else if (cell[2][0].getToken() == token
          && cell[1][1].getToken() == token
          && cell[0][2].getToken() == ' ') {
       cell[0][2].setToken(comp);
       return true;
      // System.out.println("set 0,2");
      }
      else if (cell[2][0].getToken() == ' '
          && cell[1][1].getToken() == token
          && cell[0][2].getToken() == token) {
       cell[2][0].setToken(comp);
       return true;
      // System.out.println("set 2,0");
      }
      else if (cell[2][0].getToken() == token
          && cell[1][1].getToken() == ' '
          && cell[0][2].getToken() == token) {
       cell[1][1].setToken(comp);
       return true;
     //  System.out.println("set 1,1");
      }      
      else if (cell[0][0].getToken() == ' '
          && cell[1][1].getToken() == token
          && cell[2][2].getToken() == token) {
       cell[0][0].setToken(comp);
       return true;
       //System.out.println("set 0,0");
      }
      else if (cell[0][0].getToken() == token
          && cell[1][1].getToken() == ' '
          && cell[2][2].getToken() == token) {
       cell[1][1].setToken(comp);
       return true;
     //  System.out.println("set 1,1");
      }
      else if (cell[0][0].getToken() == token
          && cell[1][1].getToken() == token
          && cell[2][2].getToken() == ' ') {
       cell[2][2].setToken(comp);
       return true;
     //  System.out.println("set 2,2");
      }   
     
      
      
      else if(token==player)  {
             
           randomTurn();
     
      }
      return false;
  }
  
  
  public void randomTurn(){
      int min = 0;
      int max = 2;
      int range = max - min + 1;
      int i =1;
      int j =1;
   
        if (cell[i][j].getToken() == ' ') {
              cell[1][1].setToken(comp);
              
       }else{
             while(cell[i][j].getToken() != ' '){
       
            i = (int)(Math.random() * range) + min;
            j = (int)(Math.random() * range) + min;
             }
           
              cell[i][j].setToken(comp);
            
           }
           
        }
  
  // An inner class for a cell
  public class Cell extends Pane {
    // Token used for this cell
    private char token = ' ';
  
    public Cell() {
      setStyle("-fx-border-color: black"); 
      this.setPrefSize(2000, 2000);
      this.setOnMouseClicked(e -> playerTurn());
    }
   
  
    /** Return token */
    public char getToken() {
      return token;
    }
  
    /** Set a new token */
    public void setToken(char c) {
      token = c;
        
      if (token == 'X') {
        Line line1 = new Line(10, 10, 
          this.getWidth() - 10, this.getHeight() - 10);
        line1.endXProperty().bind(this.widthProperty().subtract(10));
        line1.endYProperty().bind(this.heightProperty().subtract(10));
        line1.setStroke(Color.ORANGE);
        Line line2 = new Line(10, this.getHeight() - 10, 
          this.getWidth() - 10, 10);
        line2.startYProperty().bind(
          this.heightProperty().subtract(10));
        line2.endXProperty().bind(this.widthProperty().subtract(10));
        line2.setStroke(Color.ORANGE);
          
        // Add the lines to the pane
        this.getChildren().addAll(line1, line2); 
      }
      else if (token == 'O') {
        Ellipse ellipse = new Ellipse(this.getWidth() / 2, 
          this.getHeight() / 2, this.getWidth() / 2 - 10, 
          this.getHeight() / 2 - 10);
        ellipse.centerXProperty().bind(
          this.widthProperty().divide(2));
        ellipse.centerYProperty().bind(
            this.heightProperty().divide(2));
        ellipse.radiusXProperty().bind(
            this.widthProperty().divide(2).subtract(10));        
        ellipse.radiusYProperty().bind(
            this.heightProperty().divide(2).subtract(10));   
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITE);
          
        getChildren().add(ellipse); // Add the ellipse to the pane
      }
    }
     
 
 
   private boolean compTurn(int again) {
      
      
      if (again ==1) 
      {
         
      //if the corner is empty put O in the center
      randomTurn();
      
      } 
      if(!block(comp)){
      if (again >= 2){
     
      block(player);}}
      
       if (isWon(comp)) {
             
                lblStatus.setText(comp + " won! The game is over");
                comp = ' '; // Game is over
                player=' ';// // When the computer won
              }
              else if (isFull()) {
                lblStatus.setText("Draw! The game is over");
                comp = ' '; // Game is over
                player=' ';
              }
       
       return false;
   }
   
   
   
    /* Handle a mouse click event */
   
  
    private boolean playerTurn() {
        // If cell is empty and game is not over
       if (token == ' ' && player != ' ') {
          setToken(player); // Set token in the cell
  
          // Check game status
          if (isWon(player)) {
            lblStatus.setText(player + " won! The game is over");
            player = ' '; // Game is over
          }
          else if (isFull()) {
            lblStatus.setText("Draw! The game is over");
            player = ' '; // Game is over
          }
          else {
              turn = turn +1 ;
              compTurn(turn);
          }
      }
       
        return false;
    }

       
}
    
  
  public static void main(String[] args) {
    launch(args);
    }
}

