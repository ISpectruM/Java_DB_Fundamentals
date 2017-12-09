package app.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
@Entity
@DiscriminatorValue(value = "Mirrorless")
public class MirrorlessCamera extends BasicCamera{
    @Column(name = "max_frame_rate")
    private Integer maxFrameRate;
    @Column(name = "max_video_resolution")
    private String maxVideoResolution;

    public MirrorlessCamera() {
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
}
