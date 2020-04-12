import sun.rmi.runtime.Log;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        System.out.println("Good luck");
        Map map = null;
        try {
            map = Map.CreateMap("map.txt");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getStackTrace());
        }
        WavefrontAgent agent = new WavefrontAgent(map);
        Logger logger = new Logger("test2.xml");
        agent.addObserver(logger);
        Administrator admin = new Administrator(map, agent);
        int i=1;

        while(map.getNotReachYet() != 0 ){
            admin.doOneStep();
            System.out.println(i);
            map.printMap();
            i++;
        }
        logger.save();

        var a=LoggerParser.GetReports("test2.xml");
        for (Report r:a) {
            System.out.println("Agent Loc: ("+r.getAgentLocation().getX()
            +","+r.getAgentLocation().getY()+")");
            System.out.println("Checked points: "+r.GetPointsChecked().size());
            System.out.println("Compared points: "+r.GetPointsCompared().size());
        }





        /*
        MyAgent agent=new GreedyHeuristic(map);
        MyAgent agent1=new DFSAgent(map);
        Administrator admin = new Administrator(map, agent1);
        map.printMap();
        int steps = 50;
        for (int i =0; i < steps ; i++) {
            System.out.println(i);
            map.printMap();
            admin.doOneStep();
        }
        */

        /*
        while(map.getNotReachYet() != 0) {
            map.printMap();
            admin.doOneStep();
        }*/
        /*
        int steps = 1000;
        for (int i =0; i < steps ; i++) {
            System.out.println(i);
            map.printMap();
            admin.doOneStep();
            if (map.getNotReachYet() == 0) break;
            System.out.println(map.getNotReachYet());
        }*/







        /*Agent agent=new DFSAgent(map);
        List<String> mapSteps=agent.calculateSteps();
        int i=0;
        for (String m:mapSteps) {
            System.out.println(i);
            i++;
            System.out.println(m);
        }*/
        /*
        Agent agent = new DummyAgent();
        Administrator admin = new Administrator(map, agent);

        int numberOfSteps = 5;
        MapLogger mapLogger = new MapLogger();
        map.addObserver(mapLogger);
        for(int i = 0 ; i < numberOfSteps; i++) {//we need to change it
            map.printMap();
            admin.doOneStep();
            System.out.println();
        }
        mapLogger.save();*/


    }
}
