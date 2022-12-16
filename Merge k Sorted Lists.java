/**

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode();
        //System.out.println(lists.length);
        if(lists.length>0)
        { for(int i=1;i<lists.length;i++){
          
          lists[i]=merge2lists(lists[i],lists[i-1]);
          /*System.out.println("i th list i:"+i);
          res=lists[i];
            while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }*/
           }
            return(lists[lists.length-1]);
        }
        return null;
       
    }
    public ListNode merge2lists(ListNode listA,ListNode listB) {
        ListNode head=listA;
        ListNode temp;
        ListNode prev=null;
        /* temp=listA;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }*/
        int val;
        if(listA==null) return listB; 
        if(listB==null) return listA;
        while(listA!=null && listB!=null){
            
            if(listA.val>=listB.val){
                temp=listB;
                listB=listB.next;
                temp.next=listA; 
                if(head==listA){
                    head=temp;
                }
                else{
                    prev.next=temp;
                }
                listA=temp;
                
                
            }
            else{
                prev=listA;
                listA=listA.next;
            }
               // listA=listA.next;
               
            }
         

           
        
        while(listB!=null ){
           //System.out.println(" DEBUG"+listB.val);
           temp=listB;
           listB=listB.next;
           if(prev==null)
             {
                 head=temp; 
                 prev=temp;
             }else{
                prev.next=temp; 
             }
           prev=prev.next;
            
        }
        
        /*System.out.print("\n ");
           temp=head;
            while(temp!=null){
            System.out.print("D1 "+temp.val+"\t");
            temp=temp.next;
        }*/
               
        return head;
        
    }

}
