package rc.dni;

public class Request {
    private Person person;
    private String pathFrente;
    private String pathReverso;
    public Request(Person person, String pathFrente, String pathReverso){
        this.person = person;
        this.pathFrente = pathFrente;
        this.pathReverso = pathReverso;
    }


    public Request(){

    }
    public Person getPersona() {
        return person;
    }

    public void setPersona(Person person) {
        this.person = person;
    }

    public String getPathFrente() {
        return pathFrente;
    }

    public void setPathFrente(String pathFrente) {
        this.pathFrente = pathFrente;
    }

    public String getPathReverso() {
        return pathReverso;
    }

    public void setPathReverso(String pathReverso) {
        this.pathReverso = pathReverso;
    }
}
