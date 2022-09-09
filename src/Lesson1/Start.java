package Lesson1;

public class Start {

    public static void main (String[] args) {
        Course c = new Course(3000, 500, 6000);

        Member members [] = new Member[4];
        members[0] = new Member("Anton", 4000, 450, 9000);
        members[1] = new Member("Viktoria", 3000, 500, 7000);
        members[2] = new Member("Sergei", 6000, 1000, 12000);
        members[3] = new Member("Svetlana", 2500, 400, 5000);

        Team team = new Team("Fortochka", members);
        c.doIt(team);
        team.printInfoMembersTeam(team);
        team.showResults();

    }
}


//1. Добавить класс Team, который будет содержать:
//название команды;
//массив из четырех участников — в конструкторе можно сразу всех участников указывать);
//метод для вывода информации о членах команды, прошедших дистанцию;
//метод вывода информации обо всех членах команды.
//2. Добавить класс Course (полоса препятствий), в котором будут находиться:
//массив препятствий;
//метод, который будет просить команду пройти всю полосу.

//В итоге должно получиться похожее:
//public static void main(String[] args) {
//Course c = new Course(...); // Создаем полосу препятствий
//Team team = new Team(...); // Создаем команду
//c.doIt(team); // Просим команду пройти полосу
//team.showResults(); // Показываем результаты
//}