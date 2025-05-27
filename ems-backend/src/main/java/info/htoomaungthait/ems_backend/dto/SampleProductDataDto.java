package info.htoomaungthait.ems_backend.dto;

public class SampleProductDataDto {
    private int year;
    private double price;

    @com.fasterxml.jackson.annotation.JsonProperty("CPU model")
    private String cpuModel;

    @com.fasterxml.jackson.annotation.JsonProperty("Hard disk size")
    private String hardDiskSize;

    // Getters and setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(String hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }
}
