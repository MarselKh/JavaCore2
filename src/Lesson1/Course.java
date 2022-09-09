package Lesson1;

public class Course {

    private int distanceRun;
    private int distanceSwim;
    private int distanceCycle;
    public static String showFinishMember = "Участники прошедшие дистанцию: ";

    public Course(int distanceRun, int distanceSwim, int distanceCycle) {
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
        this.distanceCycle = distanceCycle;
    }

    public void doIt(Team team) {
        for (Member member: team.getMembersTeam()) {
            if (member.getRun() >= distanceRun & member.getSwim() >= distanceSwim & member.getCycle() >= distanceCycle) {
                showFinishMember += member.getNameMember() + " ";
            }
        }
    }
}
