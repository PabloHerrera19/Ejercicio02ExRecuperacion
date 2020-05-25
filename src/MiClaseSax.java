import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MiClaseSax extends DefaultHandler {
	private static final String HORA_FINAL = "HORAFINAL";
	private static final String HORA_INICIO = "HORAINICIO";
	private static final String FECHA = "FECHA";
	private static final String CODIGO_SOCIO = "CODSOCIO";
	/**
	 * Completar el programa que se proporciona usando Sax para obtener por pantalla
	 * el siguiente listado: Socio 10 Fecha 16/11/09 Horas 1 Socio 10 Fecha 16/12/09
	 * Horas 1 ... Horas totales: 19 En la última línea aparecerán el total de horas
	 * entre todos los socios.Se deben controlar las siguientes condiciones de error
	 * •Si no existe el fichero “uso_gimnasio.xml” aparecerá el mensaje “No se
	 * encuentra el fichero de uso del gimnasio”. •Si el fichero no cumple el
	 * formato esperado aparecerá el mensaje “El fichero tiene un formato
	 * incorrecto”.
	 */

	private String etiquetaActual;
	private int contadorHoras = 0, horaInicio, horaFinal, horas;

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void endDocument() throws SAXException {
		// Aquí mostraremos el total de horas

		System.out.println("Horas totales: " + contadorHoras);

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		this.etiquetaActual = qName;

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String contenido = new String(ch, start, length);
		contenido = contenido.replaceAll("[\t\n]", "").trim();
		if (contenido.length() != 0) { // No está vacío
			// Una vez hecho esto, ya podemos tratarla
			switch (etiquetaActual) {
			case CODIGO_SOCIO:
				System.out.print("SOCIO " + contenido + " ");
				break;

			case FECHA:
				System.out.print("FECHA " + contenido + " ");
				break;
			case HORA_INICIO:
				this.horaInicio = Integer.parseInt(contenido);
				break;
			case HORA_FINAL:

				this.horaFinal = Integer.parseInt(contenido);
				this.horas = horaFinal - horaInicio;

				contadorHoras = contadorHoras + horas;

				System.out.println("HORAS " + horas); // Aquí peta

				break;
			}
		}

	}

}
