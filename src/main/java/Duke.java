import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static TodoList todolist = new TodoList();

    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        introduceDuke();
    }

    public static void formatMessages(String message) {
        String output = "     -------------------------------------- \n"
                + "      " + message + "\n"
                + "\n     --------------------------------------";
        System.out.println(output);
    }

    public static void introduceDuke() {
        Scanner sc = new Scanner(System.in);
        String introduction = "Hello, I am Ah Seng, the foodcourt uncle. Come chitchat with me.";
        formatMessages(introduction);
        respondTo(sc);
    }

    public static void terminateProgramme() {
        String endingMessage = "Ah ok bye. Next time treat uncle kopi ok?";
        formatMessages(endingMessage);
    }

    public static void respondTo(Scanner sc) {
        String input = sc.nextLine();
        if(input.equals("bye")) {
            terminateProgramme();
        } else if (input.equals("list")) {
            printTasks();
            respondTo(sc);
        } else if (taskComplete(input)) {
            completeTask(input);
            respondTo(sc);
        } else {
            insertTask(input);
            respondTo(sc);
        }
    }

    public static void insertTask(String input) {
        todolist.insertTask(input);
        String done = "OK uncle added " + input + " for you liao.";
        formatMessages(done);
    }

    public static void printTasks() {
        formatMessages(todolist.getList());
    }

    public static void completeTask(String input) {
        String first = input.split(" ")[0];
        String second = input.split(" ")[1];

        try {
            int value = Integer.parseInt(second);
            Task task = todolist.complete(value-1);
            String completedTask = "Swee la! You good la sia, finished this task:\n        " + "[X] " + task.getName() ;
            formatMessages(completedTask);

        } catch (NumberFormatException e) {
            System.out.println("Aiyo, you say done a task but you never tell me which one leh.");
        }
    }

    public static boolean taskComplete(String input) {
        String first = input.split(" ")[0];
        return first.equalsIgnoreCase("done");
    }
}
