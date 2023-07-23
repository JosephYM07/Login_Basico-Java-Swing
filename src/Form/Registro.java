package Form;
import Class.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Registro {
    private JTextField IngresoNombreUsuario;
    private JPasswordField IngresoContrasenia;
    private JTextField IngresoNombres;
    private JButton Registrarse;
    private JButton RegresarLogin;
    JPanel Registro;

    private ArrayList<Usuario> usuarios;

    public Registro(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;

        Registrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = IngresoNombreUsuario.getText();
                String password = new String(IngresoContrasenia.getPassword());
                String nombres = IngresoNombres.getText();

                if (registrarUsuario(username, password, nombres)) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario.");
                }
                JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(Registro);
                thisFrame.dispose();
            }
        });

        RegresarLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame loginFrame = new JFrame("Login");
                loginFrame.setContentPane(new login().Login_Principal);
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.pack();
                loginFrame.setVisible(true);

                // Cierra el formulario actual de Registro
                JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(Registro);
                thisFrame.dispose();
            }
        });
    }

    private boolean registrarUsuario(String username, String password, String nombres) {
        // Se crea un For para recorrer la lista de usuarios
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está registrado. Intente con otro.");
                return false;
            }
        }
        usuarios.add(new Usuario(username, password, nombres));
        guardarUsuariosEnArchivo();
        return true;
    }
    //Funcion Guardar Usuarios en Archivo
    private void guardarUsuariosEnArchivo() {
        try {
            //el bufferedwriter escribe en el archivo usuarios.dat los datos de los usuarios registrados https://stackoverflow.com/questions/14503595/write-file-using-bufferedwriter-in-java
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.dat"));
            for (Usuario usuario : usuarios) {
                writer.write(usuario.getUsername() + "," + usuario.getPassword() + "," + usuario.getNombres() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
