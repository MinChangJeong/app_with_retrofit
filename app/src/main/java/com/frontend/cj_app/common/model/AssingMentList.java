package com.frontend.cj_app.common.model;

public class AssingMentList {
    private String packageName;
    private String classSize;
    private String classWeight;
    private String classTraffic;
    private int pickupTime;

    public AssingMentList(){};

    public AssingMentList(String packageName, String classSize, String classWeight, String classTraffic, int pickupTime) {
        this.packageName = packageName;
        this.classSize = classSize;
        this.classWeight = classWeight;
        this.classTraffic = classTraffic;
        this.pickupTime = pickupTime;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassSize() {
        return classSize;
    }

    public void setClassSize(String classSize) {
        this.classSize = classSize;
    }

    public String getClassWeight() {
        return classWeight;
    }

    public void setClassWeight(String classWeight) {
        this.classWeight = classWeight;
    }

    public String getClassTraffic() {
        return classTraffic;
    }

    public void setClassTraffic(String classTraffic) {
        this.classTraffic = classTraffic;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }
}
