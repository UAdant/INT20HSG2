package com.example.int20hsg2;


public class DeviceData {
    private int id;
    private String type;
    private String brand;
    private String model;
    private boolean video;
    private boolean wifi;
    private boolean twoGHz;
    private boolean fiveGHz;
    private String securityProtocol;
    private boolean privacyShutter;
    private String encryption;
    private boolean secure;
    private String infoLink;
    private String comments;

    public DeviceData(int id, String type, String brand, String model, boolean video, boolean wifi, boolean twoGHz, boolean fiveGHz, String securityProtocol, boolean privacyShutter, String encryption, boolean secure, String infoLink, String comments) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.video = video;
        this.wifi = wifi;
        this.twoGHz = twoGHz;
        this.fiveGHz = fiveGHz;
        this.securityProtocol = securityProtocol;
        this.privacyShutter = privacyShutter;
        this.encryption = encryption;
        this.secure = secure;
        this.infoLink = infoLink;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isVideo() {
        return video;
    }

    public boolean isWifi() {
        return wifi;
    }

    public boolean istwoGHz() {
        return twoGHz;
    }

    public boolean isfiveGHz() {
        return fiveGHz;
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }

    public boolean isPrivacyShutter() {
        return privacyShutter;
    }

    public String getEncryption() {
        return encryption;
    }

    public boolean isSecure() {
        return secure;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "DeviceData{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", video=" + video +
                ", wifi=" + wifi +
                ", twoGHz=" + twoGHz +
                ", fiveGHz=" + fiveGHz +
                ", securityProtocol='" + securityProtocol + '\'' +
                ", privacyShutter=" + privacyShutter +
                ", encryption='" + encryption + '\'' +
                ", secure=" + secure +
                ", infoLink='" + infoLink + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
