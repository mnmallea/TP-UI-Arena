package ui;

import domain.*;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;

import java.util.Arrays;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
public class AlumnoView extends MainWindow<Alumno> {
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

		new Label(datosPanel).setText("Legajo");
		new Label(datosPanel).bindValueToProperty("legajo");

		new Label(datosPanel).setText("Usuario github:");
		new Label(datosPanel).bindValueToProperty("usuarioGithub");

		new Button(datosPanel).setCaption("Cambiar datos").onClick(() -> new CambiarDatos(this, this.getModelObject()).open());

		this.crearTablaDeNotas(mainPanel);
	}

	private void crearTablaDeNotas(Panel mainPanel) {
		Table<Asignacion> tabla = new Table<Asignacion>(mainPanel, Asignacion.class);
		tabla.bindItemsToProperty("asignaciones");

		this.describirTablaDeNotas(tabla);
	}

	private void describirTablaDeNotas(Table<Asignacion> tabla) {
		new Column<Asignacion>(tabla).setTitle("Nombre").bindContentsToProperty("nombre");
		new Column<Asignacion>(tabla).setTitle("Nota final").bindContentsToProperty("notaFinal");
		new Column<Asignacion>(tabla).setTitle("¿Aprobada?").bindContentsToProperty("estaAprobada").setTransformer(new BoolTransformer());
	}

	public static void main(String[] args) {
		AsignacionParcial asignacion = new AsignacionParcial("Parcial DDS");
		asignacion.agregarCalificacion(new CalificacionNumerica(6));
		AsignacionTP tp = new AsignacionTP("TP UI Arena");
		tp.agregarCalificacion(new CalificacionConceptual("M"));
		tp.agregarCalificacion(new CalificacionConceptual("R"));
		Alumno alumno = new Alumno("Martin", 1590935L, "mnmallea", Arrays.asList(asignacion, tp));
		new AlumnoView(alumno).startApplication();
	}
}
