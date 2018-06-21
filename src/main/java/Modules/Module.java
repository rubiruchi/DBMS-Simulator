package main.java.Modules;

import main.java.Event.Event;
import main.java.RandomValueGenerator;
import main.java.Simulator;
import main.java.Statistics.ModuleStatistics;

import java.util.PriorityQueue;

public abstract class Module {
    Simulator simulator;
    //TODO definir si mejor hacer un enum o tener un entero para comparar más facil
    protected int currentModule;

    protected long queueLength;
    protected int numberServers;
    protected int busyServers;

    protected PriorityQueue<Event> queue;
    protected RandomValueGenerator randomValueGenerator;
    protected ModuleStatistics statisticsOfModule;

    Module(Simulator simulator, RandomValueGenerator randSimulator) {
        this.simulator = simulator;
        this.randomValueGenerator = randSimulator;
        this.busyServers = 0;
        this.queueLength = 0;
        this.statisticsOfModule = new ModuleStatistics();
    }

    protected abstract void processArrival(Event event);
    protected abstract void processDeparture(Event event);
    protected abstract double getServiceTime(Event event);
    protected abstract  void processClient(Event event);


    public void processEvent(Event event){
        switch (event.getEventType()){
            case ARRIVAL: processArrival(event);
            break;
            case DEPARTURE: processDeparture(event);
            break;
            default:
                System.out.println("Error, processEvent");
                break;
        }
    }

    protected void checkTimeOutQueue(){

    }

    public int getCurrentModuleType() {
        return currentModule;
    }

    public ModuleStatistics getStatisticsOfModule(){
        return statisticsOfModule;
    }

    public PriorityQueue<Event> getQueue() {
        return queue;
    }

    public RandomValueGenerator getRandomValueGenerator() {
        return randomValueGenerator;
    }
}
