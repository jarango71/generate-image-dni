package rc.dni;

public class Person {
    private static final long serialVersionUID = -886161831982007811L;

    private String tipoCedula;
    private String numeroCedula;
    private String nombres;
    private String lugarNacimiento1;
    private String lugarNacimiento2;
    private String fechaNacimiento;
    private String nacionalidad;
    private String sexo;
    private String estadoCivil;
    private String instruccion;
    private String profesion;
    private String codigoDactilar;
    private String nombresPadre;
    private String nombresMadre;
    private String lugarExpedicion;
    private String fechaExpedicion;
    private String fechaExpiracion;
    private String fotoPersona;

    private String nombresCiu;
    private String apellidosCiu;
    private String conyugue;
    private String cedulaFrontal;
    private String cedulaReverso;

    private String apellido1;
    private String apellido2;
    private String sexoPadres;
    private String tipoSangre;
    private String condDonante;
    private String condDiscapacidad;
    private String porDiscapacidad;

    public String getTipoCedula() {
        return tipoCedula;
    }
    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }
    public String getNumeroCedula() {
        return numeroCedula;
    }
    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getLugarNacimiento1() {
        return lugarNacimiento1;
    }

    public void setLugarNacimiento1(String lugarNacimiento1) {
        this.lugarNacimiento1 = lugarNacimiento1;
    }

    public String getLugarNacimiento2() {
        return lugarNacimiento2;
    }

    public void setLugarNacimiento2(String lugarNacimiento2) {
        this.lugarNacimiento2 = lugarNacimiento2;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getInstruccion() {
        return instruccion;
    }
    public void setInstruccion(String instruccion) {
        this.instruccion = instruccion;
    }
    public String getProfesion() {
        return profesion;
    }
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    public String getNombresPadre() {
        return nombresPadre;
    }
    public void setNombresPadre(String nombresPadre) {
        this.nombresPadre = nombresPadre;
    }
    public String getNombresMadre() {
        return nombresMadre;
    }
    public void setNombresMadre(String nombresMadre) {
        this.nombresMadre = nombresMadre;
    }
    public String getFechaExpedicion() {
        return fechaExpedicion;
    }
    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    public String getCodigoDactilar() {
        return codigoDactilar;
    }
    public void setCodigoDactilar(String codigoDactilar) {
        this.codigoDactilar = codigoDactilar;
    }
    public String getFotoPersona() {
        return fotoPersona;
    }
    public void setFotoPersona(String fotoPersona) {
        this.fotoPersona = fotoPersona;
    }
    public String getCedulaFrontal() {
        return cedulaFrontal;
    }
    public void setCedulaFrontal(String cedulaFrontal) {
        this.cedulaFrontal = cedulaFrontal;
    }
    public String getCedulaReverso() {
        return cedulaReverso;
    }
    public void setCedulaReverso(String cedulaReverso) {
        this.cedulaReverso = cedulaReverso;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getNombresCiu() {
        return nombresCiu;
    }

    public void setNombresCiu(String nombresCiu) {
        this.nombresCiu = nombresCiu;
    }

    public String getApellidosCiu() {
        return apellidosCiu;
    }

    public void setApellidosCiu(String apellidosCiu) {
        this.apellidosCiu = apellidosCiu;
    }

    public String getConyugue() {
        return conyugue;
    }

    public void setConyugue(String conyugue) {
        this.conyugue = conyugue;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getSexoPadres() {
        return sexoPadres;
    }

    public void setSexoPadres(String sexoPadres) {
        this.sexoPadres = sexoPadres;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getCondDonante() {
        return condDonante;
    }

    public void setCondDonante(String condDonante) {
        this.condDonante = condDonante;
    }

    public String getCondDiscapacidad() {
        return condDiscapacidad;
    }

    public void setCondDiscapacidad(String condDiscapacidad) {
        this.condDiscapacidad = condDiscapacidad;
    }

    public String getPorDiscapacidad() {
        return porDiscapacidad;
    }

    public void setPorDiscapacidad(String porDiscapacidad) {
        this.porDiscapacidad = porDiscapacidad;
    }

    public Person(){

    }
}
