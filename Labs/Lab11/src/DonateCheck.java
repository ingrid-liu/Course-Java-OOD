public class DonateCheck implements DonationStrategy{
    @Override
    public void donate(int amount) {
        System.out.println("Processing $" + amount + " donation through mailing a check or money");
    }
}
