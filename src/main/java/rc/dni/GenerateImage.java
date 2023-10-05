package rc.dni;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Locale;

public class GenerateImage {
    public String front;
    public String reverso;
    private static final int ANCHO = 250;
    private static final int ALTO = 333;
    private static final Locale LOCALE = new Locale("es", "ES");

    public Response handleRequest(Request request) {
        try {
            crearImagenFrontal(request.getPersona(), request.getPathFrente());
            crearImagenTrasera(request.getPersona(), request.getPathReverso());
            return new Response(front, reverso);
        } catch (Exception e) {

            return new Response(front, reverso);
        }
    }

    private void crearImagenFrontal(Person person, String pathFrente) {
        try {
            BufferedImage image = ImageIO.read(new URL(pathFrente));

            int imageType = BufferedImage.TYPE_INT_ARGB;
            BufferedImage procesada = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

            Graphics2D w = (Graphics2D) procesada.getGraphics();
            w.drawImage(image, 0, 0, null);
            w.setColor(Color.BLACK);
            w.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            int x1 = 320;
            int x2 = 720;
            w.drawString(Tags.APELLIDOS, x1, 120);
            w.drawString(Tags.NOMBRES, x1, 210);
            w.drawString(Tags.NACIONALIDAD, x1, 280);
            w.drawString(Tags.FECHA_DE_NACIMIENTO, x1, 350);
            w.drawString(Tags.LUGAR_DE_NACIMIENTO, x1, 420);

            w.drawString(Tags.CONDICION, 550, 120);
            w.drawString(Tags.SEXO, x2, 350);
          //  w.drawString("No. DOCUMENTO", x2, 420);
            w.drawString(Tags.FECHA_DE_VENCIMIENTO, x2, 490);
           // w.drawString("NAT/CAN", x2, 560);

            w.setFont(new Font("Arial", Font.BOLD, 22));

            w.drawString(person.getTipoCedula() != null ? person.getTipoCedula() : "", 680, 120);
            w.drawString(person.getNumeroCedula() != null ? "NUI." + person.getNumeroCedula() : "", 80, 560);

            String nombres = person.getNombresCiu() != null ? person.getNombresCiu() : "";
            String apellido1 = person.getApellido1() != null ? person.getApellido1() : "";
            String apellido2 = person.getApellido2() != null ? person.getApellido2() : "";

            w.drawString(apellido1, x1, 150);
            w.drawString(apellido2, x1, 175);
            w.drawString(nombres, x1, 240);

			/*String lugarNacimiento = persona.getLugarNacimiento()!=null?persona.getLugarNacimiento():"";
			String[] lugarNacs = lugarNacimiento.split(",");
			String provinciaNac = "";
			String cantonNac = "";
			String parroquiaNac = "";

			parroquiaNac =  lugarNacs[0];
			if (lugarNacs.length>1){
				cantonNac = lugarNacs[1];
				if (lugarNacs.length>2){
					provinciaNac = lugarNacs[2];
				}
			}
			String provinciaCanton = provinciaNac + " " + cantonNac;*/
            w.drawString(person.getLugarNacimiento1(), x1, 450);
            w.drawString(person.getLugarNacimiento2(), x1, 480);

            //DateFormat formato = DateFormat.getDateInstance(DateFormat.MEDIUM);

            DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy", LOCALE);
            DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd MMM yyyy", LOCALE);
            w.drawString(person.getFechaNacimiento() != null ? LocalDate.parse(person.getFechaNacimiento(), formato1).format(formato2).toUpperCase() : "", x1, 380);
            w.drawString(person.getNacionalidad() != null ? person.getNacionalidad() : "", x1, 310);
            w.drawString(person.getSexo() != null ? person.getSexo() : "", x2, 380);
            w.drawString(person.getFechaExpiracion() != null ? LocalDate.parse(person.getFechaExpiracion(), formato1).format(formato2).toUpperCase() : "", x2, 520);


	        if(person.getFotoPersona()!= null && person.getFotoPersona().length()>10)
	        {
		        float alpha = 1.0f;
		        int compositeRule = AlphaComposite.SRC_OVER;
		        AlphaComposite ac;

                byte[] pixels = Base64.getDecoder().decode(person.getFotoPersona());
                //InputStream inputStream = new ByteArrayInputStream(pixels);
                
                BufferedImage foto = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_BYTE_GRAY);
                foto.getRaster().setDataElements(0, 0, ANCHO, ALTO, pixels);
                
		        //BufferedImage foto = ImageIO.read(inputStream);
		        if(foto.getWidth() > ANCHO) {
		        	BufferedImage resizedImage = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_BYTE_GRAY);
		        	Graphics2D gFotoAux = resizedImage.createGraphics();
		        	gFotoAux.drawImage(foto, 0, 0, ANCHO, ALTO, null);
		        	gFotoAux.dispose();
		        	foto = resizedImage;
		        }
		        ac = AlphaComposite.getInstance(compositeRule, alpha);
		        w.drawImage(procesada,0,0,null);
		        w.setComposite(ac);
		        w.drawImage(foto,48,156,null);
		        w.setComposite(ac);

	        }
            w.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(procesada, "png", baos);
            baos.flush();
            byte[] byteArray = baos.toByteArray();
            front = Base64.getEncoder().encodeToString(byteArray);
            baos.close();

        } catch (IOException e) {
            front =  e.getMessage();
        }
    }

    private void crearImagenTrasera(Person person, String pathReverso) {
        try {
            BufferedImage image = ImageIO.read(new URL(pathReverso));

            int imageType = BufferedImage.TYPE_INT_ARGB;
            BufferedImage procesada = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

            Graphics2D w = (Graphics2D) procesada.getGraphics();
            w.drawImage(image, 0, 0, null);
            w.setColor(Color.BLACK);

            w.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            int x1 = 90;
            int x2 = 780;
            if (person.getSexoPadres() == null) {
                w.drawString(Tags.APELLIDOS_NOMBRES_PADRE, x1, 60);
                w.drawString(Tags.APELLIDOS_NOMBRES_MADRE, x1, 130);
            } else if (person.getSexoPadres().equals("M")) {
                w.drawString(Tags.APELLIDOS_NOMBRES_PADRE, x1, 60);
                w.drawString(Tags.APELLIDOS_NOMBRES_PADRE, x1, 130);
            } else if (person.getSexoPadres().equals("F")) {
                w.drawString(Tags.APELLIDOS_NOMBRES_MADRE, x1, 60);
                w.drawString(Tags.APELLIDOS_NOMBRES_MADRE, x1, 130);
            }
            w.drawString(Tags.ESTADO_CIVIL, x1, 200);
            if (person.getConyugue() != null && !person.getConyugue().trim().equals(""))
                w.drawString(Tags.APELLIDOS_NOMBRES_CONYUGUE_CONVIVIENTE, x1, 270);
            w.drawString(Tags.LUGAR_FECHA_EMISION, x1, 340);

            w.drawString(Tags.CODIGO_DACTILAR, x2, 60);
            //String tipoSangre = "TIPO SANGRE " + persona.getTipoSangre();
            w.drawString(Tags.TIPO_SANGRE, x2, 130);
            if (person.getCondDiscapacidad() != null && !person.getCondDiscapacidad().trim().equals(""))
                w.drawString(Tags.DISCAPACIDAD, x2, 170);
            w.drawString(Tags.DONANTE, x2, 240);

            w.setFont(new Font("Arial", Font.BOLD, 22));

            //w.drawString(persona.getInstruccion() != null ? persona.getInstruccion(): "", 90, 110);
           // w.drawString(persona.getProfesion() != null ? persona.getProfesion() : "", 432, 110);
            w.drawString(person.getNombresPadre() != null ? person.getNombresPadre() : "", x1, 90);
            w.drawString(person.getNombresMadre() != null ? person.getNombresMadre() : "", x1, 160);
            DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy", LOCALE);
            DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd MMM yyyy", LOCALE);
            String lugarFechaEmision = person.getLugarExpedicion() + " " + LocalDate.parse(person.getFechaExpedicion(), formato1).format(formato2).toUpperCase();
            w.drawString(lugarFechaEmision, x1,370);
            //w.drawString(persona.getFechaExpedicion() != null ? persona.getFechaExpedicion() : "", x1, 355);
            //w.drawString(persona.getFechaExpiracion() != null ? persona.getFechaExpiracion() : "", 88, 448);
            w.drawString(person.getConyugue() != null ? person.getConyugue(): "", x1, 300);
            w.drawString(person.getEstadoCivil() != null ? person.getEstadoCivil(): "", x1, 230);

            w.drawString(person.getCodigoDactilar() != null ? person.getCodigoDactilar() : "", x2, 90);
            w.drawString(person.getTipoSangre() != null ? person.getTipoSangre() : "", 910, 135);
            w.drawString(person.getCondDonante() != null ? person.getCondDonante() : "", x2, 270);
            String condicion = person.getCondDiscapacidad() + " " + person.getPorDiscapacidad();
            w.drawString(condicion, x2, 200);
            w.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(procesada, "png", baos);
            baos.flush();

            byte[] byteArray = baos.toByteArray();
            reverso = Base64.getEncoder().encodeToString(byteArray);
            baos.close();
        } catch (IOException e) {
            reverso = e.getMessage();
        }
    }
}
