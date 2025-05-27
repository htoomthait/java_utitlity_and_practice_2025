package info.htoomaungthait.ems_backend.dto;

public class SampleProductDto {
    private String name;
    private SampleProductDataDto data;

    // Getters and setters (or use Lombok @Data)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SampleProductDataDto getData() {
        return data;
    }

    public void setData(SampleProductDataDto data) {
        this.data = data;
    }
}
