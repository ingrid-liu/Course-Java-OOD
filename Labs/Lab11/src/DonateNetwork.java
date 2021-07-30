public class DonateNetwork implements DonationStrategy{
    @Override
    public void donate(int amount) {
        System.out.println("Processing $" + amount + " donation through Network for Good");
    }
}
