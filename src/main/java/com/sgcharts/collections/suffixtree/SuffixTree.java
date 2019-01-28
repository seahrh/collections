package com.sgcharts.collections.suffixtree;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public final class SuffixTree {
    private Optional<Character> canonizationChar;
    private String word;
    private int currentSuffixStartIndex;
    private int currentSuffixEndIndex;
    private Node lastCreatedNodeInCurrentIteration;
    private int unresolvedSuffixes;
    private int nextNodeNumber = 0;
    private int nextEdgeNumber = 0;
    private Node rootNode = new Node(this);
    private Node activeNode = rootNode;
    private Edge activeEdge;
    private int distanceIntoActiveEdge;
    private char lastCharacterOfCurrentSuffix;

    private SuffixTree(String word) {
        this.word = word;
    }

    public static SuffixTree create(String word) {
        SuffixTree res = new SuffixTree(word);
        res.build();
        return res;
    }

    private void build() {

    }

    private boolean addNextSuffix() {
        return true;
    }

    private boolean getExistingEdgeAndSetAsActive() {
        return false;
    }

    private boolean addCurrentSuffixToActiveEdge() {
        return false;
    }

    private void updateActivePointAfterAddingNewEdge() {

    }

    private void normalizeActivePointIfNowAtOrBeyondEdgeBoundary(int firstIndexOfOriginalActiveEdge) {

    }

    private void splitActiveEdge() {

    }

    private void updateActivePointToLinkedNodeOrRoot() {

    }

    public String render() {
        return "";
    }

    public String writeDotGraph() {
        return "";
    }

    public Set<String> extractAllSubstrings() {
        Set<String> res = new HashSet<>();
        ExtractAllSubstrings("", res, rootNode);
        return res;
    }

    private void ExtractAllSubstrings(String str, Set<String> set, Node node) {
        String val;
        int len;
        for (Edge edge: node.edges()) {
            val = edge.valueWithoutCanonizationChar();
            //TODO here
            var edgeLength = !edge.EndIndex.HasValue && CanonizationChar.HasValue ? edge.Length - 1 : edge.Length; // assume tailing canonization char
            for(var length = 1; length <= edgeLength; length++)
                set.Add(string.Concat(str, edgeStr.Substring(0, length)));
            if(edge.Tail != null)
                ExtractAllSubstrings(string.Concat(str, edge.StringWithoutCanonizationChar), set, edge.Tail);
        }
    }

    Optional<Character> canonizationChar() {
        return canonizationChar;
    }

    String word() {
        return word;
    }

    int currentSuffixStartIndex() {
        return currentSuffixStartIndex;
    }

    int currentSuffixEndIndex() {
        return currentSuffixEndIndex;
    }

    Node lastCreatedNodeInCurrentIteration() {
        return lastCreatedNodeInCurrentIteration;
    }

    int unresolvedSuffixes() {
        return unresolvedSuffixes;
    }

    Node rootNode() {
        return rootNode;
    }

    Node activeNode() {
        return activeNode;
    }

    Edge activeEdge() {
        return activeEdge;
    }

    int distanceIntoActiveEdge() {
        return distanceIntoActiveEdge;
    }

    char lastCharacterOfCurrentSuffix() {
        return lastCharacterOfCurrentSuffix;
    }

    int nextNodeNumber() {
        return nextNodeNumber++;
    }

    int nextEdgeNumber() {
        return nextEdgeNumber++;
    }
}
