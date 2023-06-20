package rw.ac.rca.webapp.util;

import org.fusesource.jansi.Ansi;

public class Formatter {

    public  static  String redColorCode = "\u001B[31m";
    public String resetColorCode = "\u001B[0m";

    public static void printRedMessage(String message){
        System.out.println(Ansi.ansi().fgRed().a(message));
    }

}
