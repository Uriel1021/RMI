import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Login extends JDialog {
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private boolean succeeded;

    private int idUsuario;

    public Login(Frame parent) {
        super(parent, "Inicio de sesión", true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        usernameLabel = new JLabel("Usuario: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameLabel, constraints);

        usernameField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(usernameField, constraints);

        passwordLabel = new JLabel("Contraseña: ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(passwordField, constraints);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = authenticate(usernameField.getText(), String.valueOf(passwordField.getPassword()));
                if (id != 0) {
                    succeeded = true;
                    dispose();
                    try {
                        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                        DaoService userService = (DaoService) registry.lookup("UserService");
                        ModeloUsuario modeloUsuario = userService.obtenerUsuario(id);
                        ModeloProfesion modeloProfesion = userService.obtenerProfesion(id);
                        ModeloExperienciaAdicional modeloExperienciaAdicional = userService.obtenerExAdicional(id);
                        ModeloExperienciaLaboral modeloExperienciaLaboral = userService.obtenerExLaboral(id);

                        InformacionUsuario info = new InformacionUsuario(modeloUsuario.id,modeloUsuario.nombre, modeloUsuario.apellidos, modeloUsuario.contacto,
                                modeloUsuario.direccion, modeloUsuario.pais, modeloUsuario.estadoCivil, modeloUsuario.usuario, modeloUsuario.contrasenia, modeloProfesion.carreraEstudiada, modeloProfesion.cedula,
                                modeloProfesion.escuela, modeloProfesion.anioInicio, modeloProfesion.anioFin, modeloExperienciaLaboral.nombreEmpresa, modeloExperienciaLaboral.fechaInicio, modeloExperienciaLaboral.fechaFin,
                                modeloExperienciaLaboral.responsabilidades, modeloExperienciaAdicional.nombreCurso, modeloExperienciaAdicional.documentoObtenido, modeloExperienciaAdicional.duracion, modeloExperienciaAdicional.institucion, modeloExperienciaAdicional.fechaInicio,
                                modeloExperienciaAdicional.fechaFin);

                        idUsuario = modeloUsuario.id;

                        info.setVisible(true);

                    } catch (Exception x) {
                        x.printStackTrace();
                        System.out.println(x.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos. Inténtalo de nuevo.", "Inicio de sesión fallido", JOptionPane.ERROR_MESSAGE);
                    // borrar los datos de inicio de sesión
                    usernameField.setText("");
                    passwordField.setText("");
                    succeeded = false;

                }
            }
        });

        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private int authenticate(String usuario, String contrasenia) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DaoService userService = (DaoService) registry.lookup("UserService");
            int esCorrecto = userService.inicioSesion(usuario,contrasenia);
            if (esCorrecto != 0){
                return esCorrecto;
            }else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public boolean isSucceeded() {
        return succeeded;
    }
    public int isSucceededId(){return  idUsuario;}
}

