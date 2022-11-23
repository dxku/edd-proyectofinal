package com.edd;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONObject;

public class Login {
    private Boolean isLoggedIn = false;
    private Database database = new Database();
    private JSONObject account;
    public Login() {
        loginScreen();
    }
    
    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    private void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    public JSONObject getAccount() {
        return account;
    }
    private void setAccount(JSONObject account) {
        this.account = account;
    }

    private void loginScreen() {
        JTextArea countWarning = new JTextArea();
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);

        
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Usuario:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Contraseña:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(countWarning);
        int result;
        Boolean flag = true;
        int count = 0;
        do {
            if(count > 0) {
                countWarning.setText("Intentos restantes: " + (5 - count));
            }
            result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Por favor ingrese su usuario y contraseña.", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                for (int i = 0; i < database.getUsers().length(); i++) {
                    if(database.getUsers().getJSONObject(i).get("user").equals(xField.getText()) && 
                        database.getUsers().getJSONObject(i).get("passwd").equals(yField.getText())){
                        
                        flag = false;
                        setIsLoggedIn(true);
                        setAccount(database.getUsers().getJSONObject(i));

                    }
                    count++;
                }
            }else{
                System.exit(200);
            }
        } while (flag && count < 5);
    }

}
