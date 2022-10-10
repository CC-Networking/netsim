package configurator;

import configurator.SimConfig;
import configurator.commands.ConfigCommand;
import exceptions.BadCommandRouting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetNetCmd extends ConfigCommand {
    private static Pattern ptrn = Pattern.compile("^\\s*set-network\\s+(\\w+)\\s*$");

    @Override
    public String commandSection() {
        return "Network";
    }

    @Override
    public boolean matches(String inp) {
        Matcher m = ptrn.matcher(inp);
        return m.matches();
    }

    @Override
    public void execute(String inp) {
        Matcher m = ptrn.matcher(inp);
        if(!m.matches()) {
            throw new BadCommandRouting(this.getClass().toString(), inp);
        }
        SimConfig.getConfig().setDefaultNetworkLayer(m.group(1));
    }

    @Override
    public String toString() {
        return "set-network <NetworkClass>";
    }

    @Override
    public String helpString() {
        return this.toString();
    }
}