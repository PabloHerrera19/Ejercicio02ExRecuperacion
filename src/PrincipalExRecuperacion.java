import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class PrincipalExRecuperacion {

	public static void main(String[] args) {
		try {
			if (!Files.isRegularFile(Paths.get("uso_gimnasio.xml"))) {
				System.err.println("No se encuentra el fichero de uso del gimnasio");
				 // FALTA LO DEL FORMATO
			} else {
				leerXmlConSax("uso_gimnasio.xml");
			}

		} catch (SAXException | IOException | ParserConfigurationException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void leerXmlConSax(String nombreFichero)
			throws SAXException, IOException, ParserConfigurationException {
		// Creamos el patrón factoria
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();

		XMLReader reader = parser.getXMLReader();
		reader.setContentHandler(new MiClaseSax());
		reader.parse(new InputSource(nombreFichero));
	}

}
