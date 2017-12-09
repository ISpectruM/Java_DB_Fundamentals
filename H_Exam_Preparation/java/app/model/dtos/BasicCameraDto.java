package app.model.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class BasicCameraDto implements Serializable{
    @Expose
    private String type;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private boolean isFullFrame;

    @Expose
    private Integer minISO;

    @Expose
    private Integer maxISO;

    @Expose
    private Integer MaxShutterSpeed;

    @Expose
    private Integer maxFrameRate;

    @Expose
    private String maxVideoResolution;

    public BasicCameraDto() {
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isFullFrame() {
        return this.isFullFrame;
    }

    public void setFullFrame(boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public Integer getMinIso() {
        return this.minISO;
    }

    public void setMinIso(Integer minIso) {
        this.minISO = minIso;
    }

    public Integer getMaxIso() {
        return this.maxISO;
    }

    public void setMaxIso(Integer maxIso) {
        this.maxISO = maxIso;
    }

    public Integer getMaxShutterSpeed() {
        return this.MaxShutterSpeed;
    }

    public void setMaxShutterSpeed(Integer maxShutterSpeed) {
        this.MaxShutterSpeed = maxShutterSpeed;
    }

    public Integer getMaxFrameRate() {
        return this.maxFrameRate;
    }

    public void setMaxFrameRate(Integer maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }

    public String getMaxVideoResolution() {
        return this.maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
