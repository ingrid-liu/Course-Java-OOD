public class Main {
    public static void main(String[] args) {
        DonationStrategy donationStrat1 = new DonateJustGiving();
        donationStrat1.donate(100);

        DonationStrategy donationStrat2 = new DonatePayPal();
        donationStrat2.donate(250);

        DonationStrategy donationStrat3 = new DonateCheck();
        donationStrat3.donate(50);

        DonationStrategy donationStrat4 = new DonateNetwork();
        donationStrat4.donate(1000);

        DonationStrategy donationStrat5 = new DonateCreditCard();
        donationStrat5.donate(10);
    }
}
