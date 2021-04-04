package com.AWT;

import java.awt.*;
import java.awt.event.*;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main(){ // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args){
        Main  myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showCheckBoxGroupDemo(); // и вызываемый метод showCheckBoxGroupDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI(){
        mainFrame = new Frame("Java AWT CheckboxGroup");  // инициализация фрэйма
        mainFrame.setSize(400,400); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener( new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent){ // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350,100);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в Checkbox
    private void showCheckBoxGroupDemo(){
        headerLabel.setText("Контрол в действии: Label (headerLabel)");

        CheckboxGroup fruitGroup = new CheckboxGroup(); // создание CheckboxGroup

        // -------------------------------------------- создание радио кнопок (Checkbox)
        Checkbox chkApple = new Checkbox("Яблоко",fruitGroup,true);
        Checkbox chkMango = new Checkbox("Манго",fruitGroup,false);
        Checkbox chkPeer = new Checkbox("Курага",fruitGroup,false);

        statusLabel.setText("Контрол в действии: Label (statusLabel)");

        //------------------------события
        chkApple.addItemListener(new ItemListener() {// обработка событий
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Яблоко Checkbox: нажат");
            }
        });
        chkMango.addItemListener(new ItemListener() {// обработка событий
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Манго Checkbox: нажат");
            }
        });
        chkPeer.addItemListener(new ItemListener() {// обработка событий
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Курага Checkbox: нажат");
            }
        });

        // добавление объектов на форму
        controlPanel.add(chkApple);
        controlPanel.add(chkMango);
        controlPanel.add(chkPeer);

        // -------------------------------------------- создание кнопоки (Checkbox)
        Checkbox chkLime = new Checkbox("Лайм");

        //------------------------события
        chkLime.addItemListener(new ItemListener() {// обработка событий
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Лайм Checkbox: " // проверка
                        + (e.getStateChange()==1?"нажат":"не нажат"));
            }
        });

        // добавление объектов на форму
        controlPanel.add(chkLime);

        mainFrame.setVisible(true); // видимость формы true
    }
}
