package com.pm;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();

        if (args.length == 0) {
            System.out.println("No command provided");
            return;
        }
        switch (args[0]) {
            case "add":
                String desc= "";
                if(args.length>2) {
                    for (int i = 2; i < args.length; i++) {
                        desc += " " + args[i];
                    }
                }
                else {
                    desc = args[1];
                }
                service.addTask(desc);
                break;
            case "list":
                service.list(args.length > 1 ? args[1].toLowerCase() : null);
                break;
            case "mark-done":
                service.mark(Integer.parseInt(args[1]), TaskStatus.done);
                break;
            case "mark-in-progress":
                service.mark(Integer.parseInt(args[1]), TaskStatus.inProgress);
                break;
            case "delete":
                service.delete(Integer.parseInt(args[1]));
                break;
            case "update":
                desc= "";
                if(args.length>3) {
                    for (int i = 2; i < args.length; i++) {
                        desc += " " + args[i];
                    }
                }
                else {
                    desc = args[2];
                }
                service.update(Integer.parseInt(args[1]) , desc);
                break;
            default:
                System.out.println("Unknown command");
        }
    }
}