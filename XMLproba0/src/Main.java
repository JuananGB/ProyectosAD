
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/**
 *
 * @author juagsa
 */
public class Main {
    public static void main(String[] args){
        
        try {
            DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
            
            DocumentBuilder  builder=factory.newDocumentBuilder();
            
            DOMImplementation implementation=builder.getDOMImplementation();
            
            //Documento
            Document documento=implementation.createDocument(null, "autores", null);
            // Versión
            documento.setXmlVersion("1.0");
            
            // Padre del archivo .xml
            Element autores=documento.createElement("autores");
            
            // Autor 1
            Element autor=documento.createElement("autor");
            
            // Hijos de autor 1
            
            // Atributo autor 1
            autor.setAttribute("codigo", "a1");
            //Elemento Nome
            Element nome=documento.createElement("nome");
            
            Text textoNome=documento.createTextNode("Alexandre Numas");
            
            nome.appendChild(textoNome);
            
            autor.appendChild(nome);
            
            //Elemento Título 1
            Element titulo1=documento.createElement("titulo");
            
            Text textoTitulo1=documento.createTextNode("El conde de Montecristo");
            
            titulo1.appendChild(textoTitulo1);
            
            autor.appendChild(titulo1);
            
            //Elemento Título 2
            
            Element titulo2=documento.createElement("titulo");
            
            Text textoTitulo2=documento.createTextNode("Los miserables");
            
            titulo2.appendChild(textoTitulo2);
            
            autor.appendChild(titulo2);
            
            // Cerramos autor
            autores.appendChild(autor);
            
            // Autor 2
            Element autor2=documento.createElement("autor");
            
            // Hijos de autor2
            //Atributo de autor 2
            autor2.setAttribute("codigo", "a2");
            
            //Elemento Nome
            Element nome2=documento.createElement("nome");
            
            Text textoNome2=documento.createTextNode("Fiodor Dostoyevski");
            
            nome2.appendChild(textoNome2);
            
            autor2.appendChild(nome2);
            
            //Elemento Título 1
            Element titulo1_2=documento.createElement("titulo");
            
            Text textoTitulo1_2=documento.createTextNode("El idiota");
            
            titulo1_2.appendChild(textoTitulo1_2);
            
            autor2.appendChild(titulo1_2);
            
            //Elemento Título 2
            
            Element titulo2_2=documento.createElement("titulo");
            
            Text textoTitulo2_2=documento.createTextNode("noches blancas");
            
            titulo2_2.appendChild(textoTitulo2_2);
            
            autor2.appendChild(titulo2_2);
            
            // Cerramos autor
            autores.appendChild(autor2);
            
            //Cerramos autores
            documento.getDocumentElement().appendChild(autores);
            
            
            
            //CREACIÓN DEL XML
            
            Source source=new DOMSource(documento);
            
            Result result= new StreamResult(new File("autores.xml"));
            
            try {
                Transformer transformer= TransformerFactory.newInstance().newTransformer();
                
                try {
                    transformer.transform(source, result);
                } catch (TransformerException ex) {
                    System.out.println(ex.getMessage());
                }
                
            } catch (TransformerConfigurationException ex) {
                System.out.println(ex.getMessage());
            }
            
        } catch (ParserConfigurationException ex) {
            
            System.out.println(ex.getMessage());
        }
        
        
        
        
    }
    
}
