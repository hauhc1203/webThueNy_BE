package hauhc1203.webthueny.models.dto;

public class WalletUser {
    private long id;
    private double numberMoney;

    public WalletUser() {
    }

    public WalletUser(long id, double numberMoney) {
        this.id = id;
        this.numberMoney = numberMoney;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNumberMoney() {
        return numberMoney;
    }

    public void setNumberMoney(double numberMoney) {
        this.numberMoney = numberMoney;
    }
}
