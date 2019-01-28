package com.sgcharts.collections.suffixtree;

import java.util.HashMap;
import java.util.Map;

final class Node {
    private SuffixTree tree;
    private Map<Character, Edge> edges = new HashMap<>();
    private Node linkedNode = null;
    private int nodeNumber;

    Node(SuffixTree tree) {
        this.tree = tree;
        this.nodeNumber = tree.nextNodeNumber();
    }

    @Override
    public String toString() {
        return "node #" + nodeNumber;
    }

    void addNewEdge() {
        //_tree.SendMessage("Adding new edge to {0}", this);
        Edge edge = new Edge(tree, this);
        Character k = tree.word().charAt(tree.currentSuffixEndIndex());
        edges.put(k, edge);
        //_tree.SendMessage(" => {0} --> {1}", this, edge);
    }

    String renderTree(String prefix) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(nodeNumber);
        sb.append(")");
        char connector, extender = ' ';
        if (edges.size() > 1) {
            connector = RenderChars.T_JUNCTION_DOWN;
            extender = RenderChars.VERTICAL_LINE;
        } else {
            connector = RenderChars.HORIZONTAL_LINE;
        }
        int i = 0;
        for (Edge e : edges()) {
            if (i != 0) {
                sb.append(prefix);
                if (i == edges.size() - 1) {
                    connector = RenderChars.CORNER_RIGHT;
                } else {
                    connector = RenderChars.T_JUNCTION_RIGHT;
                    extender = RenderChars.VERTICAL_LINE;
                }
            }
            sb.append(connector);
            sb.append(RenderChars.HORIZONTAL_LINE);
            sb.append(e.renderTree(newPrefix(prefix, extender), maxEdgeLength()));
            i++;
        }
        return sb.toString();
    }

    private String newPrefix(String prefix, char extender) {
        return prefix + extender + ' ';
    }

    void writeDotGraph(StringBuilder sb) {
        if (linkedNode != null) {
            sb.append(String.format("node%s -> node%s [label=\"\",weight=.01,style=dotted]\n",
                    nodeNumber, linkedNode.nodeNumber));
        }
        for (Edge edge : edges()) {
            edge.writeDotGraph(sb);
        }
    }

    private int maxEdgeLength() {
        int max = 0;
        int end;
        int len;
        for (Edge e : edges()) {
            end = e.endIndex();
            if (end == -1) end = tree.currentSuffixEndIndex();
            len = end - e.startIndex() + 1;
            if (len > max) max = len;
        }
        return max;
    }

    Iterable<Edge> edges() {
        return edges.values();
    }

}
