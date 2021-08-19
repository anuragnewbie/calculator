/*
    NAME - ANURAG CHATTERJEE
    PROJECT - A CALCULATOR USING JAWA AWT
    DEVELOPED IN VSCODE EDITOR
    DATE - 19/08/2021
*/

import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class Calculator extends Frame implements ActionListener{
    Button [] b = new Button[10];
    Button bsum, bminus, bmul, bdiv, bmod, bpow, bequals, bclear;
    TextField t;
    Panel p;
    int choice=0, firstValue=0, secondValue=0;

    Calculator(){
        t = new TextField(25);
        t.setBackground(Color.LIGHT_GRAY);
        t.setEditable(false);
        add(t);

        p = new Panel();
        p.setBackground(Color.DARK_GRAY);
        p.setLayout(new GridLayout(6, 6, 12, 10));

        for(int i=0; i<10; i++){
            b[i] = new Button(String.valueOf(i));
            b[i].addActionListener(this);
            b[i].setBackground(Color.LIGHT_GRAY);
            p.add(b[i]);
        }

        bsum = new Button(" + ");
        bsum.addActionListener(this);
        bsum.setBackground(Color.LIGHT_GRAY);

        bminus = new Button(" - ");
        bminus.addActionListener(this);
        bminus.setBackground(Color.LIGHT_GRAY);

        bmul = new Button(" * ");
        bmul.addActionListener(this);
        bmul.setBackground(Color.LIGHT_GRAY);

        bdiv = new Button(" / ");
        bdiv.addActionListener(this);
        bdiv.setBackground(Color.LIGHT_GRAY);

        bmod = new Button(" % ");
        bmod.addActionListener(this);
        bmod.setBackground(Color.LIGHT_GRAY);

        bpow = new Button(" ^ ");
        bpow.addActionListener(this);
        bpow.setBackground(Color.LIGHT_GRAY);

        bclear = new Button(" CLR ");
        bclear.addActionListener(this);
        bclear.setBackground(Color.LIGHT_GRAY);

        bequals = new Button(" = ");
        bequals.addActionListener(this);
        bequals.setBackground(Color.LIGHT_GRAY);

        p.add(bsum);
        p.add(bminus);
        p.add(bmul);
        p.add(bdiv);
        p.add(bmod);
        p.add(bpow);
        p.add(bclear);
        p.add(bequals);

        add(p);
        setTitle("CALCULATOR");
        setSize(300, 300);
        setLayout(new FlowLayout());
        setVisible(true);
        setResizable(false);
        setBackground(Color.DARK_GRAY);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    static int settings(TextField t, int f){
        f = Integer.parseInt(t.getText());
        t.setText("");
        return f;
    }

    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == b[0])
            t.setText(t.getText() + String.valueOf(0)); 
          
        if(ev.getSource() == b[1])
            t.setText(t.getText() + String.valueOf(1));

        if(ev.getSource() == b[2])
            t.setText(t.getText() + String.valueOf(2));

        if(ev.getSource() == b[3])
            t.setText(t.getText() + String.valueOf(3)); 

        if(ev.getSource() == b[4])
            t.setText(t.getText() + String.valueOf(4));

        if(ev.getSource() == b[5])
            t.setText(t.getText() + String.valueOf(5));

        if(ev.getSource() == b[6])
            t.setText(t.getText() + String.valueOf(6));

        if(ev.getSource() == b[7])
            t.setText(t.getText() + String.valueOf(7));

        if(ev.getSource() == b[8])
            t.setText(t.getText() + String.valueOf(8));

        if(ev.getSource() == b[9])
            t.setText(t.getText() + String.valueOf(9)); 
                                                                                                                                                              
        if(ev.getSource() == bsum){
            firstValue = settings(t, firstValue);
            choice = 1;
        }

        if(ev.getSource() == bminus){
            firstValue = settings(t, firstValue);
            choice = 2;
        }

        if(ev.getSource() == bmul){
            firstValue = settings(t, firstValue);
            choice = 3;
        }

        if(ev.getSource() == bdiv){
            firstValue = settings(t, firstValue);
            choice = 4;
        }

        if(ev.getSource() == bmod){
            firstValue = settings(t, firstValue);
            choice = 5;
        }

        if(ev.getSource() == bpow){
            firstValue = settings(t, firstValue);
            choice = 6;
        }

        if(ev.getSource() == bequals){
            secondValue = Integer.parseInt(t.getText());

            switch (choice) {
                case 1: t.setText(String.valueOf(firstValue+secondValue)); break;
                case 2: t.setText(String.valueOf(firstValue-secondValue)); break;
                case 3: t.setText(String.valueOf(firstValue*secondValue)); break;
                case 4 : case 5: try {
                            if(choice == 4){
                                if(secondValue==0){
                                    t.setText(String.valueOf(firstValue/secondValue));
                                }else{
                                    t.setText(String.valueOf((float)firstValue/secondValue));
                                }
                            } else if(choice==5){
                                t.setText(String.valueOf(firstValue%secondValue));
                            }
                        } catch (ArithmeticException e) {
                            t.setText("Cannot divide by 0!");
                        }
                        break;
                case 6: t.setText(String.valueOf((int)Math.pow(firstValue, secondValue))); break;         
                default: t.setText("Invalid Choice!");
            }
        }

        if(ev.getSource() == bclear){
            t.setText("");
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
