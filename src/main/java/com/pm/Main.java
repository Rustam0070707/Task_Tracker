package com.pm;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
TaskService service = new TaskService();
if(args.length == 0) {
    System.out.println("No command provided");
    return;
}
switch(args[0]){
    case "add":
        service.addTask(args[1]);
        break;
    case "list":
        service.list(args.length > 1 ?args[1].toLowerCase() : null);
        break;
    case "mark-done":
        service.mark(Integer.parseInt(args[1]), TaskStatus.done);
        break;
    case "mark-in-progress":
        service.mark(Integer.parseInt(args[1]), TaskStatus.inProgress);
        break;
    default:
        System.out.println("Unknown command");
}
    }
}