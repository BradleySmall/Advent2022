package com.small.advent2022;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.*;

@Log4j
public class NoSpaceLeftOnDevice {
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Node {
        public static final String DELIM = "/";
        private String name;
        private Integer size;
        private List<Node> children;
        private Node parent;

        public Map<String,Integer> mapFromNode() {
            Map<String,Integer> map = new HashMap<>();

            StringBuilder path = new StringBuilder(DELIM +name);
            var p = parent;
            while(p != null) {
                path.insert(0, DELIM +p.name);
                p = p.parent;
            }

            map.put(path.toString(), size);
            for (Node n : children) {

                map.putAll(n.mapFromNode());
            }
            return map;
        }
        public void show() {
            log.info("parent: " + ((parent != null )?parent.name:"*")  + " name: " + name + " size " + size);
            for (Node n : children) {
                n.show();
            }
        }
    }

    public final Node root = new Node("", 0, new ArrayList<>(), null);
    private Node current = root;

    public Map<String, Integer> mapFromNode() {
        return root.mapFromNode();
    }
    public void show() {
        root.show();
    }

    public void updateDirStruct(String line) {
        String[] parts = line.split(" ");
        if (parts[0].equals("$") && parts[1].equals("cd")) {
            if (parts[2].equals("..")) {
                current = current.parent;
            } else if (current.name.isEmpty()) {
                current.name = parts[2];
                current.size = 0;
                current.children = new ArrayList<>();
                current.parent = null;
            } else {
                Node node = new Node(parts[2], 0, new ArrayList<>(), current);
                current.children.add(node);
                current = node;
            }
        } else if (parts[0].matches("\\d+")) {
            Node p = current;
            while (p != null) {
                p.size += Integer.parseInt(parts[0]);
                p = p.parent;
            }
        }
    }
}
