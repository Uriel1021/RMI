import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistroUsuario extends JFrame {

    private JTextField txtNombre, txtApellidos, txtContacto, txtDireccion, txtPais, txtEstadoCivil, txtUsuario;
    private JPasswordField txtContrasenia;
    private JButton btnRegistrar;

    public RegistroUsuario() {
        super("Registro de Usuario");

        // Crear los componentes
        txtNombre = new JTextField(20);
        txtApellidos = new JTextField(20);
        txtContacto = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtPais = new JTextField(20);
        txtEstadoCivil = new JTextField(20);
        txtUsuario = new JTextField(20);
        txtContrasenia = new JPasswordField(20);
        btnRegistrar = new JButton("Registrar");

        // Agregar un ActionListener al botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoUsuario();
            }
        });

        // Crear un panel para los campos de texto
        JPanel panelCampos = new JPanel(new GridLayout(9, 2));
        panelCampos.add(new JLabel("Nombre:"));
        panelCampos.add(txtNombre);
        panelCampos.add(new JLabel("Apellidos:"));
        panelCampos.add(txtApellidos);
        panelCampos.add(new JLabel("Contacto:"));
        panelCampos.add(txtContacto);
        panelCampos.add(new JLabel("Dirección:"));
        panelCampos.add(txtDireccion);
        panelCampos.add(new JLabel("País:"));
        panelCampos.add(txtPais);
        panelCampos.add(new JLabel("Estado Civil:"));
        panelCampos.add(txtEstadoCivil);
        panelCampos.add(new JLabel("Usuario:"));
        panelCampos.add(txtUsuario);
        panelCampos.add(new JLabel("Contraseña:"));
        panelCampos.add(txtContrasenia);

        // Crear un panel para el botón Registrar
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(btnRegistrar);

        // Agregar los paneles al JFrame
        getContentPane().add(panelCampos, BorderLayout.CENTER);
        getContentPane().add(panelBoton, BorderLayout.SOUTH);

        // Ajustar el tamaño y hacer visible la ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void nuevoUsuario() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            DaoService userService = (DaoService) registry.lookup("UserService");

            // Obtener los valores de los campos de texto
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String contacto = txtContacto.getText();
            String direccion = txtDireccion.getText();
            String pais = txtPais.getText();
            String estadoCivil = txtEstadoCivil.getText();
            String usuario = txtUsuario.getText();
            String contrasenia = new String(txtContrasenia.getPassword());

            // Validar los campos
            if (nombre.isEmpty() || apellidos.isEmpty() || contacto.isEmpty() || direccion.isEmpty() || pais.isEmpty() || estadoCivil.isEmpty() || usuario.isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear una nueva instancia de Usuario y asignar los valores obtenidos de los campos de texto a los atributos correspondientes
            ModeloUsuario nuevo = new ModeloUsuario();
            nuevo.setNombre(nombre);
            nuevo.setApellidos(apellidos);
            nuevo.setContacto(contacto);
            nuevo.setDireccion(direccion);
            nuevo.setPais(pais);
            nuevo.setEstadoCivil(estadoCivil);
            nuevo.setUsuario(usuario);
            nuevo.setContrasenia(contrasenia);

            // Llamar al método crearUsuario() del DaoService, pasando como parámetro la instancia de Vacante creada anteriormente
            boolean seInserto = false;
            seInserto = userService.crearUsuario(nuevo);
            if (seInserto == true){
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Usuario registrado correctamente, ahora puede iniciar session", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "No se registro el usuario, intente de nuevo", "Registro erroneo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se registro el usuario, intente de nuevo", "Registro erroneo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

