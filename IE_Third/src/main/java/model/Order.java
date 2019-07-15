package model;

public class Order {
    private Order(){

    }
    private static Order instance = null;
    public static Order getInstance(){
        if(instance == null){
            instance = new Order();
            return instance;
        }
        return instance;
    }
    private String firstName;
    private String lastName;
    private int orderId;
    private boolean weight;
    private boolean waterProof;
    private boolean garanti;
    private boolean goodCamera;
    private boolean shortEdgge;
    private boolean smallSizeToCanBeInPacket;
    private String color;
    private double screenSize;
    private int ramSize;
    private int numOfCamera;
    private int backCameraResolution;
    private boolean charger;
    private boolean cover;
    private boolean headphone;
    private boolean wirelessCharger;
    private boolean antiScratch;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isWeight() {
        return weight;
    }

    public void setWeight(boolean weight) {
        this.weight = weight;
    }

    public boolean isWaterProof() {
        return waterProof;
    }

    public void setWaterProof(boolean waterProof) {
        this.waterProof = waterProof;
    }

    public boolean isGaranti() {
        return garanti;
    }

    public void setGaranti(boolean garanti) {
        this.garanti = garanti;
    }

    public boolean isGoodCamera() {
        return goodCamera;
    }

    public void setGoodCamera(boolean goodCamera) {
        this.goodCamera = goodCamera;
    }

    public boolean isShortEdgge() {
        return shortEdgge;
    }

    public void setShortEdgge(boolean shortEdgge) {
        this.shortEdgge = shortEdgge;
    }

    public boolean isSmallSizeToCanBeInPacket() {
        return smallSizeToCanBeInPacket;
    }

    public void setSmallSizeToCanBeInPacket(boolean smallSizeToCanBeInPacket) {
        this.smallSizeToCanBeInPacket = smallSizeToCanBeInPacket;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getNumOfCamera() {
        return numOfCamera;
    }

    public void setNumOfCamera(int numOfCamera) {
        this.numOfCamera = numOfCamera;
    }

    public int getBackCameraResolution() {
        return backCameraResolution;
    }

    public void setBackCameraResolution(int backCameraResolution) {
        this.backCameraResolution = backCameraResolution;
    }

    public boolean isCharger() {
        return charger;
    }

    public void setCharger(boolean charger) {
        this.charger = charger;
    }

    public boolean isCover() {
        return cover;
    }

    public void setCover(boolean cover) {
        this.cover = cover;
    }

    public boolean isHeadphone() {
        return headphone;
    }

    public void setHeadphone(boolean headphone) {
        this.headphone = headphone;
    }

    public boolean isWirelessCharger() {
        return wirelessCharger;
    }

    public void setWirelessCharger(boolean wirelessCharger) {
        this.wirelessCharger = wirelessCharger;
    }

    public boolean isAntiScratch() {
        return antiScratch;
    }

    public void setAntiScratch(boolean antiScratch) {
        this.antiScratch = antiScratch;
    }
}
