package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;


public class ErrorDialog extends SimpleWindow<ErrorMessage> {
    public ErrorDialog(WindowOwner parent, ErrorMessage model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel actionsPanel) {
        new Button(actionsPanel).setCaption("Aceptar").onClick(this::close);
    }

    @Override
    protected void createFormPanel(Panel mainPanel) {
        new Label(mainPanel).bindValueToProperty("message");
    }
}
