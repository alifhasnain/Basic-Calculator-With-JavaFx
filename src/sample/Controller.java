package sample;

/**
 *
 * @author Niloy
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller {

    @FXML
    private Label myLabel;

    @FXML
    private Label opLabel;

    private String num1 = "";
    private String num2 = "";
    private String operator = "";
    private String result = "";

    @FXML
    public void numberAction(ActionEvent myEvent)   {

        String temp = ((Button)myEvent.getSource()).getText();

        if(operator.isEmpty() && num2.isEmpty())  {
            num1 = num1 + temp;
            myLabel.setText(num1);
        }
        else {
            num2 += temp;
            myLabel.setText(num2);
            opLabel.setText("");
        }
    }

    @FXML
    public void operatorAction(ActionEvent myEvent)   {

        String temp = ((Button) myEvent.getSource()).getText();

        if(operator.isEmpty())  {
            if(temp.equals("√"))    {
                Double root = Double.parseDouble(num1);
                root = Math.sqrt(root);
                result = Double.toString(root);
                num1 = Double.toString(root);
                myLabel.setText(result);
            }
            else    {
                opLabel.setText(temp);
                operator = temp;
            }
        }
        else {

            Double x = Double.parseDouble(num1), y = Double.parseDouble(num2);

            switch (operator)
            {
                case "+":
                    result = Double.toString(x+y);
                    myLabel.setText(result);
                    opLabel.setText(temp);
                    num1 = result;
                    num2 = "";
                    break;
                case "-":
                    result = Double.toString(x-y);
                    myLabel.setText(result);
                    opLabel.setText(temp);
                    num1 = result;
                    num2 = "";
                    break;
                case "x":
                    result = Double.toString(x*y);
                    myLabel.setText(result);
                    opLabel.setText(temp);
                    num1 = result;
                    num2 = "";
                    break;
                case "/":
                    result = Double.toString(x/y);
                    myLabel.setText(result);
                    opLabel.setText(temp);
                    num1 = result;
                    num2 = "";
                    break;
            }
            operator = temp;
        }

    }

    @FXML
    public void equalAction(ActionEvent myEvent)   {
        if(operator.isEmpty())
            myLabel.setText(num1);
        else    {

            Double x = Double.parseDouble(num1), y = Double.parseDouble(num2);

            switch (operator)
            {
                case "+":
                    result = Double.toString(x+y);
                    myLabel.setText(result);
                    break;
                case "-":
                    result = Double.toString(x-y);
                    myLabel.setText(result);
                    break;
                case "x":
                    result = Double.toString(x*y);
                    myLabel.setText(result);
                    break;
                case "/":
                    result = Double.toString(x/y);
                    myLabel.setText(result);
                    break;
            }
            num1 = result;
            num2 = "";
            operator = "";
            result = "";
            opLabel.setText("");
        }
    }

    @FXML
    public void acAction(ActionEvent myEvent)   {
        num1 = "";
        num2 = "";
        operator = "";
        result = "";
        myLabel.setText("");
        opLabel.setText("");
    }

    @FXML
    public void cAction(ActionEvent myEvent)   {
        if(num1.isEmpty() && num2.isEmpty() && operator.isEmpty())  {
            acAction(myEvent);
        }
        else if(!num2.isEmpty()) {
            num2 = num2.substring(0, num2.length() - 1);
            myLabel.setText(num2);
        }
        else if(num2.isEmpty() && !operator.isEmpty())  {
            operator = "";
            opLabel.setText("");
        }
        else {
            num1 = num1.substring(0, num1.length() - 1);
            myLabel.setText(num1);
        }
    }

    @FXML
    public void closeWindow(ActionEvent myEvent)    {
        System.exit(0);
    }

}
