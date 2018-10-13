package library.management.system.ca;

import Database.Database;
import Database.Book;
import Database.Borrow;
import Database.Person;
import Database.Returns;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LibraryManagementSystemCA extends Application {

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

        TextField tfname = new TextField();
        TextField tfroll = new TextField();
        TextField tfadd = new TextField();

        Label person_name = new Label("NAME: ");
        Label person_roll = new Label("email:  ");
        Label person_add = new Label("ADDRESS: ");

        TabPane tb = new TabPane();
        Tab tab1 = new Tab("PERSON");

        Database d = new Database();
        Connection con = d.openConnection();

        Button btn1 = new Button("SUBMIT");

        GridPane gp = new GridPane();
        gp.add(person_name, 0, 0);
        gp.add(tfname, 1, 0);
        gp.add(person_roll, 0, 1);
        gp.add(tfroll, 1, 1);
        gp.add(person_add, 0, 2);
        gp.add(tfadd, 1, 2);
        gp.add(btn1, 1, 3);
        gp.setHgap(30);
        gp.setVgap(10);
        tab1.setContent(gp);
        tb.getTabs().add(tab1);

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String personName = tfname.getText();
                String personRoll = tfroll.getText();
                String personAdd = tfadd.getText();
                try {
                    Person.insertPerson(personName, personRoll, personAdd, con);
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementSystemCA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        TextField tfBookName = new TextField();
        TextField tfISBN = new TextField();
        TextField tfAuth = new TextField();
        TextField tfPubG = new TextField();

        Label book_name = new Label("NAME: ");
        Label book_isbn = new Label("ISBN: ");
        Label book_auth = new Label("AUTHOR: ");
        Label book_pub = new Label("PUBLISHER: ");

        Button btn2 = new Button("SUBMIT");

        Tab tab2 = new Tab("BOOK");
        GridPane gp1 = new GridPane();
        gp1.add(book_name, 0, 0);
        gp1.add(tfBookName, 1, 0);
        gp1.add(book_isbn, 0, 1);
        gp1.add(tfISBN, 1, 1);
        gp1.add(book_auth, 0, 2);
        gp1.add(tfAuth, 1, 2);
        gp1.add(book_pub, 0, 3);
        gp1.add(tfPubG, 1, 3);
        gp1.add(btn2, 1, 4);
        gp1.setHgap(30);
        gp1.setVgap(10);
        tab2.setContent(gp1);
        tb.getTabs().add(tab2);

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String bookName = tfBookName.getText();
                String isbn = tfISBN.getText();
                String author = tfAuth.getText();
                String publisher = tfPubG.getText();
                try {
                    Book.insertBook(bookName, isbn, author, publisher, con);
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementSystemCA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        TextField p_name = new TextField();
        TextField bk_name = new TextField();

        Label per_id = new Label("Person id: ");
        Label bok_id = new Label("book id: ");
        Label borrow_id = new Label("borrows id : ");

        Button btn3 = new Button("SUBMIT");



        Tab tab3 = new Tab("BORROW A BOOK");
        GridPane gp2 = new GridPane();
        gp2.add(per_id, 0, 0);
        gp2.add(p_name, 1, 0);
        gp2.add(bok_id, 0, 1);
        gp2.add(bk_name, 1, 1);
        gp2.add(borrow_id, 0, 2);

        gp2.add(btn3, 1, 3);
        gp2.setHgap(30);
        gp2.setVgap(10);
        tab3.setContent(gp2);
        tb.getTabs().add(tab3);

        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int pId = Integer.parseInt(per_id.getText());
                int bor_id = Integer.parseInt(borrow_id.getText());
                try {
                    Borrow.insertBorrow(pId, bor_id, con);
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementSystemCA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        TextField pe_name = new TextField();
        TextField bkk_name = new TextField();
        TextField tfBorrowId = new TextField();

        Label persId = new Label("PERSON ID: ");
        Label boookId = new Label("BOOK ID: ");
        Label borrowID = new Label("Enter Borrow ID: ");
        Label return_d = new Label("RETURNED ON: ");

        Button btn4 = new Button("SUBMIT");



        Tab tab4 = new Tab("RETURN A BOOK");
        GridPane gp3 = new GridPane();
        gp3.add(persId, 0, 0);
        gp3.add(pe_name, 1, 0);
        gp3.add(boookId, 0, 1);
        gp3.add(bkk_name, 1, 1);
        gp3.add(return_d, 0, 2);
        gp3.add(borrowID,0,3);
        gp3.add(tfBorrowId, 1, 3);

        gp3.add(btn4, 1, 3);
        gp3.setHgap(30);
        gp3.setVgap(10);
        tab4.setContent(gp3);
        tb.getTabs().add(tab4);
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                int borrowIDD = Integer.parseInt(tfBorrowId.getText()); 
                try {
                    Returns.insertReturns(borrowIDD, con);
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementSystemCA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(tb);

        Scene scene = new Scene(root, 1000, 500);

        primaryStage.setTitle("MyLibraryManagementSystemCA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
