package Lesson1;

import static Lesson1.Course.showFinishMember;

public class Team {

    private String name;
    private Member[] membersTeam;



    public Team(String name, Member[] membersTeam) {
        this.name = name;
        this.membersTeam = membersTeam;
    }

    public void printInfoMembersTeam(Team team) {
        System.out.println("Команда " + team.getName() + " состоит из участников:");
        for (Member member: team.getMembersTeam()) {
            System.out.println(member.getNameMember());
        }
    }

    public void showResults () {
        System.out.println(showFinishMember);
    }

    public String getName() {
        return name;
    }

    public Member[] getMembersTeam() {
        return membersTeam;
    }
}
