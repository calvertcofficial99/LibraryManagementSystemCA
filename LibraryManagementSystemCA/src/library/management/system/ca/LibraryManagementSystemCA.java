
package library.management.system.ca;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LibraryManagementSystemCA extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        
                //Code for person tab:

        TextField name = new TextField();
        TextField roll = new TextField();
        TextField add = new TextField();

        Label person_name = new Label("NAME: ");
        Label person_roll = new Label("ROLL NO: ");
        Label person_add = new Label("ADDRESS: ");

        TabPane tb = new TabPane();
        Tab tab1 = new Tab("PERSON");

        Button btn1 = new Button("SUBMIT");
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                 
            }
        });
        
        GridPane gp = new GridPane();
        gp.add(person_name, 0, 0);
        gp.add(name, 1, 0);
        gp.add(person_roll, 0, 1);
        gp.add(roll, 1, 1);
        gp.add(person_add, 0, 2);
        gp.add(add, 1, 2);
        gp.add(btn1, 1, 3);
        gp.setHgap(30);
        gp.setVgap(10);
        tab1.setContent(gp);
        tb.getTabs().add(tab1);

                //Code for book tab:
                
                
        TextField b_name = new TextField();
        TextField b_isbn = new TextField();
        TextField b_auth = new TextField();
        TextField b_pub = new TextField();

        Label book_name = new Label("NAME: ");
        Label book_isbn = new Label("ISBN: ");
        Label book_auth = new Label("AUTHOR: ");
        Label book_pub = new Label("PUBLISHER: ");

        Button btn2 = new Button("SUBMIT");

        Tab tab2 = new Tab("BOOK");
        GridPane gp1 = new GridPane();
        gp1.add(book_name, 0, 0);
        gp1.add(b_name, 1, 0);
        gp1.add(book_isbn, 0, 1);
        gp1.add(b_isbn, 1, 1);
        gp1.add(book_auth, 0, 2);
        gp1.add(b_auth, 1, 2);
        gp1.add(book_pub, 0, 3);
        gp1.add(b_pub, 1, 3);
        gp1.add(btn2, 1, 4);
        gp1.setHgap(30);
        gp1.setVgap(10);
        tab2.setContent(gp1);
        tb.getTabs().add(tab2);

                //Code for borrow tab:
                
                
        TextField p_name = new TextField();
        TextField bk_name = new TextField();

        Label per_name = new Label("NAME: ");
        Label bok_name = new Label("BOOK NAME: ");
        Label borrow_d = new Label("BORROWED ON:");

        Button btn3 = new Button("SUBMIT");

        DatePicker dp = new DatePicker();

        Tab tab3 = new Tab("BORROW A BOOK");
        GridPane gp2 = new GridPane();
        gp2.add(per_name, 0, 0);
        gp2.add(p_name, 1, 0);
        gp2.add(bok_name, 0, 1);
        gp2.add(bk_name, 1, 1);
        gp2.add(borrow_d, 0, 2);
        gp2.add(dp, 1, 2);
        gp2.add(btn3, 1, 3);
        gp2.setHgap(30);
        gp2.setVgap(10);
        tab3.setContent(gp2);
        tb.getTabs().add(tab3);

                //Code for return tab:
        TextField pe_name = new TextField();
        TextField bkk_name = new TextField();

        Label pers_name = new Label("NAME: ");
        Label boook_name = new Label("BOOK NAME: ");
        Label return_d = new Label("RETURNED ON:");

        Button btn4 = new Button("SUBMIT");

        DatePicker dp1 = new DatePicker();

        Tab tab4 = new Tab("RETURN A BOOK");
        GridPane gp3 = new GridPane();
        gp3.add(pers_name, 0, 0);
        gp3.add(pe_name, 1, 0);
        gp3.add(boook_name, 0, 1);
        gp3.add(bkk_name, 1, 1);
        gp3.add(return_d, 0, 2);
        gp3.add(dp1, 1, 2);
        gp3.add(btn4, 1, 3);
        gp3.setHgap(30);
        gp3.setVgap(10);
        tab4.setContent(gp3);
        tb.getTabs().add(tab4);

        StackPane root = new StackPane();
        root.getChildren().add(tb);
        

                

                
        Scene scene = new Scene(root, 1000, 500);

        primaryStage.setTitle("MyLibraryManagementSystemCA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
