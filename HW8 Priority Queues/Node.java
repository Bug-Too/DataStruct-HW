// This node contains information about an investor (investorID) who submits an order (sell order = minHeap, buy order = maxHeap)
// at a certain time (timestamp) and a certain price (price)


// [Link: คำอธิบายโจทย์เป็น pdf, คำอธิบายโจทย์เป็น PowerPoint และ starter code]

// คลาส Node จะทำหน้าที่บรรจุข้อมูลคำสั่งของนักลงทุน (ผ่านตัวแปร investorID) ที่ส่งคำสั่งซื้อขายหุ้น เข้ามา โดยคำสั่งที่ว่าจะเป็น คำสั่งขาย (ค่า minHeap เป็น true) หรือคำสั่งซื้อ (ค่า minHeap เป็น false) ก็ได้
// คำสั่งซื้อขายนึง ๆ จะประกอบด้วย ราคาที่เสนอเข้ามา (price), ปริมาณหุ้น (amount), และเวลาที่เก็บในตัวแปร timestamp (บันทึกโดยตัวแปร timer ที่อยู่ใน class Heap)
// โจทย์ข้อนี้ ต้องการให้ นักศึกษาปรับปรุงฟังก์ชัน boolean compare(Node rightNode) เพื่อให้สามารถเปรียบเทียบได้ว่าโหนดปัจจุบันนี้มี Priority สูงกว่าอีกโหนดนึงที่นำเข้ามาหรือไม่ โดยจะ return true ถ้า Priority(thisNode) > Priority(rightNode)

// หลักการสำคัญคือ
// 1. ถ้าเป็น minHeap: ราคา (price) ที่ต่ำกว่า จะมี Priority ที่สูงกว่า
// 2. ถ้าเป็น maxHeap: ราคา (price) ที่สูงกว่า จะมี Priority ที่สูงกว่า
// 3. ถ้าราคาเท่ากัน (ไม่ว่าจะเป็น minHeap หรือ maxHeap): เวลา (timestamp) ที่น้อยกว่า จะมี Priority ที่สูงกว่า

public class Node {
    
    double price;
    int investorID;
    int amount;
    int timestamp; // Heap.push() is the only function that modify this variable
    boolean isMinHeap;
    
    public Node(double price, int investorID, int amount, boolean isMinHeap){
        this.price = price;
        this.investorID = investorID;
        this.amount = amount;
        this.isMinHeap = isMinHeap;
    }
    
    // This function will return true if Priority(thisNode) > Priority(rightNode)
    // minHeap: the lower the price, the higher the priority
    // maxHeap: the lower the price, the lower the priority
    // If same price, the smaller the timestamp is, the higher the priority will be
    public boolean compare(Node rightNode){
        if (this.price == rightNode.price) {
            return this.timestamp < rightNode.timestamp ;
        }else{
            if (isMinHeap){

                return this.price < rightNode.price; // FIX THIS
            }else{
                return this.price > rightNode.price; // FIX THIS
            }
        }
    }
    
    public Node(){} // Dummy constructor, no need to edit
}
