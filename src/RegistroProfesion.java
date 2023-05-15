import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistroProfesion extends JFrame {
    private JLabel carreraLabel, cedulaLabel, escuelaLabel, anioInicioLabel, anioFinLabel;
    private JTextField carreraField, cedulaField, escuelaField, anioInicioField, anioFinField;
    private JButton enviarButton,cerrar;

    public RegistroProfesion(int idUsuario) {
        // Configuración del marco
        setTitle("Formulario");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicialización de los componentes
        carreraLabel = new JLabel("Carrera Estudiada:");
        cedulaLabel = new JLabel("Cedula:");
        escuelaLabel = new JLabel("Escuela:");
        anioInicioLabel = new JLabel("Año de inicio:");
        anioFinLabel = new JLabel("Año de fin:");

        carreraField = new JTextField();
        cedulaField = new JTextField();
        escuelaField = new JTextField();
        anioInicioField = new JTextField();
        anioFinField = new JTextField();

        enviarButton = new JButton("Enviar");
        cerrar = new JButton("Cerrar");
        // Agregar un ActionListener al botón Registrar
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevaProfesion(idUsuario);
            }
        });

        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Configuración del diseño del marco
        setLayout(new GridLayout(6, 2));
        add(carreraLabel);
        add(carreraField);
        add(cedulaLabel);
        add(cedulaField);
        add(escuelaLabel);
        add(escuelaField);
        add(anioInicioLabel);
        add(anioInicioField);
        add(anioFinLabel);
        add(anioFinField);
        add(enviarButton);
        add(cerrar);

        // Mostrar el marco
        setVisible(true);
    }

    public void nuevaProfesion(int idUsuario){
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DaoService userService = (DaoService) registry.lookup("UserService");

            // Obtener los valores de los campos de texto
            String carrera = carreraField.getText();
            String cedula = cedulaField.getText();
            String escuela = escuelaField.getText();
            String inicio = anioInicioField.getText();
            String fin = anioFinField.getText();
            // Validar los campos
            if (carrera.isEmpty() || cedula.isEmpty() || escuela.isEmpty() || inicio.isEmpty() || fin.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear una nueva instancia de Usuario y asignar los valores obtenidos de los campos de texto a los atributos correspondientes
            ModeloProfesion modeloProfesion = new ModeloProfesion();
            modeloProfesion.setIdUsuario(idUsuario);
            modeloProfesion.setCarreraEstudiada(carrera);
            modeloProfesion.setCedula(cedula);
            modeloProfesion.setEscuela(escuela);
            modeloProfesion.setAnioInicio(inicio);
            modeloProfesion.setAnioFin(fin);
            // Llamar al método crearUsuario() del DaoService, pasando como parámetro la instancia de Vacante creada anteriormente
            boolean seInserto = userService.crearProfesion(modeloProfesion,idUsuario);
            if (seInserto == true){
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Usuario registrado correctamente, ahora puede iniciar session", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "No se registro el usuario, intente de nuevo", "Registro erroneo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se registro el usuario, intente de nuevo"+e.getMessage(), "Registro erroneo", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se registro el usuario, intente de nuevo", "Registro erroneo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}



