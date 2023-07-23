package Form;
import Class.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class login {
    public JPanel Login_Principal;
    private JTextField IngresoUsuario;
    private JPasswordField IngresoContrasenia;
    private JLabel img;
    private JButton IniciarSesion;
    private JButton CargarDatos;
    private JButton registrarseButton;

    private ArrayList<Usuario> usuarios;

    public login() {
        usuarios = new ArrayList<>();

        CargarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarUsuariosDesdeArchivo();
                JOptionPane.showMessageDialog(null, "Datos cargados exitosamente.");
            }
        });

        IniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = IngresoUsuario.getText();
                String password = new String(IngresoContrasenia.getPassword());
                if (validarCredenciales(username, password)) {
                    JFrame infoFrame = new JFrame("Informacion");
                    infoFrame.setContentPane(new Informacion(username).Informacion);
                    infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    infoFrame.pack();
                    infoFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales inválidas. Inténtalo nuevamente.");
                }
                JFrame thisFrame = (JFrame) SwingUtilities.getWindowAncestor(Login_Principal);
                thisFrame.dispose();
            }
        });

        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registroFrame = new JFrame("Registro");
                registroFrame.setContentPane(new Registro(usuarios).Registro);
                registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                registroFrame.pack();
                registroFrame.setVisible(true);
            }
        });
    }

    private boolean validarCredenciales(String username, String password) {
        //se recorre el arraylist de usuarios
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) { //El metodo equals compara si son iguales los datos ingresados con los datos del archivo
                return true;
            }
        }
        return false; //retorna falso si no encuentra el usuario
    }

    private void cargarUsuariosDesdeArchivo() {
        try {
            File archivo = new File("usuarios.dat");
            if (!archivo.exists()) {
                archivo.createNewFile();
            } else {
                usuarios.clear();
                BufferedReader reader = new BufferedReader(new FileReader(archivo)); // Lee el archivo de texto plano
                String line; // Nos ayudara a leer linea por linea
                while ((line = reader.readLine()) != null) {
                    String[] datosUsuario = line.split(","); //Nos ayudara para separar los datos de los usuarios en el archivo y no se guarden todos en una sola linea
                    String username = datosUsuario[0];
                    String password = datosUsuario[1];
                    String nombres = datosUsuario[2];
                    usuarios.add(new Usuario(username, password, nombres));
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Login");
                frame.setContentPane(new login().Login_Principal);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
