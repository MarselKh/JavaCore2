package Lesson1;

public class Member {
    
    private String nameMember;
    private int run;
    private int swim;
    private int cycle;

    public Member(String nameMember, int run, int swim, int cycle) {
        this.nameMember = nameMember;
        this.run = run;
        this.swim = swim;
        this.cycle = cycle;
    }

    public String getNameMember() {
        return nameMember;
    }

    public int getRun() {
        return run;
    }

    public int getSwim() {
        return swim;
    }

    public int getCycle() {
        return cycle;
    }
}
