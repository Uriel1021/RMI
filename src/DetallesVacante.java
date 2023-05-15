import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetallesVacante extends JFrame {
    private JLabel nombreLabel, empresaLabel, descripcionLabel, salarioLabel, experienciaLabel, fechaPublicacionLabel, estadoPublicacionLabel, categoriaLabel;
    private JLabel nombreValue, empresaValue, descripcionValue, salarioValue, experienciaValue, fechaPublicacionValue, estadoPublicacionValue, categoriaValue;

    public DetallesVacante(String nombre, String empresa, String descripcion, Double salario, String experiencia, String fechaPublicacion, String estadoPublicacion, String categoria) {
        // Configuración del marco
        setTitle("Detalles del empleo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicialización de los componentes
        nombreLabel = new JLabel("Nombre:");
        empresaLabel = new JLabel("Empresa:");
        descripcionLabel = new JLabel("Descripción:");
        salarioLabel = new JLabel("Salario:");
        experienciaLabel = new JLabel("Experiencia:");
        fechaPublicacionLabel = new JLabel("Fecha de publicación:");
        estadoPublicacionLabel = new JLabel("Estado de publicación:");
        categoriaLabel = new JLabel("Categoría:");

        nombreValue = new JLabel(nombre);
        empresaValue = new JLabel(empresa);
        descripcionValue = new JLabel(descripcion);
        salarioValue = new JLabel(String.valueOf(salario));
        experienciaValue = new JLabel(experiencia);
        fechaPublicacionValue = new JLabel(fechaPublicacion);
        estadoPublicacionValue = new JLabel(estadoPublicacion);
        categoriaValue = new JLabel(categoria);

        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el marco actual
            }
        });

        botonesPanel.add(cerrarButton);

        // Panel para el botón de postularse
        JPanel postularsePanel = new JPanel();
        postularsePanel.setLayout(new FlowLayout(FlowLayout.CENTER));



        // Configuración del diseño del marco
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel1.add(nombreLabel);
        panel1.add(Box.createHorizontalStrut(10));
        panel1.add(nombreValue);
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(empresaLabel);
        panel2.add(Box.createHorizontalStrut(10));
        panel2.add(empresaValue);
        add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.add(descripcionLabel);
        panel3.add(Box.createHorizontalStrut(10));
        panel3.add(descripcionValue);
        add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
        panel4.add(salarioLabel);
        panel4.add(Box.createHorizontalStrut(10));
        panel4.add(salarioValue);
        add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
        panel5.add(experienciaLabel);
        panel5.add(Box.createHorizontalStrut(10));
        panel5.add(experienciaValue);
        add(panel5);

        JPanel panel6 = new JPanel();
        panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
        panel6.add(fechaPublicacionLabel);
        panel6.add(Box.createHorizontalStrut(10));
        panel6.add(fechaPublicacionValue);
        add(panel6);

        JPanel panel7 = new JPanel();
        panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));
        panel7.add(estadoPublicacionLabel);
        panel7.add(Box.createHorizontalStrut(10));
        panel7.add(estadoPublicacionValue);
        add(panel7);
        JPanel panel8 = new JPanel();
        panel8.setLayout(new BoxLayout(panel8, BoxLayout.X_AXIS));
        panel8.add(categoriaLabel);
        panel8.add(Box.createHorizontalStrut(10));
        panel8.add(categoriaValue);
        add(panel8);

        add(botonesPanel);

        setVisible(true);
    }
}

