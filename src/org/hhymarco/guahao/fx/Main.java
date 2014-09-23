package org.hhymarco.guahao.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.hhymarco.guahao.http.HttpClientInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HttpClient client = HttpClientInstance.getInstance().getClient();
        HttpMethod method = new GetMethod("http://guahao.zjol.com.cn/VerifyCodeCH.aspx");
        client.executeMethod(method);
        byte[] body = method.getResponseBody();
        HttpClientInstance.getInstance().setYzmRes(body);
        InputStream inputStream = new ByteArrayInputStream(body);

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("挂号");
        Scene scene=new Scene(root, 300, 275);
        ImageView imageView = (ImageView)scene.lookup("#yzm");
        Image image = new Image(inputStream);
        imageView.setImage(image);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
