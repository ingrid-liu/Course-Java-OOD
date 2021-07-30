public class DonateJustGiving implements DonationStrategy{
    @Override
    public void donate(int amount) {
        System.out.println("Processing $" + amount + " donation through JustGiving");
    }
}
