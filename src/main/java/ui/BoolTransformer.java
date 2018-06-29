package ui;

import org.apache.commons.collections15.Transformer;

public class BoolTransformer implements Transformer<Boolean, String> {

	@Override
	public String transform(Boolean estaAprobada) {
		return estaAprobada? "Sí" : "No";
	}
}
