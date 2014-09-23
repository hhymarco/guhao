package org.hhymarco.guahao.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.hhymarco.guahao.http.HttpClientInstance;
import org.hhymarco.guahao.ocr.ImageOCR;

import java.io.ByteArrayInputStream;

public class Controller {
    @FXML
    private Text actiontarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
        String text = ImageOCR.getAllOcr(new ByteArrayInputStream(HttpClientInstance.getInstance().getYzmRes()));
        actiontarget.setText(text);
    }

}
