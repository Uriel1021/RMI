import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient extends JFrame {
    private boolean inicioSesion = false;
    private int idUsuario = 0;
    private JTable table;
    private DefaultTableModel model;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RMIClient gui = new RMIClient();
            gui.setVisible(true);
        });
    }
    public RMIClient() {
        setTitle("Lista de Vacantes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        // Crear el modelo de la tabla
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Empresa");
        model.addColumn("Descripción");
        model.addColumn("Salario");
        model.addColumn("Experiencia");
        model.addColumn("Fecha de Publicación");
        model.addColumn("Estado de Publicación");
        model.addColumn("Categoría");
        model.addColumn("Número de Vacantes");
        // Crear el botón "Iniciar Sesión"
        JButton btnAddSesion = new JButton("Iniciar Sesión");
        btnAddSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(RMIClient.this);
                login.setVisible(true);
                if (login.isSucceeded()){
                    inicioSesion = true;
                }
                idUsuario = login.isSucceededId();
            }
        });
// Crear el botón "buscar"
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar();
            }
        });
// Crear el botón "Registrarse"
        JButton btnRegistrar = new JButton("Registrarse");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroUsuario registro = new RegistroUsuario();
                registro.setVisible(true);
            }
        });
// Crear el JTextField para búsquedas
        JTextField txtBuscar = new JTextField(20);

// Crear el panel para el botón "Iniciar sesión" y el JTextField
        JPanel panelIzquierdo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelIzquierdo.add(btnBuscar);
        panelIzquierdo.add(Box.createRigidArea(new Dimension(10, 0))); // Espacio entre los botones
        panelIzquierdo.add(txtBuscar);

// Crear el panel para los botones "Registrarse" y "Añadir vacante"
        JPanel panelDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelDerecho.add(btnAddSesion);
        panelDerecho.add(Box.createRigidArea(new Dimension(10, 0))); // Espacio entre los botones
        panelDerecho.add(btnRegistrar);

// Agregar los paneles al panel superior con BorderLayout
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelIzquierdo, BorderLayout.WEST);
        panelSuperior.add(panelDerecho, BorderLayout.EAST);

// Agregar el panel superior a la ventana
        getContentPane().add(panelSuperior, BorderLayout.NORTH);

        // Crear la tabla con el modelo
        table = new JTable(model);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar el JScrollPane al JFrame
        getContentPane().add(scrollPane);

        // Crear el botón "Postularse"
        JButton btnVerDetalles = new JButton("Postularse");
        btnVerDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) table.getValueAt(selectedRow, 0);
                    if (inicioSesion){
                        mostrarDetallesVacante(id,idUsuario);
                    }else{
                        JOptionPane.showMessageDialog(RMIClient.this, "Debes iniciar sesion para postularse", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(RMIClient.this, "Selecciona una vacante de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

// Crear el panel inferior
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.add(btnVerDetalles);

// Agregar el panel inferior a la ventana
        getContentPane().add(panelInferior, BorderLayout.SOUTH);


        // Obtener los datos de las vacantes
        obtenerVacantes();
    }
    private void obtenerVacantes() {
        try {
            // se crea una referencia al registro de objetos remotos utilizando la clase LocateRegistry.
            // El método getRegistry() de esta clase devuelve una referencia al registro de objetos remotos en
            // la dirección proporcionada como parámetro. En este caso, se utiliza "localhost" como la dirección
            // y 1099 como el puerto de comunicación.
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            //Se obtiene una referencia al objeto remoto llamado "UserService" registrado en el registro de objetos remotos.
            // La referencia se obtiene utilizando el método lookup() del registro de objetos remotos.
            // El objeto remoto es convertido al tipo DaoService utilizando una conversión de tipo (cast) para poder llamar a sus métodos.
            DaoService userService = (DaoService) registry.lookup("UserService");
            List<ModeloVacante> listaVacantes = userService.listarVacantes();
            for (ModeloVacante vacante : listaVacantes) {
                model.addRow(new Object[]{
                        vacante.getId(),
                        vacante.getNombre(),
                        vacante.getEmpresa(),
                        vacante.getDescripcion(),
                        vacante.getSalario(),
                        vacante.getExperiencia(),
                        vacante.getFechaPublicacion(),
                        vacante.getEstadoPublicacion(),
                        vacante.getCategoria(),
                        vacante.getMaxPostulaciones()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    private void mostrarDetallesVacante(int id, int idUsuario) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DaoService userService = (DaoService) registry.lookup("UserService");
            ModeloVacante vacante = userService.obtenerVacante(id);
            InformacionEmpleo informacionEmpleo = new InformacionEmpleo(idUsuario, vacante.id,vacante.nombre,vacante.empresa, vacante.descripcion, vacante.salario,vacante.experiencia,
                    vacante.fechaPublicacion,vacante.estadoPublicacion,vacante.categoria,vacante.maxPostulaciones);
            informacionEmpleo.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
