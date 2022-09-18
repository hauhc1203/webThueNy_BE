package hauhc1203.webthueny.models.dto;

import java.util.Date;

public class OrderBad {
    private long id;
    private java.util.Date createDate;
    private double total;
    private long idAppUser;
    private long idProfile;
    private long getIdAppUserFrom;
    private long idOrder;
    private String problem;
    private String reason; // thông tin thêm về vấn đề gặp phải, có thể có hoăc k
    private Boolean isConfirm=false;

    public OrderBad() {
    }

    public OrderBad(long id, Date createDate, double total, long idAppUser, long idProfile, long getIdAppUserFrom, long idOrder, String problem, String reason, Boolean isConfirm) {
        this.id = id;
        this.createDate = createDate;
        this.total = total;
        this.idAppUser = idAppUser;
        this.idProfile = idProfile;
        this.getIdAppUserFrom = getIdAppUserFrom;
        this.idOrder = idOrder;
        this.problem = problem;
        this.reason = reason;
        this.isConfirm = isConfirm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public long getIdAppUser() {
        return idAppUser;
    }

    public void setIdAppUser(long idAppUser) {
        this.idAppUser = idAppUser;
    }

    public long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(long idProfile) {
        this.idProfile = idProfile;
    }

    public long getGetIdAppUserFrom() {
        return getIdAppUserFrom;
    }

    public void setGetIdAppUserFrom(long getIdAppUserFrom) {
        this.getIdAppUserFrom = getIdAppUserFrom;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getConfirm() {
        return isConfirm;
    }

    public void setConfirm(Boolean confirm) {
        isConfirm = confirm;
    }
}
