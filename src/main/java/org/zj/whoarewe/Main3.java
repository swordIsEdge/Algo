package org.zj.whoarewe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    private static HashMap<String, RmAppAttempt> rmAppAttempts;
    private static HashMap<Resource, Set<Event>> validateMap;

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        rmAppAttempts = new HashMap<>();
        initValidateMap();


        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] cmds = s.split(" ");
            for (String cmdInString : cmds) {
                try {
                    Cmd cmd = parseCmd(cmdInString);
                    handleCmd(cmd);
                } catch (Exception e) {
                }
            }
        }
    }

    private static void initValidateMap() {
        validateMap = new HashMap<>();

        Set<Event> set = new HashSet<>();
        set.add(Event.start);
        set.add(Event.kill);
        validateMap.put(Resource.RmApp, set);

        set = new HashSet<>();
        set.add(Event.app_accepted);
        set.add(Event.finished);
        validateMap.put(Resource.ResouceScheduler, set);

        set = new HashSet<>();
        set.add(Event.container_allocated);
        validateMap.put(Resource.RmContainer, set);

        set = new HashSet<>();
        set.add(Event.launched);
        validateMap.put(Resource.ApplicationMasterLauncher, set);


    }

    private static void handleCmd(Cmd cmd) {
        if (!validateCmd(cmd)) {
            return;
        }
        switch (cmd.event) {
            case start:
                RmAppAttempt rmAppAttempt = new RmAppAttempt(cmd.target);
                rmAppAttempts.put(cmd.target, rmAppAttempt);
                break;
            default:
                rmAppAttempt = rmAppAttempts.get(cmd.target);
                rmAppAttempt.handleEvent(cmd.event);
        }

    }

    private static Cmd parseCmd(String cmd) {
        String[] strings = cmd.split("\\|");
        Resource resource = Resource.valueOf(strings[0]);
        String target = strings[1];
        Event event = Event.valueOf(strings[2]);
        Cmd cmd1 = new Cmd(resource, target, event);
        return cmd1;
    }

    private static boolean validateCmd(Cmd cmd) {
        Set<Event> events = validateMap.get(cmd.resource);
        return events.contains(cmd.event);
    }

    public static class Cmd {
        Resource resource;
        String target;
        Event event;

        public Cmd(Resource resource, String target, Event event) {
            this.resource = resource;
            this.target = target;
            this.event = event;
        }
    }

    enum Resource {
        RmApp,
        ResouceScheduler,
        ApplicationMasterLauncher,
        RmContainer;
    }

    enum Event {
        start,
        app_accepted,
        container_allocated,
        launched,
        finished,
        kill;
    }

    enum RmState {
        submitted,
        scheduled,
        allocated,
        running,
        finished,
        killed;

        public RmState transfer(Event event) {
            switch (this) {
                case submitted:
                    if (event == Event.app_accepted) {
                        return scheduled;
                    }
                    if (event == Event.kill) {
                        return killed;
                    }
                    break;
                case running:
                    if (event == Event.finished) {
                        return finished;
                    }
                    if (event == Event.kill) {
                        return killed;
                    }
                    break;
                case allocated:
                    if (event == Event.kill) {
                        return killed;
                    }
                    break;
                case scheduled:
                    if (event == Event.container_allocated) {
                        return allocated;
                    }
                    if (event == Event.launched) {
                        return running;
                    }
                    if (event == Event.kill) {
                        return killed;
                    }
                    break;

            }
            return this;
        }
    }

    public static class RmAppAttempt {
        String name;
        RmState state;

        public RmAppAttempt(String name) {
            this.name = name;
            changeState(RmState.submitted);
        }

        public void handleEvent(Event event) {
            RmState newState = state.transfer(event);
            changeState(newState);
        }

        private void changeState(RmState state) {
            if (this.state == state) {
                return;
            }
            this.state = state;
            System.out.print(name + "|" + state.name() + ";");

        }


    }
}