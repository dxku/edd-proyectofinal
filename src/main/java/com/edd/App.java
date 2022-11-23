package com.edd;

import javax.swing.JOptionPane;

public class App 
{
    private static Login login;
    public static void main( String[] args )
    {
        login = new Login();
        if(!login.getIsLoggedIn()){
            System.exit(403);
        }
        menu();
        
    }

    private static void menu(){
        Boolean flag = true;
        String option;
        int optionNumber = 0;
        do {
            option = JOptionPane.showInputDialog("¡Bienvenido! Seleccione una opción: \n 1. Listado de materias. \n 2. Profesores asignados. \n 3. Horarios. \n 4. Salir.");
            try {
                optionNumber = Integer.valueOf(option);
            } catch (Exception e) {
                optionNumber = 0;
                e.printStackTrace();
            }
            if(optionNumber == 4){
                System.exit(200);
            }
            if (optionNumber == 0 || optionNumber > 4) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción válida.");
            }
            loadOption(optionNumber);
        } while (flag);
		
    }
    private static void loadOption(int option){
        switch (option) {
            case 1:
                materias();
                break;
            case 2:
                profesores();
                break;
            case 3:
                horarios();
                break;
        }
    }
    private static void materias() {
        String toShow = "";
        for (int i = 0; i < login.getAccount().getJSONArray("materias").length(); i++) {
            toShow += (i+1)+". "+login.getAccount().getJSONArray("materias").getJSONObject(i).getString("name")+"\n";
        }
        JOptionPane.showMessageDialog(null, toShow);
    }

    private static void profesores() {
        String toShow = "";
        for (int i = 0; i < login.getAccount().getJSONArray("materias").length(); i++) {
            toShow += (i+1)+". "+login.getAccount().getJSONArray("materias").getJSONObject(i).getString("name")+": "+login.getAccount().getJSONArray("materias").getJSONObject(i).getString("profesor")+"\n";
        }
        JOptionPane.showMessageDialog(null, toShow);
    }
    private static void horarios() {
        String toShow = "";
        for (int i = 0; i < login.getAccount().getJSONArray("materias").length(); i++) {
            toShow += (i+1)+". "+login.getAccount().getJSONArray("materias").getJSONObject(i).getString("name")+": "+login.getAccount().getJSONArray("materias").getJSONObject(i).getString("horario")+"\n";
        }
        JOptionPane.showMessageDialog(null, toShow);
    }
}
