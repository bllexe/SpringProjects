package org.tigris.docker.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Visitor {

    @Id
    @GeneratedValue
    private  long id;
    @Column(nullable = false)
    private long times;
    private String ip;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }



}
