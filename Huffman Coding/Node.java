class Node {
    
    char c;
    int weight;
    Node right, left;
    
    public String toString() {
    return "|" + this.c + " " + this.weight + "|";
    }
    }