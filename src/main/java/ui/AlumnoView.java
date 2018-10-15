package ui;

import domain.Alumno;
import domain.Asignacion;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import repos.RepoAlumno;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class AlumnoView extends MainWindow<Alumno> {

    private static final int NUMBER_VISIBLE_ROWS = 4;

    public AlumnoView(Alumno model) {
        super(model);
    }

    @Override
    public void createContents(Panel mainPanel) {
        this.setTitle("Ventana de Alumno");
        mainPanel.setLayout(new VerticalLayout());

        Panel datosPanel = new Panel(mainPanel);
        datosPanel.setLayout(new ColumnLayout(2));

        new Label(datosPanel).setText("Nombre:");
        new Label(datosPanel).bindValueToProperty("nombre");

        new Label(datosPanel).setText("Apellido:");
        new Label(datosPanel).bindValueToProperty("apellido");

        new Label(datosPanel).setText("Legajo");
        new Label(datosPanel).bindValueToProperty("legajo");

        new Label(datosPanel).setText("Usuario github:");
        new Label(datosPanel).bindValueToProperty("usuarioGithub");

        new Button(mainPanel).setCaption("Cambiar datos").onClick(() -> new CambiarDatos(this, new AlumnoCambiarDatosViewModel(this.getModelObject())).open());
        new Button(mainPanel).setCaption("Refresh").onClick(() -> getModelObject().coerceToRefresh());

        this.crearTablaDeNotas(mainPanel);
    }

    private void crearTablaDeNotas(Panel mainPanel) {
        Table<Asignacion> tabla = new Table<>(mainPanel, Asignacion.class);
        tabla.bindItemsToProperty("asignaciones");

        this.describirTablaDeNotas(tabla);
    }

    private void describirTablaDeNotas(Table<Asignacion> tabla) {
        new Column<>(tabla).setTitle("Nombre").bindContentsToProperty("nombre");
        new Column<>(tabla).setTitle("Nota final").bindContentsToProperty("notaFinal");
        new Column<>(tabla).setTitle("Aprobada?").bindContentsToProperty("estaAprobada")
                .setTransformer(new BoolTransformer());
        tabla.setNumberVisibleRows(NUMBER_VISIBLE_ROWS);
    }

    public static void main(String[] args) {
        new AlumnoView(RepoAlumno.getInstance().getAlumno()).startApplication();
    }
}
