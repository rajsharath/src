package graph;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DijkHeap {

        public void dijk(Map<Integer, Map<Integer, Integer>> graph) {
                int[] minDistancesArray = new int[graph.keySet().size() + 1];
                int maxDistance = 1000000;
                for (int i = 1; i < minDistancesArray.length; i++) {
                        minDistancesArray[i] = maxDistance;
                }
                minDistancesArray[1] = 0;

                // initialize the heap
                MinNodeHeap minHeap = new MinNodeHeap();
                minHeap.insert(new Node(1, 0));
                for (int i = 2 ; i <= graph.keySet().size() ; i++) {
                        minHeap.insert(new Node(i, maxDistance));
                }

                // vertexId is the index of the array
                int[] positionInHeap = new int[graph.keySet().size() + 1];
                positionInHeap[1] = 1;
                for (int i = 2 ; i <= graph.keySet().size() ; i++) {
                        positionInHeap[i] = i;
                }        
                
                int count = graph.keySet().size() - 1;

                while (count > 0) {
                        Node node = minHeap.extractMin2(positionInHeap);
                        minDistancesArray[node.vertexId] = node.minDistance;
                        Map<Integer, Integer> map = graph.get(node.vertexId);
                        for (Integer childVertex : map.keySet()) {
                                int currentMinDist = minDistancesArray[childVertex];
                                int dgs = node.minDistance + map.get(childVertex);
                                if (currentMinDist <= dgs) {
                                        continue;
                                }
                                int newPositionInHeap = minHeap.decrementKey(positionInHeap[childVertex], dgs, positionInHeap);
                                positionInHeap[childVertex] = newPositionInHeap;
                        }
                        count--;
                }
                System.out.println(minDistancesArray[7] + "," + minDistancesArray[37] + "," 
                                + minDistancesArray[59] + "," + minDistancesArray[82] + "," + minDistancesArray[99] + ","
                                + minDistancesArray[115] + "," + minDistancesArray[133] + "," + minDistancesArray[165] + ","
                                + minDistancesArray[188] + ","  + minDistancesArray[197]);
        }
        
        private static void readFile(Map<Integer, Map<Integer, Integer>> graph) {
                try {
                        FileInputStream fstream = new FileInputStream("/tmp/dijkstraData.txt");
                        DataInputStream in = new DataInputStream(fstream);
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        String strLine;
                        while ((strLine = br.readLine()) != null) {
                                process(strLine, graph);
                        }
                        in.close();
                } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                }
        }
        
        private static void process(String strLine, Map<Integer, Map<Integer, Integer>> graph) {
                String[] strs= strLine.split("\\s+");
                int processingNode = 0;
                int i = 0;
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (String str : strs) {
                        if (i == 0) {
                                i++;
                                processingNode = new Integer(str);
                                continue;
                        }
                        String[] strs2= str.split(",");
                        map.put(new Integer(strs2[0]), new Integer(strs2[1]));                                        
                }
                graph.put(processingNode,  map);
        }

        /**
         * @param args
         */
        public static void main(String[] args) {
                Map<Integer, Map<Integer, Integer>> graph = new HashMap<Integer, Map<Integer, Integer>>();                
                readFile(graph);
                new DijkHeap().dijk(graph);                
        }

}
