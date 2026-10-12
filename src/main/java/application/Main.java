package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import java.util.Random;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Pane coriandoli = new Pane();
			coriandoli.setMouseTransparent(true);

			StackPane livelli = new StackPane(root, coriandoli);
			Scene scene = new Scene(livelli, 800, 800);
			AudioClip applauso = new AudioClip(
				    getClass().getResource("applauso.wav").toExternalForm()
				);
			
			Button bottone = new Button("Premimi");
			root.setCenter(bottone);
			
			bottone.setOnAction(evento -> {
				applauso.play();
				Alert messaggio = new Alert(Alert.AlertType.INFORMATION);
				messaggio.setTitle("Complimenti");
				messaggio.setHeaderText(null);
				messaggio.setContentText("BRAVO! SEI UN GRANDE!!!");
				messaggio.initOwner(primaryStage);
				
				Random casuale = new Random();

				for (int i = 0; i < 100; i++) {
				    Rectangle coriandolo = new Rectangle(10, 16);

				    coriandolo.setFill(Color.hsb(casuale.nextInt(360), 0.8, 1.0));
				    coriandolo.setX(casuale.nextDouble() * coriandoli.getWidth());
				    coriandolo.setY(-20);

				    TranslateTransition caduta = new TranslateTransition(
				        Duration.seconds(2 + casuale.nextDouble()),
				        coriandolo
				    );

				    caduta.setToY(coriandoli.getHeight() + 40);
				    caduta.setOnFinished(eventoFine -> {
				        coriandoli.getChildren().remove(coriandolo);
				    });

				    coriandoli.getChildren().add(coriandolo);
				    caduta.play();
				}
				
				messaggio.showAndWait();
			    System.out.println("Bravo, hai premuto il bottone");
			});
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Primo bottone");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
