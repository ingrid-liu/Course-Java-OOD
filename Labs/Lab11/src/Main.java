public class Main {
    public static void main(String[] args) {
        DonationStrategy donationStrat1 = new DonateJustGiving();
        donationStrat1.donate(100);

        DonationStrategy donationStrat2 = new DonatePayPal();
        donationStrat2.donate(250);
    }
}
