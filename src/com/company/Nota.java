package com.company;

public class Nota {
    private float puntuacion;
    private String asignatura;
    private TipoDeEvaluacion tipoDeEvaluacion;

    public Nota(float puntuacion, String asignatura, TipoDeEvaluacion tipoDeEvaluacion){
        this.puntuacion = puntuacion;
        this.asignatura = asignatura;
        this.tipoDeEvaluacion = tipoDeEvaluacion;
    }

    public float getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public TipoDeEvaluacion getTipoDeEvaluacion() {
        return tipoDeEvaluacion;
    }
    public void setTipoDeEvaluacion(TipoDeEvaluacion tipoDeEvaluacion) {
        this.tipoDeEvaluacion = tipoDeEvaluacion;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "puntuacion=" + puntuacion +
                ", asignatura='" + asignatura + '\'' +
                ", tipoDeEvaluacion='" + tipoDeEvaluacion + '\'' +
                '}';
    }

    enum TipoDeEvaluacion {ACS, TCP, PF}
}
