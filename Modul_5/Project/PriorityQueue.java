package Modul_5.Project;

class PriorityQueue extends LinkedList<Vertex>{
    
    public Vertex dequeue(){
        Vertex save = head.data;
        removefirst();
        return save;
    }
    
    public void enqueue(Vertex data, double [] weight){
        Node<Vertex> baru = new Node<Vertex>(data);
        if (head == null) {
            head = tail = baru;
            return;
        }
        Node<Vertex> bantu = head;
        while(bantu != null){
            if(weight[head.data.index] > weight[baru.data.index]){
                baru.next = head;
                head.prev = baru;
                head = baru;
                return;
            }else if(weight[tail.data.index] <= weight[baru.data.index]){
                tail.next = baru;
                baru.prev = tail;
                tail = baru;
                return;
            }else if(weight[baru.data.index] >= weight[bantu.data.index] && weight[baru.data.index] < weight[bantu.next.data.index] ){
                baru.next = bantu.next;
                baru.prev = bantu;
                bantu.next.prev = baru;
                bantu.next = baru;
                return;
            }
            bantu = bantu.next;
        }
    }
}