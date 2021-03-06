package ru.fizteh.fivt.students.kamilTalipov.database;

import ru.fizteh.fivt.students.kamilTalipov.shell.Shell;
import ru.fizteh.fivt.students.kamilTalipov.shell.SimpleCommand;

public class PutCommand extends SimpleCommand {
    public PutCommand(Database database) {
        super("put", -2);
        this.database = database;
    }

    @Override
    public void run(Shell shell, String[] args) throws IllegalArgumentException {
        if (args.length < 2) {
            throw new IllegalArgumentException(name + ": need at least two arguments");
        }
        StringBuilder value = new StringBuilder();
        for (int i = 1; i < args.length; ++i) {
            value.append(args[i]);
            value.append(" ");
        }

        String oldValue = database.put(args[0], value.toString());
        if (oldValue == null) {
            System.out.println("new");
        } else {
            System.out.println("overwrite");
            System.out.println(oldValue);
        }
    }

    private final Database database;
}
