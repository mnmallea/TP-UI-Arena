package ui;

import domain.Alumno;
import domain.Asignacion;
import domain.Consulta;
import domain.Fixture;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
@SuppressWarnings("serial")
public class AlumnoView extends MainWindow<Consulta> {

	private static final int NUMBER_VISIBLE_ROWS = 4;

	public AlumnoView(Consulta model) {
		super(model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Ventana de Alumno");
		mainPanel.setLayout(new VerticalLayout());

		Panel datosPanel = new Panel(mainPanel);
		datosPanel.setLayout(new ColumnLayout(2));

		new Label(datosPanel).setText("Nombre:");
		new Label(datosPanel).bindValueToProperty("alumno.nombre");

		new Label(datosPanel).setText("Legajo");
		new Label(datosPanel).bindValueToProperty("alumno.legajo");

		new Label(datosPanel).setText("Usuario github:");
		new Label(datosPanel).bindValueToProperty("alumno.usuarioGithub");

		new Button(mainPanel).setCaption("Cambiar datos").onClick(() -> new CambiarDatos(this, new AlumnoCambiarDatosViewModel(this.getModelObject().getAlumno())).open());

		this.crearTablaDeNotas(mainPanel);
	}

	private void crearTablaDeNotas(Panel mainPanel) {
		Table<Asignacion> tabla = new Table<Asignacion>(mainPanel, Asignacion.class);
		tabla.bindItemsToProperty("alumno.asignaciones");

		this.describirTablaDeNotas(tabla);
	}

	private void describirTablaDeNotas(Table<Asignacion> tabla) {
		new Column<Asignacion>(tabla).setTitle("Nombre").bindContentsToProperty("nombre");
		new Column<Asignacion>(tabla).setTitle("Nota final").bindContentsToProperty("notaFinal");
		new Column<Asignacion>(tabla).setTitle("Aprobada?").bindContentsToProperty("estaAprobada")
				.setTransformer(new BoolTransformer());
		tabla.setNumberVisibleRows(NUMBER_VISIBLE_ROWS);
	}

	public static void main(String[] args) {
		Fixture.setUp();
		new AlumnoView(new Consulta()).startApplication();
	}
}
