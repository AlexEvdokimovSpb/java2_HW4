package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {

    @FXML
    private TextArea textOutputData;
    @FXML
    private TextArea textCalculateData;
    @FXML
    private TextField enterYouAge;
    @FXML
    private TextField enterPulseRest;

    private int pulseRest;
    private int youAge;
    private float youMaxPulse;

    private float youPulseZona1;
    private float youPulseZona2;
    private float youPulseZona3;
    private float youPulseZona4;
    private float youPulseZona5;

    final private float A = 205.8f;
    final private float B = 0.685f;

    final private float ZONA1 = 0.5f;
    final private float ZONA2 = 0.6f;
    final private float ZONA3 = 0.7f;
    final private float ZONA4 = 0.8f;
    final private float ZONA5 = 0.9f;

    public void onEnterYouAge (ActionEvent actionEvent) {
        textOutputData.appendText("Ваш возраст: " + enterYouAge.getText()+'\n');
        enterYouAge.requestFocus();
        youAge = Integer.parseInt(enterYouAge.getText());
        System.out.println(youAge);
        enterYouAge.clear();
    }

    public void onEnterPulseRest (ActionEvent actionEvent) {
        textOutputData.appendText("Ваш пульс в состоянии покоя: " + enterPulseRest.getText()+'\n');
        enterPulseRest.requestFocus();
        pulseRest = Integer.parseInt(enterPulseRest.getText());
        System.out.println(pulseRest);
        enterPulseRest.clear();
    }

    public void onCalculatePulseArea (ActionEvent actionEvent) {
        textCalculateData.clear();

        youMaxPulse = A - (B*youAge);
        youPulseZona1 = (youMaxPulse-pulseRest)*ZONA1+pulseRest;
        youPulseZona2 = (youMaxPulse-pulseRest)*ZONA2+pulseRest;
        youPulseZona3 = (youMaxPulse-pulseRest)*ZONA3+pulseRest;
        youPulseZona4 = (youMaxPulse-pulseRest)*ZONA4+pulseRest;
        youPulseZona5 = (youMaxPulse-pulseRest)*ZONA5+pulseRest;

//        System.out.println((int)youMaxPulse + " "+ (int)youPulseZona1 + " "+ (int)youPulseZona2 + " "
//                + (int)youPulseZona3 + " "+ (int)youPulseZona4 + " "+ (int)youPulseZona5);

        textCalculateData.appendText("Максимальный пульс: " + (int)youMaxPulse+'\n');

        textCalculateData.appendText("Зона 1: от " + (int)youPulseZona1 + " до "+ (int)youPulseZona2 +'\n');
        textCalculateData.appendText("Разминка и востановление "+'\n'+'\n');

        textCalculateData.appendText("Зона 2: от " + (int)youPulseZona2 + " до "+ (int)youPulseZona3 +'\n');
        textCalculateData.appendText("Оптимально сжигает калории "+'\n'+'\n');

        textCalculateData.appendText("Зона 3: от " + (int)youPulseZona3 + " до "+ (int)youPulseZona4 +'\n');
        textCalculateData.appendText("Аэробная. Разитие выносливости и сердца. "+'\n'+'\n');

        textCalculateData.appendText("Зона 4: от " + (int)youPulseZona4 + " до "+ (int)youPulseZona5 +'\n');
        textCalculateData.appendText("Анаэробная. Разитие скорости и силы. "+'\n'+'\n');

        textCalculateData.appendText("Зона 5: от " + (int)youPulseZona5 + " до "+ (int)youMaxPulse +'\n');
        textCalculateData.appendText("Максимальная. Не более 5% от тренировки"+'\n'+'\n');
    }

}
