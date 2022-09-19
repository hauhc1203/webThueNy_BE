package hauhc1203.webthueny.models.dto;

import hauhc1203.webthueny.models.AppUser;

import javax.persistence.ManyToOne;

public class MaR {

    private AppUser sender;

    private AppUser receiver;

    private String content;


    private String room;

    public MaR() {
    }

    public MaR(AppUser sender, AppUser receiver, String content, String room) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.room = room;
    }

    public AppUser getSender() {
        return sender;
    }

    public void setSender(AppUser sender) {
        this.sender = sender;
    }

    public AppUser getReceiver() {
        return receiver;
    }

    public void setReceiver(AppUser receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
