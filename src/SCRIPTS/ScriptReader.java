package SCRIPTS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import operableSatellites.*;
import datatype.*;
import controlCenter.*;

public class ScriptReader {

    Status lastline_status;

    public ScriptReader() {
        this.lastline_status = Status.OK;
    }

    public Status read(Satellite sat, String script) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/SCRIPTS/" + script + ".txt"));
        while (in.ready()) {
            String currentLine = in.readLine();
            choose(sat, in, currentLine);
        }
        in.close();
        return lastline_status;
    }

    public void choose(Satellite sat, BufferedReader in, String line) throws IOException {
        String[] operation = line.split(":");
        String[] repeat = line.split(" ");

        if (operation[0].equals("")) {
            line = "fini!";
        }

        else {

            if (operation.length == 2) {
                String sub = operation[0];
                String op = operation[1];
                setStatus(ControlCenter.operation(sat, sub, op));
            } else if (repeat[0].equals("REPEAT")) {
                int n = Integer.parseInt(repeat[1]);
                String line_to_repeat = in.readLine();
                for (int i = 0; i < n; i++) {
                    choose(sat, in, line_to_repeat);
                }
            } else if (line.equals("ANDTHEN")) {
                if (lastline_status == Status.OK) {
                    String line_to_execute = in.readLine();
                    choose(sat, in, line_to_execute);
                } else {
                   in.readLine();
                   }
            } else if (line.equals("ORELSE")) {
                if (lastline_status == Status.KO) {
                    String otherChoice = in.readLine();
                    choose(sat, in, otherChoice);
                } else {
                   in.readLine();
                   }
            } else {
                read(sat, operation[0]);
            }
        }
    }

    public void setStatus(Status status) {
        this.lastline_status = status;

    }

}
