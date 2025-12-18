package com.revision.topics.trees.problems;

import java.util.*;

//Pl - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
//VL - https://youtu.be/i9ORlEy6EsI
public class AlNodesDistanceK {

    public static List<Integer> distanceK(Node root, Node target, int k) {
        //step one - find all the parent for all the nodes and store it in HashMap
        Map<Node, Node> childToParentMapping = getChildToParentMapping(root);

        //keep hashset as visited node container.
        HashSet<Node> visited = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();

        //put target node into queue
        queue.add(target);

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            //when count == K that we have all the required nodes which are equals distance K from target.
            if (count == k) {
                break;
            }

            //Run loop till queue size
            for (int i = 0; i < size; i++) {
                Node polledNode = queue.poll();
                visited.add(polledNode);

                //check if left node is not visited put it into queue
                if (polledNode.left != null && !visited.contains(polledNode.left)) {
                    queue.add(polledNode.left);
                }
                //check if right node is not visited put it into queue
                if (polledNode.right != null && !visited.contains(polledNode.right)) {
                    queue.add(polledNode.right);
                }

                //check if parent node is not visited put it into queue
                if (childToParentMapping.containsKey(polledNode)
                        && !visited.contains(childToParentMapping.get(polledNode))) {
                    queue.add(childToParentMapping.get(polledNode));
                }
            }
            count++;
        }
        List<Integer> list = new ArrayList<>();

        //In last only those nodes will be present in the queue which are distance k from Given target node.
        while (!queue.isEmpty()) {
            list.add(queue.poll().element);
        }
        return list;
    }

    private static Map<Node, Node> getChildToParentMapping(Node root) {
        Map<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                queue.add(temp.left);
                map.put(temp.left, temp);
            }

            if (temp.right != null) {
                queue.add(temp.right);
                map.put(temp.right, temp);
            }
        }
        return map;
    }


}
