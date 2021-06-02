public class CSuiteManager extends Person {
    private int stockOptions;
    private double strikePrice;
    private String fancyTitle;

    public CSuiteManager(String name, int age, String SSN, String password, String fancyTitle) {
        super(name, age, SSN, password);
        this.stockOptions = 0;
        this.strikePrice = 1.00;
        this.fancyTitle = fancyTitle;
    }

    public CSuiteManager(String name, int age, String SSN, String password,
                         int stockOptions, double strikePrice, String fancyTitle) {
        super(name, age, SSN, password);
        this.stockOptions = stockOptions;
        this.strikePrice = strikePrice;
        this.fancyTitle = fancyTitle;
    }

    public int getStockOptions() {
        return stockOptions;
    }

    public void setStockOptions(int stockOptions) {
        this.stockOptions = stockOptions;
    }

    public double getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(double strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getFancyTitle() {
        return fancyTitle;
    }

    public void setFancyTitle(String fancyTitle) {
        this.fancyTitle = fancyTitle;
    }

    public double exerciseCost(){
        return this.strikePrice * this.stockOptions;
    }

    public int increaseOption(int increaseOption){
        if (increaseOption < 0 ){
            throw new IllegalArgumentException("Stock option increment can not be negative.");
        }
        return this.stockOptions += increaseOption;
    }

    public double capitalGain(double marketPrice){
        return (marketPrice - this.strikePrice)* this.stockOptions;
    }

    @Override
    public String toString() {
        return "This is a CSuiteManager. " + "Name: " + getName() + "; Age: " + getAge() +
                "; Title: " + fancyTitle;
    }

    public String printStockInfo() {
        return "Stock option: " + this.stockOptions + "\nStrike price: $" + this.strikePrice
                + "\nExercise cost: $" + this.exerciseCost()
                + "\nCaptical gain: $" + this.capitalGain(1);
    }
}
