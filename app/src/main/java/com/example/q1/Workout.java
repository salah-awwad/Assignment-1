package com.example.q1;

public class Workout {
    private String type;
    private String intensity;
    private int duration;

    public Workout(String type, String intensity, int duration) {
        this.type = type;
        this.intensity = intensity;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
