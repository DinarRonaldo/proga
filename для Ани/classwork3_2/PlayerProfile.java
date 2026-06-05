package proga.classwork3_2;

import java.io.Serializable;

public class PlayerProfile implements Serializable {
    private String nickname;
    private int level;
    private long score;
    private boolean isOnline;

    public PlayerProfile(String nickname, int level, long score, boolean isOnline) {
        this.nickname = nickname;
        this.level = level;
        this.score = score;
        this.isOnline = isOnline;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}