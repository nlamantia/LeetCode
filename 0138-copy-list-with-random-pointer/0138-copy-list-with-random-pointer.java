/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // O(n) time | O(n) space
    public Node copyRandomList(Node head) {
        return copyRandomList(head, new HashMap<>());
    }
    
    private Node copyRandomList(Node head, Map<Node, Node> nodeMap) {
        if (head == null) return null;
        if (nodeMap.containsKey(head)) {
            return nodeMap.get(head);
        } else {
            Node node = new Node(head.val);
            nodeMap.put(head, node);
            node.next = copyRandomList(head.next, nodeMap);
            node.random = copyRandomList(head.random, nodeMap);
            return node;
        }
    }
}