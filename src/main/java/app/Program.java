package app;

import data.Persistencia;
import views.MenuView;

public class Program {
    public static void main(String[] args) {
        Persistencia.inicializar();
        MenuView menu = new MenuView();
        menu.setVisible(true);
    }
}
