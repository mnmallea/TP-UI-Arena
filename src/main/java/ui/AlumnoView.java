package ui;

import domain.Alumno;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

//IMPORTANTE: correr con -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
public class AlumnoView extends MainWindow<Alumno> {
	public AlumnoView(Alumno model) {
		super(model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Ventana de Alumno");
		mainPanel.setLayout(new ColumnLayout(2));

		new Label(mainPanel).setText("Nombre:");
		new Label(mainPanel).bindValueToProperty("nombre");

		new Label(mainPanel).setText("Legajo");
		new Label(mainPanel).bindValueToProperty("legajo");

		new Label(mainPanel).set<>Text("Usuario github:");
		new Label(mainPanel).bindValueToProperty("usuarioGithub");

		new Button(mainPanel).setCaption("Cambiar datos").onClick(() -> new CambiarDatos(this, this.getModelObject()).open());
	}

	public static void main(String[] args) {
		Alumno alumno = new Alumno("Martin", 1590935L, "mnmallea");
		new AlumnoView(alumno).startApplication();
	}
}
