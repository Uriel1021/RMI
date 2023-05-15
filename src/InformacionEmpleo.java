import javax.swing.*;
import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class InformacionEmpleo extends JFrame {
    private JLabel nombreLabel, empresaLabel, descripcionLabel, salarioLabel, experienciaLabel,
            fechaPublicacionLabel, estadoPublicacionLabel, categoriaLabel, maxPostulacionesLabel;
    private JButton postularseButton;


    public InformacionEmpleo(int idUsuario ,int id, String nombre, String empresa, String descripcion, double salario, String experiencia,
                             String fechaPublicacion, String estadoPublicacion, String categoria, int maxPostulaciones) {
        // Configuración de la ventana
        setTitle("Información del Empleo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel para los datos del empleo
        JPanel empleoPanel = new JPanel();
        empleoPanel.setLayout(new GridLayout(9, 2));
        empleoPanel.setBorder(BorderFactory.createTitledBorder("Datos del Empleo"));

        nombreLabel = new JLabel("Nombre: " + nombre);
        empleoPanel.add(nombreLabel);

        empresaLabel = new JLabel("Empresa: " + empresa);
        empleoPanel.add(empresaLabel);

        descripcionLabel = new JLabel("Descripción: " + descripcion);
        empleoPanel.add(descripcionLabel);

        salarioLabel = new JLabel("Salario: " + salario);
        empleoPanel.add(salarioLabel);

        experienciaLabel = new JLabel("Experiencia: " + experiencia);
        empleoPanel.add(experienciaLabel);

        fechaPublicacionLabel = new JLabel("Fecha de Publicación: " + fechaPublicacion);
        empleoPanel.add(fechaPublicacionLabel);

        estadoPublicacionLabel = new JLabel("Estado de Publicación: " + estadoPublicacion);
        empleoPanel.add(estadoPublicacionLabel);

        categoriaLabel = new JLabel("Categoría: " + categoria);
        empleoPanel.add(categoriaLabel);

        maxPostulacionesLabel = new JLabel("Máximo de Postulaciones: " + maxPostulaciones);
        empleoPanel.add(maxPostulacionesLabel);

        // Panel para el botón de postularse
        JPanel postularsePanel = new JPanel();
        postularsePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        postularseButton = new JButton("Postularse");
        postularseButton.addActionListener(e -> {
            // postularse
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                DaoService userService = (DaoService) registry.lookup("UserService");
                ModeloEmpleo modeloEmpleo = new ModeloEmpleo();
                JOptionPane.showMessageDialog(this, "Usuario registrado correctamente"+ id + idUsuario, "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                userService.crearEmpleo(modeloEmpleo,id,idUsuario);
            } catch (Exception x) {
                x.printStackTrace();
                System.out.println(x.getMessage());
            }
        });
        postularsePanel.add(postularseButton);

        // Botón para cerrar
        JButton cerrarButton = new JButton("Salir");
        cerrarButton.addActionListener(e -> {
            // Cerar ventana
            this.dispose();
        });
        postularsePanel.add(cerrarButton);

        // Agregar paneles a la ventana
        add(empleoPanel, BorderLayout.CENTER);
        add(postularsePanel, BorderLayout.SOUTH);
    }
}
