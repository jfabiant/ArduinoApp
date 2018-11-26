package pe.edu.tecsup.jfabiant.arduinoapp.models;

import java.util.Date;

public class Data {

    private Integer id;
    private String humedad;
    private String temperatura;
    private String rayos_v;
    private String sensor_lluvia;
    private Date created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getRayos_v() {
        return rayos_v;
    }

    public void setRayos_v(String rayos_v) {
        this.rayos_v = rayos_v;
    }

    public String getSensor_lluvia() {
        return sensor_lluvia;
    }

    public void setSensor_lluvia(String sensor_lluvia) {
        this.sensor_lluvia = sensor_lluvia;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", humedad='" + humedad + '\'' +
                ", temperatura='" + temperatura + '\'' +
                ", rayos_v='" + rayos_v + '\'' +
                ", sensor_lluvia='" + sensor_lluvia + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
