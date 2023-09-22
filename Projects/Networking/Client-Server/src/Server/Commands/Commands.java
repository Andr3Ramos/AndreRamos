package Server.Commands;

import javax.xml.stream.events.EndDocument;

public enum  Commands {
     BYE("BYE"),
     DISCONNECT("DISCONNECT"),
     QUIT("QUIT"),
     HELP("HELP"),
     LS("LS"),
     PUT("PUT"),
     GET("GET"),
     MKDIR("MKDIR"),

     END("/end");


     private String command;

     Commands(String command){
         this.command = command;
     }



}
