package ui;

import domain.Consulta;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.WindowOwner;

public class CambiarDatos extends TransactionalDialog<Consulta> {

	public CambiarDatos(WindowOwner owner, Consulta model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel panel) {
		this.setTitle("Cambiar Datos");
		panel.setLayout(new ColumnLayout(2));

		new Label(panel);

		new Label(panel).setText("Nombre:");
		new TextBox(panel).bindValueToProperty("alumno.nombre");

		new Label(panel).setText("Legajo");
		new NumericField(panel).bindValueToProperty("alumno.legajo");

		new Label(panel).setText("Usuario github:");
		new TextBox(panel).bindValueToProperty("alumno.usuarioGithub");

		new Button(panel).setCaption("Aceptar").onClick(this::accept).setAsDefault();
		new Button(panel).setCaption("Cancelar").onClick(this::cancel);
	}
}
