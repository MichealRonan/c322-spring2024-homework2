package iu.msronan.edu.c322spring2024homework2.model;

public class Guitar {

    private String serialNumber;
    private double price;
    private String builder;
    private String model;
    private String type;
    private String backWood;
    private String topWood;

    public Guitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = String.valueOf(builder);
        this.model = model;
        this.type = String.valueOf(type);
        this.backWood = String.valueOf(backWood);
        this.topWood = String.valueOf(topWood);
    }


    public enum Builder {
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

        @Override
        public String toString() {
            switch (this){
                case FENDER: return "Fender";
                case MARTIN: return "Martin";
                case GIBSON: return "Gibson";
                case COLLINGS: return "Collings";
                case OLSON: return "Olson";
                case RYAN: return "Ryan";
                case PRS: return "PRS";
                case ANY:
                default: return "Unspecified";
            }
        }
    }

    public enum Type{
        ACOUSTIC, ELECTRIC;

        @Override
        public String toString() {
            switch (this){
                case ACOUSTIC: return "acoustic";
                case ELECTRIC: return "electric";
                default: return "Unspecified";
            }
        }
    }

    public enum Wood{
        INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE,
        COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

        @Override
        public String toString() {
            switch (this){
                case INDIAN_ROSEWOOD: return "Indian Rosewood";
                case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
                case MAHOGANY: return "Mahogany";
                case SITKA: return "Sitka";
                case ALDER: return "Alder";
                case CEDAR: return "Cedar";
                case MAPLE: return "Maple";
                case COCOBOLO: return "Cocobolo";
                case ADIRONDACK: return "Adirondack";
                default: return "Unspecified";
            }
        }
    }
    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }


}
