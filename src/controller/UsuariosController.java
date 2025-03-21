package controller;

import model.UsuarioDAO;
import model.UsuarioDAO;
import views.login; 
import java.util.List;

public class UsuariosController {
    private UsuarioDAO usuarioDAO;
    private login loginView; // Aquí deberías usar la clase de vista correspondiente

    public UsuariosController(UsuarioDAO usuarioDAO, login loginView) { // Aquí deberías ajustar el tipo de vista según sea necesario
        this.usuarioDAO = usuarioDAO;
        this.loginView = loginView;
    }

    // Aquí puedes agregar métodos para manejar acciones relacionadas con la vista login
}