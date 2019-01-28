package com.sgcharts.collections.suffixtree;

import java.util.Optional;

final class Edge {
    private SuffixTree tree;
    private Node head;
    private Node tail;
    private int startIndex;
    private int endIndex = -1;
    private int edgeNumber;
    private int length;

    Edge(SuffixTree tree, Node head) {
        this.tree = tree;
        this.head = head;
        this.startIndex = tree.currentSuffixStartIndex();
        this.edgeNumber = tree.nextEdgeNumber();
    }

    Node head() {
        return head;
    }

    Node tail() {
        return tail;
    }

    int startIndex() {
        return startIndex;
    }

    int endIndex() {
        return endIndex;
    }

    int edgeNumber() {
        return edgeNumber;
    }

    int length() {
        int j = endIndex;
        if (j == -1) {
            //j = _tree.Word.Length - 1
        }
        return j - startIndex + 1;
    }

    Edge splitAt(int index) {
        /*_tree.SendMessage("Splitting edge {0} at index {1} ('{2}')", this, index, _tree.Word[index]);
        Edge newEdge = new Edge(_tree, Head);
        Node newNode = new Node(_tree);
        newEdge.Tail = newNode;
        newEdge.StartIndex = StartIndex;
        newEdge.EndIndex = index - 1;
        Head = newNode;
        StartIndex = index;
        newNode.Edges.Add(_tree.Word[StartIndex], this);
        newEdge.Head.Edges[_tree.Word[newEdge.StartIndex]] = newEdge;
        _tree.SendMessage(" => Hierarchy is now: {0} --> {1} --> {2} --> {3}", newEdge.Head, newEdge, newNode, this);*/
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        /*return string.Concat(_tree.Word.Substring(StartIndex, (EndIndex ?? _tree.CurrentSuffixEndIndex) - StartIndex + 1), "(",
            StartIndex, ",", EndIndex.HasValue ? EndIndex.ToString() : "#", ")");*/
        return null;
    }

    String valueWithoutCanonizationChar() {
        int end = tree.currentSuffixEndIndex();
        if (tree.canonizationChar().isPresent()) {
            end -= 1;
        }
        return tree.word().substring(startIndex, (endIndex == -1 ? end: endIndex) - startIndex + 1);
    }

    String value() {
        StringBuilder sb = new StringBuilder(valueWithoutCanonizationChar());
        tree.canonizationChar().ifPresent(sb::append);
        return sb.toString();
    }

    String renderTree(String prefix, int maxEdgeLength) {
        StringBuilder sb = new StringBuilder();
        var strEdge = _tree.Word.Substring(StartIndex, (EndIndex ?? _tree.CurrentSuffixEndIndex) - StartIndex + 1);
        writer.Write(strEdge);
        if(Tail == null)
            writer.WriteLine();
        else
        {
            var line = new string(RenderChars.HorizontalLine, maxEdgeLength - strEdge.Length + 1);
            writer.Write(line);
            Tail.RenderTree(writer, string.Concat(prefix, new string(' ', strEdge.Length + line.Length)));
        }
        return sb.toString();
    }

    void writeDotGraph(StringBuilder sb) {
        /*if(Tail == null)
            sb.AppendFormat("leaf{0} [label=\"\",shape=point]", EdgeNumber).AppendLine();
        string label, weight, color;
        if(_tree.ActiveEdge != null && ReferenceEquals(this, _tree.ActiveEdge))
        {
            if(_tree.ActiveEdge.Length == 0)
                label = "";
            else if(_tree.DistanceIntoActiveEdge > Length)
                label = "<<FONT COLOR=\"red\" SIZE=\"11\"><B>" + String + "</B> (" + _tree.DistanceIntoActiveEdge + ")</FONT>>";
            else if(_tree.DistanceIntoActiveEdge == Length)
                label = "<<FONT COLOR=\"red\" SIZE=\"11\">" + String + "</FONT>>";
            else if(_tree.DistanceIntoActiveEdge > 0)
                label = "<<TABLE BORDER=\"0\" CELLPADDING=\"0\" CELLSPACING=\"0\"><TR><TD><FONT COLOR=\"blue\"><B>" + String.Substring(0, _tree.DistanceIntoActiveEdge) + "</B></FONT></TD><TD COLOR=\"black\">" + String.Substring(_tree.DistanceIntoActiveEdge) + "</TD></TR></TABLE>>";
            else
                label = "\"" + String + "\"";
            color = "blue";
            weight = "5";
        }
        else
        {
            label = "\"" + String + "\"";
            color = "black";
            weight = "3";
        }
        var tail = Tail == null ? "leaf" + EdgeNumber : "node" + Tail.NodeNumber;
        sb.AppendFormat("node{0} -> {1} [label={2},weight={3},color={4},size=11]", Head.NodeNumber, tail, label, weight, color).AppendLine();
        if(Tail != null)
            Tail.WriteDotGraph(sb);*/
    }
}
