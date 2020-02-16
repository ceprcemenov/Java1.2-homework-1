public class main {
    public static void main(String[] args) {
        int deposit = 2_000_000_000;
        int incoming_transfer = 500_000_000;
        int deposit_new = deposit + incoming_transfer;
        System.out.println("Текущий баланс: " + deposit_new);
    }
}
