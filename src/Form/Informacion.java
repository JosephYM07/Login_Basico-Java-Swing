package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Informacion {
    private JLabel MostrarNombreRegistrado;
    private JButton cerrarSesionButton;
    JPanel Informacion;
    private String usuario;

    public Informacion(String username) {
        usuario = username;
        MostrarNombreRegistrado.setText("Bienvenido, " + usuario);

        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesion();
            }
        });
    }

    private void cerrarSesion() {
        JFrame infoFrame = (JFrame) SwingUtilities.getWindowAncestor(Informacion);
        infoFrame.dispose();
        // Mostrar el formulario de Login nuevamente
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setContentPane(new login().Login_Principal);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
        loginFrame.setVisible(true);
    }
}
