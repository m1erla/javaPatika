package WeekFive.PatikaStore.Path;

public class Brands implements Comparable<Brands>{
    private int brandId;
    private String brandName;

    public Brands(int brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public int getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public int compareTo(Brands other) {
        return this.brandName.compareTo(other.getBrandName());
    }
}
