package rc.dni;

public class Response {

    private String front;
    private String reverso;

    public Response(String front, String reverso) {
        this.front = front;
        this.reverso = reverso;
    }

    public String getReverso() {
        return reverso;
    }

    public void setReverso(String reverso) {
        this.reverso = reverso;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }
}
