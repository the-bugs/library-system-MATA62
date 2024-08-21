package domain.common;

public class Params {

    private final String commandName;
    private final String firstKey;
    private final String secondKey;

    public Params(
            final String commandName,
            final String firstKey,
            final String secondKey
    ) {
        this.commandName = commandName;
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public Params(final String commandName, final String firstKey) {
        this.commandName = commandName;
        this.firstKey = firstKey;
        this.secondKey = null;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getFirstKey() {
        return firstKey;
    }

    public String getSecondKey() {
        return secondKey;
    }
}
